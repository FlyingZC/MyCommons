package com.zc.basic.z03string.topic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author flyingzc
 * String str = "-1-3-5-4-6-7-8-2-1-2-5-9-0";
 * 1.去重;2.从大到小排序;3.输出最大值
 */
public class T01StringUniqueSort
{
    @Test
    public void test()
    {
        // 1.split拆分成数组;2.转成Integer存入set去重;3.将set包装成List;4.Collections.sort()倒序排序
        String str = "-1-3-5-4-6-7-8-2-1-2-5-9-0";
        // 1.split()结果第一个值为空 
        String[] arr = str.split("-");
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 1; i < arr.length; i++)
        {
            set.add(Integer.parseInt(arr[i]));
        }
        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        });
        System.out.println(list);
    }

}
