package com.zc.z07array;
public class Z04RuntimeException {
	public static void main(String[] args) {
	    //数组类型 存在父子类型,即Object[]是String[]的父类型
		//1.java.lang.ArrayStoreException,试图将Integer类型放入String[]中
		Object[] strs=new String[3];
		strs[0]=1;
		strs[1]=new Integer(1);
	}
}
