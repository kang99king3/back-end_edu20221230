package edu_20230109.hk.day6;

public class ClassMain {

	public static void main(String[] args) {
		ClassTest ct=new ClassTest();
		ClassTest ct2=new ClassTest();
		
		System.out.println(ct.hashCode()+":"+ct2.hashCode());
		
		//static으로 선언한 맴버필드 b : static 메모리에서 관리되는 b(객체끼리 같이 공유)
		ct.b=10;
		System.out.println(ct.b);
		System.out.println(ct2.b);
		//인스턴스변수로 선언한 맴버필드 a : 각자 객체에서 관리되는 a(각각의 객체마다 관리)
		ct.a=10;
		System.out.println(ct.a);
		System.out.println(ct2.a);
		
		//static메서드를 호출: 클래스명.메서드명 , 이텔릭체로 표현된다.
		ClassTest.staticTest();
	}

}


