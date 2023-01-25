package edu_20230120.hk.day14_book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu_20230116.hk.day10.Lotto;

public class ListTest {

	public static void main(String[] args) {
		//List의 선언방법
		List list=new ArrayList();
		list.add("가"); // ["가","나"]
		list.add("나"); //    0   1
		list.add(1); // Object obj=new Integer(1);
		              // int i = (int)obj;
//		class ArrayList{
//			
//			private Object value;
//			
//			public void add(Object s) {
//				value=s;
//			}
//		}
		
		
		//값을 꺼낼때 항상 해당 타입으로 다운 캐스팅을 해야 하는 불편함이 있다..
		//값이 저장될때 Object 타입으로 저장됨
		String s=(String)list.get(0);// 저장 실패 ?? --> (String)캐스팅해서 사용
		System.out.println(s);
		
		//List입장에서 생각해보면..  
		byte [] ii= {12,3,4};
		byte iii=ii[0];
		
		//값을 저장할때 미리 타입을 변환해서 저장하자: "제네릭" 사용하기
		List<String> list2=new ArrayList<>();
					 list2.add("가");
		String ss=list2.get(0);//다운 캐스팅을 할 필요 없이 바로 저장
		
		list2.remove(0);//index로 특정 값을 삭제할때
		list2.clear();//list의 값들을 모두 지운다.
		System.out.println(list2.size());
		
		//Lotto객체를 넣어보자
		List<Lotto> lottoList=new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			lottoList.add(new Lotto());	//값을 저장할때마다 인덱스는 자동 생성		
		}
		for (int i = 0; i < lottoList.size(); i++) {
			System.out.println(Arrays.toString(lottoList.get(i).lots));
		}
	}
}





