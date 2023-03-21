<%@page import="com.hk.dtos.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="index.jsp" %>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--1. jquery 라이브러리 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

<!--2. 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!--3. 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!--4. 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!--5. Custom styles for this template -->
<link href="css/starter-template.css" rel="stylesheet">
</head>
<%
	LoginDto ldto =(LoginDto)session.getAttribute("ldto");
	if(ldto==null){
// 		pageContext.forward("index.jsp");
		response.sendRedirect("index.jsp");
	}
%>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			    <span class="sr-only">Toggle navigation</span>
			    <span class="icon-bar"></span>
			    <span class="icon-bar"></span>
			    <span class="icon-bar"></span>
			  </button>
			  <a class="navbar-brand" href="#">회원관리</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			  <ul class="nav navbar-nav">
			    <li class="active"><a href="#">Home</a></li>
			    <li><a href="LoginController.do?command=userAllList">회원전체조회</a></li>
			    <li><a href="LoginController.do?command=userlist">회원정보[등급]수정</a></li>
			  </ul>
		</div><!--/.nav-collapse -->
	</div>
</nav>
<div class="container">
	<div class="starter-template">
		<div class="lead" style="text-align: right !important;">
			<span>${ldto.id} [${ldto.role}]님이 로그인함</span>
			<a href="LoginController.do?command=logout">로그아웃</a>
		</div>
		<div class="table-responsive" style="width:60%; margin: 230px auto;" >
		<h1>회원 등급 변경</h1>
			<form action="LoginController.do" method="post">
			<input type="hidden" name="command" value="userUpdateRole"/>
			<input type="hidden" name="id" value="${dto.id}"/>
			<table class="table w-auto">
				<tr>
					<th>아이디</th>
					<td>${dto.id}</td>
				</tr>
				<tr>
					<th>등급</th>
					<td>
						<select name="role">      
							<option value="ADMIN" ${dto.role eq "ADMIN"?"selected":""}>관리자</option>
							<option value="MANAGER" ${dto.role eq "MANAGER"?"selected":""}>정회원</option>
							<option value="USER" ${dto.role eq "USER"?"selected":""}>일반회원</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${dto.name}</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${dto.address}</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${dto.email}</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit" >수정</button>
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
</div>
<div class="footer" style="text-align: center;color:white; line-height:50px; height:50px; background-color: #3c3c3c;">Copyright 1999-2023. 한경닷컴 All rights reserved.</div>
<script type="text/javascript">
	function updateUserForm(){
		location.href="LoginController.do?command=updateUserForm&id=${dto.id}";
	}
	
	function delUser(){
		location.href="LoginController.do?command=delUser&id=${dto.id}";
	}
</script>
</body>
</html>









