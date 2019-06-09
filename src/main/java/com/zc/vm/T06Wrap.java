package com.zc.vm;

public class T06Wrap
{
    public static void main(String[] args)
    {//包装类的"=="运算 在不遇到算术运算的情况下不会自动拆箱,以及它们的equals()不会处理数据转型的关系
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        //缓存-128到127
        System.out.println(c == d);//true
        System.out.println(e == f);//false

        System.out.println(c == (a + b));//true 
        System.out.println(c.equals(a + b));//true

        //基本数据类型==比较值是否相等
        System.out.println(1L == 1);//true
        System.out.println(1L == 1.0);//true

        //以下相当于 
        System.out.println(g == (a + b));//true
        System.out.println(g.longValue() == (a.intValue() + b.intValue()));//true

        // equals方法中if (obj instanceof Long)... 以下相当于
        System.out.println(g.equals(a + b));//false
        System.out.println(g.equals(Integer.valueOf((a.intValue() + b.intValue()))));//false
    }
}
