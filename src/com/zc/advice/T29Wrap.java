package com.zc.advice;

/**
 * <包装类与基本类型重载>
 * <功能详细描述>
 * 
 * @author  Administrator
 * @version  [版本号, 2017年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T29Wrap
{
    public static void main(String[] args)
    {
        new T29Wrap().f(1);//基本数据类型方法被调用
    }
    public void f(long a)
    {
        System.out.println("基本数据类型方法被调用");
    }
    public void f(Long a)
    {
        System.out.println("引用数据类型方法被调用");
    }
}
;
;;
;;;
;;;;
;;;;;
;;;;;;
;;;;;;;                                            ;
;;;;;;;;                                           ;;;
;;;;;;;;;                                          ;;;;;   
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;                                          ;;;;; 
;;;;;;;;                                           ;;;
;;;;;;;                                            ;
;;;;;;
;;;;;
;;;;
;;;
;;
;
