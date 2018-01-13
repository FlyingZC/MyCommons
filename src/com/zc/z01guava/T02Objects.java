package com.zc.z01guava;

import com.google.common.base.Objects;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

public class T02Objects
{
    public static void main(String[] args)
    {
        System.out.println(Objects.equal("a", "a"));//true
        System.out.println(Objects.equal(null, "a"));//false
        System.out.println(Objects.equal("a", null));//false
        System.out.println(Objects.equal(null, null));//true
        System.out.println("----myEqual---");
        System.out.println(myEqual("a", "a"));
        System.out.println(myEqual(null, "a"));
        System.out.println(myEqual("a",null));
        System.out.println(myEqual(null, null));
        System.out.println("---hashCode---");
        System.out.println(Objects.hashCode(new String[]{"a","b","c"}));
        System.out.println(myHashCode(new String[]{"a","b","c"}));
        
        Ordering<String> compare=new Ordering<String>(){

            @Override
            public int compare(String left, String right)
            {
                return Ints.compare(left.length(), right.length());
            }
            
        };
        System.out.println("----");
        System.out.println("----");
        System.out.println("----");
        System.out.println(null==null);
        System.out.println(a(-1));
    }
    public static boolean a(int a){
        return a>0;
    }
    
    public static boolean myEqual(Object a,Object b){
        return a==b||(a!=null&&a.equals(b));
    }
    
    public static int myHashCode(Object...objs){
        if(objs==null)
            return 0;
        
        int result=1;
        for(Object elem:objs){
            result=31*result+(elem==null?0:elem.hashCode());
        }
        return result;
    }
    
    public static <T>T myCheckNotNull(T reference){
        if(reference==null)
            throw new NullPointerException();

        return reference;
    }
    
}
