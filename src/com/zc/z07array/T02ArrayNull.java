package com.zc.z07array;

import org.junit.Test;

public class T02ArrayNull
{
    @Test
    public void test01()
    {
        Integer[] arr = new Integer[] {1, 2, 3};
        Integer num1 = arr[1];
        //该 修改 不会 影响 到 存在 堆 中 的 数组中的值
        num1 = null;
        //2
        System.out.println(arr[1]);
    }

}
