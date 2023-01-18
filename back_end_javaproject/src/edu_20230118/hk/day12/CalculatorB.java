package edu_20230118.hk.day12;

//뺄셈
public class CalculatorB extends Calculator{

	public CalculatorB() {
		// TODO Auto-generated constructor stub
	}
	
	public CalculatorB(int num1, int num2) {
		super.num1=num1;// super.num1 , super.a()
		super.num2=num2;
	}
	
	//뺄셈연산 기능
	@Override
	public int a() {
		int result=super.num1-super.num2;
		return result;
	}
}
