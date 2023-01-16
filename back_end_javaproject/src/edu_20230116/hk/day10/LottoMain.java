package edu_20230116.hk.day10;

public class LottoMain {

	public static void main(String[] args) {
		Lotto lotto=new Lotto();
//		int[] lotto1=lotto.lots;
		for (int i = 0; i < 30; i++) {
//			System.out.print(lotto.makeBall()+",");			
			lotto.makeLotto();
		}

	}

}
