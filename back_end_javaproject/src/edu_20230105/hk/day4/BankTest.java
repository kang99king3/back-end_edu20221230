package edu_20230105.hk.day4;

import java.util.Scanner;

public class BankTest {

	public static void main(String[] args) {
		
		//while문과 Scanner를 이용해서 키보드로부터 입력된 데이터로 예금, 출금, 조회, 종료 기능을 
		//제공하는 코드를 작성해보세요. 이 프로그램을 실행시키면 다음과 같은 실행 결과가 나와야 합니다.
		//추가 문제: 출금을 할때 잔액이 초과되면 초과됐다고 안내하고 다시 입력받게 하자
		boolean run = true;
		int balance=0;// 계좌 
		Scanner scan=new Scanner(System.in);
		while(run) {
			System.out.println("------------------------------");
			System.out.println("1.예금|2.출금|3.잔고|4.종료");
			System.out.println("------------------------------");
			System.out.println("선택>");
			int sel=scan.nextInt();
			// 코드작성
			// sel의 값이 1이냐??
			  // 예금 --> 얼마나 금액을 넣을건지 입력 받아서 처리
//			   예금할 금액을 입력받기  -->	scan.nextInt();
			
			if(sel==1) {
				System.out.println("예금액을 입력하세요>");
				int a=scan.nextInt();//콘솔에 키보드로 입력하고 엔터치면 다음 코드 실행
				balance=balance+a;// 10000이 저금되어 있다면 여기에 1000원 저금하면 10000+1000
				System.out.println("예금합니다");
			}else if(sel==2) {
				//출금
				//추가 문제: 출금을 할때 잔액이 초과되면 초과됐다고 안내하고 다시 입력받게 하자
				System.out.println("출금액을 입력하세요>");
				int a=scan.nextInt();//콘솔에 입력한 값을 받아온다
//				balance=balance-a;
				balance-=a;//단축연산자
				System.out.println("출금합니다");
			}else if(sel==3) {
				//잔고조회
				System.out.println("잔고:"+balance+"원입니다.");
			}else if(sel==4) {
				//종료
//				System.out.println("종료합니다");
				break;
			}else {
				//위에 상황외에 처리
				System.out.println("1~4까지만 입력해주세요");
				continue;
			}
			
			// sel의 값이 2냐??
		}
		
		System.out.println("프로그램을 종료합니다.!!");

	}

}
