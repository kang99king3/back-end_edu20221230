package edu_20230127.hk.day17;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IoTest {

	public static void main(String[] args) {
		
		IoTest io=new IoTest();
//		io.test01();
		io.test02();
		
	}

	//파일을 읽고 출력하기
	public void test01() {
		InputStream in=null;//입력을 위한 파이프 설계도 준비
		OutputStream out=null;//출력을 위한 파이프 설계도 준비
		
		try {
			in=new FileInputStream("d:\\HelloWorld.java");//파일의 위치를 담고 있는 객체 생성
			out=new FileOutputStream("d:\\HelloWorld2.txt");//출력할 파일의 위치를 담고 있는 객체 생성
			
			int i=0;// read()에서 반환되는 값을 저장할 변수
			while((i=in.read())!=-1) {
				System.out.print((char)i);
				out.write(i);
			}
			
//			while(true) {
//				i=in.read();//byte단위로 파일의 내용을 읽어서 i에 저장한다.(실제값저장)
//				System.out.print((char)i);
//				out.write(i);
//				
//				if(i==-1) { //읽을 값이 없으면 -1을 반환한다.
//					break;
//				}
//			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();//마지막에 실행된 것부터 닫아준다.
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//test01() 종료
	
	//filter : 보조 스트림을 이용해서 출력하기
	public void test02() {
		OutputStream out=null;//출력을 위한 파이프 준비
		DataOutputStream ds=null;//보조 스트림
		
		String s="파일을 기록합니다.";
		try {
			out=new FileOutputStream("d:\\outdata.txt");//주 스트림
			ds=new DataOutputStream(out);//보조 스트림 사용
			ds.writeUTF(s);//UTF-8 형식으로 인코딩된 문자열을 출력해 준다. 문자열을 알아서 바이트로 나눠서 처리
		} catch (FileNotFoundException e) {
			//처리코드 작성
			e.printStackTrace();
		} catch (IOException e) {
			//처리코드 작성
			e.printStackTrace();
		}finally {
			try {
				ds.close();//마지막에 실행된 것부터 닫아준다.
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}











