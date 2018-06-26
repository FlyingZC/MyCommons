package com.zc.zhongjianjian;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap
{
    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    private ConcurrentHashMap<String, Integer> conMap = new ConcurrentHashMap<String, Integer>();

    public synchronized void add(String key)
    {
        Integer value = map.get(key);
        if (value == null)
        {
            map.put(key, 1);
        }
        else
        {
            map.put(key, value + 1);
        }
    }

    public void addCon(String key)
    {
        Integer value = conMap.get(key);
        if (value == null)
        {
            conMap.put(key, 1);
        }
        else
        {
            conMap.put(key, value + 1);
        }
    }

    public static void main(String[] args)
    {
        TestHashMap t = new TestHashMap();

        for (int i = 0; i < 100; i++)
        {
            t.add("1");
        }
        System.out.println(t.map.get("1"));

        for (int i = 0; i < 100; i++)
        {
            t.addCon("1");
        }
        System.out.println(t.conMap.get("1"));
    }
}
