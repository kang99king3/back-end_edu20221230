package com.hk.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hk.daos.AnsDao;
import com.hk.dtos.AnsDto;

@WebServlet("*.board")
public class AnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//원하는 쿠키 구하는 메서드
	public Cookie getCookie(String name,HttpServletRequest request) {
		Cookie[] cookies=request.getCookies();
		Cookie cookie=null;
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals(name)) {
				cookie=cookies[i];
			}
		}
		return cookie;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("requestURI:"+request.getRequestURI());
		System.out.println("contextPath:"+request.getContextPath());
		//1단계: command 값 받기
		String command=request.getRequestURI()
				              .substring(request.getContextPath().length());
		System.out.println("command:"+command);
		
		//2단계: Dao객체 생성
		AnsDao dao=new AnsDao();
		
		//세션객체 생성: 요청정보를 가지고 있는 request로 부터 세션객체 구해옴
		HttpSession session=request.getSession();
		
		//3단계: 분기(command값 확인)
		if(command.equals("/boardlist.board")) {
			//조회수관련 -------------------------------------------------
			//글목록을 요청하면 session 또는 cookie를 삭제하자(글조회 초기화)
			//1.session삭제하기
//			session.removeAttribute("readcount");
			
			//2.cookie삭제하기
			
			//쿠키의 값을 가져오기: 반환타입이 배열
			
			Cookie cookie=getCookie("rseq", request);
			if(cookie!=null) {
				cookie.setMaxAge(0);//쿠키 삭제
				response.addCookie(cookie);//클라이언트에 반영
			}
			
//			Cookie[] cookies=request.getCookies();
////			String s=null;
//			for (int i = 0; i < cookies.length; i++) {
//				if(cookies[i].getName().equals("rseq")) {
////					s=cookies[i].getValue();
//					cookies[i].setMaxAge(0);//해당쿠키 삭제[유효기간을 0으로 설정]
//					response.addCookie(cookies[i]);//클라이언트로 반영
//				}
//			}
			//조회수 관련 종료---------------------------------------------------
			
			String pnum=request.getParameter("pnum");// <---페이지번호 받기
			if(pnum==null) { //페이지번호 없이 요청이 오면 기본 1페이지보여주기
				pnum=1+"";
			}
			//작업1.글목록 구하고 request에 담기
			List<AnsDto> list=dao.getAllList(pnum);//<---받은 페이지 번호에 해당하는 목록구하기
			request.setAttribute("list", list);
			//작업2.글의 페이지수 구하고 request에 담기
			int pcount=dao.getPCount();
			request.setAttribute("pcount", pcount);// Object <---(Integer) int
			
			//forward하기
			request.getRequestDispatcher("boardlist.jsp")
			       .forward(request, response);
		}else if(command.equals("/insertForm.board")) {
			//forward하기
			request.getRequestDispatcher("insertboard.jsp")
			       .forward(request, response);
		}else if(command.equals("/insertboard.board")) {//새글추가하기
			String id=request.getParameter("id");
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			boolean isS=dao.insertBoard(new AnsDto(id,title,content));
			if(isS) {
				response.sendRedirect("boardlist.board");
			}else {
				response.sendRedirect("error.jsp?msg="
									+URLEncoder.encode("글추가실패","utf-8"));
			}
		}else if(command.equals("/boardDetail.board")) {// 상세보기
			int seq=Integer.parseInt(request.getParameter("seq"));
			AnsDto dto=dao.getBoard(seq);
			
			//조회수올리기---------------------------------------------
//			if(session.getAttribute("readcount")==null) {
//				dao.readCount(seq);
//				session.setAttribute("readcount", "readcount");				
//			}
			
			//쿠키의 값을 가져오기: 반환타입이 배열
			Cookie[] cookies=request.getCookies();
			String s=null;
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("rseq")) {
					s=cookies[i].getValue();
				}
			}
			
			//쿠키를 생성하는 전제조건: "rseq"라는 이름의 쿠키값이 없을 때
			if(s==null||!s.equals(seq+"")) {
				Cookie cookie=new Cookie("rseq", seq+"");//쿠키생성
				cookie.setMaxAge(60*10);//쿠키의 유효기간
				response.addCookie(cookie);//브라우저로 생성한 쿠키를 추가
				dao.readCount(seq);//조회수 증가
			}
			//조회수 올리기 처리 종료 --------------------------------------------
			
			request.setAttribute("dto", dto);
			dispatch("board_detail.jsp", request, response);
		}else if(command.equals("/replyboard.board")) {// 답글달기
			int seq=Integer.parseInt(request.getParameter("seq"));
			String id=request.getParameter("id");
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			boolean isS=dao.replyBoard(new AnsDto(seq,id,title,content));
			if(isS) {
				response.sendRedirect("boardlist.board");
			}else {
				response.sendRedirect("error.jsp?msg="
									+URLEncoder.encode("답글추가실패","utf-8"));
			}
		}else if(command.equals("/board_update_form.board")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			AnsDto dto=dao.getBoard(seq);
			request.setAttribute("dto", dto);
			dispatch("board_update.jsp", request, response);
		}else if(command.equals("/board_update.board")){
			int seq=Integer.parseInt(request.getParameter("seq"));
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			boolean isS=dao.updateBoard(new AnsDto(seq,title,content));
			
			if(isS) {
				response.sendRedirect("boardDetail.board?seq="+seq);
			}else {
				response.sendRedirect("error.jsp?msg="
						+URLEncoder.encode("수정실패","utf-8"));
			}
		}else if(command.equals("/muldel.board")) {
			String[] chks=request.getParameterValues("chk");
			
			boolean isS = dao.muldelBoard(chks);
			if(isS) {
				response.sendRedirect("boardlist.board");
			}else {
				response.sendRedirect("error.jsp?msg="
						+URLEncoder.encode("삭제실패","utf-8"));
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
