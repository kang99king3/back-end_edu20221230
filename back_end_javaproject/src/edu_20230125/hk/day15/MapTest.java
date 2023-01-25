package edu_20230125.hk.day15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		//Map 사용하기 --> myBatis 프레임워크에서 많이 사용.
		Map<String, String> map=new HashMap<>();
		map.put("하나", "한경");
		map.put("둘", "닷컴");
		map.put("셋", "IT");
		System.out.println("Map에서 값 가져오기:"+map.get("하나"));
		
		//map의 키값을 Set에 담아서 반환한다.
		//map에서 바로 iterator객체를 반환하는 메서드가 없어서 
		//key값들을 Set객체로 반환하는 keySet메서드를 이용한다.--> Set에는 iterator()존재
		Set<String> setKeyMap=map.keySet();//Set객체반환
		Iterator<String> iterKeyMap=setKeyMap.iterator();//Iterator객체 반환
		while(iterKeyMap.hasNext()) {
			String str=iterKeyMap.next();//키값을 가져온다.
			System.out.println(map.get(str));
		}
	}

}





