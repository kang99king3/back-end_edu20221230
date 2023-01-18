package edu_20230118.hk.day12;

//곱셈
public class CalculatorD extends Calculator{
		
	public CalculatorD() {
		// TODO Auto-generated constructor stub
	}
	
	public CalculatorD(int num1, int num2) {
		super.num1=num1;
		super.num2=num2;
	}
	
	//곱셈연산 기능
	@Override
	public int a() {
		int result=super.num1*super.num2;
		return result;
	}
}
