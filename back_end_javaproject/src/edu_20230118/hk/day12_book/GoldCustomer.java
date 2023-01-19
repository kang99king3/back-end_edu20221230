package edu_20230118.hk.day12_book;

public class GoldCustomer extends Customer{

	double saleRatio;

	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		customerGrade="GOLD";
		bonusRatio=0.02;
		saleRatio =0.1;
	}
	
	@Override
	public int calcPrice(int price) {
//		bonusPoint=bonusPoint+(int)(price*bonusRatio);
		bonusPoint+=price*bonusRatio;//보너스 포인트 적립
		return price-(int)(price*saleRatio);//가격 할인 적용
	}
	
	
}
