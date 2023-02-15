package edu_20230130.hk.day18;

import java.util.List;

public class ThreadMain {

	public static void main(String[] args) {
		
		Thread t1=new MyThread1("t1");
		Thread t2=new MyThread1("t2");
		Thread t3=new MyThread1("t3");
		//쓰레드 작업 시작!!
		t1.start();
		t2.start();
		t3.start();
		
		
		
		try {
			t1.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Runnable 구현해서 작성
//		Runnable rn= new MyRunable();
//		Thread tr=new Thread(rn);
//		
//		tr.start();
		
	}

}
