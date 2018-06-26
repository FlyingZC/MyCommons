package com.zc.basic.z02oop.topic;

import com.zc.basic.z02oop.demo.extend.Fu;
import com.zc.basic.z02oop.demo.extend.Zi;
import com.zc.basic.z02oop.demo.extend.Zi2;

public class T05instanceof
{
    public static void main(String[] args)
    {
        // Fu fu2=new Zi();
        Fu fu2 = null;
        // instanceof后面加类型   null instanceof 类型 : 永远返回false
        if (fu2 instanceof Zi)// false
        {
            // 强转必须赋给引用,否则编译期报错
            Zi z2 = (Zi) fu2;
            Zi2 z22 = (Zi2) fu2;// ClassCastException
        }
    }
}
