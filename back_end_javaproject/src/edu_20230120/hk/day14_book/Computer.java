package edu_20230120.hk.day14_book;

public abstract class Computer {
	//추상메서드를 포함하는 클래스도 반드시 abstract 작성해야 한다.--> 추상클래스로 선언 
	public abstract void display();
	public abstract void typing();
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
}
