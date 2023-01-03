package edu_20230103.hk.day2;

public class VariableTest {

	public static void main(String[] args) {
		//정수타입
		//변수 선언, 초기화 
		byte b=1; //-128~127까지의 숫자를 저장할 수 있다.
		     //b=128;// 128은 범위에서 벗어나기 때문에 오류
		short sh=128;//2byte크기   
		int i=5000000;//4byte크기 <----자바에서 기본정수타입
		long l=500000000L;//8byte크기
		
		//값을 표현할때 변수,상수,리터럴(값 자체)
		int ii=5000000;
		  //변수 = 리터럴
		
		//실수형
		double d=15.2;
		float f=20.5F; // <----자바에서 실수형은 기본이 double타입
		
		//다른 타입끼리 연산
		//실수형이 우선 5000000.0+15.2 , 큰 타입이 우선으로해서 변환하여 연산
		int iii=(int)(ii+d);// <--- 50000015.2
		double dd=ii+d;
		System.out.println("정수형: "+iii+",실수형: "+dd);
		
		//정수형끼리 연산
		int intNum=2;
		byte byteNum=3;
		//int resultNum=intNum+byteNum;
		byte resultNum=(byte)(intNum+byteNum);// int+int=int형---> byte 저장하려고 함
		int resultNum2=(int)((byte)intNum+(byte)byteNum);
		// 5+10X2
		System.out.println((5+10)*2);
		
		//실수+정수 연산
		double ddd=15.5;
		int iiii=10;
		double resultNum3=(int)(ddd+iiii);
//		double resultNum3=(int)ddd+iiii;//15+10=25->25.0
		System.out.println(resultNum3);
	}
}







