package edu_20230125.hk.day15_baseballgame;

import java.util.Arrays;

public class Pitcher {

public int [] pBall;
	
	public Pitcher() {
		pBall=new int[3];
	}
	public boolean isCheck(int[]a, int b){
		boolean isS=false;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==b){
				isS=true;
			}
		}
		return isS;
	}
	
	public void make(){
		int count=0;
		while(count<3){
			int b=(int) (Math.random()*9+1);
			if(!isCheck(pBall, b)){
				pBall[count++]=b;
			}
		}
	}
	
	public void pPrint(){
		System.out.println("야구게임을 시작합니다.번호를 예측하여 숫자 3개를 입력하세요");
		System.out.println(Arrays.toString(pBall));
	}
}






