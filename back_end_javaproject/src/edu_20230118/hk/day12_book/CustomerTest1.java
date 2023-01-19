package edu_20230118.hk.day12_book;

public class CustomerTest1 {

	public static void main(String[] args) {
//		Customer customerLee=new Customer();//고객한명생성(고객추가)
//		customerLee.setCustomerID(10010);
//		customerLee.setCustomerName("이순신");
//		customerLee.bonusPoint=1000;
//		System.out.println(customerLee.showCustomerInfo());
//		System.out.println("할인율계산한 가격:"+customerLee.calcPrice(10000)
//		 				  +",보너스포인트:"+customerLee.bonusPoint);
		
//		Customer customerKim=new VIPCustomer();//고객한명생성(고객추가)
//		customerKim.setCustomerID(10010);
//		customerKim.setCustomerName("김유신");
//		customerKim.bonusPoint=10000;
//		System.out.println(customerKim.showCustomerInfo());
//		System.out.println("할인율계산한 가격:"+customerKim.calcPrice(10000)
//						  +",보너스포인트:"+customerKim.bonusPoint);
		
		Customer customer=new Customer(10011, "김유신");
		System.out.println("결제금액 :"+customer.calcPrice(10000));//결제하기
		System.out.println(customer.showCustomerInfo());
		
		VIPCustomer vip=new VIPCustomer(10012, "강감찬", 20010);
		System.out.println("결제금액 :"+vip.calcPrice(10000));//결제하기
		System.out.println(vip.showCustomerInfo());
		
		//부모의 타입으로 자식을 생성한 경우: 자동 캐스팅 --> 큰타입에 작은 타입을 대입하는 상황
		Customer vipCustomer=new VIPCustomer(10012, "안중근", 20010);
//		VIPCustomer vipCust=(VIPCustomer)vipCustomer;//참조타입 형변환
		System.out.println("결제금액 :"+vipCustomer.calcPrice(10000));//결제하기
		System.out.println(vipCustomer.showCustomerInfo());
	}

}






