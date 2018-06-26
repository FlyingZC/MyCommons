package com.zc.advice;

import java.util.Random;

/**
 * <随机数>
 *在同一台机器上,若指定了随机数种子,无论打印多少次,随机数顺序都是相同的
 *种子不同,随机数不同
 *种子相同,即使实例不同也产生相同的随机数 
 * @author  Administrator
 * @version  [版本号, 2017年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T30Random
{
    public static void main(String[] args)
    {
        //多次打印,结果相同.因为new Random(100)指定了种子为100
        Random r=new Random(100);
        for(int i=0;i<4;i++)
        {
         //每次输出为15,50,74,88
         System.out.println(r.nextInt(100));   
        }
        //2.不指定种子,默认使用System.nanoTime()经过运算得到的值作为种子(时间在走,所以每次调用种子都会不同)
        Random rand=new Random();
        System.out.println(rand.nextInt(100));
    }
}
