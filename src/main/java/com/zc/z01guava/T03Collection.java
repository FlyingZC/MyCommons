package com.zc.z01guava;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

public class T03Collection
{
    //不可变对象因为有固定不变，可以作为常量来安全使用
    public static final ImmutableSet<String> COLOR_NAMES
    =ImmutableSet.<String>of("red","orange","yellow");
    
    @Test
    public void testImmutable(){
        /*
           Immutable集合使用方法：
                        　　一个immutable集合可以有以下几种方式来创建：
                        　　1.用copyOf方法, 譬如, ImmutableSet.copyOf(set)
                        　　2.使用of方法，譬如，ImmutableSet.of("a", "b", "c")或者ImmutableMap.of("a", 1, "b", 2)
                        　　3.使用Builder类
         * */
        List<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list："+list);
        //通过List创建ImmutableList
        ImmutableList<String> imList=ImmutableList.copyOf(list);
        System.out.println("imlist:"+imList);
        //直接通过添加元素创建ImmutableList
        ImmutableList<String> imOfList=ImmutableList.of("peida","jerry","harry");
        System.out.println("imOfList:"+imOfList);
        //imSortSet:[a, b, c]中元素顺序 在创建时已经确定
        ImmutableSortedSet<String> imSortSet=ImmutableSortedSet.of("a","b","c");
        System.out.println("imSortSet:"+imSortSet);
        
        list.add("babby");
        System.out.println("添加新元素后点的list:"+list);
        //原始集合添加元素后,原始集合改变.但是ImmutableList中的元素不发生变化
        System.out.println("添加新元素后点的imList:"+imList);
        //采用builder生成ImmutableList
        ImmutableSet<String> imColorSet=ImmutableSet.<String>builder()
                .add(new String("a"))
                .add(new String("c"))
                .build();
        System.out.println("imColorSet:"+imColorSet);
    }
    @Test
    public void testCotyOf(){
        ImmutableSet<String> imSet=ImmutableSet.of("peida","jerry","harry","lisa");
        System.out.println("imSet："+imSet);
        ImmutableList<String> imlist=ImmutableList.copyOf(imSet);
        System.out.println("imlist："+imlist);
        ImmutableSortedSet<String> imSortSet=ImmutableSortedSet.copyOf(imSet);
        System.out.println("imSortSet："+imSortSet);
        
        List<String> list=new ArrayList<String>();
        for(int i=0;i<20;i++){
            list.add(i+"x");
        }
        System.out.println("list："+list);
        ImmutableList<String> imInfolist=ImmutableList.copyOf(list.subList(2, 18));
        System.out.println("imInfolist："+imInfolist);
        int imInfolistSize=imInfolist.size();
        System.out.println("imInfolistSize："+imInfolistSize);
        ImmutableSet<String> imInfoSet=ImmutableSet.copyOf(imInfolist.subList(2, imInfolistSize-3));
        System.out.println("imInfoSet："+imInfoSet);
    }
}
