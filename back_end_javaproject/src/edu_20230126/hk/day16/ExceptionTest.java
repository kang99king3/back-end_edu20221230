package edu_20230126.hk.day16;

public class ExceptionTest {

	public static void main(String[] args) {
		
		exTest("한");

	}

	public static void exTest(String s) {
		int i =0;
		String ss="";
		try {
			System.out.println("예외가 발생할 가능성이 있는 코드 작성");
			ss=s.substring(0, 2);//예외가 발생한 코드에서 바로 catch로 이동
		}catch(StringIndexOutOfBoundsException se) {
			System.out.println(se+"\n:문자열의 길이를 확인하세요");
		}catch(IndexOutOfBoundsException ie) {
			System.out.println(ie+"\n:배열의 길이를 확인하세요");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("반드시 처리할 코드 실행");
		}
	}
}









