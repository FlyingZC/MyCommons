package com.zc02.enums;

public class WeekDay {
	public static final WeekDay SUN=new WeekDay();
	public static final WeekDay MON=new WeekDay();
	
	//获取枚举类的下一个值
	public WeekDay nextDay(){
		if(this==SUN){
			return MON;
		}else{
			return SUN;
		}
	}
	
	public String toString(){
		return this==SUN?"SUN":"MON";
	}
}
