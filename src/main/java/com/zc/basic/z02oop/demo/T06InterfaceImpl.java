package com.zc.basic.z02oop.demo;

import java.util.ArrayList;
import java.util.List;

// 接口中能否编写方法实现？接口中能否声明变量
public class T06InterfaceImpl
{

}

interface Inter
{
    public static final List<String> strs = new ArrayList()
    {

    };

    public abstract void say();

    public class inner implements Inter
    {
        @Override
        public void say()
        {
            System.out.println("inner method's say");
        }
    }
}
