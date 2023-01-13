package edu_20230113.hk.day9;

import javax.print.attribute.standard.Destination;

import edu_20230112.hk.day8.StringMethodTest;

public class StringCompare {

	public static void main(String[] args) {
		//리터럴과 리터럴 비교
		String s1="java";
		String s2="java";
		System.out.println(s1==s2);//주소가 같다
		System.out.println(s1.equals(s2));//hashcode가 같다
		
		//객체와 객체 비교
		String obj1=new String("java");
		String obj2=new String("java");
		System.out.println(obj1==obj2);
		System.out.println(obj1.equals(obj2));
		
		//객체와 리터럴
		String s3="java";
		String obj3=new String("java");
		System.out.println(s3==obj3);
		System.out.println(s3.equals(obj3));
		
		
		//StringBuffer를 이용한 문자열 변경하기(더하기)
		//String 리터럴 방식은 값이 바뀔때마다 객체를 새로 생성한다.--> 메모리효율이 안좋음
		String ssss="가";    // "가"
			   ssss=ssss+"나";//"가나" 
		       ssss=ssss+"다";//"가나다"
		
		StringBuffer sb=new StringBuffer("가");
		sb.append("나");
		sb.append("다");
		System.out.println(ssss+":"+sb.toString());     
		StringMethodTest smt=new StringMethodTest();
		System.out.println(smt.toString());
	}
}









