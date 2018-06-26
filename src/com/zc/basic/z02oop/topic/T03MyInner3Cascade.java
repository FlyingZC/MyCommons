package com.zc.basic.z02oop.topic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author flyingzc
 * 匿名内部类实现的递归
 */
public class T03MyInner3Cascade
{
    @Test
    public void testCollection()
    {
        List<Object> list = new ArrayList<Object>();
        list.add("a");
        list.add("ab");
        list.add("ac");
        list.add("ad");
        new Object()
        {
            private int i = 0;

            public void collect(List<Object> list)
            {
                System.out.println("collect");
                System.out.println(list.get(i++));
                if (i >= list.size())
                {
                    return;
                }
                this.collect(list);
            }
        }.collect(list);
    }
}
