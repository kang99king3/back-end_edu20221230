package edu_20230109.hk.day6;

import edu_20230106.hk.day5.Divisor;

public class Divisor2 {
	
	public static void main(String[] args) {
		
//		System.out.println(sumDivisor(220)+":"+ sumDivisor(sumDivisor(220)));
		int num=220;
		if(num == sumDivisor(sumDivisor(num))) {// 220의 친화수를 확인하는 조건
			    //sumDivisor(sumDivisor(10)) --> sumDivisor(5)
			System.out.println(num+"의 친화수는 "+sumDivisor(num));
		}
		
		int a=220;
		int b=284;
		if(sumDivisor(b)==a&&sumDivisor(a)==b) {// 220의 친화수를 확인하는 조건
		    //sumDivisor(sumDivisor(10)) --> sumDivisor(5)
		System.out.println(num+"의 친화수는 "+sumDivisor(num));
		}
		System.out.println("========================");
		
		amicable(200,5000);
		
		System.out.println("========================");
		
		perfectNum(1000);
		
		//약수,최대공약수,최소공배수..... 그룹화해서 프로그램 실행시 선택에 의해 
		//                         선택적으로 실행하여 결과를 확인할 수 있게..
		
	}

	//친화수 구하기
	//필요한 기능 구현: 진약수의 합을 구하는 메서드 추가 구현
	
	//진약수의 합을 구하는 메서드 : 220의 약수중 자신의 수를 제외한 합을 구하는 메서드
	//                       합을 구했는데 그 합을 반환해줘야 하는데 그 타입을 결정해야 함
	public static int sumDivisor(int a) {
		//합을 구하는거????  ----> 1~100까지의 합을 구해보자~~~ 우리는 경험이 있어요~~
		int sum=0;
		for (int i = 1; i <a; i++) {
			if(a%i==0) { // 100의 약수는??
				sum=sum+i;				
			}
		}
		return sum;
	}
	
	//두 수의 친화수 관계를 구하는 메서드
	public static void amicable(int s,int e) { //범위를 설정해서 그 범위 안에 친화수를 출력하자
		for (int i = s; i <= e; i++) {
			// 완전수까지 구해짐--> 
			// 완전수의 조건을 생각해서 현재 실행 결과에서는 완전수가 제외되도록 하자
			if(i!=sumDivisor(i)&&i==sumDivisor(sumDivisor(i))) {
				System.out.println(i+":"+sumDivisor(i));
			}
		}
	}
	
	//완전수 구하는 메서드: 진약수의 합과 자기자신의 수가 같은 수
	public static void perfectNum(int num) {
		for (int i = 1; i < num; i++) {
			if(sumDivisor(i)==i) {
				System.out.printf("진약수의 합:%d \n",sumDivisor(i));
				System.out.printf("%d은 완전수이다.\n",i);
			}			
		}
	}
	
	
}






