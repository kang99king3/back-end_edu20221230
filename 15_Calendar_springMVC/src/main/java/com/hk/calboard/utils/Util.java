package com.hk.calboard.utils;

import java.text.SimpleDateFormat;

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
	
	//한자리를 두자리로 변환
	public static String isTwo(String str) {
		
		return str.length()<2?"0"+str:str;// 4 --> "04"
	}
	
	//SimpleDateFormat 날짜포멧을 설정<----jstl에 fmt태그
	//timestamp 
}





