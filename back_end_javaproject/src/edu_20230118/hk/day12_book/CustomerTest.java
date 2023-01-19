package edu_20230118.hk.day12_book;

public class CustomerTest {

	public static void main(String[] args) {
		
		Customer [] custArray=new Customer[5];//[ , , , , ]
		
		Customer custLee=new Customer(10010,"이순신");
		Customer custShin=new Customer(10020,"신사임당");
		Customer custHong=new GoldCustomer(10030,"홍길동");
		Customer custYoul=new GoldCustomer(10040,"이율곡");
		Customer custKim=new VIPCustomer(10050,"김유신",12345);
		
		custArray[0]=custLee;
		custArray[1]=custShin;
		custArray[2]=custHong;
		custArray[3]=custYoul;
		custArray[4]=custKim;
		
		//향상된 for문: 인덱스를 사용하지 않고 값을 꺼내준다.
		for (Customer customer : custArray) {
			System.out.println(customer.showCustomerInfo());
		}
		
		int price=10000;
		for (Customer customer : custArray) {
			int cost = customer.calcPrice(price);
			System.out.println(customer.getCustomerName() +" 님이"+cost+"원 지불하셨습니다.");
			System.out.println(customer.getCustomerName() +" 님의 현재 보너스 포인트는 "
					                                      + customer.bonusPoint+ "점입니다.");
		}
	}

}







