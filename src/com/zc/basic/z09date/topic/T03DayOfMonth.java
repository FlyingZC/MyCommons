package com.zc.basic.z09date.topic;

import java.util.Calendar;

public class T03DayOfMonth
{
    public static void main(String[] args)
    {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2013);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DATE, 1);
        for (int i = 0; i < 12; i++)
        {
            System.out.println(c.get(Calendar.MONTH) + c.getActualMaximum(Calendar.DAY_OF_MONTH));
            c.add(Calendar.MONTH, 1);
        }
    }
}
