<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.hk.dtos.HkDto"%>
<%@page import="java.util.List"%>
<%@page import="com.hk.daos.HkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<% //scriptlet: java의 실행코드를 작성할 수 있는 영역 
	HkDao dao=new HkDao();
	List<HkDto> lists=dao.getAllList();  // --> boardlist.jsp --> boardlist_jsp.class
%>
<body>
<h1>글목록 조회</h1>
<table border="1">
	<col width="50px"><col width="100px"><col width="300px"><col width="200px">
	<tr><th>No</th><th>작성자</th><th>제목</th><th>작성일</th></tr>
	<%
		for(int i=0;i<lists.size();i++){
			HkDto dto=lists.get(i);
			%>
			<tr>
				<td><%=dto.getSeq()%></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getTitle()%></td>
				<td><%=dto.getRegdate()%></td>
			</tr>
			<%
		}
	%>
</table>
</body>
</html>










