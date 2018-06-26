package com.zc.basic.z01func.demo;

public class T02Switch
{
    public static void main(String[] args)
    {
        int i = 24, j = 32, h = 58;
        switch (j - i)
        {
            case 7:
                h++;
            case 8:
                h++;
            case 9:
                h += 2;
            case 10:
                h += 3;
                // 不加break; 则default也要执行
            default:
                h /= j;
        }
        System.out.println(h);

    }
}
