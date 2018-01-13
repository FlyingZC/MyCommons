package com.zc.z03string;

import org.junit.Test;

/**
 * <一句话功能简述>String类型与其他数据类型之间互转
 * <功能详细描述>
 * 
 * @author  Flyin
 * @version  [版本号, 2017年3月4日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T04ZhuanHuan {
	@Test
	public void test1(){
		//1.基本数据类型,包装类与String类型转换
		String str1="123";
		int i=Integer.parseInt(str1);
		
		String str2=String.valueOf(i);
		
		//2.字符串与字节数组之间转换
		//字符串与字节数组之间的转换
		String str3="abc123";
		//String类型调用getBytes() 返回byte[]
		byte[] b=str3.getBytes();
		for(int j=0;j<b.length;j++){
			System.out.println((char)b[j]);
		}
		
		//字节数组转成字符串
		String str4=new String(b);
		System.out.println("str4-->"+str4);
		
		//3.字符数组与字符串转换
		//字符串转成字符数组
		String str5="abc123中国人";
		char[] c=str5.toCharArray();
		for(int j=0;j<c.length;j++){
			System.out.println(c[j]);
		}
		//字符数组转成字符串
		String str6=new String(c);
		
	}
}
