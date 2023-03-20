package com.hk.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.daos.HkDao;
import com.hk.dtos.HkDto;

@WebServlet("/HkController.do")
public class HkController extends HttpServlet{
	
	//HttpServlet은 추상 클래스이다.---> 상속강요를 위해
//	HttpServlet hs=new HttpServlet(); (X)
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩 처리 코드 작성--> filter구현
		
		//1단계: command값 받기(어떤요청인지 확인을 위해)
		String command=request.getParameter("command");

		//2단계: DAO객체 생성하기(DB에 연결해서 작업하기 위한 준비)
		HkDao dao=new HkDao();
		
		//3단계: command값에 의해 분기 실행(요청에 대한 분기 처리)
		if(command.equals("boardlist")){//글목록 요청 처리
			List<HkDto> lists=dao.getAllList();//글목록 구하기
			
			//6단계:스코프 객체에 lists 담기
			//setAttribute("name","value"); // Map객체--> key:value
			request.setAttribute("lists", lists);//lists객체를 request 스코프에 "lists"이름으로 저장
			//7단계:페이지 이동
			dispatch("boardlist.jsp", request, response);
//			pageContext.forward("boardlist.jsp");
			
		}else if(command.equals("insertBoardForm")){//글추가폼으로 이동
			response.sendRedirect("insertboard.jsp");
		}else if(command.equals("insertboard")){//글추가하기
			//4단계:파라미터 받기
			String id=request.getParameter("id");
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			//5단계:Dao메서드 실행
			boolean isS=dao.insertBoard(new HkDto(id,title,content));
			if(isS){
//	 			request.setAttribute("lists", lists);//sendRedirect와 같이쓰면 안됨 (X)
				
				//redirect 방식
				response.sendRedirect("HkController.do?command=boardlist");//글목록(boardlist.jsp)이동

				//forward 방식
//	 			List<HkDto> lists=dao.getAllList();//글목록 구하기
//	 			request.setAttribute("lists", lists);
//	 			pageContext.forward("boardlist.jsp");
			}else{
				response.sendRedirect("error.jsp?msg="
						+URLEncoder.encode("글추가에 실패하였습니다", "utf-8"));
			}
		}else if(command.equals("board_detail")){//글 상세보기
			int seq=Integer.parseInt(request.getParameter("seq"));
			HkDto dto=dao.getBoard(seq);//글 상세내용 구함
			request.setAttribute("dto", dto);
//			pageContext.forward("board_detail.jsp");
			dispatch("board_detail.jsp", request, response);
		}else if(command.equals("board_update_form")){//수정폼이동
			int seq=Integer.parseInt(request.getParameter("seq"));
			HkDto dto=dao.getBoard(seq);
			request.setAttribute("dto", dto);
//			pageContext.forward("board_update.jsp");
			dispatch("board_update.jsp", request, response);
		}else if(command.equals("board_update")){
			int seq=Integer.parseInt(request.getParameter("seq"));
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			boolean isS=dao.updateBoard(seq, title, content);
			if(isS){
				response.sendRedirect("HkController.do?command=board_detail&seq="+seq);
			}else{
				response.sendRedirect("error.jsp?msg="
						+URLEncoder.encode("글 수정 실패!!", "utf-8"));
			}
		}else if(command.equals("board_delete")){
			String seq=request.getParameter("seq");
			boolean isS=dao.delBoard(seq);
			if(isS){
				//boardlist페이지를 보여주기위한 코드는 이미 컨트롤러에 구현되어 있기때문에 
				//브라우저한테 컨트롤러로 다시 요청하게 해주면 알아서 글목록 보여주기를 실행한다.
				response.sendRedirect("HkController.do?command=boardlist");
			}else{
				response.sendRedirect("error.jsp?msg="
						+URLEncoder.encode("글삭제실패~~", "utf-8"));
			}
		}else if(command.equals("muldel")){
			// 체크박스중에 체크가 된 값들만 전달된다. : "chk"이름의 값이 여러개 전달되고 있음
			// ---> 동일한 이름의 여러 값들은 배열로 받아서 처리한다.
//	 		request.getParameter("chk");// 파라미터 1개값을 받는 메서드
			String[] chks = request.getParameterValues("chk");

//	     유효값을 java(서버쪽)에서 처리할 수 도 있지만.....쩝..
//	 		if(chks==null||chks.length==0){
//	 			//하나이상체크해야된다 라는 메시지를 보여주고 목록으로 돌아가는 코드 구현
//	 		}else{
//	 			//삭제 기능 실행 코드
//	 		}
			
			boolean isS=dao.mulDel(chks);
			if(isS){
				response.sendRedirect("HkController.do?command=boardlist");
			}else{
				response.sendRedirect("error.jsp?msg="
									+URLEncoder.encode("글삭제실패", "utf-8"));
			}
		}
	}
	
	//forward 메서드 구현
	public void dispatch(String url,HttpServletRequest request, 
			  			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);		
	}
	
}






