package edu_20230125.hk.day15;

import java.util.ArrayList;
import java.util.List;

public class CardCase {

	private List<Card> cards;//Card객체를 여러개 담을 필통
	
	// 52를 구할 수 있다.(카드 총 장수)
	private static final int numOfCards=Card.DECK.length*Card.STECK.length;
	
	
	public CardCase() {
		cards=new ArrayList<>();
		shuffle();// CardCase객체가 생성되면 바로 카드케이스가 준비된다.
	}
	
	//카드 객체를 생성해서 cards에 담는 기능
	public void shuffle() {
		//카드 객체를 생성해서 cards에 담을 때 랜덤하게 생성해서 담기때문에 중복된 카드가 저장될 수 있다.
		//코드 구현하기:Card객체를 생성해서 cards에 넣는 작업---> 52장 넣어야 함 (중복처리 고려X)
		
		int i=0;
		while (true) {
			Card cc=new Card();//카드 한장이 만들어짐
			
			if(!cards.contains(cc)) {
				cards.add(cc);// list[Card,Card,Card,.....52개]				
				i++;//i값을 1씩 증가시켜줌
			}
			
			//if : 종료시키는 코드
			if(i==numOfCards) {
				break;
			}
		}
		
	}

	//getter메서드를 통해서 값을 가져온다.
	public List<Card> getCards() {
		return cards;
	}

	
	
}







