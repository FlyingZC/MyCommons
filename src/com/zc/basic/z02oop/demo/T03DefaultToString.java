package com.zc.basic.z02oop.demo;

// 默认Object中的toString()输出	包名.类名@散列码
public class T03DefaultToString
{
    public static void main(String[] args)
    {
        Person p = new Person();
        System.out.println(p);
        System.out.println(p.toString());
        /*
         * com.zc.ooad.Person@2b571dff
        	com.zc.ooad.Person@2b571dff
         * */
    }
}

class Person
{

}
