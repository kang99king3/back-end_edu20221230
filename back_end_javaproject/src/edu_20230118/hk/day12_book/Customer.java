package edu_20230118.hk.day12_book;

public class Customer {

	protected int customerID;//고객 아이디
	protected String customerName;//고객 이름
	protected String customerGrade;//고객 등급
	int bonusPoint; //보너스 포인트
	double bonusRatio;//적립 비율
	
	public Customer() {
		initCustomer();
		System.out.println("Customer()생성자 호출");
	}
	//생성자 오버로딩, 초기화할 맴버필드를 매개변수로 초기화
	public Customer(int customerID, String customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		initCustomer();
		System.out.println("Customer(int,String) 생성자 호출");
	}
    //모든 생성자에서 공통으로 초기화할 내용들을 따로 메서드에 정의해 놓고 호출해서 사용하자
	private void initCustomer() {
		customerGrade = "SILVER"; //기본등급
		bonusRatio = 0.01; //보너스 포인 기본 적립 비율
	}
	
	public int calcPrice(int price) {
		bonusPoint += price*bonusRatio;
		return price;
	}
	
	public String showCustomerInfo() {
		return customerName+" 님의 등급은 "+customerGrade + "이며, 보너스 포인트는 "
				+ bonusPoint +"입니다.";
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

}







