package edu_20230118.hk.day12_book;

public class VIPCustomer extends Customer{
	
	private int agentID; //VIP 고객 담당 상담원 아이디  ---은닉화
	double saleRatio; //할인율
	
	public VIPCustomer() {
		customerGrade="VIP";
		bonusRatio=0.05;//5%적립
		saleRatio=0.1;//10%할인
	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint += price*bonusRatio;
		return price-(int)(price*saleRatio);
	}
	
	//메서드를 통해 값에 접근한다.(은닉화)
	public int getAgentID() {
		return agentID;
	}
	
	
}










