package com.zc.advice;

import java.util.ArrayList;
import java.util.List;

/**
 * static final修饰的变量引用不可改变,内容可变
 * 
 * @author  zc
 * @version  [版本号, 2017年1月31日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T01StaticFinal
{
    private static final List<Integer> list = new ArrayList<Integer>();

    public static void addToList()
    {
        list.add(1);
        // Cannot assign a value to final variable 'list'
        // list = new ArrayList<Integer>();
    }
}
