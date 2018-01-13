package com.zc.z08oop;

import java.util.Arrays;

//T2
/*
 *  java的方法参数传递。在Java中方法参数传递只有值传递，其特点如下：
 *  1)基本数据类型传递的是值本身。
 *  2)引用数据类型传递也是引用的值，是对象的地址，而不是对象本身。 
 *  
 *  运行过程如下： 
 *  1.执行Question q = new Question();这句代码，在堆内存中为Question类的对象，分配内存空间并初始化成员变量num；
 *    在栈内存中分配变量q的值是堆中Question类型对象的首地址。
 *  2.执行q.num=13;将q引用的堆内存中的对象的成员变量num的值改为13。 
 *  3.调用update方法，将main方法中q的值（对象首地址）赋值给方法形式参数q，
 *    此时，方法形式参数q和main方法中q指向了同一对象。 
 *  4.在update方法找中，改变形式参数q引用的对象的属性num的值为9。 
 *  5.由于main方法中的引用q和update方法形参q指向了相同对象，
 *    所以在main方法中输出q.num的值和方法形式参数q引用的对象的属性num值应该是一样的，都是9。
 * */
public class Question
{
    private int num;

    public static void main(String[] args)
    {
        //================= 修改引用类型 =====================
        Question q = new Question();
        q.num = 13;
        updateRef(q);
        System.out.println(q.num);//9	值改变了

        //================== 修改基本类型 ====================
        int a = 3;
        /* 
         * 基本数据类型,全部分配在栈中,在调用upNormal(int 新对象)时,
         * 直接将3赋值给新对象,新对象改变不会影响到原先的变量,且新变量作用域也过了
         * */
        upNormal(3);
        System.out.println(a);//3

        //=================== 修改数组,也会改变,数组又不是基本数据类型  ===================
        int[] arr = new int[]{1,2,3};
        updateArray(arr);
        System.out.println(Arrays.toString(arr));//[3, 2, 3]
    }

    private static void updateArray(int[] arr)
    {
        if(arr != null && arr.length > 0)
        {
            arr[0] = 3;
        }
    }

    public static void updateRef(Question q)
    {
        q.num = 9;
        //注意这句与上一句的区别
        //num=9;
    }

    public static void upNormal(int a)
    {
        a = 10;
    }
}
