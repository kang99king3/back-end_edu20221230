package edu_20230118.hk.day12;

public class CalculatorMain {

	public static void main(String[] args) {
		
		CalculatorCompare calCom=new CalculatorCompare();
		calCom.calculator(25, 5, "+");
		int result=calCom.getResult();
		System.out.println("계산결과:"+result);
		
//		Calculator cal=new Calculator();//추상클래스라 객체생성 못해
//		cal.b();
		
//		Calculator cal2=new CalculatorA();
//				   cal2.a();
//				   cal2.b();
				   
	}

}






