package edu_20230111.hk.day7;

public class CalculatorMain {

	public static void main(String[] args) {
		
		CalculatorCompare calCom=new CalculatorCompare();
		calCom.calculator(20, 5, "+");
		int result=calCom.getResult();
		System.out.println("계산결과:"+result);
		
	}

}
