package edu_20230111.hk.day7;

public class ConstructorTest {

	public int size=0;
	public String color="검정색";
	
	public ConstructorTest() {
		super();//부모의 생성자를 호출한다.(생략가능,부모가 먼저 실행되어야 하기 때문에 가장 윗줄에 작성)
		this.size=20;
		System.out.println(size+"인치 검은색 텔레비전이 왔어요 ㅋㅋ");
	}
	//생성자 오버로딩
	public ConstructorTest(int size) {
//		this();
		this.size = size;
		System.out.println(size+"인치 검은색 텔레비전이 왔어요 ㅋㅋ");
	}

	public ConstructorTest(int size, String color) {
//		this(size); // 생성자끼리도 호출할 수 있다. 단 생성자는 딱 한번만 실행된다는 것 기억하기
		this.size = size;
		this.color = color;
		System.out.println(size+"인치 "+color+" 텔레비전이 왔어요 ㅋㅋ");
	}
	
	
	
}
