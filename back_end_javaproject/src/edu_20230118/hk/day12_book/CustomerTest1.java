package edu_20230118.hk.day12_book;

public class CustomerTest1 {

	public static void main(String[] args) {
		Customer customerLee=new Customer();//고객한명생성(고객추가)
		customerLee.setCustomerID(10010);
		customerLee.setCustomerName("이순신");
		customerLee.bonusPoint=1000;
		System.out.println(customerLee.showCustomerInfo());
		System.out.println("할인율계산한 가격:"+customerLee.calcPrice(10000)
		 				  +",보너스포인트:"+customerLee.bonusPoint);
		
		Customer customerKim=new VIPCustomer();//고객한명생성(고객추가)
		customerKim.setCustomerID(10010);
		customerKim.setCustomerName("김유신");
		customerKim.bonusPoint=10000;
		System.out.println(customerKim.showCustomerInfo());
		System.out.println("할인율계산한 가격:"+customerKim.calcPrice(10000)
						  +",보너스포인트:"+customerKim.bonusPoint);
	}

}
