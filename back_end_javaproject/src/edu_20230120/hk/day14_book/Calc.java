package edu_20230120.hk.day14_book;

public interface Calc {

	//인터페이스에 선언하는 변수는 모두 상수가 된다.
	double PI = 3.14;
	int ERROR = -999999;
	
	int add(int num1, int num2);
	int substract(int num1,int num2);
	int times(int num1, int num2);
	int divide(int num1,int num2);
}
