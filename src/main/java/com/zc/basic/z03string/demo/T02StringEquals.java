package com.zc.basic.z03string.demo;

import org.junit.Test;

public class T02StringEquals
{
    @Test
    public void test1()
    {
        String str1 = "JavaEE";
        String str2 = "JavaEE";

        String str3 = new String("JavaEE");
        String str4 = "JavaEE" + "Android";
        String str5 = "Android";
        String str6 = str1 + str5;

        str5 = str5 + "Hadoop";
        String str7 = "AndroidHadoop";

        String str8 = "Android" + "Hadoop";

        System.out.println(str1 == str2);//true

        System.out.println(str1 == str3);//false

        System.out.println(str1.equals(str3));//true
        // 只要 右值 中 出现字符串对象(String变量名),都返回false    
        System.out.println(str4 == str6);//false??

        System.out.println(str4.equals(str6));//true
        //??
        System.out.println(str5 == str7);//false
        System.out.println(str5.equals(str7));
        System.out.println(str5.hashCode());
        System.out.println(str7.hashCode());

        System.out.println(str7 == str8);//true

        Person p1 = new Person(111, "AA");
        Person p2 = new Person(111, "AA");
        //栈空间不同的引用指向堆空间不同的new的对象
        System.out.println(p1 == p2);//false
        //name属性都放在字符串常量池中
        System.out.println(p1.name == p2.name);//true
        System.out.println(p1.id == p2.id);//true
    }

    //常用方法
    /*
     * public int length()
     * public char charAt(int index):返回指定索引.index从0开始
     * bolean equals(Object obj):比较字符串是否相等
     * */
    @Test
    public void test2()
    {
        String str1 = "abcdefg";
        String str2 = "adcc";
        System.out.println(str2.length());
        System.out.println(str1.charAt(2));
        System.out.println(str1.compareTo(str2));
    }

    @Test
    public void testStrFalse()
    {
        String str1 = "a";
        String str2 = str1 + "b";
        String str3 = "ab";
        String str4 = "a" + "b";
        System.out.println(str2 == str3);
        System.out.println(str3 == str4);
    }
}

class Person
{
    int id;

    String name;

    Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

}
