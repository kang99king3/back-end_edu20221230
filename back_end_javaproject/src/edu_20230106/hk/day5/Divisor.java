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
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int num=scan.nextInt();//키보드로 콘솔에서 입력받은 값 구하기
		divisor(num);//입력받은 값을 메서드에 전달하면서 실행하기
	}
	//약수를 구하는 메서드
	public static void divisor(int num) {
		//약수구하기는 프로그램 구현하기
		for (int i = 1; i <= num; i++) {
			if(num%i==0) {   // --> 약수를 구하는 조건식
				System.out.print(i+"\t");			
			}										
		}
	}
	
}





