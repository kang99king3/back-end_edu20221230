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
<h1>수정하기</h1>
<jsp:useBean id="util" class="com.hk.calboard.utils.Util"></jsp:useBean>
<form action="calBoardUpdate.do" method="post">
<input type="hidden" name="seq" value="${dto.seq}"/>
<table class="table">
	<tr>
		<th>작성자</th>
		<td>${dto.id}</td>
	</tr>
	<tr>
		<th>일정</th>
		<td>${dto.mdate }
			<select name="year">
				<c:set var="year" value="${fn:substring(dto.mdate,0,4)}" />
				<c:forEach var="i" begin="${year-5}" end="${year+5}" step="1">
					<option ${year==i?"selected":""}  value="${i}">${i}</option>
				</c:forEach>
			</select>년
			<select name="month">  
				<c:set var="month" value="${fn:substring(dto.mdate,4,6)}" />
				<c:forEach var="i" begin="1" end="12" step="1">
					<option ${month==i?"selected":""}  value="${i}">${i}</option>
				</c:forEach>
			</select>월
			<select name="date">
				<c:set var="date" value="${fn:substring(dto.mdate,6,8)}" />
				<c:forEach var="i" begin="1" end="31" step="1">
					<option ${date==i?"selected":""}  value="${i}">${i}</option>
				</c:forEach>
			</select>일
			<select name="hour">
				<c:set var="hour" value="${fn:substring(dto.mdate,8,10)}" />
				<c:forEach var="i" begin="0" end="23" step="1">
					<option ${hour==i?"selected":""} value="${i}">${i}</option>
				</c:forEach>
			</select>시
			<select name="min">
				<c:set var="min" value="${fn:substring(dto.mdate,10,12)}" />
				<c:forEach var="i" begin="0" end="59" step="1">
					<option ${min==i?"selected":""} value="${i}">${i}</option>
				</c:forEach>
			</select>분
		</td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="title" value="${dto.title}"/></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="60" name="content" >${dto.content}</textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="submit" 
			onclick="location.href='calBoardUpdateform.do?seq=${dto.seq}'">수정</button>
			<button type="button" onclick="location.href='calBoardDetail.do?seq=${dto.seq}'">상세보기</button>
			<button type="button"
				onclick="location.href='calBoardList.do?year=${fn:substring(dto.mdate,0,4)}&month=${fn:substring(dto.mdate,4,6)}&date=${fn:substring(dto.mdate,6,8)}'">목록</button>
		</td>
	</tr>
</table>
</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>