package com.hk.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.daos.FileDao;
import com.hk.dtos.FileDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/FileMultiController.do")
public class FileMultiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		FileDao dao=new FileDao();

		MultipartRequest multi=null;
	
		//1.상대 경로
		String saveDirectory=request.getSession().getServletContext()
				            .getRealPath("upload");
		System.out.println("saveDirectory: "+saveDirectory);
		
		//2.절대 경로
//			String saveDirectory="C:/Users/user/git/back-end_edu20221230/"
//					           + "10_fileboard_MVC2_mybatis/src/main/webapp/upload";
		
		//파일을 업로드할때 최대 파일 사이즈 설정(10MB로 설정)
		//              1b->1024b->1kb->1024kb->1MB
		int maxPostSize=1*1024*1024*10;
		boolean isS=true;
		try {
			//객체생성과 동시에 파일이 업로드 된다.
			//객체(요청객체,저장경로,최대업로드 사이즈, 인코딩,중복된 파일명 리네임 객체)
			multi=new MultipartRequest(request, saveDirectory, maxPostSize,"utf-8",
									  new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(multi.getFile("filename")!=null) {
//			System.out.println(multi.getFile("filename").getName());			
//		}
						                       
		//여러개의 파일 이름을 구해준다.: //name=filename1, name=filename2...
		Enumeration files=multi.getFileNames();
		while(files.hasMoreElements()) {
		String fileName=(String)files.nextElement();//각각의 파일의 이름을 구한다.
		System.out.println("fileName:"+fileName);
		//1.원본파일명 구하기
		String origin_name=multi.getOriginalFileName(fileName);
//			String storedName=multi.getFilesystemName("filename");//rename된 파일명
		System.out.println("원본파일명:"+origin_name);
		
		//2.저장되는 파일명 구하기:UUID ---> 32자리로 생성하여 저장
		//"12345678-12345678-12345678-12345678"
		String random32=UUID.randomUUID().toString().replace("-", "");//"-"제거->32자리로 만듬
		String stored_name=random32            // abc.jpeg->  "32자리"+".jpeg"
				         +(origin_name.substring(origin_name.lastIndexOf(".")));
		
		//3.file사이즈 구하기: length() -> long타입 반환하기 때문에 int로 형변환 필요
		int file_size =(int)multi.getFile(fileName).length();
		
		//4.DB에 파일 정보 추가하기
		isS=dao.insertFileInfo(
				new FileDto(0,origin_name,stored_name,file_size,null,null));
		//5.저장된 파일의 이름을 stored_fname으로 바꾼다.
		File oldFile=new File(saveDirectory+"/"+multi.getFilesystemName(fileName));
		File newFile=new File(saveDirectory+"/"+stored_name);
		oldFile.renameTo(newFile);// old파일의 이름을 new파일의 이름으로 재정의한다.
		}
		if(isS) {
			response.sendRedirect("uploadform.jsp");
		}else {
			response.sendRedirect("error.jsp");
		}
	}
	

}
