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
<%@include file="header.jsp" %>
<div id="container" style="margin-bottom:  700px;">
<h1>메인페이지</h1>
<a class="btn btn-default" href="boardlist.board?pageNum=1">글목록</a>
</div>
<%@include file="footer.jsp" %>
</body>
</html>




