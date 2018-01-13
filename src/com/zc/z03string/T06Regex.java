package com.zc.z03string;
//正则表达式
/*
 * 元字符
 * 限定符
 * 	?0-1
 * 	*0-多
 * 	+0-度
 * {n}正好n次
 * {n,}至少n次
 * {n,m}n-m次
 * 
 * */
public class T06Regex {
	public static void main(String[] args) {
		//七个字符组成.第一位大写.2-4位小写.后3位数字
		String s1="Sabc123";
		boolean b1=s1.matches("\\p{Upper}\\p{Lower}\\p{Lower}\\p{Lower}\\d\\d\\d");
		System.out.println(b1);
		String s2="Aa1 aab";
		boolean b2=s2.matches("\\p{Upper}\\p{Lower}\\d\\s\\w\\w\\w");
		System.out.println(b2);
		
		boolean b3=s1.matches("\\p{Upper}\\p{Lower}{3}\\d{3}");
		System.out.println(b3);
		
		String s3="123@qq.com";
		//多个 限定符
		boolean b4=s3.matches("\\w{0,}\\@\\w{0,}\\.{1}\\w{0,}");
		System.out.println(b4);
		
		//验证手机号
		String s4="18051373336";
		boolean b5=s4.matches("1[3,5,8]\\d{9}$");
		System.out.println(b5);
		
	}
}
