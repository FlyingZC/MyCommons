package com.zc.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>内存溢出.创建了大量对象
 * <功能详细描述>
 * 
 * @author  zc
 * @version  [版本号, 2017年1月31日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T01OutOfMemoryError
{
    public static void main(String[] args)
    {
        List<Object> list = new ArrayList<Object>();
        while (true)
        {
            list.add(new Object());
        }
    }
}
