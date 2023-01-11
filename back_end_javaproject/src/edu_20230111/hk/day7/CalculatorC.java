package edu_20230111.hk.day7;

//나눗셈
public class CalculatorC {
	//저장할 변수 2개에 대한 맴버필드
		public int num1;
		public int num2;
		
		public CalculatorC() {
			// TODO Auto-generated constructor stub
		}
		
		public CalculatorC(int num1, int num2) {
			this.num1=num1;
			this.num2=num2;
		}
		
		//나눗셈연산 기능
		public int a() {
			int result=this.num1/this.num2;
			return result;
		}
}
