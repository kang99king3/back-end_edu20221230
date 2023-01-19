package edu_20230118.hk.day12_book;

public class VIPCustomer extends Customer{
	
	private int agentID; //VIP 고객 담당 상담원 아이디  ---은닉화
	double saleRatio; //할인율
	
	public VIPCustomer() {
		super();//부모의 생성자를 호출한다.
		customerGrade="VIP";
		bonusRatio=0.05;//5%적립
		saleRatio=0.1;//10%할인
		System.out.println("VIPCustomer()생성자 호출");
	}
	
	public VIPCustomer(int coustomerID, String customerName,int agentID) {
		super(coustomerID,customerName);//부모의 생성자를 호출한다(매개변수가 있는 생성자)
		customerGrade="VIP";
		bonusRatio=0.05;//5%적립
		
		saleRatio=0.1;//10%할인
		this.agentID=agentID;//자식에서 정의된 필드
		System.out.println("VIPCustomer(int,String,int) 생성자 호출");
	}
	
	//메서드 오버라이딩: 부모의 메서드를 자식이 재정의해서 사용하는 방법 
	@Override
	public int calcPrice(int price) { //적립률 계산:부모의기능 + 할인률 계산 기능 추가:자식의 기능 추가
		bonusPoint += price*bonusRatio;
		return price-(int)(price*saleRatio);
	}
	
	@Override
	public String showCustomerInfo() {
		return super.showCustomerInfo()+"담당 상담원 아이디는 "+agentID+"입니다";
	}
	
	//메서드를 통해 값에 접근한다.(은닉화)
	public int getAgentID() {
		return agentID;
	}
	
	
}










