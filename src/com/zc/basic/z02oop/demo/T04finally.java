package com.zc.basic.z02oop.demo;

public class T04finally
{
    public static void main(String[] args)
    {
        test01();
    }

    public static String test01()
    {
        try
        {
            // 即使在try里return了.finally里的还是会执行
            return new String("a");
        }
        catch (Exception e)
        {

        }
        finally
        {
            // 会执行
            System.out.println("finally block");
        }
        return null;
    }
}
