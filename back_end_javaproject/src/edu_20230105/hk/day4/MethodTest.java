package edu_20230105.hk.day4;

public class MethodTest {

	
  //접근제한자 static/non-static  반환타입(void/타입[int,double...])    메서드명(변수선언)  
	public      static          void                            main(String[] args) {
//		test2();
		MethodTest methodTest=new MethodTest();
				   methodTest.test007(10,5,20,15.5);//힙 메모리에 올라가 있는 상황
	}
	
	//메서드의 유형
	//1.static/non-static
	public static void test001() {}
	public void test002() {}
	
	//2.반환타입O/반환타입X
	public int test003() { return 5;  } //반환타입O --> 반드시 return작성
	public double test004() { return 5.0;}
	public void test005() { } //반환X ---> return작성하면 안됨
	
	//3.파라미터O/파라미터X(default)
	// 파라미터를 선언하면 호출할때 반드시 값을 전달해서 호출해야한다. a(int a)-> a(5) 
	public int test006(int a) { // int a= 10(test007())
	
		return a+5;  
	}
	public void test007(int a,int b,long l,double d) { 
		int num=a;
		int num2=test006(num);//  int형의 값을 반환(15값 반환)
		System.out.println(num2);
	}
	
	//모든 곳에서 접근이 가능하고, 반환타입이 없고, 파라미터도 없는 메서드
	//반환타입X, 파리미터X, static
	public static void test() {
		int a=5;
		System.out.println(a);
	}
	
	public static void test2() {
		test();// 메서드명()--> 메서드를 실행시킨다.
	}
	
	

}










