package edu_20230109.hk.day6;

public class ClassTest { //클래스: 설계도, 틀--> 아직 쓸 수 없다

	//맴버 필드: 클래스에서 정의하는 저장공간, 클래스의 정보를 담는 공간
	//          클래스가 소멸되기 전까지 살아있음
	public int a;
	
	//생성자는 객체 생성할 때 딱 한번 실행된다.
	//default 생성자: 파라미터 없는 생성자(기본생성자)
	public ClassTest() {
		//객체생성이란는건 생성자를 호출하는 것임
//		ClassTest classTest=new ClassTest();
		this.a=10;//맴버필드 a의 값을 10으로 초기화 한다.
		System.out.println("생성자 호출");
	}
	
	//오버로딩: 파라미터의 타입과 개수를 다르게 구성하여 
	//        같은 이름으로 작성가능하게 하는 기법
	//생성자 오버로딩
	//주의사항: default생성자를 생략할 수 없다.
	public ClassTest(int n) {
		this.a=n;//맴버필드 a의 값을 n으로 초기화 한다.
		System.out.println("생성자 오버로딩");
	}
}



