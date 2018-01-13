package com.zc.z01guava;

import com.google.common.collect.ComparisonChain;

public class Person
{
    private int age;
    private String name;
    public Person(int age, String name)
    {
        this.age=age;
        this.name=name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    /**guava中的链式comparisonChain*/
    public int compareTo(Person that){
        return ComparisonChain.start()
                .compare(this.name, that.name)
                .compare(this.age, that.age)
                .result();
    }
}
