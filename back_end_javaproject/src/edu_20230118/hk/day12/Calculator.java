package edu_20230118.hk.day12;


//클래스간에 상속관계 형성--> 계층구조 
//오버라이딩 개념, 사용방법
//CalculatorCompare에서 factory pattern 이용해서 다형성 구현, 은닉화 구현
public class Calculator {

	//저장할 변수 2개에 대한 맴버필드
	public int num1;
	public int num2;
	
	public Calculator() {
		System.out.println("Calculator부모클래스생성자");
	}
	
	public int a() {
		System.out.println("나중에 수정할 메서드:a()");
		return 0;
	}
}
