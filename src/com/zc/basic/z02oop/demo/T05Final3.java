package com.zc.basic.z02oop.demo;

//正确
public class T05Final3
{
    public static void main(String[] args)
    {
        Other o = new Other();
        new T05Final3().addOne(o);
    }

    public void addOne(final Other o)
    {
        // 传入的引用类型 o的引用不变即可
        o.i++;
        //o= new Other();
    }
}

class Other
{
    public int i;
}
