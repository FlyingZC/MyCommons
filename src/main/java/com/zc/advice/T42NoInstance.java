package com.zc.advice;

public class T42NoInstance
{
    
}
//由于该类的无参构造器为私有.则不能有子类
class NoInstance
{
    private NoInstance()
    {
        throw new Error("不要实例化我");
    }
}
//若创建子类则报错,因为父类无法创建
//Implicit super constructor NoInstance() is not visible for default constructor. 
//Must define an explicit constructor
/*class NoInstanceSub extends NoInstance
{
    
}*/