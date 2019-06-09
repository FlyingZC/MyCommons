package com.zc.basic.z09date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author flyingzc
 * SimpleDateFormat线程不安全问题
 */
public class UnSafeDateFormat extends Thread
{
    //多线程共享
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private String name;

    private String dateStr;

    private boolean sleep;

    public UnSafeDateFormat(String name, String dateStr, boolean sleep)
    {
        this.name = name;
        this.dateStr = dateStr;
        this.sleep = sleep;
    }

    @Override
    public void run()
    {

        Date date = null;

        if (sleep)
        {
            try
            {
                TimeUnit.MILLISECONDS.sleep(2000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        try
        {
            date = sdf.parse(dateStr);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        System.out.println(name + " : date: " + date);
    }

    public static void main(String[] args) throws InterruptedException
    {

        ExecutorService executor = Executors.newCachedThreadPool();

        // A 会sleep 2s 后开始执行sdf.parse()
        executor.execute(new UnSafeDateFormat("A", "1991-09-13", true));
        // B 打了断点,会卡在方法中间
        executor.execute(new UnSafeDateFormat("B", "2013-09-13", false));

        executor.shutdown();
    }
}
