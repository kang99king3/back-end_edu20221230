package edu_20230130.hk.day18;

//java.lang 패키지는 기본 패키지라 따로 import설정을 해주지 않아도 됨
public class MyThread1 extends Thread{

	public String threadName;
	
	public MyThread1() {

	}
	public MyThread1(String s) {
		this.threadName=s;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(threadName+":"+i+": 쓰레드 상속받아서 실행");
		}
	}
}
