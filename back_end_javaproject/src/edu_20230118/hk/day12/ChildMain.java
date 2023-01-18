package edu_20230118.hk.day12;

public class ChildMain {

	public static void main(String[] args) {
		
		Child child=new Child();//자식타입으로 자식을 생성
		child.parentMethod();
		child.childMethod();//자식에서만 구현한 메서드
		System.out.println(child.toString());
		
		Parent parent=new Child();//부모의 타입으로 자식을 생성한다.
		parent.parentMethod();
		Child child2=(Child)parent;//int ii=(int)0.5;
		child2.childMethod();//자식의 타입으로 형변환하면 자식메서드사용할 수 있다.
//		parent.childMethod();//자식에서만 구현한 메서드를 호출못함
		System.out.println(parent.toString());
		
		Parent parent2=new Parent();//부모의 타입으로 자식을 생성한다.
		parent2.parentMethod();
		System.out.println(parent2.toString());
	}
}
