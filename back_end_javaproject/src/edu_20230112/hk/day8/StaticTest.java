package edu_20230112.hk.day8;

//            자식클래스		    부모클래스
public class StaticTest extends SuperClass {
	
	@Override
	public void Method() {
		System.out.println("부모의 메서드를 숨기고 제가 나왔습니다.");
	}
	
	public static void StaticMethod() { // 숨김이 일어난다.
	   System.out.println("저는 클래스명만으로도 부를 수 있어요.");
	   final int a=5;//상수
//	   a=10;// 값 변경 금지인데 변경하려고 해서 오류 발생
	}

}
