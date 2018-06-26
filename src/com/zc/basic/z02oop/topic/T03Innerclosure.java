package com.zc.basic.z02oop.topic;

import com.zc.basic.z02oop.topic.Outer.Inner;

/**
 * <一句话功能简述>匿名内部类实现闭包
 * <功能详细描述>
 * 
 * @author  zc
 * @version  [版本号, 2017年2月7日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T03Innerclosure
{
    public static void main(String[] args)
    {
        Outer outer = new Outer();
        Inner inner = outer.getInner();
        String outName = inner.innerMethod();
        System.out.println(outName);
    }
}

class Outer
{
    private String outName = "I am out";

    public Inner getInner()
    {
        return new Inner();
    }
    // 普通内部类
    class Inner
    {
        public String innerMethod()
        {
            return outName;
        }
    }
}
