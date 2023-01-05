package edu_20230105.hk.day4;

import java.util.Scanner;

public class BankTest {

	public static void main(String[] args) {
		
		//while문과 Scanner를 이용해서 키보드로부터 입력된 데이터로 예금, 출금, 조회, 종료 기능을 
		//제공하는 코드를 작성해보세요. 이 프로그램을 실행시키면 다음과 같은 실행 결과가 나와야 합니다.
		boolean run = true;
		int balance=0;
		Scanner scan=new Scanner(System.in);
		while(run) {
			System.out.println("------------------------------");
			System.out.println("1.예금|2.출금|3.잔고|4.종료");
			System.out.println("------------------------------");
			System.out.println("선택>");
			
			
		}
		
		System.out.println("프로그램을 종료합니다.!!");

	}

}
