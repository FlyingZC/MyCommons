package com.zc.basic.z02oop.demo;

import java.util.ArrayList;
import java.util.List;

public class T05Final2
{
    final int a;

    public T05Final2()
    {
        a = 1;
    }

    final int b;
    {
        b = 2;
    }

    static final int sa = 1;

    static final int sb;
    static
    {
        sb = 1;
    }

    public void hello(final int a)
    {
        System.out.println(a);
        //a=1;报错,a不能被改变
    }

    public static void main(String[] args)
    {
        final List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        //编译错误
        //list=new ArrayList<Integer>();
    }
}
