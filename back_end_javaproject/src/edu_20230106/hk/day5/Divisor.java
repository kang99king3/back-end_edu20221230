package edu_20230106.hk.day5;

import java.util.Scanner;

public class Divisor {

	public static void main(String[] args) {
		//약수구하기는 프로그램 구현하기
		//12의 약수
//		for (int i = 1; i <= 12; i++) {
//			if(12%i==0) {   // --> 1은 12의 약수
//				System.out.print(i+"\t");			
//			}										
//		}
//		Scanner scan = new Scanner(System.in);
//		System.out.println("숫자를 입력하세요");
//		int num=scan.nextInt();//키보드로 콘솔에서 입력받은 값 구하기
//		divisor(num);//입력받은 값을 메서드에 전달하면서 실행하기
		
		greateDivisor(30,50);
		

	}
	//약수를 구하는 메서드
	public static void divisor(int num) {
		//약수구하기는 프로그램 구현하기
		for (int i = 1; i <= num; i++) {
			if(num%i==0) {   // --> 약수를 구하는 조건식
				System.out.print(i+"\t");			
			}										
		}
		System.out.println();
	}
	
	//최대공약수 구하는 메서드
	//방법: 두 수중 큰수에서 작은 수를 빼는 방식으로 마지막에 서로 같아지면 그게 최대공약수
	public static void greateDivisor(int a, int b) {
//		int a=15; //메서드의 파라미터로 처리하면 외부로터 값을 받을 수 있다.
//		int b=20;
		int tempA=a;//기본 타입의 성질: immutable하다 (변하지 않는 성질)
		int tempB=b;//값을 복사해서 전달한다.--> 값을 전달한다. 
		// a > b   a=a-b
		// a < b   b=b-a
		// 15   20
		// 15    5
		// 10    5
		//  5    5
		while(true) {
			//a가 b보다 클 경우
			if(a>b) {
				a=a-b;
			}
			//b가 a보다 클 경우
			if(b>a) {
				b=b-a;
			}
			//a와 b가 같을 경우
			if(a==b) {
				break; //while문일때는 반드시 반복문을 종료하는 코드를 작성해야 한다.
			}
			
		}//while종료
		//두수의 약수들을 출력해서 확인해보기
		divisor(tempA);
		divisor(tempB);
		System.out.println(tempA+"와"+tempB+"의 최대공약수:"+a);
		
	}//greateDivisor()종료
	
}










