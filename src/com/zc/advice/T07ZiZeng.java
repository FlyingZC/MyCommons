package com.zc.advice;

public class T07ZiZeng
{
    /** <自增++>
     * 在java中(其他语言未必如此)
     * 先把count的值(0)拷贝到一个临时变量区
     * count变量加1,count值为1
     * 返回临时变量区的值,即0
     * 返回值赋值给count,即count重置为0
     * @param args
     * @see [类、类#方法、类#成员]
     */
    public static void main(String[] args)
    {
        int count=0;
        for(int i=0;i<10;i++)
        {//!!!
            count=count++;
        }
        System.out.println(count);//0   
        //相当于
        System.out.println(doubleAdd(0));
    }
    public static int doubleAdd(int count){
        int temp=count;
        count=count+1;
        return temp;
    }
}
