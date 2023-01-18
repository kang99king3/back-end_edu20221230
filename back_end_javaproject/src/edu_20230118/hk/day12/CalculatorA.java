package edu_20230118.hk.day12;

//덧셈
public class CalculatorA extends Calculator {
	
	public CalculatorA() {
		
	}
	
	public CalculatorA(int num1, int num2) {
		super.num1=num1;
		super.num2=num2;
	}
	
	//덧셈연산 기능
	@Override
	public int a() {
		int result=super.num1+super.num2;
		return result;
	}
}
