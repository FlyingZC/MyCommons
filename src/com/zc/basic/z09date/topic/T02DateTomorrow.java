package com.zc.basic.z09date.topic;

import java.util.Calendar;
import java.util.Date;

// 输出明日此时
public class T02DateTomorrow
{
    public static void main(String[] args)
    {
        Date date = new Date();
        long now = date.getTime();
        System.out.println(date);
        date.setTime(now + 24 * 60 * 60 * 1000);
        System.out.println(date);

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        Date d = c.getTime();
        System.out.println(d);
    }
}
