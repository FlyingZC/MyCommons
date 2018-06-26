package com.zc.basic.z02oop.topic;

// 可变个数参数	和	数组参数
public class T03variableParam
{
    public static void main(String[] args)
    {
        Snow s = new Snow();
        System.out.println(s.jump(4, 5));
        // 可变个数形参    可以接收数组类型的参数,或可变个数的参数.而int[] vals只能接收数组参数
        System.out.println(s.jump(new int[] {1, 3}));
        System.out.println(s.jump(1, 2, 3));
    }
}

class Snow
{
    public String jump(int x, int y)
    {
        return "jump one";
    }

    // int[] vals参数列表和int...args参数列表不能同时出现
    /*public String jump(int[] vals) {
    	return "jump two";
    }*/

    public String jump(int... args)
    {
        return "jump three";
    }

}
