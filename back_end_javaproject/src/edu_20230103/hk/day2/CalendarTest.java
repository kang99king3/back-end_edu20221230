package edu_20230103.hk.day2;

public class CalendarTest {

	public static void main(String[] args) {
		
		//윤년을 판단하는 기능 : 1년 365일 --> 366일 (윤년) 2월달 28,29
		//윤년인지를 판단하는 조건식이 존재
		//2023이 4의 배수이면서 100으로는 나누어 떨이지지 않는 수 또는 400으로 나누어 떨어지는 수
		//      (i%4==0   &&   i%100!=0)  ||    i%400==0
		for (int i = 2000; i <= 2030; i++) {
			if((i%4==0&&i%100!=0)||i%400==0) {
				System.out.println(i);				
			}
		}
		System.out.println();
		
		System.out.println(isLeapYear(2023));
	}
	
	//윤년을 판별하는 메서드 : 윤년이면 true를 아니면 false를 반환해주자
	public static boolean isLeapYear(int i) {
		boolean isS=false;
		if((i%4==0&&i%100!=0)||i%400==0) {
			//System.out.println(i);
			//조건을 만족하면 isS를 true로 저장 코드 작성
			isS=true;
		}
		
		return isS;   
	}

}




