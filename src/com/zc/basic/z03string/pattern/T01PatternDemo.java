package com.zc.basic.z03string.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * <一句话功能简述> 去除所有空格
 * <功能详细描述>
 * 
 * @author  flyingzc
 * @version  [版本号, 2017年1月11日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T01PatternDemo
{
    public static void main(String[] args)
    {
        //创建正则表达式
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        //输出正则表达式
        System.out.println(p.pattern());
        //若只使用一次正则表达式,直接使用Pattern类的matches(reg,inputStr)方法
        boolean b1 = Pattern.matches("\\w+", "ab");
        
        //Matcher它依据Pattern对象做为匹配模式对字符串展开匹配检查
        Matcher m = p.matcher("he ll dsf \t\n\rab");
        String obj = m.replaceAll("");
        System.out.println(obj);
        
        //是否匹配,matches()方法 尝试 将 整个输入的字符串 与 正则模式 匹配.返回是否成功的boolean值
        boolean b = m.matches();
        //lookingAt() 判断该字符串的开始部分能否匹配模式.返回是否成功的boolean值
        boolean b3 = m.lookingAt();
        //Matcher.find()用于在CharSequence中查找多个匹配的子串.返回是否成功的boolean值
        m.find();
        System.out.println(obj);
        
        Pattern p2=Pattern.compile("\\s+");
        Matcher m2=p2.matcher("he ll dsf \t\n\rab");
        String obj2 = m.replaceAll("");
        System.out.println(obj2);
    }
    
    /**
     * Pattern类 是 正则表达式的编译 表示形式 
     */
    @Test
    public void testPattern()
    {
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher("abc");
        System.out.println(m.matches());//true
    }
    
    @Test
    public void testPattern2()
    {
        //当 仅仅使用一次正则表达式时,通过Pattern.matches(reg,input)来判断字符串是否匹配模式
        System.out.println(Pattern.matches("\\w+", "abc"));
    }
    
    @Test
    public void testMatcher1()
    {
        Pattern p = Pattern.compile("[abc]+");
        Matcher m = p.matcher("dabc");
        //m.find(),只要 子串 中有符合正则的 ,就返回true
        System.out.println(m.find());//true
        //m.lookingAt(),必须从开头 就与正则表达式匹配 的子串,才返回true
        System.out.println(m.lookingAt());//false
        //m.matches(),必须全匹配才返回true
        System.out.println(m.matches());//false
    }
}
