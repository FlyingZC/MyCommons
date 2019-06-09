package com.zc02.enums;

//将之前的nextDay()方法通过多个内部类来实现.减少if..else判断.
public abstract class WeekDay2
{
    public static final WeekDay2 SUN = new WeekDay2()
    {

        @Override
        public WeekDay2 nextDay()
        {
            return null;
        }

    };

    public static final WeekDay2 MON = new WeekDay2()
    {

        @Override
        public WeekDay2 nextDay()
        {
            return null;
        }

    };

    //获取枚举类的下一个值
    public abstract WeekDay2 nextDay();

    public String toString()
    {
        return this == SUN ? "SUN" : "MON";
    }
}
