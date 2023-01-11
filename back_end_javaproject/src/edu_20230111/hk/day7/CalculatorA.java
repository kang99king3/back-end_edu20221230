package edu_20230111.hk.day7;

//덧셈
public class CalculatorA {
	
	//저장할 변수 2개에 대한 맴버필드
	public int num1;
	public int num2;
	
	public CalculatorA() {
		
	}
	
	public CalculatorA(int num1, int num2) {
		this.num1=num1;
		this.num2=num2;
	}
	
	//덧셈연산 기능
	public int a() {
		int result=this.num1+this.num2;
		return result;
	}
}
