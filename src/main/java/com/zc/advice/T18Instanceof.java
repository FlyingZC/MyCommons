package com.zc.advice;

import java.util.Date;

/**
 * <instanceof>
 *1.只要instanceof关键字左右的两个操作数有继承或实现关系,就能编译通过 
 *2.只能判断引用数据类型
 *3.若左操作符为null,直接返回false
 * @author  Administrator
 * @version  [版本号, 2017年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T18Instanceof
{
    public static void main(String[] args)
    {
        boolean b1="S" instanceof Object;
        boolean b2=new String() instanceof String;
        System.out.println(new Object() instanceof String);
        //前后没有继承或实现关系
        //System.out.println(new Integer() instanceof String);
        //基本数据类型不可用,此处为char类型
        //System.out.println('A' instanceof Character);
        //若左操作符为null,直接返回false
        System.out.println(null instanceof String);
        System.out.println((String)null instanceof String);//false
        //System.out.println(new Date() instanceof String);
        String s = null;
        System.out.println(s instanceof String);
        System.out.println(new GenericClass<String>().isDateInstance(""));//false
        System.out.println(new GenericClass<String>().isInstan(""));//true
    }
}
class GenericClass<T>
{
    public boolean isDateInstance(T t)
    {//t(传入String类型变量"")在编译期转换为Object类型,和Date之间有继承关系,所以不报错.
        return t instanceof Date;//相当于new Ojbect() instanceof Date编译不报错,当然返回值为false
    }
    public boolean isInstan(T t)
    {
        return t instanceof Object;
    }
}