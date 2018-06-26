package com.zc.basic.z01func.topic;

import java.util.Arrays;
import java.util.Random;

public class Z10RandArray
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++)
        {
            arr[i] = rand.nextInt(101);
        }
        System.out.println(Arrays.toString(arr));
    }
}
