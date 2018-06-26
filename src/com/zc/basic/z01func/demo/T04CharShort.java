package com.zc.basic.z01func.demo;

/* 字符类型。字符类型事实上是一个16位无符号整数，
 * 这个整数对应字符的Unicode字符集编码。本题中，int类型和char类型都可以存储汉字“达”。
 * */
public class T04CharShort
{
    public static void main(String[] args)
    {
        char c = '达';
        // short s='达';//达放不下
        int i = '达';
        // '中'字符可以放得下
        short ss = '中';
        long l = '中';//你放long里也可以啊,编译器应该将''字符 翻译成 整数值
        // short范围  -32768到32767
        System.out.println(Short.MAX_VALUE + " " + Short.MIN_VALUE);
        // char范围 0到65535 
        System.out.println((int) Character.MAX_VALUE + " " + (int) Character.MIN_VALUE);
        System.out.println("i:" + i);//i:36798
        System.out.println("l:" + l);//l:20013
    }
}
