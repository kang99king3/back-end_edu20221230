<%@page import="com.hk.daos.LoginDao"%>
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
	String command=request.getParameter("command");

	LoginDao dao=LoginDao.getLoginDao();//dao객체 생성[싱글톤패턴 적용]
	
	if(command.equals("registForm")){
		response.sendRedirect("regist.jsp");
	}
%>
</body>
</html>







