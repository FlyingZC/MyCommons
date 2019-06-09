package com.zc.advice;

/**
 * <静态变量static>
 *静态变量在类初始化时首先被加载到方法区.未赋值
 *!!!再根据静态块顺序赋值 
 * @author  zc
 * @version  [版本号, 2017年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T32Static
{
    public void setAge(int age)
    {//成员变量age作用域是类内的,随便在哪声明
        this.age=age;
    }
    //2.根据静态库顺序赋值
    static
    {
        i=100;
    }
    //1.静态变量在类初始化时加载到方法区,未赋值
    public static int i=1;//先赋值为100,后赋值为1
    
    private int age;
    public static void main(String[] args)
    {
        System.out.println(T32Static.i);//1
    }
}
