package com.hk.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.daos.FileDao;
import com.hk.dtos.FileDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/FileController.do")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//요청방식이 multipart/form-data 방식이기 때문에 httpSR로 받을 수 없다
		String command=request.getParameter("command");
		
		//multipartRequest로 받아야 된다.
//	    MultipartRequest mrequest=new MultipartRequest(request,"D:/eclipse") ;
//	    String command = mrequest.getParameter("command");
		
		FileDao dao=new FileDao();
		System.out.println(command);
		
		//command값이 null이면 multipart로 요청한거라고 보고 코드(파일업로드작업) 작성
		if(command==null) {
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
			
			try {
				//객체생성과 동시에 파일이 업로드 된다.
				//객체(요청객체,저장경로,최대업로드 사이즈, 인코딩,중복된 파일명 리네임 객체)
				multi=new MultipartRequest(request, saveDirectory, maxPostSize,"utf-8",
										  new DefaultFileRenamePolicy());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(multi.getFile("filename").getName());

			//1.원본파일명 구하기
			String origin_name=multi.getOriginalFileName("filename");
//			String storedName=multi.getFilesystemName("filename");//rename된 파일명
			System.out.println("원본파일명:"+origin_name);
			
			//2.저장되는 파일명 구하기:UUID ---> 32자리로 생성하여 저장
			//"12345678-12345678-12345678-12345678"
			String random32=UUID.randomUUID().toString().replace("-", "");//"-"제거->32자리로 만듬
			String stored_name=random32            // abc.jpeg->  "32자리"+".jpeg"
					         +(origin_name.substring(origin_name.lastIndexOf(".")));
			
			//3.file사이즈 구하기: length() -> long타입 반환하기 때문에 int로 형변환 필요
			int file_size =(int)multi.getFile("filename").length();
			
			//4.DB에 파일 정보 추가하기
			boolean isS=dao.insertFileInfo(
					new FileDto(0,origin_name,stored_name,file_size,null,null));
			//5.저장된 파일의 이름을 stored_fname으로 바꾼다.
			File oldFile=new File(saveDirectory+"/"+multi.getFilesystemName("filename"));
			File newFile=new File(saveDirectory+"/"+stored_name);
			oldFile.renameTo(newFile);// old파일의 이름을 new파일의 이름으로 재정의한다.
			
			if(isS) {
				response.sendRedirect("uploadform.jsp");
			}else {
				response.sendRedirect("error.jsp");
			}
		}else if(command.equals("uploadform")) {//업로드 폼 이동
			response.sendRedirect("uploadform.jsp");
		}else if(command.equals("downloadlist")) {//업로드 목록보기
			List<FileDto>list=dao.getFileList();//목록 구하고
			
			request.setAttribute("list", list);//스코프에 담고
			
			request.getRequestDispatcher("filelist.jsp")
				   .forward(request, response);//이동
		}else if(command.equals("download")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			
			//DB에 저장되어 있는 파일 정보가져오기(origin_name, stored_name)
			FileDto dto=dao.getFileInfo(seq);
			
			//파일의 저장 경로
			String saveDirectory=request.getSession().getServletContext()
		            .getRealPath("upload");
			
			String filePath=saveDirectory+"/"+dto.getStored_name();
			
			//-------다운로드 환경 설정하기 시작
			//브라우저로 응답할 때 설정값 초기화
			response.reset();
			
			//다운로드하는 파일의 형식을 모른다면 octet-stream 설정한다.
//			response.setContentType("text/html");
//			response.setContentType("application/msword");
			response.setContentType("application/octet-stream");
			
			//한글 인코딩 : 한글파일에 경우 이름이 깨지는 것을 방지
			String encoding=new String(dto.getOrigin_name()
										.getBytes("utf-8"),"8859_1");
			
			//파일의 다운로드 버튼을 클릭했을때 저장화면이 나오도록 처리
			//파일명을 원본파일명으로 바꿔주는 코드
			response.setHeader("Content-Disposition",
					           "attachment; filename="+encoding);
			//-------다운로드 환경 설정하기 종료
			
			File file=new File(filePath);//file객체 생성
			
			//java가 한번에 읽을 수 있는 양의 크기만큼 배열을 생성
			byte[] b=new byte[(int)file.length()];
			
			FileInputStream in=null;//파일을 읽어들이기 위한 파이프(입력)
			ServletOutputStream out=null;//내보내기 위한 객체(출력)
			
			try {
				in=new FileInputStream(file);//file을 읽어들이기 위한 파이프 준비
				out=response.getOutputStream();//출력을 위한 파이프 준비
				int numRead=0;//읽어들이는 값을 저장할 변수
				while((numRead=in.read(b,0,b.length))!=-1) {
					out.write(b,0,numRead);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				out.flush();//남은 데이터가 있으면 모두 다 밀어내서 내보내기
				out.close();
				in.close();
			}
		}
	}

}







