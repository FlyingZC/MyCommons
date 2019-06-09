package com.zc.vm;

import java.util.ArrayList;
import java.util.List;

public class T03Fill
{
    public static void fillHeap(int num) throws InterruptedException
    {
        List<MyObject> list = new ArrayList<MyObject>();
        for (int i = 0; i < num; i++)
        {
            list.add(new MyObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException
    {
        fillHeap(1000);
    }
}

class MyObject
{
    public byte[] placeHolder = new byte[64 * 1024];
}
