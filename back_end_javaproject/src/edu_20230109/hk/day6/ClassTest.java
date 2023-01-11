package edu_20230109.hk.day6;

public class ClassTest{ //클래스: 설계도, 틀--> 아직 쓸 수 없다

	//맴버 필드: 클래스에서 정의하는 저장공간, 클래스의 정보를 담는 공간
	//          클래스가 소멸되기 전까지 살아있음
	public int a;//클래스 인스턴스 변수
	public static int b;//클래스 전역변수
	
	//생성자는 객체 생성할 때 딱 한번 실행된다.
	//default 생성자: 파라미터 없는 생성자(기본생성자)
	public ClassTest() {
		super();//부모의 생성자를 호출
		//객체생성이란는건 생성자를 호출하는 것임
//		ClassTest classTest=new ClassTest();
//		this.a=0;//맴버필드 a의 값을 10으로 초기화 한다.
		System.out.println("생성자 호출");
	}
	
	//오버로딩: 파라미터의 타입과 개수를 다르게 구성하여 
	//        같은 이름으로 작성가능하게 하는 기법
	//생성자 오버로딩
	//주의사항: default생성자를 생략할 수 없다.
	public ClassTest(int n) {
		super();
		this.a=n;//맴버필드 a의 값을 n으로 초기화 한다.
		System.out.println("생성자 오버로딩");
	}
	
	//메서드: 클래스의 기능 구현을 담당함.
	//메서드의 유형: static/non-static, 반환타입O/X, 파라미터O/X
	//non-static메서드
	//문법: 객체생성한뒤에 객체명.메서드명()
	public void test() {
		System.out.println("클래스의 기능을 담당하는 메서드");
	}
	//static 메모리에 이미 올라가 있기 때문에 따로 객체생성을 해서 쓸 필요가 없다
	//문법: 클래스명.메서드명() ---> 자주 사용하는 기능 예)Math클래스: 수학적인 기능 제공
	public static void staticTest() {
		System.out.println("static메서드");
	}
}



