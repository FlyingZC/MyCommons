package com.zc.basic.z02oop.topic;

import java.util.ArrayList;
import java.util.Collection;

import com.zc.basic.z02oop.demo.extend.Fu;
import com.zc.basic.z02oop.demo.extend.Zi;

// 强转成功的条件
public class T02ZaoXing
{
    public static void main(String[] args)
    {
        // 1.该引用对象指向 的对象类型确实是要强转的类型
        Fu zz = new Zi();
        Zi z = (Zi) zz;

        // 2.该对象实现了要强转的接口
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collection<Integer> c = (Collection<Integer>) list;
    }
}
