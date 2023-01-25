package edu_20230125.hk.day15;

import java.util.ArrayList;
import java.util.List;

public class CardMain {

	public static void main(String[] args) {
//		Card card=new Card();//카드 한장 만들어짐
		//다음 코드를 실행할때 [♠5] 이런 형태로 출력되도록 Card클래스에 코드를 추가하세요
//		System.out.println(card.toString());

//		List<String> list=new ArrayList<>();
//		list.add("가");
//		System.out.println("해당객체가 존재하냐?:"+list.contains("나"));
		
		CardCase cardCase=new CardCase();
		List<Card> cList=cardCase.getCards();//cards를 가져온다.
		for (int i = 0; i < cList.size(); i++) {
		 //   Card객체 	.  card--> "[♠5]" : 실제 카드값을 출력
//			String card=cList.get(i).getCard();
//			System.out.print(card+"\t");
			System.out.print(cList.get(i)+"\t");
			//10장씩 줄바꿔서 출력하기
			if((i+1)%10==0) { //1%10==0 ?
				System.out.println();//10장출력하고 실행되게...				
			}
		}
		
	}

}





