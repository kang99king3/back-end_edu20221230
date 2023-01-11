package edu_20230111.hk.day7;

//곱셈
public class CalculatorD {
	//저장할 변수 2개에 대한 맴버필드
		public int num1;
		public int num2;
		
		public CalculatorD() {
			// TODO Auto-generated constructor stub
		}
		
		public CalculatorD(int num1, int num2) {
			this.num1=num1;
			this.num2=num2;
		}
		
		//곱셈연산 기능
		public int a() {
			int result=this.num1*this.num2;
			return result;
		}
}
