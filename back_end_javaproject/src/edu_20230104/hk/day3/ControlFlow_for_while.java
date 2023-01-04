package edu_20230104.hk.day3;

import java.util.Iterator;

public class ControlFlow_for_while {

	public static void main(String[] args) {
		
		//for문 : 기본 for문, 향상된 for문
		//기본 형태: 범위를 설정하고 범위를 벗어나지 않는 상태에서 반복
		for (int i = 0; i <= 10; i++) {
			//i의 값이 5가 되는 순간 종료하고 싶다
			if(i==5) {
//				break;//이 코드가 실행되면 반복문을 바로 종료한다.
				continue;//이 코드가 실행되면 가장 가까운 반복문으로 돌아간다
			}
			System.out.println(i);
		}
			
		//향상된 for문
//		String[] s= {"a","b","c"};//배열: 같은 타입의 나열 --> 변수는 값 하나만 저장
//		for (String string : s) {
//			System.out.println(string);
//		}
		
		//while문
		System.out.println("=======while문==================");
		int i=0;
		while (true) {
			//if : 종료시키는 코드
			if(i>10) {
				break;
			}
			System.out.println(i);
			i++;//i값을 1씩 증가시켜줌
		}
		
		int ii=0;
		while(ii<=10) {
			System.out.println(ii);
			ii++;
		}
		//do{실행코드}while(조건)문 : 조건이 false여도 최소 한번은 실행한다.
		do {
			System.out.println("최소 한번은 실행된다");
		} while(10<5);
		
		//for문과 while문이 사용되는 상황
		//반복의 범위가 명확할때는 for문, 그렇지 않다면 while문을 사용한다.(절대적인건 X)
	}

}










