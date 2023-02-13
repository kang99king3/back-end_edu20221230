package edu_20230130.hk.day18;

public class MyRunable implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Runnable인터페이스를 구현하여 실행");
		}
		
	}

}
