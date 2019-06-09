package com.zc.zjunit;
//这里import static是引入Assert类中静态属性或静态方法的写法。
//原来要Assert.fail()，现在只需直接fail()即可，即省略了Assert。
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MyServiceTest
{

    @BeforeClass
    public static void setUpBeforeClass()
    {
        System.out.println("BeforeClass");
    }
    @Before
    public void setUp()
    {
        System.out.println("Before");
    }
    @After
    public void after()
    {
        System.out.println("After");
    }
    @AfterClass
    public static void afterClass()
    {
        System.out.println("AfterClass");
    }
    @Test
    public void testHello()
    {
        byte[] excepted="trial".getBytes();
        byte[] actual="trial1".getBytes();
        //断言相等. 若断言失败,则直接在此处抛异常
        Assert.assertArrayEquals("failure -byte arrays not same",excepted, actual);
        byte[] excepted1="trial".getBytes();
        byte[] actual1="trial".getBytes();
        Assert.assertArrayEquals("failure -byte arrays not same",excepted1, actual1);
    }

    @Test
    public void testHelp()
    {//断言
        Assert.assertNotEquals(12, 13);
        Assert.assertNull(null);
        Assert.assertNotNull(new MyService());
        Assert.assertSame("hehe", "hehe");
        Assert.assertTrue(true);
        Assert.assertFalse(false);
        Assert.assertEquals("failuer -not equals",12, 12);
        fail();
    }

    @Test
    public void testHehe()
    {
        System.out.println("Test");
    }

    @Ignore
    public void ignore()
    {
        
    }
}
