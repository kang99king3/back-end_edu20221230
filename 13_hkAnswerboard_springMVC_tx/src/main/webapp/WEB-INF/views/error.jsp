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
// 	String msg=(String)request.getAttribute("msg");
	String msg=request.getParameter("msg");
%>
<h1>시스템 오류 발생</h1>
<h2>관리자에게 문의하세요(<%=msg==null?"":msg%>${msgs})</h2>
<h3><a href="index.jsp">메인으로 돌아가기</a></h3>
</body>
</html>


