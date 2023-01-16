package edu_20230116.hk.day10;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayTest {
	
	public static void main(String[] args) {
		//선언 방법
		//1.변수와 값을 동시에 정의한다.
		int [] a={1,2,3,4,5,6};
		int [] b;//변수만 선언, 자릿수X, 초기값X
		//b= {11,22}; //(X) 리터럴 방식은 선언과 초기화를 따로 진행할 수 없다.
		
		//값을 가져오는 방법: 인덱스를 통해서 가져온다.
		int value=a[0];
		
		//2.변수와 값을 따로 정의할 수 있다.
		int [] b2=null;
		b2=new int [] {1,2,3,4,5,6};
		
		int [] b3=new int[5];
		b3[0]=1; b3[1]=2; b3[2]=4; b3[3]=4; b3[4]=5;
		for (int i = 0; i < b3.length; i++) {
			System.out.print(b3[i]+",");
		}
		System.out.println(b3);
		System.out.println(Arrays.toString(b3));
	}
}






