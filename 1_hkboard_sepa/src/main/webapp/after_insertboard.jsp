<%@page import="com.hk.dtos.HkDto"%>
<%@page import="com.hk.daos.HkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>after_insertboard</title>
</head>
<body>
<%
	//insertboard.jsp로 부터 id=hk&title=제목&content=내용 전달됨
	//파라미터를 받는 메서드 : getParameter("값이름")
	String id = request.getParameter("id");
	String title= request.getParameter("title");
	String content=request.getParameter("content");
	
	HkDao dao=new HkDao();
// 	HkDto dto=new HkDto();
// 	dto.setId(id);
// 	dto.setTitle(title);
// 	dto.setContent(content);
	boolean isS = dao.insertBoard(new HkDto(id,title,content));
	if(isS){
		response.sendRedirect("boardlist.jsp");
	}else{
		response.sendRedirect("insertboard.jsp");
	}
%>
</body>
</html>








