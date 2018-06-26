package com.zc.basic.z02oop.demo.extend;

public class Zi extends Fu
{
    @Override
    public void swim()
    {

    }

    public static void main(String[] args)
    {
        Zi z = new Zi();
        System.out.println(z.getClass().getName());//com.zc.z02oop.Zi
        System.out.println(z.getClass().getSuperclass().getName());//com.zc.z02oop.Fu
    }

}
