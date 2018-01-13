package com.zc.z01guava;

import com.google.common.base.Optional;

public class T01Optional
{
    public static void main(String[] args)
    {
        //　Optional.of(T)：获得一个Optional对象，其内部包含了一个非null的T数据类型实例，若T=null，则立刻报错。
        Optional<Integer> possible = Optional.of(5);
        if (possible.isPresent())
        {
            //isPresent()来判断是否返回了期望的值.boolean isPresent()：如果Optional包含的T实例不为null，则返回true；若T实例为null，返回false
            System.out.println("possible isPresent:" + possible.isPresent());
            //get()来获得实际的返回值
            System.out.println("possible value:" + possible.get());
        }
        //获得一个Optional对象，其内部包含了空值
        Optional<Integer> absentOpt = Optional.absent();
        //将一个T的实例转换为Optional对象，T的实例可以不为空，也可以为空
        //Optional.fromNullable(null)和Optional.absent()等价。此时obj.isPresent()返回false
        Optional<Integer> nullableOpt = Optional.fromNullable(null);
        if (absentOpt.isPresent())
        {
            System.out.println("absentOpt isPresent:" + absentOpt.isPresent());
            System.out.println("absentOpt value:" + absentOpt.get());
        }
        if (nullableOpt.isPresent())
        {
            System.out.println("nullableOpt isPresent:" + nullableOpt.isPresent());
            System.out.println("nullableOpt value:" + nullableOpt.get());
        }
        Optional<Integer> noNullableOpt = Optional.fromNullable(1);
        if (noNullableOpt.isPresent())
        {
            System.out.println("noNullableOpt isPresent:" + noNullableOpt.isPresent());
            System.out.println("noNullableOpt value:" + noNullableOpt.get());
        }

        /*java.lang.NullPointerException
        at com.google.common.base.Preconditions.checkNotNull(Preconditions.java:210)*/
        Optional<Integer> possible1 = Optional.of(null);
        if (possible.isPresent())
        {
            System.out.println("possible1 isPresent:" + possible1.isPresent());
            System.out.println("possible1 value:" + possible1.get());
        }
    }
}
