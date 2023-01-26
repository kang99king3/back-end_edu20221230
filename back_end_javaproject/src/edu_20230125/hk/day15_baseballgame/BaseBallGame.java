package edu_20230125.hk.day15_baseballgame;

public class BaseBallGame {

	public int [] pit;
	public int [] bat;
	public BaseBallGame() {
		create();
	}
	public void create(){
		Pitcher p=new Pitcher();
		p.make();
		pit=p.pBall;
		p.pPrint();
	}
	
	public void play(){
		Hitter h=new Hitter();
		int count=0;
		while(count<10){
			bat=h.make();
			if(!isInt(bat)){
				h.Bprint();
				if(compare()==3){
					break;
				}
				count++;
				if(count==10){
					System.out.println("10회를 초과 하여 투수가 승리하였습니다!!");
					break;
				}
			}else{
				System.out.println("숫자만 입력하세요");
			}
			
		}
	}
	
	public int compare(){
		int strike=0;
		int ball=0;
		for (int i = 0; i < pit.length; i++) {
			for (int j = 0; j < pit.length; j++) {
				if(pit[i]==bat[j]&&i==j){
					strike++;
				}else if(pit[i]==bat[j]&&i!=j){
					ball++;
				}
			}
		}
		return winPrint(strike, ball);
	}
	
	public int winPrint(int s,int b){
		if(s==0&&b==0){
			System.out.println("OUT!!!");
		}else if(s==3){
			System.out.println("strike: "+s+" 숫자를 모두 맞추셨습니다.");
			System.out.println("타자 승리 !!");
			return 3;
		}else{
			System.out.println("strike: "+s+",ball: "+b);
		}
		return 1;
	}
	public boolean isInt(int [] a){
		boolean isC=false;
		for (int i = 0; i < a.length; i++) {
			if(!(a[i]>0&&a[i]<10)){
				isC=true;
				break;
			}
		}
		return isC;
	}
}




