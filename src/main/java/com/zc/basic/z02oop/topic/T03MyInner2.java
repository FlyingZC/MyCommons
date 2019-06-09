package com.zc.basic.z02oop.topic;

/**
 * @author flyingzc
 * 定义再任何块内的内部类  和  匿名内部类
 */
public class T03MyInner2
{
    {
        class A
        {
            
        }
    }
    
    static 
    {
        class A
        {
            
        }
    }
    
    public static void main(String[] args)
    {
        // 定义在方法内的内部类.内部类可以定义在任何块内
        class A
        {
            protected String name;

            public A()
            {

            }

            public A(String name)
            {
                this.name = name;
            }

            public void print()
            {
                System.out.println(this.name);
            }
        }
        
        if (true)
        {
            class B
            {
                
            }
        }
        
        // 匿名内部类.创建一个继承自 父类的(或实现接口的) 匿名类的对象,通过new表达式返回的引用被自动转型为对父类(接口)的引用
        A obj = new A("zc")
        {
            {
                System.out.println("静态内部类中没有构造器,可以使用代码块模拟");
            }
            @Override
            public void print()
            {
                System.out.println("匿名内部类 子类重写父类的方法");
                System.out.println(this.name);
            }
        };
        obj.print();
    }
}
