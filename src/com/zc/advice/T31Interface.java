package com.zc.advice;
//接口中不要有实现
public class T31Interface
{
    //接口中的实现
    public static final Thread t=new Thread(new Runnable(){

        @Override
        public void run()
        {
            System.out.println("厉害喽");    
        }
        
    }); 
}
