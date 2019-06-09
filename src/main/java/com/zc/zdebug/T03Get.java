package com.zc.zdebug;

public class T03Get
{
    public static void main(String[] args)
    {
        Person p=new Person();
        p.getFamily().getJob().say();
    }
}
