package edu_20230118.hk.day12;

public class Child extends Parent{

	public Child() {
		//super();//생략되어 있었다.... 항상 첫줄에 작성이 되어야 한다.
		this(5);
		System.out.println("자식의 생성자입니다.");
	}
	
	public Child(int a) {
//		super();
		super(a);
		System.out.println("자식의 생성자 오버로딩입니다.");
	}
	
	//자식에만 있는 메서드
	public void childMethod() {
		System.out.println("자식에서만 구현된 메서드입니다.");
	}
	
	//오버라이딩: 부모의 메서드를 자식에서 재정의한다.
	@Override
	public void parentMethod() {
//		super.parentMethod();
		System.out.println("자식이 주변환경에 맞게 코드를 다시 재정의해서 사용한다."
				         + ":parentMethod()");
	}
	
//	@Override
//	public String toString() {
//		//Object의 메서드이고, 기능: 기본타입에 경우는 값을 문자열로 반환
//		//                       참조타입에 경우는 주소@해시코드를 문자열로 반환
//		return "나는 Child객체입니다.";
//	}

}






