package com.zc.basic.z02oop.topic;

public class T01Final
{
    final int a;

    public T01Final(int id)
    {
        a = id;
    }

    public void setA(int id)
    {
        //编译错误The final field T01Final.a cannot be assigned
        //final初始化后，只要你试图改变，就会报错
        //a=id;
    }
}
