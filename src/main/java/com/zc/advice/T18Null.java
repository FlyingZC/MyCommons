package com.zc.advice;

public class T18Null
{
    public static void main(String[] args)
    {
        //1.只声明不赋值,则不可使用该变量.否则编译不通过
        String str2;
        //编译报错,声明后未初始化
        //str2.length();
        
        //2.将引用赋值为null,则可以使用该变量,编译期通过.运行期 空指针异常
        String str=null;
        //运行时报java.lang.NullPointerException
        str.length();
    }
}
