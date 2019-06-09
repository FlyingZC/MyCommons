package com.zc.basic.z06wrapper;

import org.junit.Test;

public class T01Wrapper
{
    @Test
    public void test011() {
        int i1 = 1;
        int i2 = 1;
        Integer in1 = 1;
        System.out.println(i1 == i2);
        System.out.println(in1 == i1);

        Integer in2 = new Integer(1);

        Integer in3 = 1;
        System.out.println(in1 == in3);
        System.out.println(in1 == in2);

        Integer ii1 = 200;
        Integer ii2 = 200;
        System.out.println(ii1 == ii2);
    }

    @Test
    public void test01()
    {
        //自动拆箱,包装类隐式转换为基本类型
        Double dd1 = 1.1;
        double d1 = 1.1;
        //相当于 dd1.doubleValue() == d1
        System.out.println(dd1 == d1);//true
        System.out.println(dd1.doubleValue() == d1);

        //基本数据类型->包装类
        Integer i1 = Integer.valueOf(1);
        Double d = Double.valueOf(1);

        //包装类->基本数据类型
        Integer i2 = new Integer(1);
        int n1 = i2.intValue();
        double n2 = i2.doubleValue();
    }

    @Test
    public void testt() {
        Integer integer = 1;
        int i = integer;
        int ii = integer.intValue();

        int i2 = 2;
       Integer inte2 =  Integer.valueOf(i2);
       Integer inte3 = i2;
        System.out.println();
    }

    @Test
    public void test02()
    {
        //Double 不存在缓存
        Double dd1 = 1.1;
        Double dd2 = 1.1;
        Double dd3 = new Double(1.1);
        Double dd4 = Double.valueOf(1.1);
        System.out.println(dd1 == dd2);//false
        System.out.println(dd1 == dd3);//false
        System.out.println(dd1 == dd4);//false
    }

    @Test
    public void test03()
    {
        //Integer默认在静态块中 缓存-128~127的Integer
        Integer ii1 = 1;
        Integer ii2 = 1;
        Integer ii3 = new Integer(1);
        Integer ii4 = Integer.valueOf(1);
        System.out.println(ii1 == ii2);// true
        System.out.println(ii1 == ii3);// false
        System.out.println(ii1 == ii4);// true
    }
    
    @Test
    public void testLong()
    {
        //long sum = 0L;
        Long sum = 0L;
        long begin = System.currentTimeMillis();
        for (long i = 0; i < Integer.MAX_VALUE; i++)
        {
            // sum+=i;
            //相当于此.Long不可变,每次new.
            sum = new Long(sum.longValue() + i);
        }
        long end = System.currentTimeMillis();
        System.out.println(sum);
        //使用包装类 和 基本数据类型 时
        System.out.println(end - begin);// 11687 1391
    }

    @Test
    public void cast()
    {
        // 包装类转成基本数据类型 前 加验证 是否为null,避免空指针异常
        Integer b = null;
        // java.lang.NullPointerException
        // int intB = b;
        if (b != null)
        {
            int bb = b;
        }
    }
}
