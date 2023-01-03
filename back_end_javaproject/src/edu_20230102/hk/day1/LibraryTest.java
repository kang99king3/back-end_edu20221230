package edu_20230102.hk.day1;

//명명법,식별자
//클래스명: 파스칼 ( 첫글자는 대문자로)
//        파일명과 클래스명은 동일해야함
public class LibraryTest {
//main메서드 : 자바코드를 실행시키는 특별한 메서드
	public static void main(String[] args) {// "안녕 자바야"
		String s="안녕 자바야";
		System.out.println(s.substring(0,2));
		 //                 0 123 4 5
		
		//String public="";//예약어X
	
		//immutable: 값이 변하지 않는 성질 
		int a=5;
		int b=a;// a의 값을 복사해서 b에 저장 : 값을 전달
		b=10;//  a의 값은??? 뭘까요?
		System.out.println(a+" : "+b);//syso("문자열") 문자열 합치기 +
		
		//mutable: 값이 변하는 성질 : 주소값 전달
	}

	//메서드명: 카멜방식(소문자로 시작하고 의미가 바뀔때 대문자)
	//변수명  : 동일한 방식
	public void test_Method() {
		isP=true;
	}
	
	boolean isP = true;//변수 선언: 타입 + 변수명
	
	//변수의 개념과 블럭변수
	public boolean isPrimeTest(int num) {     // isP 변수시작
		int isA;
		isA=5;
		
		for(int j =2; j < num; j++) {     // j 변수시작
			if (num % j == 0) {
				isP = false;
				break;
			}
		}     // j 변수 끝 (for문 안에서만)
		return isP;
	}     // isP 변수 끝 (isPrimeTest 메소드 안에서만 사용 가능하다.) 

	
}





