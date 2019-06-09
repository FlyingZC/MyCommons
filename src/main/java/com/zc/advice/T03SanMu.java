package com.zc.advice;

/**
 * @author zc
 * 建议比较的类型相同
 * 三目运算符转换原则
 * (1)若两个操作数不可转换,则不转换,返回值为Object类型
 * (2)int->long,long->float等
 */
public class T03SanMu
{
    public static void main(String[] args)
    {
        //int a=0b111;// 1.7之后支持
        int i = 80;
        
        // 1.三目运算比较的是相同类型的数据(此处为int),返回int类型
        int result1 = i < 100 ? 90 : 100;// 90
        
        // 2.三目运算比较的是不同类型(此处为int和double),但是可以转换,返回自动转换后的类型
        double result2 = i < 100 ? 90 : 100.0;// 90.0
        
        // 3.三目运算比较的是不同类型,且不可转换,则返回Object类型
        Object result3 = i < 100 ? Boolean.TRUE : Integer.MAX_VALUE;
    }
}
