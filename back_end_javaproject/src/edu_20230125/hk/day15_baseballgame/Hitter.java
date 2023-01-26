package edu_20230125.hk.day15_baseballgame;

import java.util.Arrays;
import java.util.Scanner;

public class Hitter {

public int []batBall;
	
	public Hitter() {
		batBall=new int [3];
	}
	
	public int[] make(){
		Scanner scan=new Scanner(System.in);
		while(true){
			System.out.print("숫자입력: ");
			char []c=scan.next().toCharArray();
			if(c.length==3){
				for (int i = 0; i < batBall.length; i++) {
					batBall[i]=c[i]-'0';
				}
				break;
			}else{
				System.out.println("숫자 3개를 입력하세요");
			}
		
		}
		
		return batBall;
	}
	
	public void Bprint(){
			System.out.println("\n"+Arrays.toString(batBall));
	}
}
