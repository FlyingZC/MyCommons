package com.zc.z07array;

import org.junit.Test;

public class T01ArrayStore
{
    @Test
    public void test01ArrayStoreException()
    {
        Fruit[] fruitArray = new Apple[10];
        fruitArray[0] = new Apple();
        //ArrayStoreException
        fruitArray[1] = new Fruit();
        fruitArray[2] = new Orange();
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