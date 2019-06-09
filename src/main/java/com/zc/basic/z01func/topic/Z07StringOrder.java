package com.zc.basic.z01func.topic;

import java.util.Arrays;

//任意数字序列“123456”之类，输出它们所有的排列组合
public class Z07StringOrder
{
    public static void main(String[] args)
    {
        String s1 = "123456";
        char[] c1 = s1.toCharArray();
        char[] c2 = Arrays.copyOf(c1, c1.length);

        for (int i = 0; i < c1.length; i++)
        {
            for (int j = i + 1; j < c2.length; j++)
            {

            }
        }

    }
}
