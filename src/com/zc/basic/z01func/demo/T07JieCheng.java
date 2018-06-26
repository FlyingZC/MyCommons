package com.zc.basic.z01func.demo;

public class T07JieCheng
{
    public static void main(String[] args)
    {
        System.out.println(jieCheng(4));
    }

    public static int jieCheng(int num)
    {
        if (num > 1)
        {
            return num * jieCheng(num - 1);
        }
        else
        {
            return 1;
        }
    }
}
