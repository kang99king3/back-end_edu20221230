package edu_20230116.hk.day10;

import java.util.Arrays;

//Lotto객체: 로또 번호 6개를 생성해서 배열에 저장하고 있는 객체
public class Lotto {
	//맴버필드: 클래스에 정의하는 변수
	public int [] lots;//배열선언
	//생성자: 클래스의 맴버필드를 초기화한다.
	public Lotto() {
		lots=new int[6];
		makeLotto();
	}
	//생성자 오버로딩
	public Lotto(int n) {
		lots=new int[n];
		makeLotto();
	}
	
	//로또1장 만든다 ---> 임의 숫자가 생성되야해..--> 1~45까지 숫자 중에...
	//1~45사이에 숫자를 렌덤하게 생성(반환)해주는 메서드
	public int makeBall() {
		//0.0000000000....1 ~ 0.9999999999...99:사이에 숫자를 렌덤하게 반환(0~1사이의 실수반환)
		//0~1사이 ---> 1~45까지의 숫자 :  렌덤실수X45+1 => 1X45=45보다는 작은 수=> 0.000..~44.999
		//                                                       정수변환-> 0~44 ->1~45
		int a=(int)(Math.random()*45)+1;
		return a;
	}
	
	//1~45까지의 렌덤 숫자를 배열에 6개 담아주는 메서드
	public void makeLotto() {
//		for(int i=0;i<lots.length;i++) {
//			lots[i]=makeBall();
//		}
		int count=0;
		while(count<lots.length) {
			int b=makeBall();
			if(!isSame(lots, b)) {// lots배열에 b숫자가 존재하지 않는다면 실행해라
				lots[count++]=b;
			}
		}
		System.out.println(Arrays.toString(lots));
	}
	
	//1~45까지의 숫자를 렌덤하게 뽑다보면... 예를 들어 5가 생성됐는데, 그 다음에 또 5가 생성될 수 있나??
	//---> 중복된 숫자를 제거해야 되는구나...--> 중복된 숫자를 판별할 수 있는 메서드
	//lots배열에 저장되어 있는 숫자들을 확인해서 중복되는게 있는지 판별하기:makeBall()에 의해 생성된 숫자와 비교
	//이 메서드에 전달될 파리미터: lots배열, 랜덤숫자
	public boolean isSame(int[] a,int b) {
		boolean isS=false;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==b) {//배열에 b와 같은 숫자가 존재한다면..
				isS=true;
				break;
			}
		}
		return isS;
	}
}






