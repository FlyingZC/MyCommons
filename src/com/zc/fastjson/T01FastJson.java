package com.zc.fastjson;

import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class T01FastJson {
    @Test
    public void t01() {
        //一.从json文本转成其他
        String jsonStr = "{'name':'zc','hobbies':['swim','run']}";
        //1.将json文本 parse为 Object类型对象
        Object obj = JSON.parse(jsonStr);
        System.out.println(obj);

        //将json文本 parseObject成JSONObject
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        System.out.println(jsonObject);

        //2.将json文本 parseObject成JavaBean.与上一个方法重载
        Person person = JSON.parseObject(jsonStr, Person.class);
        System.out.println(person);//Person [name=zc, hobbies=[swim, run]]

        String jsonStr2 = "[{'name':'zc','hobbies':['swim','run']},{'name':'zx','hobbies':['going','runing']}]";
        //3.将json文本 parseArray成JSONArray.前提是该json文本是一个数组
        JSONArray arr = JSON.parseArray(jsonStr2);
        System.out.println(arr);
        //4.将json文本 parseArray成List<JavaBean>
        List<Person> ps = JSON.parseArray(jsonStr2, Person.class);
        for (Person p : ps) {
            System.out.println(p);
        }

        //二.从其他到JSON文本(String)
        //1.将JavaBean序列化成JSON文本
        String jstr = JSON.toJSONString(person);
        System.out.println(jstr);
        //2.将Javabean序列化为 格式化的 json文本
        String strFormat = JSON.toJSONString(obj, true);
        System.out.println(strFormat);
    }

    /**
     * 字符串数组 转 List
     */
    @Test
    public void testParseArray() {
        String jsonStr = "['1','2','3']";
        List<String> list = JSON.parseArray(jsonStr, String.class);
        System.out.println(list);
    }

    @Test
    public void test3() {
        String jsonStr = "{'name':'zc','hobbies':['swim','run']}";
        // 1.JSON格式字符串与JSON对象之间的转换
        JSONObject jsonObject = JSON.parseObject(jsonStr);

        //  2.JSON格式字符串与javaBean之间的转换
        Person person = JSON.parseObject(jsonStr, Person.class);

        // 3.javaBean与json对象间的转换使用：JSON.toJSON(obj)，然后使用强制类型转换，JSONObject或者JSONArray
        JSONObject jsonObject2 = (JSONObject) JSON.toJSON(person);

        Person person2 = JSONObject.toJavaObject(jsonObject, Person.class);
        System.out.println();
    }

    public void parse1(Person src, Person dest, Class destClazz) {
        JSONObject.toJavaObject((JSONObject) JSON.toJSON(src), destClazz);
    }
}
