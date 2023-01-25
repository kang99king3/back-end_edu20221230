package edu_20230120.hk.day14_book;

public class RoundRobin implements Scheduler{

	@Override
	public void getNextCall() {
		System.out.println("상담 전화를 순서대로 대기열에 가져옵니다.");
		
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("다음 순서 상담원에게 배분합니다.");
	}

}
