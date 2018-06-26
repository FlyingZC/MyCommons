package com.zc.z00codestyle;

import org.junit.Test;

public class Z01Test
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++)
        {
            if (i > 5 && i <= 6)
            {
                System.out.println("hehe");
            }
        }
    }
    
    @Test
    public void test01()
    {
        System.out.println("haha");
    }
}
