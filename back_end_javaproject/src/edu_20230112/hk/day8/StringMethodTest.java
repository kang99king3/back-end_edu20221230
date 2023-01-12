package edu_20230112.hk.day8;

public class StringMethodTest {

	//String 주요 메서드 
	//1.문자 하나를 반환: charAt(int index)
	public String sTest01(String s) {
		String str=s.charAt(1)+"";//문자열을 만나면 문자열이 된다
		String str2=String.valueOf(s.charAt(2));//기본타입을 ---> 문자열로 변환
		int i=Integer.parseInt("100");//숫자형태의 문자열 ---> int형으로 변환 
	
		return str;
	}
	//2.문자열의 인덱스를 반환:indexOf(String s)
	//  "최강야구"
	//   0 1 2 3  ---> "강"
	//  indexOf(s) ---> 원하는 s가 존재한다면 해당 인덱스를 반환, 없으면 -1 반환
	//  indexOf      ,   lastIndexOf 가 있다.
	//  왼쪽부터 검색함 ,   오른쪽부터 왼쪽으로 검색함
	public String sTest2(String s) {
		int num1 = s.indexOf("최");
		int num2 = s.indexOf("강야");//2글자이상일 경우 해당 문자들을 찾고 그 첫번째 문자의 인덱스 반환
		int num3 = s.lastIndexOf("구");
		int num4 = s.indexOf("동");
		
		if(s.indexOf("최고")!=-1) { //조건식으로 활용:문자열 중에 "최고"라는 단어가 존재한다면
			
		}

		return num1+ ","
			  +num2+ ","
			  +num3+ ","
			  +num4;
	}
	
	//3.문자열의 길이 반환:length()
	public int sTest03(String s) {
		return s.length();
	}
	//4.문자열의 내용을 바꾸는 기능:replace("원본","새로운 내용")
	public void sTest4() {
		String s="자바프로그래밍";
		String ss=s.replace("자바", "파이썬");//새로 대입해줘야 한다.
		System.out.println(s+":"+ss);
	}
	//5.문자열에서 원하는 내용만 추출하는 기능:substring(int start,int end)
	// substring(int startIdx) , substring(int startIdx, int endIdx)
	public String sTest05(String s) {
		String str=s.substring(2);// 문자열의 2번째 인덱스부터 끝까지 추출
		String str2=s.substring(1, 3);//문자열의 1번째 인덱스 부터 3-1번째까지 추출
		return str +" : "+str2;
	}
	//문자열에서 해당 검색어가 존재하는지 판단하여 존재한다면 해당 검색어를 추출하여
	//출력하고, "###"으로 변경하여 처리하고, 계속 검색어가 존재하는지 확인하여
	//앞에 작업을 진행한다.
	// 
	//1.해당 검색어가 존재하는 여부 판단해보기
	//2.해당 검색어의 인덱스를 구해보기
	//3.해당 검색어를 추출해서 출력해보기
	//4.해당 검색어를 문자열에서 ###으로 바꿔주기
	//5.해당 검색어의 검색된 개수 출력하기[ indexOf(idx,검색시작인덱스)]
	public void search(String s) {
		//샘플데이터는 인터넷 글 가져와서 진행하기
		String txt="이영 중소벤처기업부 장관은 12일 경영난을 겪고 있는 이태원 상인들을 만나 \"융자·대출 지원을 넘어서 진취적인 대책을 찾아갔으면 한다\"고 밝혔다."
				+ "이 장관은 이날 서울 이태원 관광특구연합회 사무실을 방문해 지난해 10월 이태원 사고 이후 경영난에 시달리고 있는 상인들을 위로하고 애로·건의 사항을 들었다."
				+ "이 장관은 인사말에서 \"사고 난 지역의 매출이 한 달째 제로(0)에 가깝다고 들었다\"면서 \"(상인들이) 임대료와 인건비를 지출해야 하다 보니 굉장히 많이 힘들어하는 것 같다\"고 했다."
				+ "그는 \"이태원이라는 상권 자체가 무너져 내려 염려가 크다\"며 \"정상적인 영업 행위를 할 수 있는 방법을 고민해야 할 것\"이라고 말했다.\r\n"
				+ "이어 이 장관은 \"급한 불을 끄는 융자·대출을 넘어서 힘을 모을 수 있는 진취적인 대책을 마련하려고 한다\"고 밝혔다.\r\n"
				+ "이태원 일대는 유동 인구가 감소하고 상인들의 매출이 급락하면서 상권 전체가 위기를 맞고 있다. 이에 중기부는 지난해 11월 자체 재난대책심의위원회를 열고 용산구 특별재난지역 선포에 따른 소상공인 특별지원방안을 마련했다.";
	

	}
}









