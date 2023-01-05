package edu_20230105.hk.day4;

public class MethodTest {

	
  //접근제한자 static/non-static  반환타입(void/타입[int,double...])    메서드명(변수선언)  
	public      static          void                            main(String[] args) {
		test2();
		
	}
	
	//모든 곳에서 접근이 가능하고, 반환타입이 없고, 파라미터도 없는 메서드
	public static void test() {
		int a=5;
		System.out.println(a);
	}
	
	public static void test2() {
		test();// 메서드명()--> 메서드를 실행시킨다.
	}

}






