package com.zc.basic.z05bigdecimal;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author Flyingzc
 * BigDecimal extends Number implements Comparable
 * 不可变的,任意精度 的 有符号 十进制数.每次运算 会创建一个新的BigDecimal对象,请用新对象接收
 * 
 * BigDecimal 提供:算术,标度操作,舍入,比较,哈希,格式转换
 */
public class T01BigDecimal
{
    @Test
    public void test01()
    {
        //创建BigDecimal对象
        //方式1:使用构造器,传入int,double,long或String类型
        BigDecimal b1 = new BigDecimal(11);
        //方式2:
        BigDecimal b2 = BigDecimal.valueOf(0.48);
    }
    
    /**
     * !!!创建BigDecimal时一定往构造器中传字符串,而不是double 
     */
    @Test
    public void test02()
    {
        //1.参数类型为double的构造方法的结果有一定的不可预知性.传入1.22实际上这个double值并不是你想象的
        BigDecimal b1 = new BigDecimal(1.22);
        System.out.println(b1);//1.2199999999999999733546474089962430298328399658203125
        
        //可以将double转成String传入
        BigDecimal b3 = new BigDecimal(Double.toString(1.22));
        
        //2.String构造方法是完全可预知的
        BigDecimal b2 = new BigDecimal("1.22");
        System.out.println(b2);//1.22
    }
    
    /**
     * 测试 工具类 加减乘除
     * @throws IllegalAccessException 
     */
    @Test
    public void testBigDecimalUtil() throws IllegalAccessException
    {
        double b1 = 11.111;
        double b2 = 33.333;
        System.out.println(BigDecimalUtil.add(b1, b2));
        System.out.println(BigDecimalUtil.subtract(b1, b2));
        System.out.println(BigDecimalUtil.multiply(b1, b2));
        System.out.println(BigDecimalUtil.divide(b1, b2, 0));
    }

    @Test
    public void testToString() {
        BigDecimal b = new BigDecimal("1.22");
        System.out.println(b.toString());
        System.out.println(String.valueOf(b));
    }
}
