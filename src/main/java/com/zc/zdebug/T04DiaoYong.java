package com.zc.zdebug;

public class T04DiaoYong
{
    public static void main(String[] args)
    {
        int num=1;
        A a=new A();
        num=2;
        a.show();
        num=3;
    }
}

class A
{
    public String show()
    {
        System.out.println("A's show method...");
        B b=new B();
        b.show();
        return "A's show method...";
    }
}

class B
{
    public String show()
    {
        System.out.println("B show method...");
        C c=new C();
        c.show();
        return "A's show method...";
    }
}

class C
{
    public String show()
    {
        System.out.println("C show method...");
        D.show();
        return "C show method...";
    }
}

class D
{
    public static void show()
    {
        System.out.println("D static show method...");
        new E().show();
    }
}

class E
{
    public void show()
    {
        System.out.println("E show method...");
    }
}
