package com.zc.z01guava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;

/**
Multiset:可保存多个相同对象的set,不保证顺序.例如:跟踪每种对象的数量
SortedMultiset
Multimap:将一个key映射到多个value上
ListMultimap
SetMultimap
BiMap:key和value双向关联,即通过value也可以查询出key.要求value唯一
ClassToInstanceMap
Table
 * 
 * @author  Administrator
 * @version  [版本号, 2017年1月13日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T05NewCollection
{
    @Test
    public void testWordCount(){
        String strWorld="wer|dffd|ddsa|dfd|dreg|de|dr|ce|ghrt|cf|gt|ser|tg|ghrt|cf|gt|" +
                "ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr|wer|dffd|ddsa|dfd|dreg|de|dr|" +
                "ce|ghrt|cf|gt|ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr";
        String[] words=strWorld.split("\\|");
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        for (String word : words) {
            Integer count = countMap.get(word);
            if (count == null) { 
                countMap.put(word, 1); 
            }
            else { 
                countMap.put(word, count + 1); 
            }
        }        
        System.out.println("countMap：");
        for(String key:countMap.keySet()){
            System.out.println(key+" count："+countMap.get(key));
        }
    }
    
    @Test
    public void testMySplit(){
        String strs="wer|dffd|ddsa|dfd|dreg|de|dr|ce|ghrt|cf|gt|ser|tg|ghrt|cf|gt|" +
                "ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr|wer|dffd|ddsa|dfd|dreg|de|dr|" +
                "ce|ghrt|cf|gt|ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr";
        String[] splitStrs=strs.split("\\|");
        Map<String,Integer> map=new HashMap<String,Integer>(); 
        for(String s:splitStrs){
            if(!map.containsKey(s)){
                map.put(s, 1);
            }else{
                map.put(s, map.get(s)+1);
            }
        }
        Iterator<Entry<String,Integer>> it=map.entrySet().iterator();
        while(it.hasNext()){
            Entry<String,Integer> e=it.next();
            System.out.println(e.getKey()+":"+e.getValue());
        }
    }
    
    @Test
    public void testMultsetWordCount(){
        String strWorld="wer|dfd|dd|dfd|dda|de|dr";
        String[] words=strWorld.split("\\|");
        List<String> wordList=new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }
        //创建Multiset:无序 可重复
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);
     
        for(String key:wordsMultiset.elementSet()){
            //count(key):用于统计同一个key的数量
            System.out.println(key+" count："+wordsMultiset.count(key));
        }
    }
    
    @Test
    public void testMultimap(){
        //若用ArrayListMultimap,则key的value为List
        Multimap<String,Person> personMultimap=ArrayListMultimap.create();
        for(int i=0;i<20;i++){
            personMultimap.put("per", new Person(i,"zx"+i));
        }
        for(int i=0;i<10;i++){
            personMultimap.put("pax", new Person(i,"za"+i));
        }
        System.out.println(personMultimap.size());
        System.out.println(personMultimap.keys());
        System.out.println(personMultimap.get("per"));
    }
    
    
    @Test
    public void testReverseMap(){
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("1.txt", 1);
        map.put("2.txt", 2);
        map.put("3.txt", 3);
        map.put("4.txt", 4);
        Map<Integer,String> reverseMap=new HashMap<Integer,String>();
        for(Map.Entry<String, Integer> m:map.entrySet()){
            reverseMap.put(m.getValue(), m.getKey());
        }
        for(Map.Entry<Integer,String> m:reverseMap.entrySet()){
            System.out.println(m.getKey()+":"+m.getValue());
        }
    }
    
    @Test
    public void bimapTest(){
        BiMap<Integer,String> logfileMap = HashBiMap.create(); 
        logfileMap.put(1,"a.log");
        logfileMap.put(2,"b.log");
        logfileMap.put(3,"c.log"); 
        System.out.println("logfileMap:"+logfileMap); 
        BiMap<String,Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:"+filelogMap);
        
        logfileMap.put(4,"d.log"); 

        System.out.println("logfileMap:"+logfileMap); 
        System.out.println("filelogMap:"+filelogMap); 
    }
    
    @Test
    public void tableTest(){
        Table<String,Integer,String> table=HashBasedTable.create();
        for(char a='A';a<'D';a++){//行
            for(Integer b=1;b<=4;b++){//列
                //元素
                table.put(String.valueOf(a), Integer.valueOf(b), String.valueOf(a)+b);
            }
        }
        System.out.println(table.row("B"));
        System.out.println(table.column(3));
        System.out.println(table.contains("A", 1));
        System.out.println(table.containsColumn(2));
        System.out.println(table.containsRow("A"));
        System.out.println(table.columnMap());
        System.out.println(table.rowMap());
        System.out.println(table.remove("B", 3));
    }
    
    
    
    
    
    
}
