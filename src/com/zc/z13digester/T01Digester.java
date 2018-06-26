package com.zc.z13digester;

import java.io.File;

import org.apache.commons.digester.Digester;

public class T01Digester
{
    public static void main(String[] args) throws Exception
    {
        Digester digester = new Digester();
        digester.setValidating(false);
        // 匹配department节点,创建Department对象
        digester.addObjectCreate("department", Department.class);
        // 匹配department节点时,设置对象属性
        digester.addSetProperties("department");
        
        // 匹配department/user节点时,创建User对象
        digester.addObjectCreate("department/user", User.class);
        // 匹配department/user节点时,设置对象属性
        digester.addSetProperties("department/user");
        // 匹配department/user节点时,调用Department对象的addUser方法
        digester.addSetNext("department/user", "addUser");
        
        // 匹配department/extension节点时,调用Department对象的putExtension方法
        digester.addCallMethod("department/extension", "putExtension", 2);
        // 调用方法的第一个参数为节点department/extension/property-name的内容
        digester.addCallParam("department/extension/property-name", 0);
        // 调用方法的第二个参数为节点department/extension/property-value的内容
        digester.addCallParam("department/extension/property-value", 1);
        Department dept = (Department) digester.parse(new File("DigesterTest.xml"));
        System.out.println(dept);
    }
}






















