<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>업로드 목록</h1>
<c:choose>
	<c:when test="${empty list}">
		<p>업로드 목록이 존재하지 않습니다. <a href="index.jsp">메인</a></p>
	</c:when>
	<c:otherwise>
		<table border="1">
			<tr>
				<th>seq</th>
				<th>원본명</th>
				<th>저장명</th>
				<th>사이즈</th>
				<th>업로드날짜</th>
				<th>삭제여부</th>
			</tr>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.seq}</td>
					<td>
						<a href="FileController.do?command=download&seq=${dto.seq}">
					    	${dto.origin_name}
					    </a>
					</td>
					<td>${dto.stored_name}</td>
					<td>${dto.file_size}</td>
					<td><fmt:formatDate value="${dto.f_regdate}" pattern="yyyy-MM-dd"/> </td>
					<td>${dto.f_delflag}</td>
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>

</body>
</html>







