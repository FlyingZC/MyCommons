package com.zc.z06wrapper;

import org.junit.Test;

public class T01Wrapper
{
    @Test
    public void test01()
    {
        //自动拆箱,包装类隐式转换为基本类型
        Double dd1 = 1.1;
        double d1 = 1.1;
        //相当于 dd1.doubleValue() == d1
        System.out.println(dd1 == d1);//true
        System.out.println(dd1.doubleValue() == d1);
    }
    
    @Test
    public void test02()
    {
        //Double 不存在缓存
        Double dd1 = 1.1;
        Double dd2 = 1.1;
        Double dd3 = new Double(1.1);
        Double dd4 = Double.valueOf(1.1);
        System.out.println(dd1 == dd2);//false
        System.out.println(dd1 == dd3);//false
        System.out.println(dd1 == dd4);//false
    }
    
    @Test
    public void test03()
    {
        //Integer默认在静态块中 缓存-128~127的Integer
        Integer ii1 = 1;
        Integer ii2 = 1;
        Integer ii3 = new Integer(1);
        Integer ii4 = Integer.valueOf(1);
        System.out.println(ii1 == ii2);//true
        System.out.println(ii1 == ii3);//false
        System.out.println(ii1 == ii4);//true
    }
}
