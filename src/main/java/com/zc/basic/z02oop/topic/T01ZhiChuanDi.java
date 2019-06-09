package com.zc.basic.z02oop.topic;

/*T3
Java的方法参数传递.在Java中方法参数传递 只有值传递,其特点如下: 
1)基本数据类型传递的是值本身,即跟这个对象没有关系了(即基本数据类型值修改后,对传进去的对象没有影响). 
2)引用数据类型传递也是引用的值,是对象的地址,而不是对象本身. 
 
main方法中的局部变量score，和add方法的形参score在栈内存中是两个变量，
 当调用add方法时，是把main方法中局部变量score的值20 赋值给add方法的形式参数score，
 所以当形参score在add方法中发生变化时不会影响到main方法中局部变量score的值。 

运行过程如下：
1.从main方法的第一行开始，定义并初始化局部变量score。 
2.实例化Answer类的对象ans，调用add方法，将main方法中的score的值 赋值给形参score，此时，形参score的值为20。 
3.计算表达式score++的值。计算后，score++表达式的值为20，score的值变为21。此处输出的是score++表达式的值，该值为20。 
4.由于形式参数score的改变不会影响main方法中score的值，故main方法中输出score仍然为20。
 * */
public class T01ZhiChuanDi
{
    public static void main(String[] args)
    {
        int score = 20;
        T01ZhiChuanDi ans = new T01ZhiChuanDi();
        ans.add(score);
        System.out.println(" main： score = " + score);// 20
        
        ans.addBefore(score);
        System.out.println(" main： score = " + score);// 20
        
        addStat(score);
        System.out.println(" main： score = " + score);// 20
    }

    private static void addStat(int score)
    {
        score = 30;
        System.out.println("addState方法中 score = " + score);// 30
    }

    void add(int score)
    {
        // 后++
        System.out.println(" add： score=" + score++);// 20
    }
    
    void addBefore(int score)
    {
        // 先++
        System.out.println(" add： score=" + ++score);// 21
    }
}
