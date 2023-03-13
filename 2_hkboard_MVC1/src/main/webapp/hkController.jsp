<%@page import="com.hk.dtos.HkDto"%>
<%@page import="java.util.List"%>
<%@page import="com.hk.daos.HkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
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
		pageContext.forward("boardlist.jsp");
		
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
// 			request.setAttribute("lists", lists);//sendRedirect와 같이쓰면 안됨 (X)
			
			//redirect 방식
			response.sendRedirect("hkController.jsp?command=boardlist");//글목록(boardlist.jsp)이동

			//forward 방식
// 			List<HkDto> lists=dao.getAllList();//글목록 구하기
// 			request.setAttribute("lists", lists);
// 			pageContext.forward("boardlist.jsp");
		}else{
			request.setAttribute("msg", "글추가에 실패하였습니다");
			pageContext.forward("error.jsp");
		}
	}else if(command.equals("board_detail")){//글 상세보기
		int seq=Integer.parseInt(request.getParameter("seq"));
		HkDto dto=dao.getBoard(seq);//글 상세내용 구함
		request.setAttribute("dto", dto);
		pageContext.forward("board_detail.jsp");
	}
%>
</body>
</html>







