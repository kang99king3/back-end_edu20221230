package edu_20230118.hk.day12;

public class CalculatorMain {

	public static void main(String[] args) {
		
		CalculatorCompare calCom=new CalculatorCompare();
		calCom.calculator(25, 5, "+");
		int result=calCom.getResult();
		System.out.println("계산결과:"+result);
		
		Calculator cal=new Calculator() {
			@Override
			public int a() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
	}

}
