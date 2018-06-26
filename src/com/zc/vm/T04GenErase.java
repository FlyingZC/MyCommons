package com.zc.vm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * <一句话功能简述>泛型擦除
 * <功能详细描述>
 * 
 * @author  Flyin
 * @version  [版本号, 2017年1月31日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T04GenErase
{
    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "呵呵");
        map.put("how", "哈哈");
        System.out.println(map.get("hello"));

        //现在value可放任意Object类型
        Map map2 = map;
        map2.put("hello2", new Object());

        //现在value(只能存入)Integer类型(编译期检查).但事实上value仍未Object
        Map<String, Integer> map3 = map2;
        Set<Entry<String, Integer>> entrySet = map3.entrySet();
        Iterator<Entry<String, Integer>> it = entrySet.iterator();
        /**
         *  呵呵
            hello=呵呵
            hello2=java.lang.Object@15db9742
            hello2=1
        
         * */
        while (it.hasNext())
        {
            System.out.println(it.next());
        }

    }
}
