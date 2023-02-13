package edu_20230127.hk.day17;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class IoTest {

	public static void main(String[] args) {
		
		IoTest io=new IoTest();
//		io.test01();
//		io.test02();
//		io.test03();
//		io.test04();
		io.test05();
		
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
			
			//보조스트림(filter) 미사용시
//			byte[] b=s.getBytes();//문자열을 byte단위로 변환해서 배열로 반환한다.
//			out.write(b);
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
	}//test02종료
	
	//한번 읽을 때 크기를 설정해서 읽고 쓰기
	public void test03() {
		InputStream in=null;
		OutputStream out=null;
		
		try {
			//해당 파일을 읽기 위한 스트림 객체 생성
			in=new FileInputStream("d:\\testimage.jpg");
			//해당 파일을 복사해서 출력하기 위한 스트림 객체 생성
			out=new FileOutputStream("d:\\testimage_copy.jpg");
			//10byte단위로 읽기 위한 가방을 만든다.
			byte [] b=new byte[10];
			int i=0;//읽어들인 개수가 저장  (read()에 경우에는 실제 값이 저장)
			while((i=in.read(b))!=-1) {  //-> 6개를 읽어서 배열b에 담으면 [1,2,3,4,5,6,7,8,9,10]
			  //out.write(b);           //                           [11,12,13,14,15,16,7,8,9,10]
				out.write(b, 0, i);//b배열의 0번째 부터 길이i만큼 출력하자
			}
		}catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//test03()종료
	
	//Reader와 Writer를 이용해서 키보드로 입력 및 출력하기
	public void test04() {
		InputStreamReader in=null;
		OutputStreamWriter out=null;
		System.out.println("입력하세요");
		
		try {
			in=new InputStreamReader(System.in);
			out=new OutputStreamWriter(System.out);
			
			char[] ch=new char[512];
			int i=0;
			while((i=in.read(ch))!=-1) {
				out.write(ch,0,i);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//test04()종료
	
	//문자 단위로 읽는 Reader와 보조스트림을 활용하여 구현
	public void test05() {
		Reader reader=null;
		BufferedReader br=null;
		
		try {
			File file=new File("d:\\HelloWorld.java");
			reader=new FileReader(file);//주스트림(node)
			br=new BufferedReader(reader);//보조스트림(filter)
			String str="";
			while((str=br.readLine())!=null) {
				System.out.println(str);// 한줄 단위로 출력
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}




























