package com.zc.basic.z09date;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class T01Date
{
    /**
     * 输出明日此时
     */
    @Test
    public void test01()
    {
        Date date = new Date();
        long now = date.getTime();
        date.setTime(now + 24 * 60 * 60 * 1000);
        System.out.println(date);

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        Date d = c.getTime();
        System.out.println(d);
    }

    @Test
    public void test02()
    {
        // new Timestamp(long time)
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String tsString = ts.toString().substring(0, 19);// 2018-02-21 12:22:44
        String tsDate = tsString.substring(0, 10);
    }

}
