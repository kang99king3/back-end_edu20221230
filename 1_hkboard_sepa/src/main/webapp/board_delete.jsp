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
	//삭제를 위해 전달된 파라미터 seq를 받는다.
	String seq=request.getParameter("seq");
	
	if(seq==null){
		//값이 전달되지 않아 발생하게 될 오류를 처리하는 코드
	}else{
// 		int sseq=Integer.parseInt(seq);
		HkDao dao=new HkDao();
		boolean isS=dao.delBoard(seq);//seq를 String 타입으로 정의했음
		if(isS){
			%>
			<script type="text/javascript">
				alert("글을 삭제합니다.");
				location.href="boardlist.jsp";
			</script>
			<%
		}else{
			%>
			<script type="text/javascript">
				alert("글 삭제 실패");
				location.href="board_detail.jsp?seq=<%=seq%>";
			</script>
			<%
		}
	}
	
%>
</body>
</html>










