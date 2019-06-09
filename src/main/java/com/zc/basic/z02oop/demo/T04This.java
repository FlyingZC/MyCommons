package com.zc.basic.z02oop.demo;

//t01
public class T04This
{
    public static void main(String[] args)
    {
        Point p = new Point();
        p.step(10);
    }
}

class Point
{
    int y = 7;

    public void step(int y)
    {//10
        y += y;//20
        this.y += y;//27
        System.out.println(y);//20
        System.out.println(this.y);//27
    }
}
