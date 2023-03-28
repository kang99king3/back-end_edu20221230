package com.hk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.daos.FileDao;
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
		
			String saveDirectory="D:/workspace_20221230_backend/10_fileboard_MVC2_mybatis"
					           + "/src/main/webapp/upload";
			//파일을 업로드할때 최대 파일 사이즈 설정(10MB로 설정)
			//              1b->1024b->1kb->1024kb->1MB
			int maxPostSize=1*1024*1024*10;
			
			try {
				multi=new MultipartRequest(request, saveDirectory, maxPostSize,"utf-8",
										  new DefaultFileRenamePolicy());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String origin_fname=multi.getOriginalFileName("filename");
			System.out.println("원본파일명:"+origin_fname);
		}else if(command.equals("uploadform")) {//업로드 폼 이동
			response.sendRedirect("uploadform.jsp");
		}
	}

}







