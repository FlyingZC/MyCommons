package com.zc.z01guava;
//静态导入Preconditions类中的所有静态方法
import static com.google.common.base.Preconditions.*;

public class T04Preconditions
{
    public static void main(String[] args)
    {
        String name = null;
        //Exception in thread "main" java.lang.NullPointerException: name不能为null
        //Preconditions.checkNotNull(name,"name不能为null");
        //检查表达式是否为true
        checkArgument(true,"表达式不为真");
        //检查表达式是否为null
        checkNotNull(new String(),"str不能为null");
        //checkState();
        String str="23242";
        checkElementIndex(2,str.length());
    }
}
