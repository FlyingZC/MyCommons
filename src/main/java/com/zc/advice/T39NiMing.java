package com.zc.advice;

import java.util.ArrayList;
import java.util.List;

public class T39NiMing
{
    //匿名类+代码块
    List list4=new ArrayList(){{}{}{}{}{}{}{}};
    public static void main(String[] args)
    {
        List list1=new ArrayList();
        List list2=new ArrayList(){};//匿名类
        List list3=new ArrayList(){{}};//匿名类加代码块
        List list4=new ArrayList(){{}{}{}{}{}{}{}};//匿名类加多个代码块
        System.out.println(list1.getClass()==list2.getClass());
        System.out.println(list2.getClass()==list3.getClass());
    }
}
