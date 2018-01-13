package com.zc.z04debug;

public class T01
{
    public static void main(String[] args)
    {
        for(int i=0;i<100;i++)
        {
            System.out.println(i);
            if(i==10)
            {
                System.out.println("i=10时");
                System.out.println("i=10时");
            }
        }
        method1();
    }
    
    public static void method1()
    {
        System.out.println("hehe");
    }
}
