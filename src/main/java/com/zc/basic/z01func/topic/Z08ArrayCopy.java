package com.zc.basic.z01func.topic;

import java.util.Arrays;

public class Z08ArrayCopy
{
    public static void main(String[] args)
    {
        //1.声明
        int[] b;
        b = new int[10];//分配内存
        b[0] = 1;//此时只能通过下标初始化

        int[] c;//声明
        c = new int[] {1, 2, 4};//分配内存 并 初始化

        int[] d = new int[] {};//声明同时初始化
        int[] e = {};//声明同时初始化

        for (int i = 0; i < 10; i++)
        {
            b[i] = i;
        }
        //此时desc容量必须足够容纳且长度不能超
        System.arraycopy(b, 3, d, 3, 6);
        System.out.println(Arrays.toString(d));
        System.gc();
    }
}
