package com.hk.calboard.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hk.calboard.dtos.CalDto;

public class Util {

	private String toDates;//문자열 날짜를 원하는 패턴으로 만들어 저장할 필드
	
	
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
	//DB에서 mdate컬럼 --> 12자리 날짜가  저장되어 있기 때문에 화면에 출력할때 
	//                   날짜형식으로 표현을 해야 함.
	//.jsp에서는 JSTL과 EL을 사용하고 있어서 <% , <%= 를 사용할 수 없다 ---> usebean을 사용하자
	public void setToDates(String mDate) {
		//날짜형식: yyyy-MM-dd hh:mm:ss --> mDate를 날짜 형식으로 만들기 위한 사전 준비
		//        "202304071503"
		String m=mDate.substring(0, 4)+"-"
				+mDate.substring(4, 6)+"-"
				+mDate.substring(6, 8)+" "
				+mDate.substring(8, 10)+":"
				+mDate.substring(10)+":00";
		
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm");
		Timestamp tm=Timestamp.valueOf(m);//문자열값을 Date타입으로 변환
		this.toDates=sdf.format(tm);
	}
	
	public String getToDates() {
		return this.toDates;
	}
	
	public static String getCalViewList(int i,List<CalDto> clist) {
		String d=isTwo(i+"");//숫자 4 --> "04" 변환
		String calList="";//"<p>title1..</p><p>title2</p><p>title3</p>"
		for(int j=0;j<clist.size();j++){
			if(clist.get(j).getMdate().substring(6, 8).equals(d)){
				calList+="<p>"
					   +(clist.get(j).getTitle().length()>7?
					     clist.get(j).getTitle().substring(0, 7)+".."
					     :clist.get(j).getTitle())
					   +"</p>";
			}
		}
		return calList;
	}
}





