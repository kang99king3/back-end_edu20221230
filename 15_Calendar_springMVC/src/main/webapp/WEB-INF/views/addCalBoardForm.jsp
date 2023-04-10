<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="header.jsp"/>
</head>
<%
	Calendar cal=Calendar.getInstance();
	int hour = cal.get(Calendar.HOUR_OF_DAY);
	int min = cal.get(Calendar.MINUTE);
	System.out.println("시간:"+hour);
	
	//EL에서 꺼내 쓰기 위해 pageScope에 저장함 --> controller에서는 requestScope에 담기
	pageContext.setAttribute("hour", hour);
	pageContext.setAttribute("min", min);
%>
<body>
<div id="container">
<h1>일정 추가하기</h1>
<form action="addCalBoard.do" method="post">
<%-- 	<input type="hidden" name="id" value="${sessionScope.ldto.id}"/> --%>
	<table class="table">
		<tr>
			<th>아이디</th>
<%-- 		<td>${sessionScope.ldto.id}</td> --%>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<th>일정</th>
			<td>
				<select name="year">
					<c:forEach var="i" begin="${param.year-5}"
										 end="${param.year+5}" step="1">
						<option ${param.year==i?"selected":""}  value="${i}">${i}</option>
					</c:forEach>
				</select>년
				<select name="month">
					<c:forEach var="i" begin="1"
										 end="12" step="1">
						<option ${param.month==i?"selected":""}  value="${i}">${i}</option>
					</c:forEach>
				</select>월
				<select name="date">
					<c:forEach var="i" begin="1"
										 end="31" step="1">
						<option ${param.date==i?"selected":""}  value="${i}">${i}</option>
					</c:forEach>
				</select>일
				<select name="hour">
					<c:forEach var="i" begin="0"
										 end="23" step="1">
						<option ${hour==i?"selected":""} value="${i}">${i}</option>
					</c:forEach>
				</select>시
				<select name="min">
					<c:forEach var="i" begin="0"
										 end="59" step="1">
						<option ${min==i?"selected":""} value="${i}">${i}</option>
					</c:forEach>
				</select>분
<!-- 				<input type="time" /> -->
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="60" name="content"></textarea> </td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="일정추가"/>
				<input type="button" value="달력"
				  onclick="location.href='calendar.do'"/>
			</td>
		</tr>
	</table>
</form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>