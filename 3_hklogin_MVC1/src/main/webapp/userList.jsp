<%@page import="com.hk.dtos.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="index.jsp" %>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %>      
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
			    <li><a href="loginController.jsp?command=userAllList">회원전체조회</a></li>
			    <li><a href="loginController.jsp?command=userlist">회원정보[등급]수정</a></li>
			  </ul>
		</div><!--/.nav-collapse -->
	</div>
</nav>
<div class="container">
	<div class="starter-template">
		<div class="lead" style="text-align: right !important;">
			<span>${ldto.id} [${ldto.role}]님이 로그인함</span>
			<a href="loginController.jsp?command=logout">로그아웃</a>
		</div>
		<div class="table-responsive" style="width:100%; margin: 230px auto;" >
		<h1>회원 정보 목록 조회[사용자조회]</h1>
			<table class="table w-auto">
				<tr>
					<th>회원번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>회원등급</th>
					<th>가입일</th>
				</tr>
				<c:choose>
					<c:when test="${empty lists}">
						<tr>
							<td colspan="5">---회원이 존재하지 않습니다---</td>
						</tr>					
					</c:when>
					<c:otherwise>
						<c:forEach items="${lists}" var="dto" >
							<tr>
								<td>${dto.seq}</td>
								<td>${dto.id}</td>
								<td>${dto.name}</td>
								<td>${dto.role}
									<button onclick="authForm('${dto.id}')">변경</button>							
								</td>
								<td>${dto.regdate}</td>
							</tr>							
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<tr>
					<td colspan="5">
<!-- 						<button onclick="updateUserForm()">수정</button> -->
<!-- 						<button onclick="delUser()">탈퇴</button> -->
					</td>
				</tr>
			</table>
		
		</div>
	</div>
</div>
<div class="footer" style="text-align: center;color:white; line-height:50px; height:50px; background-color: #3c3c3c;">Copyright 1999-2023. 한경닷컴 All rights reserved.</div>
<script type="text/javascript">
	//등급변경 폼으로 이동
	function authForm(id){
		location.href="loginController.jsp?command=roleForm&id="+id;
	}
</script>
</body>
</html>









