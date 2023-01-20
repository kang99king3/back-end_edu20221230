package edu_20230120.hk.day14_book;

public class CompleteCalc  extends Calculator{

	@Override
	public int times(int num1, int num2) {
		return num1*num2;
	}

	@Override
	public int divide(int num1, int num2) {
		if(num2!=0) {// 어떤수를 0으로 나누면 에러나요~~
			return num1/num2;
		}else {
			return Calc.ERROR;			
		}
	}
	
	public void showInfo() {
		System.out.println("Calc 인터페이스를 구현합니다.");
	}

}
