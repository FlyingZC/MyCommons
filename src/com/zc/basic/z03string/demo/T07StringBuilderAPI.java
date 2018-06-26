package com.zc.basic.z03string.demo;

import static java.lang.System.out;

import org.junit.Test;

public class T07StringBuilderAPI
{
    /**
     * StringBuilder():构造一个其中不带字符的字符串生成器，初始容量为 16 个字符。
     */
    @Test
    public void test01()
    {
        StringBuilder sb = new StringBuilder("a").append("bcd").append("efg");
        System.out.println(sb.toString());//abcdefg
        out.println(sb.capacity());//17
        System.out.println(sb.charAt(0));//a
        System.out.println(sb.indexOf("bcd"));//1
        System.out.println(sb.lastIndexOf("bcd"));//1
        System.out.println(sb.length());//7
        System.out.println(sb.substring(0, 2));//ab
        //insert(index,str):在指定下标处 插入字符串,不会替换原来位置的字符串
        System.out.println(sb.insert(0, "A"));//Aabcdefg
        System.out.println(sb.delete(2, 3));//Aacdefg
        System.out.println(sb.deleteCharAt(2));//Aadefg
        //replace(startIndex,endIndex,str):替换指定下标区间的字符串
        System.out.println(sb.replace(0, 2, "ABCD"));//ABCDdefg
    }
}
