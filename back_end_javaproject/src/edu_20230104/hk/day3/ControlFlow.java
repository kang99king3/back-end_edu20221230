package edu_20230104.hk.day3;

public class ControlFlow {

	public static void main(String[] args) {
		
		// if문 
		//유형 3가지 
		//1. if(조건식){실행코드}
		//2. if(조건식){실행코드}else{실행코드}
		//3. if(조건식){실행코드}else if(조건식2){실행코드}else{실행코드}
		
		int num1=10;
		int num2=5;
		// if문을 독립적으로 사용: if문끼리 영향없이 그냥 자기 조건에 대해서 실행
		if(num1>num2) {
			System.out.println("실행결과:"+num1+">"+num2);
		}
		
		if(num1<num2) {
			System.out.println("실행결과:"+num1+"<"+num2);
		}
		
		// 반드시 참,거짓에 의해 실행결과가 있어야 하는 경우 
		//if~else
		if(num1>num2) {
			System.out.println("실행결과:"+num1+">"+num2);
		}else{
			System.out.println("실행결과:"+num1+"<"+num2);
		}
		
		//if~else if ~else....
		if(num1>num2) {
			System.out.println("실행결과:"+num1+">"+num2);
		}else if(num1<num2){
			System.out.println("실행결과:"+num1+"<"+num2);
		}else if(num1==num2){
			System.out.println("실행결과:"+num1+"<"+num2);
		}else if(num1<num2){
			System.out.println("실행결과:"+num1+"<"+num2);
		}else {
			System.out.println("상위조건들에 해당이 안되면 실행해야 하는 코드");
		}
		
		//if { if } else{ if}
		if(num1==num2) {
			System.out.println("같다");
		}else {
			if(num1>num2) {
				System.out.println("다르다");
			}
			
		}
		
		//switch case문
		int num=10; // 정수형과 String 타입만 비교 대상임
		switch (num) {
			case 1:System.out.println("1입니다"); break; //break를 쓰지 않으면 해당 코드부터 밑으로 모두 실행됨
			case 5:System.out.println("5입니다"); break;
			case 10:System.out.println("10입니다"); break;
			case 15:System.out.println("15입니다"); break;
			case 20:System.out.println("20입니다"); break;
			default:System.out.println("해당되는 값이 없습니다.");break;
		}
	}
	
	
}






