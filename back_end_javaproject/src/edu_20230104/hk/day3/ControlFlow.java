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
	}

}






