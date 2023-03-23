package com.hk.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.daos.AnsDao;
import com.hk.dtos.AnsDto;

@WebServlet("*.board")
public class AnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("requestURI:"+request.getRequestURI());
		System.out.println("contextPath:"+request.getContextPath());
		//1단계: command 값 받기
		String command=request.getRequestURI()
				              .substring(request.getContextPath().length());
		System.out.println("command:"+command);
		
		//2단계: Dao객체 생성
		AnsDao dao=new AnsDao();
		
		//3단계: 분기(command값 확인)
		if(command.equals("/boardlist.board")) {
			List<AnsDto> list=dao.getAllList();
			request.setAttribute("list", list);
			
			//forward하기
			request.getRequestDispatcher("boardlist.jsp")
			       .forward(request, response);
		}else if(command.equals("/insertForm.board")) {
			//forward하기
			request.getRequestDispatcher("insertboard.jsp")
			       .forward(request, response);
		}else if(command.equals("/insertboard.board")) {
			String id=request.getParameter("id");
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			boolean isS=dao.insertBoard(new AnsDto(id,title,content));
			if(isS) {
				response.sendRedirect("boardlist.board");
			}else {
				response.sendRedirect("errror.jsp?msg="
									+URLEncoder.encode("글추가실패","utf-8"));
			}
		}else if(command.equals("/boardDetail.board")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			AnsDto dto=dao.getBoard(seq);
			request.setAttribute("dto", dto);
			dispatch("board_detail.jsp", request, response);
		}else if(command.equals("/replyboard.board")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			String id=request.getParameter("id");
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			boolean isS=dao.replyBoard(new AnsDto(seq,id,title,content));
			if(isS) {
				response.sendRedirect("boardlist.board");
			}else {
				response.sendRedirect("errror.jsp?msg="
									+URLEncoder.encode("답글추가실패","utf-8"));
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	
	//forward 메서드 구현
	public void dispatch(String url,HttpServletRequest request, 
			  			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);		
	}

}
