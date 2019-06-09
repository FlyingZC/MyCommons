package com.zc.zdebug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T01
{
    private static String job;
    private String name;
    public static void main(String[] args)
    {
        T01 t=new T01();
        job="a";
        t.name="b";
        Map<String,String> map=new HashMap<String,String>();
        List<String> list=new ArrayList<String>();
        String name="c";
        t.name="c";
        for(int i=0;i<500;i++){
            map.put("k"+i,"v"+i);
            list.add("L"+i);
            System.out.println(i);
            if(i==10){
                System.out.println("查看list,map");
            }
            if(i==301){
                name="a";
                t.name="d";
            }else if(i==400){
                name="b";
                t.name="e";
            }else if(i==401){
                name="a";
                t.name="f";
                hello(new String("aaa"));
            }
            else if(i==450){
                throw new RuntimeException("异常");
            }
        }
    }

    private static void hello(String s)
    {
        System.out.println(s);
    }
    
}
