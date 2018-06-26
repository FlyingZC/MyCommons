package com.zc.basic.z07array;

import org.junit.Test;

public class T01ArrayStoreException
{
    @Test
    public void test01ArrayStoreException()
    {
        Fruit[] fruitArray = new Apple[10];
        fruitArray[0] = new Apple();
        // ArrayStoreException
        fruitArray[1] = new Fruit();
        fruitArray[2] = new Orange();
    }

    @Test
    public void test02()
    {
        // 数组类型 存在父子类型,即Object[]是String[]的父类型
        // 1.java.lang.ArrayStoreException,试图将Integer类型放入String[]中
        Object[] strs = new String[3];
        strs[0] = 1;
        strs[1] = new Integer(1);
    }
}

class Fruit
{

}

class Apple extends Fruit
{

}

class Orange extends Fruit
{

}

class RedApple extends Apple
{

}
