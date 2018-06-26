package com.zc.basic.zenum;
//每个枚举类都是继承自java.lang.Enum
public enum Color
{
    //1.枚举用于定义常量.以下均为该枚举类的实例.都是Color类型!!!多个枚举实例之间逗号,最后;号
    //2.每个枚举常量后面括号中的数值就是传递给构造器的参数.如ORANGE(5,"orangeColor")调用的是有参构造方法
    RED, GREEN, BLANK, YELLOW, ORANGE(5, "orangeColor");
    
    //3.自定义 成员变量  
    private String name;

    private int index;

    //枚举类的默认构造方法为private,因为实例数量已经确定.Red,Green...
    private Color()
    {

    }

    private Color(int index, String name)
    {
        this.index = index;
        this.name = name;
    }
    
    //3.在枚举类中定义自己的方法
    // 自定义普通静态方法  
    public static String getMyName(int index)
    {
        for (Color c : Color.values())
        {
            if (c.getIndex() == index)
            {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法  
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }
}
