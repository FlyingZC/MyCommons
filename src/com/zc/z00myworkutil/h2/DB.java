/*
 * 文 件 名:  DB.java
 * 版    权:   . Copyright 2008-2016,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  simon
 * 修改时间:  2018年6月15日
 */
package com.zc.z00myworkutil.h2;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.*;
import java.sql.*;
import java.util.*;


public class DB
{
    
    // 连接数据库时使用的用户名
    private static final String USER = "tracer";
    
    // 连接数据库时使用的密码
    private static final String PASSWORD = "tracer";
    
    // 连接H2数据库时使用的驱动类，org.h2.Driver这个类是由H2数据库自己提供的，在H2数据库的jar包中可以找到
    private static final String DRIVER_CLASS = "org.h2.Driver";

    private String path = "/Users/zhangcheng6/twice-cooked-pork/trace-data/20190404-231826/";

    // 一条程序调用栈
    private Deque<Pork> stack = new LinkedList<>();

    // 所有pork
    private List<Pork> porks = new ArrayList<>();

    // 调用tree,每一条栈开始对应一个tree.先假设有很多tree
    private Pork root;

    @Test
    public void test() {
        getData();
        trace();
        System.out.println(JSON.toJSONString(root));
    }

    public void trace() {
        preTrace();
        for (Pork p : porks) {
            Pork last = stack.peekLast();// 查看队尾元素,取不到返回null
            if (last != null) {
                Long parentId = p.getWhoInvokeMeId();
                if (last.getMethodId().equals(parentId)) {
                    last.addChild(p);
                    stack.offerLast(p);// 向队尾添加元素,失败返回false
                } else {
                    Pork lastInStack;
                    do{
                        stack.pollLast();// 弹出队尾元素,队列为空时返回null
                        lastInStack = stack.peekLast();
                    }while (!lastInStack.getMethodId().equals(parentId));
                    lastInStack.addChild(p);
                    stack.offerLast(p);// 添加到队尾
                }

            } else {// 栈里没有元素 直接添加
                stack.offerLast(p);
                root = p;
            }
        }
    }

    private void preTrace() {
        // 初始化根节点信息,methodId = 1
        root = new Pork();
        root.setMethodId(0L);
        stack.offerLast(root);
    }

    private Connection getConnection()
    {
        Connection conn = null;
        try
        {
            Class.forName(DRIVER_CLASS);
            conn = DriverManager.getConnection(
                "jdbc:h2:" + path + "tracer.data.h2db",
                USER,
                PASSWORD);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    private void getData() {
        Connection conn = null;
        try
        {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
//            String createDataSql = "select * from trace_data " +
//                    " where class_name not like '%org/slf4j%'" +
//                    " and class_name not like '%org/apache/log4j%'" +
//                    " and class_name not like '%org/apache/commons/logging%'";

            String createDataSql = "select * from trace_data ";
            ResultSet rs = stmt.executeQuery(createDataSql);
            while(rs.next()) {
                //  ID  	THREAD_ID  	STACK_NUM  	THREAD_NAME  	METHOD_ID  	WHO_INVOKE_ME_ID  	CLASS_NAME  	METHOD_NAME  	LINE_NUM  	INVOKE_AT
                long id = rs.getLong(1);
                long threadId = rs.getLong(2);
                long stackNum = rs.getLong(3);
                String threadName = rs.getString(4);
                long methodId = rs.getLong(5);
                long whoInvokeMeId = rs.getLong(6);
                String className = rs.getString(7);
                String methodName = rs.getString(8);
                long lineNum = rs.getLong(9);
                long invokeAt = rs.getLong(10);
                Pork pork = new Pork();
                pork.setId(id);
                pork.setThreadId(threadId);
                pork.setStackNum(stackNum);
                pork.setThreadName(threadName);
                pork.setMethodId(methodId);
                pork.setWhoInvokeMeId(whoInvokeMeId);
                pork.setClassName(className);
                pork.setMethodName(methodName);
                pork.setLineNum(lineNum);
                pork.setInvokeAt(invokeAt);
                porks.add(pork);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    

    
}
