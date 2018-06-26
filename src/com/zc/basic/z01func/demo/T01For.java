package com.zc.basic.z01func.demo;

public class T01For
{
    public static void main(String[] args)
    {
        int result = 0;
        int i;
        for (i = 0; i < 10; i++)
        {
            if (i > 5)
            {
                break;
            }
            result += i;
        }
        System.out.println("result:" + result);
        System.out.println("i:" + i);
    }
}
