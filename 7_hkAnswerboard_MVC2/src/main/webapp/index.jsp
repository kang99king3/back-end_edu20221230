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
<%-- <%@include file="header.jsp" %> --%>
<jsp:include page="header.jsp" />
<div id="container">
<%
// 	String s="Hello";
	String s="안녕";
%>
<%=s%>
</div>
<%@include file="footer.jsp" %>
</body>
</html>




