package com.zc.basic.z01func.demo;

public class T04FuZhi
{
    public static void main(String[] args)
    {
        //The literal 8888888888 of type int is out of range编译错误
        //int a=8888888888;
        char b = 1000 + 300;// 字面量会自动计算
        byte c = 100 + 20;
        // byte c2 = 100 + 30;// 编译错误
        byte c3 = 127;
        int d = 'a' + 'b' + 'c';
    }
}
