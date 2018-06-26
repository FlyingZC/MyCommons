package com.zc.basic.z01func.topic;

// 编写一个函数将一个十六进制数的字符串参数转换成整数返回
public class Z02HexToBin
{
    public static void main(String[] args)
    {
        String hex = "fbca";
        //Integer.parseInt(str,radix);进制默认是按十进制转换
        Integer i = Integer.parseInt(hex, 16);
        System.out.println(i);
    }

}
