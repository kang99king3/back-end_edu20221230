<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* 	.table{ */
/* 		display: table; */
/* 	} */
/* 	.tr{display: table-row;} */
/* 	.td{display: table-cell; width: 50px; */
/* 		border:1px solid black; */
/* 	} */
	th,td{padding:10px !important; }
</style>
</head>
<body>
<%@include file="header.jsp" %>
<jsp:useBean id="util" class="com.hk.utils.Util" />
<div id="container">
<!-- <div class="table"> -->
<!-- 	<div class="tr"> -->
<!-- 		<div class="td">1</div> -->
<!-- 		<div class="td">2</div> -->
<!-- 		<div class="td">3</div> -->
<!-- 	</div> -->
<!-- </div> -->
<div class="table-responsive" >
	<h1>게시판 글목록 보기</h1>
	<table class="table table-striped">
		<tr>
			<th>번호</th><th>작성자</th><th>제목</th>
			<th>조회수</th><th>작성일</th><th>삭제여부</th>
			<th>refer</th><th>step</th><th>depth</th>
		</tr>
		<c:set var="lists" value="${list}"/>
		<c:forEach items="${lists}" var="dto">
			<tr>
				<td>${dto.seq}</td>
				<td>${dto.id}</td>
				<td style="width: 300px;">
					<jsp:setProperty property="arrow" name="util" value="${dto.depth}" />
					<jsp:getProperty property="arrow" name="util"/>
					<a href="boardDetail.board?seq=${dto.seq}">
					${fn:length(dto.title)<10?dto.title : fn:substring(dto.title,0,10)+="..."}
					</a>
				</td>
				<td>${dto.readcount}</td>
				<td><fmt:formatDate value="${dto.regdate}" pattern="yyyy년MM월dd일" /> </td>
				<td>${dto.delflag}</td>
				<td>${dto.refer}</td>
				<td>${dto.step}</td>
				<td>${dto.depth}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9">
				<button onclick="location.href='insertForm.board'">글추가</button>
				<button onclick="location.href='muldel.board'">삭제</button>
			</td>
		</tr>
	</table>
	</div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>



