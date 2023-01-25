package edu_20230125.hk.day15;

// Card 객체가 카드 한장을 뜻함
public class Card {
	//카드를 만들기 위한 필드를 선언한다.
	public static final String[] DECK= {"♠","♣","◆","♥"};
	public static final String[] STECK = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
	
	//카드 한장의 대한 정보(그림+숫자)
	private String card;// "♠3"
	
//	public static final String[] ID;
	
//	public Card(String hk) {
//		ID=hk;// final을 붙이면 값변경 금지(상수): ID를 선언하고 생성자에서 초기화해주면 가능
		      // --> 객체 단위로 봤을때 변경이 되는 값이라 static을 붙여야 진정한 상수를 표현할수있다.
//	}
	
	public Card() {
//		ID[0]="10";// 안에 값은 바뀐다
//		ID=new String[] {"1","20"};//주소값 변경 금지
		init();
	}
	
	//1.맴버필드인 card의 get메서드 작성
	public String getCard() {
		return card;
	}
	
	//2.맴버필드 card에 "♠3"형태로 카드값을 저장하는 메서드 구현
	//랜덤하게 만들어서 저장해야 됨
	// init()
	// Math.random()
	public void init() {
		//랜덤하게 구하는 숫자를 인덱스로 활용할 계획이라 0부터 필요함
		//DECK은 인덱스가 0 1 2 3 로 구성됨: 0~3사이의 숫자 랜덤 생성
		int a=(int)(Math.random()*DECK.length);
		int b=(int)(Math.random()*STECK.length);//0~12사이의 숫자 랜덤 생성
		card=DECK[a]+STECK[b];
	}
	
	@Override
	public String toString() {
		return "["+card+"]";// java에서 문자열 합치는 방법 : " "+" "
	}

}





