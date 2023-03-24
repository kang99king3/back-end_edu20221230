<%@page import="com.hk.dtos.HkDto"%>
<%@page import="com.hk.daos.HkDao"%>
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
<%
	//상세보기 코드와 동일함
// 	int seq=Integer.parseInt(request.getParameter("seq"));
// 	HkDao dao=new HkDao();
// 	HkDto dto=dao.getBoard(seq);

	HkDto dto=(HkDto)request.getAttribute("dto");
%>
<body>
<h1>작성글 수정하기</h1>
<form action="board_update.board" method="post">
<!-- <input type="hidden" name="command" value="board_update"/> -->
<input type="hidden" name="seq" value="<%=dto.getSeq()%>"/>
<table border="1">
	<tr>
		<th>작성자</th>
		<td><%=dto.getId()%></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="title" value="<%=dto.getTitle()%>"/></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="60" name="content"><%=dto.getContent()%></textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="수정완료"/>
			<button type="button"
				onclick="boardlist.board'">목록</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>


