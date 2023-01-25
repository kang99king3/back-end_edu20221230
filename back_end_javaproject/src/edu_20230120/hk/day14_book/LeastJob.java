package edu_20230120.hk.day14_book;

public class LeastJob implements Scheduler{

	@Override
	public void getNextCall() {
		System.out.println("상담전화를 순서대로 대기열에 가져옵니다.");
		
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("현재 상담 없무가 없거나 대기가 가장 적은 상담원"
				+ "에게 할당합니다.");
		
	}

}
