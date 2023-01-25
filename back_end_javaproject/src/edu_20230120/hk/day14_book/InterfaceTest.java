package edu_20230120.hk.day14_book;

public interface InterfaceTest {

	//다중상속 흉내... extends..implements..
//	public class Test extends ParentTest implements IParent{  }
	
	//인터페이스는 다중 구현이 가능함  implements A, B...
//	public class Test implements IParent , IChild{  }
	
	//상수 선언
	public static final int A=10;
	
	//추상메서드
	public abstract int test();
	
	//추가적인 요소
	
	//private 메서드: 구현한 클래스에서 사용할 수 없으며, interface내에서만 사용할 수 있다.
	//              공통 기능으로 정의할 때 사용된다.
	private void test2() {
		System.out.println("interface내부에서 공통적으로 사용될 기능 구현");
	}
	
	//default 메서드
	public default void test3() {
		test2();//private메서드 호출하기
		System.out.println("인터페이스를 구현한 객체가 사용한다.");
	}
	
	//static 메서드 :  InterfaceTest.test04() 로 호출
	public static void test04() {
		System.out.println("인터페이스만으로 실행시킬 수 있다.");
	}
}




