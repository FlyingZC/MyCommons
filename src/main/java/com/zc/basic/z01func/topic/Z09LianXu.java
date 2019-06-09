package com.zc.basic.z01func.topic;

public class Z09LianXu
{
    public static void main(String[] args)
    {
        String str = "abbcabcadfcaabcdefghia";
        int maxLength = 0;
        int i = 0;
        for (; i < str.length(); i++)
        {
            int count = 1;
            for (int j = i + 1; j < str.length(); j++)
            {
                System.out.println(str.charAt(i) + " " + str.charAt(j));
                if ((str.charAt(j) - str.charAt(i)) == (j - i))
                {
                    count += 1;
                }
                else
                {
                    i = j;
                    break;
                }
                if (maxLength < count)
                {
                    maxLength = count;
                }
            }
        }
        System.out.println(maxLength);
    }
}
