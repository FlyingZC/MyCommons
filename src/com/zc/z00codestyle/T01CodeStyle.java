package com.zc.z00codestyle;

import org.junit.Test;

/**
 * @author flyingzc
 * 手写代码codeStyle,不要format
 */
public class T01CodeStyle
{
    // 大括号前必须有一个空格
    public static void main(String[] args) {
        // 定义两个变量.写一个if语句.写一个if...else...
        String str = "ab";
        //缩进四个空格
        int flag = 0;
        // 关键字与括号之间必须有一个空格,比如if后的空格,&&前后的空格,==前后的空格
        if ("ab".equals(str) && flag == 0) {
            for (int i = 0; i < 10; i++) {// !!分号后加空格
                System.out.println("a");
            }
        }
        // 注释前空一格
        if (flag == 0) {
            // 大括号前后必须有一个空格
        } else {
            
        }
        
        //方法参数在定义和传入时,多个参数 逗号后 必须加空格
        //private void method(String string, String string2)
        method("a", "b");
    }
    
    @Test
    public void testLength() {
        // 单行字符数限制不超过120个,超出需要换行
        // 换行遵循原则:
        // 1.第二行相对第一行缩进4个空格,从第三行开始,不再继续缩进
        // 2.运算符与下文一起换行
        // 3.方法调用的 点符号与下文一个换行
        // 4.在多个参数超长,逗号后进行换行
        // 5.括号前不要换行
        
        StringBuffer sb = new StringBuffer();
        sb.append("zi").append("zi").append("zi").append("zi").append("zi").append("zi").append("zi")//单行超过120换行
            .append("zi");//运算符 和 点符号 换到下一行
        
        method("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",// 参数超长,逗号后面进行换行
                "bbbbbbbb");
    }

    private static void method(String string, String string2)
    {
        // 方法体内 的 执行语句组,变量的定义语句组,不同的业务逻辑之间 或者 不同的语义之间 插入一格空行.
        // 相同业务逻辑和语义之间不需要插入空行.
    }
}
