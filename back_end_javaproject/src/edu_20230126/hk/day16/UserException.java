package edu_20230126.hk.day16;

public class UserException extends Exception{

	public UserException() {
		this("UserException 오류입니다.");
	}
	
	public UserException(String msg) {
		super(msg);//부모의 생성자: Exception클래스 호출
	}
}
