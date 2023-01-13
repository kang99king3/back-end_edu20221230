package edu_20230113.hk.day9;

public class AntQuiz {

	//"11" --> "12" 로 만들어주는 메서드 구현
	//"11"를 처리한 결과 "12"를 저장해 줄 변수선언
	//"11"을 받아서 앞에 첫문자를 저장할 변수선언
	//연속된 같은 숫자의 개수를 저장할 변수선언
	public String antMake(String s) {
		String txt=s;
		String t="";//최종 만들어지는 숫자를 저장할 변수
		char c=txt.charAt(0);//첫번째 숫자를 구해서 저장(카운트할 대상을 저장)
		int count=1;//연속된 같은 숫자의 개수를 저장할 변수선언
		//첫번째 숫자하고 다음 숫자하고 같은지 비교--> 같으면 카운트하고, 
		//다르면 기존숫자 카운트 종료하고, 다음 숫자를 카운트한다.
		for (int i = 1; i < txt.length(); i++) {
			if(c==txt.charAt(i)) {
				count++;
			}else {
				t=t+c+count;//""+1+2   ,    "12"+"2"+1
				c=txt.charAt(i);// 2   ,  1
				count=1;//다시 카운트해야되니깐 1로 초기화
			}
		}
		t=t+c+count;//   12 --> 1121 --> "1221"+"1"+"1"
//		System.out.println(t);
		return t;
	}
	
	//"11"값을 넣어서 "12"라는 결과를 반환하는 메서드의 기능을 반복 수행하게 만들자
	//"1"-->20번째에는 어떤 숫자가 나올까?? 
	public void antPrint(int num) {
		String s="11";
		for (int i = 0; i < num; i++) {
			s=antMake(s);	
			System.out.println(s);
		}
//		System.out.println(s);
	}
}










