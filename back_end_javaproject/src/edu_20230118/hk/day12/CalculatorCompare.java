package edu_20230118.hk.day12;

public class CalculatorCompare {
	
	//은닉화(캡슐화)
	private int result;//연산 결과값을 저장할 맴버필드
	
	public CalculatorCompare() {
		// TODO Auto-generated constructor stub
	}
	
	public void calculator(int num1,int num2, String cal) {
		//분기형태
		Calculator calcu=null;
		if(cal.equals("+")) {
			calcu=new CalculatorA(num1,num2);//num1,num2의 초기값을 넣어준다
			System.out.println(calcu.num1+"와"+calcu.num2+"의 덧셈을 실행합니다.");
		}else if(cal.equals("-")) {
			calcu=new CalculatorB(num1,num2);
			System.out.println("뺄셈을 실행합니다.");
		}else if(cal.equals("/")) {
			calcu=new CalculatorC(num1,num2);
			System.out.println("나눗셈을 실행합니다.");
		}else if(cal.equals("*")) {
			calcu=new CalculatorD(num1,num2);
//			result(new CalculatorC(num1, num2));//참조타입을 파라미터로 전달할 경우
			System.out.println("곱셈을 실행합니다.");
		}else {
			System.out.println("입력내용을 확인하세요");
		}
		result(calcu);
	}
	
	public void result(Calculator calcu) {
		result=calcu.a();//a()메서드가 Calculator에 존재하기 때문에 바로 사용가능
	}
//	public void result(Object calcu) {
//		Calculator ccc=(Calculator)calcu;//Object는 a()메서드가 없기때문에 형변환해야 한다.
//		result=ccc.a();
//	}
	
	//맴버필드 result 값을 가져오는 기능
	public int getResult() {
		return result;
	}

}
