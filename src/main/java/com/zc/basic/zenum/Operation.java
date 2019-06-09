package com.zc.basic.zenum;

/**
 * 枚举类中定义抽象方法,则在每个枚举实例中需要予以实现
 * 
 * @author  zc
 * @version  [版本号, 2017年3月28日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public enum Operation
{
    //枚举类的实例,使用代码块实现枚举类中的抽象方法
    PLUS
    {
        //实例中需予以实现
        @Override
        double apply(double x, double y)
        {
            return x + y;
        }
    },
    
    MINUS
    {
        @Override
        double apply(double x, double y)
        {
            return x - y;
        }
    };
    
    //枚举类中定义抽象方法
    abstract double apply(double x, double y);
}
