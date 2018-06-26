package com.zc.advice;

/**
 * <静态方法不能被重写>
 * 若子类中不覆盖(隐藏)父类中的静态方法,也可通过 子类.静态方法名  调用父类中的静态方法
 * 调用静态方法时,根据声明类型调用,如Sup s=new Sub();s.doStatMethod();调用的是父类中的静态方法
 * @author  zc
 * @version  [版本号, 2017年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T33Static
{
    public static void main(String[] args)
    {
        Base base=new Sub();
        base.doStatMethod();//会调用父类中的静态方法
        base.doNormalMethod();//调用子类中的非静态方法
        
        Sub sub=new Sub();
        sub.doStatMethod();//调用子类中的静态方法
        sub.doNormalMethod();//调用子类中的非静态方法
        Sub.superStatMethod2();//(子类对象调用)父类中的静态方法,子类中没有同名方法
    }
}
class Base
{

    public static void doStatMethod()
    {
        System.out.println("父类静态方法");
    }

    public static void superStatMethod2()
    {
        System.out.println("父类中的静态方法,子类中没有同名方法");
    }
    
    public void doNormalMethod()
    {
        System.out.println("父类普通方法");
    }

}
class Sub extends Base
{   //静态方法没有@Override
    public static void doStatMethod()
    {
        System.out.println("子类静态方法");
    }
    @Override
    public void doNormalMethod()
    {
        System.out.println("子类普通方法");
    }
}