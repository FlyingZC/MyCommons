package com.zc.basic.z01func.demo;

public class T06Break
{
    public static void main(String[] args)
    {
        boolean flag = true;
        for (int i = 0; i < 10 && flag; i++)
        {
            for (int j = 0; j < 100; j++)
            {
                if (i * j == 200)
                {
                    flag = false;
                    break;
                }
                System.out.println(i * j);
            }
        }
    }
}
