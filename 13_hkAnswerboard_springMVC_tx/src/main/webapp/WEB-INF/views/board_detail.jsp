<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세보기</title>
<style type="text/css">
	#replyForm{
		display: none;
	}
</style>
</head>
<body>
<%@include file="header.jsp" %>
<div id="container">
<h1>상세보기</h1>
<table class="table">
	<tr>
		<th>작성자</th>
		<td>${dto.id}</td>
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
			<button type="button" class="replybtn" >답글</button>
			<button type="button" 
			onclick="location.href='board_update_form.do?seq=${dto.seq}'">수정</button>
			<button type="button"
			    onclick="location.href='muldel.do?chk=${dto.seq}'">삭제</button>
			<button type="button"
				onclick="location.href='boardlist.do'">목록</button>
		</td>
	</tr>
</table>
<div id="replyForm">
	<h1>답글 작성하기</h1>
	<form action="replyboard.board" method="post" >
		<input type="hidden" name="seq" value="${dto.seq}"/>
		<table class="table table-striped" >
			<tr>
				<th>작성자(ID)</th>
				<td><input type="text" name="id" pattern="^[a-zA-Z]+$"  required="required" /></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="title" required="required"/></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><textarea rows="10" cols="60" name="content" required="required"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답글등록" />
					<input type="button" value="목록" 
					onclick="location.href='boardlist.board'"/>
				</td>
			</tr>
		</table>
	</form>
</div>
</div>
<%@include file="footer.jsp" %>
<script type="text/javascript">
	$(function(){
		$(".replybtn").click(function(){
			$("#replyForm").toggle();
// 			document.getElementsByName("form")[0].reset();
		});
	});
</script>
</body>
</html>








