package com.hk.calboard.utils;

public class Util {

	public static String fontColor(int dayOfWeek,int i){
		//토요일:(dayOfWeek-1+i)%7==0
		//일요일:(dayOfWeek-1+i)%7==1
		String str="black";//기본은 평일
		if((dayOfWeek-1+i)%7==0){ // 토요일
			str="blue";
		}else if((dayOfWeek-1+i)%7==1){ //일요일
			str="red";
		}
		return str;
	}
}
