package com.zc.basic.z03string.demo;

import org.junit.Test;

// StringBuffer:可变长度的字符串
// StringBuilder:可变长度的字符串.线程不安全.效率高
/*
 * 添加效率StringBuilder>StringBuffer>String
 * */
public class T05StringBuffer
{
    public void test1()
    {
        //初始化容量为16.但是length为0
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("abc").append("123");
    }

    // 测试效率
    @Test
    public void test2()
    {
        String text = "";
        long startTime = 0L;
        long endTime = 0L;
        StringBuffer buffer = new StringBuffer("");
        StringBuilder buidler = new StringBuilder("");
        // StringBuffer的执行时间
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++)
        {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间" + (endTime - startTime));

        // StringBuilder的执行时间
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++)
        {
            buidler.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间" + (endTime - startTime));

        // String的执行时间
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++)
        {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间" + (endTime - startTime));
    }
}
