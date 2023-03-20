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
<%	String str="객체";
	out.print("프린트"+str);
%>
<%=str%>
<a href="HelloServletOld.do?name=hankyung">서블릿요청</a>
</body>
</html>