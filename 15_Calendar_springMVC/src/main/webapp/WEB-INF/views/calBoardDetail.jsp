<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="header.jsp" %>
</head>
<body>
<div id="container">
<h1>상세보기</h1>
<jsp:useBean id="util" class="com.hk.calboard.utils.Util"></jsp:useBean>
<table class="table">
	<tr>
		<th>작성자</th>
		<td>${dto.id}</td>
	</tr>
	<tr>
		<th>일정</th>
		<td>
			<jsp:setProperty property="toDates" name="util" value="${dto.mdate}"/>
			<jsp:getProperty property="toDates" name="util"/>
		</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${dto.title}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="60" readonly="readonly">${dto.content}</textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" 
			onclick="location.href='calBoardUpdateform.do?seq=${dto.seq}'">수정</button>
			<button type="button"
			    onclick="location.href='calMulDel.do?chk=${dto.seq}'">삭제</button>
			<button type="button"
				onclick="location.href='calBoardList.do?year=${fn:substring(dto.mdate,0,4)}&month=${fn:substring(dto.mdate,4,6)}&date=${fn:substring(dto.mdate,6,8)}'">목록</button>
<%-- 	        onclick="location.href='calBoardList.do">목록</button> --%>
		</td>					
	</tr>
</table>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>