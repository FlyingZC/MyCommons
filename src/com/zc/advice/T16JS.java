package com.zc.advice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * <使用java调用js>
 * <虽然可以调用,但是运行期间修改js不会有效果,未知>
 * 从控制台输入测试
 * @author  zc
 * @version  [版本号, 2017年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T16JS
{
    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException
    {
        //获得一个JS的执行引擎
        ScriptEngine engine=new ScriptEngineManager().getEngineByName("javascript");
        //建立上下文变量,则factor会在mytest.js中可以使用
        Bindings bind=engine.createBindings();
        bind.put("factor", 3);
        //绑定上下文,作用域是当前引擎范围
        engine.setBindings(bind, ScriptContext.ENGINE_SCOPE);
        engine.eval(new FileReader("mytest.js"));
        //是否可调用方法
        if(engine instanceof Invocable)
        {
         Invocable in=(Invocable) engine;   
         //执行js中的函数
         Scanner sc=new Scanner(System.in);
         while(true)
         {
             int num=sc.nextInt();
             Double result=(Double) in.invokeFunction("add", 1,num);
             System.out.println(result.intValue());
         }
        }
    }
}
