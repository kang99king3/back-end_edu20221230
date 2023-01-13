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
		String txt="LG헬로비전은 2019년 컨소시엄 형태로 전기차 충전사업에 진출한 후 2020년부터 사업을 본격화했다. "
				+ "기존 방송통신 사업의 지역 네트워크와 기술력,전기차 지역 밀착 서비스 노하우를 기반으로 전기차 인접 사업 영역을 확장했다. "
				+ "전국 23개 사업권역 공동주택과 전기차 아파트를 중심으로 전기차 약 1300여대 전기차 충전소(완속 및 급속 등)를 운영했다.";
		
		if(txt.indexOf(s)!=-1) {// 해당 단어가 존재한다면...
			//검색된 단어를 처리할 코드
			System.out.println("검색 내용이 존재합니다.");
			int idx=txt.indexOf(s);
			System.out.println(s+"의 위치값은 "+idx+"입니다.");
			//substring() --> (idx), (idx,idx) --> "기 술 력"
			//                                      11+3(단어의 길이값)=14
			String ss=txt.substring(idx, idx+s.length());
			System.out.println("추출한 검색어:"+ss+"입니다.");
			String txtAfter=txt.replace(s,"###");
			System.out.println(txtAfter);
			isIndexCount(txt,s);
		}else {
			//해당 단어가 없는 경우 처리할 코드
			System.out.println("검색어가 존재하지 않습니다.");
		}
	}
	
	//5.해당 검색어의 검색된 개수 출력하기[ indexOf(idx,검색시작인덱스)]
	public void isIndexCount(String txt, String s) {
		int count=0;
		int idx=0;
		while(txt.indexOf(s,idx)!=-1) {
			count++;//증감연산자 ++, --
			idx=txt.indexOf(s,idx)+s.length();//해당 단어의 종료 위치 다음 인덱스를 구함 --> 그 인덱스부터 검색하기 위해		
		}
		System.out.println(s+"의 검색된 개수는 "+count+"이다.");
		
	}
}









