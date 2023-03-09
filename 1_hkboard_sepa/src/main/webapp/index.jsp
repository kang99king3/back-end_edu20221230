<%@page import="com.hk.dtos.HkDto"%>
<%@page import="java.util.List"%>
<%@page import="com.hk.datasource.DataBase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	//자바코드 작성 영역
	String str="Hello JSP";

	DataBase db=new DataBase();
	List<HkDto> lists=db.getAllList();
%>

<%=str%><br/>
<%=lists.get(0).getContent()%>
</body>
</html>