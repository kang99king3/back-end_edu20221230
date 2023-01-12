package edu_20230112.hk.day8;

public class Singleton {

	private static Singleton singleton;//객체를 생성해서 주소를 저장할 맴버필드
	
	private Singleton() {
		
	}
	//객체가 생성됐는지 확인해서 생성 안됐다면 생성해주고, 
	//생성됐다면 바로 singleton 객체를 반환해준다
	public static Singleton getInstance() {
		if(singleton==null) {
			singleton=new Singleton();
		}
		return singleton;
	}
}
