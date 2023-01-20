package edu_20230120.hk.day14_book;

public abstract class NoteBook extends Computer{

	@Override
	public void display() {
		System.out.println("NoteBook display()");
	}

	//typing()을 구현하지 않음 ---> NoteBook클래스는 추상클래스로 선언해야 한다.
}
