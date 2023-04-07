package com.hk.calboard.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TestController {

	public Map<String, Integer> makeCalendar(HttpServletRequest request){
		Map<String , Integer>map=new HashMap();
		
		//달력의 날짜를 바꾸기 위해 전달된 year와 month 파라미터를 받는 코드
		String paramYear=request.getParameter("year");
		String paramMonth=request.getParameter("month");
		
		Calendar cal=Calendar.getInstance(); // new(X)
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;// API: 0월~11월
		
		//달이 바뀌면서 년도와 월 값에 대한 처리 코드 작성
		if(paramYear!=null){
			year=Integer.parseInt(paramYear);
		}
		if(paramMonth!=null){
			month=Integer.parseInt(paramMonth);
		}
		
		//여기에 작성하세요 0월 -1월....   13월 14월 ....  월을 변경할 때 오류를 처리하기
		//월이 증가하다가 12에서 13으로 넘어가는 과정에서 14,15,16...증가되는거 처리하기
		if(month>12){
			month=1;
			year++;
		}
		
		//월이 감소하다가 1에서 0또는 -1,-2... 변경되는거 처리하기
		if(month<1){
			month=12;
			year--;
		}
		
		//현재 월의 1일에 대한 요일 구하기: 1~7 --> 1(일), 2(월), 3(화), 4(수)...
		cal.set(year,month-1,1);
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);//1~7 중에 반환
		
		//현재 월의 마지막 날 구하기
		int lastDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		map.put("year", year);
		map.put("month", month);
		map.put("dayOfWeek", dayOfWeek);
		map.put("lastDay", lastDay);
		
		
		
		return map; 
	}
}
