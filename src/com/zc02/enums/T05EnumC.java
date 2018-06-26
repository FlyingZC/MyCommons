package com.zc02.enums;

public class T05EnumC
{
    public static void main(String[] args)
    {
        Week week = Week.MON;
        System.out.println(week);//MON
        System.out.println(week.name());//MON
        System.out.println(week.ordinal());//1
        System.out.println(Week.valueOf("SUN"));//
        System.out.println(Week.values().length);

    }

    public enum Week
    {
        SUN, MON, TUE, WES, THR, FRI, SAT;
        //枚举类中的所有其他信息必须在元素列表之后.且元素最后加;方法必须定义为私有的
        //只要用到枚举类.里面的静态成员变量都会执行.所以调用多次构造方法
        private Week()
        {
            System.out.println("无参");
        }

        private Week(int day)
        {

        }
    }
}
