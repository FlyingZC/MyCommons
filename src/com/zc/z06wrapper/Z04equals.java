package com.zc.z06wrapper;

public class Z04equals {
	public static void main(String[] args) {
		short s1=1;
		int i1=1;
		System.out.println(s1==i1);//true
		
		double d1=1.0;
		int i2=1;
		System.out.println(d1==i2);//true
		
		//包装类中Integer
		//以下两条语句引用了Integer类中Interger数组中同一对象，自动装箱时对于值从-128到127之间的值，使用同一个实例。
		//相当于Integer in1=Integer.valueOf(1);
		Integer in1=1;
		Integer in2=1;
        System.out.println(in1 == in2);//true

		//new 永远是创建一个新的对象
		Integer in3=new Integer(1);
		System.out.println(in1==in3);//false
		Integer in4=500;
		Integer in5=500;
		System.out.println(in4==in5);//false
		
		//必须写1.0,不能写1.因为此处自动装箱,1不行
		Double do1=1.0;
		Double do2=1.0;
		//Double中不存在缓存
		System.out.println(do1==do2);//false
	}
}
