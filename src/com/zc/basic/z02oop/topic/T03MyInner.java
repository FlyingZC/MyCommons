package com.zc.basic.z02oop.topic;

/**
 * @author flyingzc
 * 内部类
 */
public class T03MyInner
{

    //如果写了两个main方法,eclipse会提示让你选择一个运行.一个入口
    public static void main(String[] args)
    {
        System.out.println("外部类的main ");
        // 普通内部类 对象的创建. 必须使用外部类对象 去 创建 内部类对象
        new MyOuter().new MyInner().print();
        // 静态内部类 对象的创建. 由于静态内部类相当于 属于 外部类的static域.直接 "点"调用
        new MyOuter.MyInnerStatic().print();
    }

}

class MyOuter
{
    private String name = "MyOuterName";
    
    private static String outStatName = "MyOuterStatName";
    
    // 1.普通内部类
    class MyInner
    {
        private String name = "MyInnerName";
        // 普通内部类中不能有static域
        // private static String statName = "";
        // 普通内部类 可以有static final修饰的域
        private static final String statFinalName = "";
        
        public void print()
        {
            System.out.println("==成员内部类的print方法==");
            // 访问内部类中的成员变量
            System.out.println(name);
            // 访问内部类中的成员变量
            System.out.println(this.name);
            // 指代外部类的成员变量,内部类可以直接访问外部类的成员变量
            System.out.println(MyOuter.this.name);
        }
    }
    
    // 2.静态内部类. 只能访问外部类的static域
    public static class MyInnerStatic
    {
        private String name = "MyInnerName";
        
        // 静态内部类 内部 可嵌套 其他静态内部类或普通内部类. 普通内部类 内部 不能嵌套静态内部类
        static class A
        {
            static class B
            {
                static class C
                {
                    class D
                    {
                        class E
                        {
                            /*static class F
                            {
                                
                            }*/
                        }
                    }
                }
            }
        }
        
        //内部类里也可以写main方法,且可以执行,前提是内部类用static修饰
        public static void main(String[] args)
        {
            new MyInnerStatic().print();
        }

        public void print()
        {
            System.out.println("==静态内部类的print方法==");
            // 内部类的成员变量
            System.out.println(name);
            // 内部类的成员变量
            System.out.println(this.name);
            // 外部类的静态域.不能访问外部类的成员变量
            System.out.println(MyOuter.outStatName);
        }
    }
    
}
