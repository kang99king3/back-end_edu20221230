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
<title>글상세보기</title>
</head>
<%
	//상세보기 기능을 실행하기 위해 seq값을 전달 받는다.
// 	int seq =Integer.parseInt(request.getParameter("seq"));
// 	HkDao dao=new HkDao();
// 	HkDto dto=dao.getBoard(seq);

//  controller에서 전달된 dto 객체를 받는다.
	HkDto dto=(HkDto)request.getAttribute("dto");
%>
<body>
<h1>상세보기</h1>
<table border="1">
	<tr>
		<th>작성자</th>
		<td><%=dto.getId()%></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><%=dto.getTitle()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent()%></textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" 
			onclick="location.href='board_update_form.board?seq=<%=dto.getSeq()%>'">수정</button>
			<button type="button"
			    onclick="location.href='board_delete.board?seq=<%=dto.getSeq()%>'">삭제</button>
			<button type="button"
				onclick="location.href='boardlist.board'">목록</button>
		</td>
	</tr>
</table>
</body>
</html>








