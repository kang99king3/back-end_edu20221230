package edu_20230125.hk.day15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		
		//Set 사용하기
		Set<String> set=new HashSet<>();
		set.add("한");
		set.add("경");
		set.add("닷");
		set.add("컴");
		set.add("컴");//중복된 값은 저장X
		
		//Iterator 패턴이라고 한다.
		//Iterator는 인터페이스라서 혼자 객체생성을 못함--> iterator()메서드가 객체를 생성해줌
		Iterator<String> iter=set.iterator();
//		iter.next();//꺼내는 기능
		while(iter.hasNext()) { // hasNext() 값이 존재하는지 확인
			String str=iter.next(); // next()  값을 가져온다.
			System.out.println("set값:"+str);
		}
	}

}




