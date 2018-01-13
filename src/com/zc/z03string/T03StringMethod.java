package com.zc.z03string;

import java.util.Formatter;

import org.junit.Test;

public class T03StringMethod
{
    //===============String,Integer不可变==============
    @Test
    public  void testStringModify()
    {
        //str传入另一个方法,修改后.此处的str值不变
        String str = "11";
        helpString(str);
        System.out.println(str);//11
        helpString2(str);
        System.out.println(str);//11
    }

    void helpString(String str)
    {
        //因为String不可变,此处相当于 str = new String("22");更改了传进来的引用,所以外面那个String值还是"11"
        str = "22";
    }
    
    private void helpString2(String str)
    {
        str += "22"; 
    }
    
    @Test
    public void testIntegerModify()
    {
        Integer i = 11;
        helpInteger(i);
        System.out.println(i);//11
    }
    
    public void helpInteger(Integer i)
    {
        i = 12;
    }
    
    @Test
    public void testStringBuilderModify()
    {
        StringBuilder sb = new StringBuilder("11");
        helpStringBuilder(sb);
        System.out.println(sb.toString());//1112
    }
    
    private void helpStringBuilder(StringBuilder sb)
    {
        sb.append("12");
    }
    
    @Test
    public void testSubstring()
    {
        String[] fileNames = new String[] {"abc.txt", "bcd.exe", "cde.exe", "def.dat", "efg.exe"};
        for (String s : fileNames)
        {
            if (s.endsWith(".exe"))
            {
                //记得结果传给s
                s = s.substring(0, s.lastIndexOf(".exe"));
                //注意输出位置
                System.out.println(s);
            }
        }
    }

    @Test
    public void testIndexOf()
    {
        String str = "**java***java*****java*";
        String str1 = "java";
        int index = 0;
        //strings.indexOf(str,index):返回指定字符串str在strings里出现的索引
        while ((index = str.indexOf(str1, index)) != -1)
        {
            System.out.print(index + "");
            index += str1.length();
        }
    }

    @Test
    public void testLianJie()
    {
        String s = "";
        //比较 ""=="0"  ,+表示连接
        if (s == s + 0)
        {
            System.out.println("Hello World");
        }
    }
    
    /**
     * thinking P292
     * String.format()内部使用Formatter类实现
     */
    @Test
    public void testFormat()
    {
        //%d 整数型,十进制
        System.out.println(String.format("%d",10 ));
        //%c Unicode字符,传入字符类型
        System.out.println(String.format("%c",'a'));
        //%b Boolean值
        System.out.println(String.format("%b",true ));
        //%s String类型
        System.out.println(String.format("%s","ab" ));
        //%f 浮点数,十进制
        System.out.println(String.format("%f",1.1 ));
        //%e 浮点数,科学计数
        System.out.println(String.format("%e",1.11 ));
        //%x 整数,十六进制,传入整数
        System.out.println(String.format("%x",111));
        //%h 散列码(十六进制)
        System.out.println(String.format("%h",1.11 ));
        //%% 转义成%
        System.out.println(String.format("%%"));
        //java.util.Formatter(appender)
        Formatter formatter = new Formatter(System.out);
        //直接输出到appender目的地中
        formatter.format("%s", "ab");
    }
    
    /**
        public String intern()返回字符串对象的规范化表示形式。
                        返回：一个字符串，内容与此字符串相同，但一定取自具有唯一字符串的池。
 
                        一个初始为空的字符串池，它由类 String 私有地维护。 
                        当调用 intern 方法时，如果池已经包含一个等于此 String 对象的字符串（用 equals(Object) 方法确定），
                        则返回池中的字符串。否则，将此 String 对象添加到池中，并返回此 String 对象的引用。 

                        它遵循以下规则：对于任意两个字符串 s 和 t，当且仅当 s.equals(t) 为 true 时，s.intern() == t.intern() 才为 true。 
                        所有字面值字符串和字符串赋值常量表达式都使用 intern 方法进行操作。字符串字面值在 Java Language Specification 的 §3.10.5 定义。 
     */
    public void testIntern()
    {
        
    }
    
    //============= 与正则表达式 相关 的 API =============
    @Test
    public void testMatches()
    {
        System.out.println("+123".matches("(-|\\+)?\\d+"));//第一位正号或负号 或没有  后面至少一个数字
        System.out.println("-123".matches("-?\\d+"));
    }
    
    /**
     * split()
     * debug看每一个结果 
     */
    @Test
    public void testSplit()
    {
        //在原始字符串中,与正则表达式匹配的部分,在最终的数组结果中将不再存在
        String str = "Then, when you have found the shrubbery, you must "
            + "cut down the mightiest tree in the forest... " + "with... a herring!";
            str.split("");
            str.split(" ");
            str.split("\\W+");
            str.split("n\\W+");
       String str2 = "a,b,c,d,,";
       String[] arr = str2.split(",");
       //长度为4,会忽略最后空白的内容
       System.out.println(arr.length);//4
    }
    
    
    /**
     *   replace(CharSequence target, CharSequence replacement):使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。 
     *   String replaceAll(String regex, String replacement):使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
     */
    @Test
    public void testReplace()
    {
        String str="abacadafag";
        System.out.println(str.replace("a", "AA"));//AAbAAcAAdAAfAAg
        System.out.println(str.replace('a', 'A'));//AbAcAdAfAg
        
        System.out.println(str.replaceAll("a", "A"));//AbAcAdAfAg
        System.out.println(str.replaceAll(".", "A"));//AAAAAAAAAA
        //替换满足正则表达式的第一个字符
        System.out.println(str.replaceFirst(".", "A"));//Abacadafag
    }
    
    
    

}
