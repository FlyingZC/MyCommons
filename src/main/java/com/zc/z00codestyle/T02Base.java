package com.zc.z00codestyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author flyingzc
 * 控制语句代码规范
 */
public class T02Base
{
    @Test
    public void testSwitch()
    {
        switch (1)
        {
            case 0:
                break;
            case 1:
                // 注释下不加break的case执行到哪例
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("hello");
                break;
            case 6:
                break;
            // 一定有个default
            default:
        }
    }

    /**
     * 注释规范
     */
    @Test
    public void testZhuShi()
    {
        // TODO : (zc, 20180202) 代办事宜
        // FIXME : (zc, 20180202)
    }

    /**
     * 空指针规避
     */
    @Test
    public void testNPE()
    {
        //testNPE1();

    }

    /**
     * 1.返回类型为包装数据类型, 有可能为null, 方法返回int时注意判空
     * 2.数据库查询结果可能为null
     */
    public int testNPE1()
    {
        Integer in = null;
        // 相当于in.intValue();自动拆箱 报空指针
        return in;
    }

    /**
     * 3.集合中的元素即使isNotEmpty, 取出的数据元素也可能为null
     * 4.远程调用返回的对象, 一律要求进行NPE判断
     * 5.级联调用obj.getA().getB().getC()一连串调用,容易产生NPE
     * @return
     */
    public String testNPE2()
    {
        List<String> list1 = new ArrayList<String>(Arrays.asList("a", null, "b"));
        if (list1 != null && list1.size() > 0)
        {
            // 返回null
            return list1.get(1);
        }
        return null;
    }
    
    

}
