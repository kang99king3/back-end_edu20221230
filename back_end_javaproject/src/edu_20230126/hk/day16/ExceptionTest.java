package edu_20230126.hk.day16;

import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest {

	public static void main(String[] args) {
		
		try {
			userExceptionTest(20);
		} catch (UserException e) {
			System.out.println("발생한 예외를 처리합니다.");
			e.printStackTrace();
		}
		
		exTest("1234");//아규먼트:"값", "예외처리", null
	}

	public static void exTest(String s) {
		int i =0;
		String ss="";
		int [] array= {1,2,3,4,5};//index는 0~4
		try {
			System.out.println("예외가 발생할 가능성이 있는 코드 작성");
			ss=s.substring(0, 2);//예외가 발생한 코드에서 바로 catch로 이동
			i=Integer.parseInt(ss);//문자열을 int형으로 변환
			int a=array[5];  //index를 5 사용
		}catch(StringIndexOutOfBoundsException se) {
			System.out.println(se+"\n:문자열의 길이를 확인하세요");
		}catch(IndexOutOfBoundsException ie) {
			System.out.println(ie+"\n:배열의 길이를 확인하세요");
		}catch(NullPointerException | NumberFormatException en) {
			System.out.println(en+"\n:해당 객체의 형식을 확인하세요");
		}catch (Exception e) {
			System.out.println("다중catch문을 작성할 때 주의사항:"
					         + "Exception 클래스를 작성하는 순서가 "
					         + "하위 클래스-->상위클래스 순으로 작성한다.");
			e.printStackTrace();
		}finally {
			System.out.println("반드시 처리할 코드 실행");
		}
	}
	
	//throws: 예외 던지는 방법
	public void test03() {
		try {
			test01();//3.예외를 던지면 반드시 마지막에는 직접 처리해야 한다.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void test01() throws IOException,NullPointerException {
		int i=0;
		System.out.println("예외를 직접 처리하기 않는다.");
		test02();//2.예외를 또 던질 수 있다.
	}	
	
	public void test02() throws IOException {
		InputStreamReader in=new InputStreamReader(null);
		in.read();//1.빨간줄이 표시됨--> checkedException이여서 무조건 예외처리해야 한다.
	}
	
	//사용자 예외처리
	public static void userExceptionTest(int a) throws UserException {
		//a는 1~10까지만 받을 수 있는 상황
		if(!(a>0&&a<11)) {//조건식: 1~10의 범위를 벗어나는 숫자이면 true
			throw new UserException("1부터 10까지만 입력이 가능합니다.");
		}
	}
}









