package edu_20230120.hk.day14_book;

//인터페이스를 구현한다. : 강제구현
public abstract class Calculator implements Calc{

	@Override
	public int add(int num1, int num2) {
		return num1+num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1-num2;
	}

	//2개의 메서드는 구현하려고 봤더니 기능이 구체화하기 힘든 코드라 하위 클래스에서 구현하도록 하자
	//--> 구현이 안된 메서드(추상메서드로 선언해두자)
	@Override
	public abstract int times(int num1, int num2);

	@Override
	public abstract int divide(int num1, int num2);

}
