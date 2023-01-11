package edu_20230111.hk.day7;

public class CalculatorCompare {
	
	//은닉화(캡슐화)
	private int result;//연산 결과값을 저장할 맴버필드
	
	public void calculator(int num1,int num2, String cal) {
		//분기형태
		if(cal.equals("+")) {
			CalculatorA cA=new CalculatorA(num1,num2);//num1,num2의 초기값을 넣어준다
			result=cA.a();//a에서 실행된 결과를 result에 저장한다.
			System.out.println("덧셈을 실행합니다.");
		}else if(cal.equals("-")) {
			CalculatorB cB=new CalculatorB(num1,num2);
			result=cB.a();
			System.out.println("뺄셈을 실행합니다.");
		}else if(cal.equals("/")) {
			CalculatorC cC=new CalculatorC(num1,num2);
			result=cC.a();
			System.out.println("나눗셈을 실행합니다.");
		}else if(cal.equals("*")) {
			CalculatorD cD=new CalculatorD(num1,num2);
			result=cD.a();
			System.out.println("곱셈을 실행합니다.");
		}else {
			System.out.println("입력내용을 확인하세요");
		}
		
	}
	//맴버필드 result 값을 가져오는 기능
	public int getResult() {
		return result;
	}

}
