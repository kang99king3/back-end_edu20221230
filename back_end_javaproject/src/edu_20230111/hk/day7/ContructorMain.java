package edu_20230111.hk.day7;

import edu_20230109.hk.day6.Divisor2;

public class ContructorMain {

	public static void main(String[] args) {
		ConstructorTest ct=new ConstructorTest();
		ConstructorTest ct2=new ConstructorTest(50);
		ConstructorTest ct3=new ConstructorTest(65,"화이트");
		
//		ct.setSize(50);//size는 매서드를 통해서만 바꿀 수 있다.
		ct.setSize(50, 1236);
		ct.color="핑크색";//객체명.맴버필드로 접근하여 바꿀 수 있고
		ct.setColor("블랙");//객체명.메서드로 접근하여 바꿀 수 있다.
		System.out.println(ct.getSize()+":"+ct.color);
		
		
//		ContructorMain cm=new ContructorMain();
//		cm.test();
		
		//다른 클래스의 기능을 사용하고 싶으면 객체 생성해서 메서드를 호출해야 한다
//		Divisor2 dv=new Divisor2();
//		System.out.println(dv.sumDivisor(20));
	}

	public void test() {
		System.out.println("안녕");
	}
}
