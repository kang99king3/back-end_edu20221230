package edu_20230104.hk.day3;

public class Gugudan {
	
	public static void main(String[] args) {
		//2중for문 사용하기
		//구구단구하기
		//2단 :  2X1=2, 2X2=2 ......  범위는 1~9
		for (int i = 1; i < 10; i++) {
			System.out.println("2X"+i+"="+(2*i));			
		}
	
		//2단---> 2단~9단 한번에 다 출력되도록 해볼 수 있지 않을까???...
		//2중 for문에 대해 알아보자
		for (int i = 2; i < 10; i++) {  // 2~9단까지 지정해 줄 값
			
				for (int j = 1; j < 10; j++) {    // 1~9까지 곱해질 값
					System.out.println(i+"X"+j+"="+(i*j));
				}
				
		}
		//자바 코딩을 해보아요~~~
		//1.2~9단까지 출력하는데 이때 짝수단만 출력하기 
		//2~9까지의 숫자중에 짝수를 어떻게 알 수 있을까??? 
		for (int i = 2; i < 10; i++) {  // 2~9단까지 지정해 줄 값
			if(i%2==0) {
				for (int j = 1; j < 10; j++) {    // 1~9까지 곱해질 값
					System.out.println(i+"X"+j+"="+(i*j));
				}				
			}
			
		}
		
		//2.2~9단까지 출력하는데 이때 홀수단만 출력하기 
		for (int i = 2; i < 10; i++) {  // 2~9단까지 지정해 줄 값
			if(i%2!=0) {
				for (int j = 1; j < 10; j++) {    // 1~9까지 곱해질 값
					System.out.println(i+"X"+j+"="+(i*j));
				}				
			}
			
		}
		//3.1~100까지의 정수의 총 합을 출력하기
		
		//4.1~100까지의 정수중 3의 배수의 총 합을 출력하기
		
		//5.주사위의 합이 5이면 실행을 멈추고, 5가 아니면 계속 실행하는 코드 작성
		//실행결과 출력하기:  (2,4) (1,3) (5,4) ... 이런식으로  
		int number=(int)(Math.random()*6+1);//랜덤하게 숫자를 1~6까지 생성하는 코드
		//         Math.random(): 0.00000..1~0.99999999 (0~1사이의 실수를 반환)
		//                         0.5 * 6 = 0.222~5.1212121  
		                         // 0~1 * 6 = 0~ 5.99999--- 0~5
		
		int number1=(int)(Math.random()*6+1);
		int number2=(int)(Math.random()*6+1);
		System.out.println("("+number1+","+number2+")");
	}
	

}



