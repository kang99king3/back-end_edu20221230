package edu_20230113.hk.day9;

public class Calculator {
	//연산을 하기 위한 숫자 2개를 저장할 맴버필드
	public int num1; 
	public int num2;
	
	// scanner 이용해서 키보드로 값을 입력받기:
	//                      "5+10" , "5*20" 하나의 문자열로 입력받기 
	
	
	// [맴버필드 초기화]문자열에서 정수를 추출하여, 맴버필드 num1,num2에 저장하는 기능 구현
	// "5+10" --> 5 10 추출   5+10 을 실행해야 15가 구해짐
	// String을 int형으로 변환
	// String s는"5+10" ,  String cal은 "+","/","-","*" 사칙연산자
	public void paramInt(String s,String cal) {
		num1=Integer.parseInt(s.substring(0, s.indexOf(cal))) ; // "5+1" -> substring(0,1)
		num2=Integer.parseInt(s.substring(s.indexOf(cal)+1));  // "5+1" -> 
	}
	
	//+,-,*,/를 실행하는 메서드 4개 
	public int a(int a,int b) {
		System.out.println("덧셈을 실행합니다.");
		return a+b;
	}
	public int b(int a,int b) {
		System.out.println("뺄셈을 실행합니다.");
		return a-b;
	}
	public int c(int a,int b) {
		System.out.println("곱셈을 실행합니다.");
		return a*b;
	}
	public int d(int a,int b) {
		System.out.println("나눗셈을 실행합니다.");
		return a/b;
	}
	// 입력받은 값에 해당하는 메서드(+,-,*,/)를 실행하는 메서드
	// 키워드: indexOf() 검색대상이 없으면 -1을 리턴
	public void calcu(String s) { //s= "5+10"
		
		if(s.indexOf("+")!=-1) { //s라는 문자열에서 "+"문자열이 존재하는지 확인하는 조건
			paramInt(s, "+");// 맴버필드  num1,num2를 초기화해주는 코드
			System.out.println(a(num1, num2));
		}else if(s.indexOf("-")!=-1) {//s라는 문자열에서 "-"문자열이 존재하는지 확인하는 조건
			paramInt(s, "-");// 맴버필드  num1,num2를 초기화해주는 코드
			System.out.println(b(num1, num2));
		}else if(s.indexOf("*")!=-1) {// *연산확인
			paramInt(s, "*");// 맴버필드  num1,num2를 초기화해주는 코드
			System.out.println(c(num1, num2));
		}else if(s.indexOf("/")!=-1) {// /연산확인
			paramInt(s, "/");// 맴버필드  num1,num2를 초기화해주는 코드
			System.out.println(d(num1, num2));
		}else {
			System.out.println("연산식을 확인하세요");
		}
	}
}





