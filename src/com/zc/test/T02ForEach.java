package com.zc.test;

import org.junit.Test;

public class T02ForEach
{
    @Test
    public void test01()
    {
        String[] strArray = null;
        //运行时 空指针
        for (String s : strArray)
        {
            System.out.println(s);
        }
    }
    
    @Test
    public void test02()
    {
        for(int i=1000;i<0;i++)
        {
            System.out.println("ss");
        }
    }
}
