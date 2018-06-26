package com.zc.vm;

import java.util.List;

public class T05GenOverload
{
    /**
     * 重载不依据返回值类型
     * 但在Class文件中,只要描述符不完全一致的两个方法就可以共存
     * 即两个方法若有相同的名称和特征签名,但返回值不同,则可以合法共存于一个Class文件中
     * 有的jdk版本能编译通过,有的不能
     * Erasure of method method(List<String>) is the same as another method in type T05GenOverload
     * 泛型擦除后为相同的方法
     * */
    /* public static String method(List<String> list)
    {
        System.out.println("调用method(List<String> list)");
        return "";
    }*/
    /* public static int method(List<Integer> list)
    {
        System.out.println("调用method(List<String> list)");
        return 1;
    }*/
    //警告Erasure of method method(List<Integer>) is the same as another method in type T05GenOverload
    public static int method(List<Integer> list)
    {
        System.out.println("调用method(List<String> list)");
        return 1;
    }

}
