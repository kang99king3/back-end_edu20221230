package edu_20230113.hk.day9;

import java.util.Scanner;

public class CalcuMain {

	public static void main(String[] args) {
		
		System.out.println("계산 값을 입력하세요(+,-*,/ 연산만 가능)입력은 \"5+10\"");
		Calculator cal=new Calculator();
		Scanner scan=new Scanner(System.in);

		while(true) {
			System.out.println("계산 값을 입력하세요(+,-*,/ 연산만 가능)입력은 \"5+10\"");
			//예: "5+10"입력값 받는 코드 작성
			String s=scan.next();
			//"9"를 입력하면 "계산 프로그램을 종료해요~~" 출력하고 끝내기 코드 작성
			if(s.equals("9")) {
				System.out.println("계산 프로그램을 종료해요~~~");
				break;
			}
			cal.calcu(s); //작성하여 계산실행하기	
			
		}

	}

}










