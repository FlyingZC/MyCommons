package com.zc.basic.z02oop.demo.extend;

// 值传递
public class T01Value
{
    public static void main(String[] args)
    {
        Person p = new Person();
        T01Value t = new T01Value();
        //传入参数p时将引用p传入(方法内外指向堆空间的同一个Person对象)
        t.changePerson(p);
        System.out.println(p);//Person [age=0, name=zc]

        t.changePerson2(p);
        System.out.println(p);//Person [age=0, name=zc]

        //基本数据类型传入1
        int i = 1;
        t.changeBase(i);
        System.out.println(i);//1.不影响
    }

    public void changePerson(Person p)
    {
        p.setName("zc");
    }

    //值传递
    public void changePerson2(Person p)
    {
        p.setName("zc");
        //修改p的引用
        p = new Person();
        p.setName("newzcc");
    }

    public void changeBase(int a)
    {
        //该a为局部变量,方法结束销毁
        a = 1000;
    }
}
