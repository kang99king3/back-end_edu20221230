package edu_20230103.hk.day2;

public class Operator {

	public static void main(String[] args) {
		//관계연산자
		System.out.println(10>5);
		if(10>5) {
			System.out.println("10이 크다");
		}else {
			System.out.println("10이 작다");
		}
		//삼항연산자
		System.out.println(10>5?"10이 크다":"10이 작다");
		System.out.println(!(10>5)?"10이 크다":"10이 작다");
		
		//단축연산자
		int ii = 1;
        int sum = 1;
//        sum=sum+ii;
        while(sum<20) {
        	sum+=ii;    
        	System.out.println(sum);
        }
        System.out.println(sum);    // sum = 11;

        //증감연산자
        int x = 10;
		System.out.println(x++);  // 10 출력 후 1증가 ⇒ 11 저장
		System.out.println(x);      // 11 출력
		System.out.println(++x);  // 1 증가 후 출력 ⇒ 12 출력
		System.out.println(x);     // 12 출력

		//논리연산자
		int i = 1, j = 2, k = 3;
		 System.out.println("i = " + i + ", j = " + j + ", k = " + k);
	     System.out.println("i < j && j < k의 결과는 : " + (i < j && j < k));
		 System.out.println("i < j || j < k의 결과는 : " + (i < j || j < k));
	 	 System.out.println("!(i < j) || !(j < k)의 결과는 : "+(!(i < j) || !(j < k)));

	}
	
	

}





