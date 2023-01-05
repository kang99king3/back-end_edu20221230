package edu_20230105.hk.day4;

public class StarView {

	public static void main(String[] args) {
		
//		  0★         --->   1 2 3 4 5
//		  1★★               0 1 2 3 4
//		  2★★★
//		  3★★★★
//		  4★★★★★
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("★");	//별을 옆으로 출력					
			}
			System.out.println();//줄바뀜
		}
		
//		  0☆☆☆☆★         --->   1 2 3 4 5
//		  1☆☆☆★★               0 1 2 3 4
//		  2☆☆★★★
//		  3☆★★★★
//		  4★★★★★
		// 공백 " "
		System.out.println(" "+"☆");
	
	}

}
