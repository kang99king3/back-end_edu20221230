package edu_20230116.hk.day10;

public class LottoStore {

	//Lotto객체(숫자6개생성된 로또1장)들을 담을 배열 선언
	public Lotto [] lottoObj;//Lotto객체를 저장{Lotto,Lotto,Lotto....}
	
	//2차원배열로 구현할 수 있지만 여기서는 사용 안함
	public int [][] lotsInt;//2차원배열 {{1,2,3,4,5,6},{...},{..}}
	
	public LottoStore() {
		lottoObj=new Lotto[5];//참조타입 배열, 길이 5로 초기화하여 생성
		makeLotto();
	}
	
	public LottoStore(int n) {
		lottoObj=new Lotto[n];//참조타입 배열, 길이 n으로 초기화하여 생성
		makeLotto();
	}
	
	//2차원배열을 사용한다면 실행할 생성자
	public LottoStore(int m, int n) {
		lotsInt=new int [m][n];//m은 장수, n 번호개수(현재는 6개로 설정하기)
	}
	
	//Lotto객체를 생성해서 배열에 저장하는 메서드
	public void makeLotto() {
		for (int i = 0; i < lottoObj.length; i++) {
			lottoObj[i]=new Lotto();
		}
	}
}







