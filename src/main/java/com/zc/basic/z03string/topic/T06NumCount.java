package com.zc.basic.z03string.topic;

/**
 * @author flyingzc
 * 统计每个字符出现的次数
 */
public class T06NumCount
{
    public static void main(String[] args)
    {
        String str = "ewrwqFrewqfsadfdsfdsfs";
        str = str.toLowerCase();
        int count = 0;
        while (str.length() > 0)
        {
            int oldLength = str.length();
            char first = str.charAt(0);
            // 去除所有相同字符后的新字符串
            String strNew = str.replaceAll(String.valueOf(first), "");
            if (oldLength > strNew.length())
            {
                // 原来字符串长度 减去 现在长度 得到去除字符串的个数
                count = oldLength - strNew.length();
                // 将新字符串赋给当前字符串
                str = strNew;
                System.out.println(first + "出现次数: " + count);
            }
        }
    }
}
