package edu_20230118.hk.day12;

//나눗셈
public class CalculatorC extends Calculator{
		
		public CalculatorC() {
			// TODO Auto-generated constructor stub
		}
		
		public CalculatorC(int num1, int num2) {
			super.num1=num1;
			super.num2=num2;
		}
		
		//나눗셈연산 기능
		@Override
		public int a() {
			int result=super.num1/super.num2;
			return result;
		}
}
