package com.zc.z08oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

//强转成功的条件
public class T02ZaoXing
{
    public static void main(String[] args)
    {
        //1.该引用对象指向 的对象类型确实是要强转的类型
        Fu zz = new Zi();
        Zi z = (Zi) zz;
        
        //2.该对象实现了要强转的接口
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collection<Integer> c = (Collection<Integer>) list;
    }
}

class Fu 
{
    public synchronized void swim() throws IOException,NoSuchMethodException
    {
        System.out.println("fu");
    }
}

class Zi extends Fu
{
    
}
