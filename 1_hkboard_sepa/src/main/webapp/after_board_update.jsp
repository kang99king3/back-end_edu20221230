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
<body>
<%
	//수정 입력값들을 받는다
	int seq=Integer.parseInt(request.getParameter("seq"));
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	
	HkDao dao=new HkDao();
	boolean isS = dao.updateBoard(seq, title, content);
	
	if(isS){
		%>
		<script type="text/javascript">
			alert("글을 수정하였습니다.");
			location.href="board_detail.jsp?seq=<%=seq%>";
		</script>
		<%
	}else{
		%>
		<script type="text/javascript">
			alert("글 수정에 실패하였습니다.");
			location.href="board_update.jsp?seq=<%=seq%>";
		</script>
		<%
	}
%>
</body>
</html>










