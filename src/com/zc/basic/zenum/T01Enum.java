package com.zc.basic.zenum;

import java.util.Arrays;

public class T01Enum
{
    //枚举与switch配合使用
    public static void main(String[] args)
    {
        Color red = Color.RED;
        switch (red)
        {
            case BLANK:
                red = Color.BLANK;
                break;
            case RED:
                red = Color.RED;
                break;
            default:
                red = Color.YELLOW;
        }

        //========================================
        //枚举类中自带的方法 values(),valueOf(str),name(),ordinal()

        //枚举类自带的values()方法,返回该枚举类的所有实例
        Color[] cs = Color.values();
        System.out.println(Arrays.toString(cs));//[RED, GREEN, BLANK, YELLOW, ORANGE]

        //静态方法valueOf()根据枚举实例的常量名  -> 枚举实例
        Color c = Color.valueOf("RED");
        System.out.println(c);//RED

        //枚举对象.name():返回该枚举实例在枚举类中定义时的名字
        System.out.println(c.name());//RED
        //直接输出枚举对象,和上述结果相同
        System.out.println(c);//RED

        //返回该枚举常量在枚举类中的数字位置
        System.out.println(c.ordinal());//0

        //========================================
        //以下为自定义方法
        //调用枚举类中的 自定义静态方法
        String c1 = Color.getMyName(0);
        System.out.println(c1);
        System.out.println(c.getIndex());//0
        System.out.println(c.getName());//null
    }
}
