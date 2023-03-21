<%@page import="com.hk.dtos.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="index.jsp"%>
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
 <link href="css/carousel.css" rel="stylesheet">
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
	  <a class="navbar-brand" href="user_main.jsp">회원관리</a>
	</div>
	<div id="navbar" class="collapse navbar-collapse">
	  <ul class="nav navbar-nav">
	    <li class="active"><a href="#">Home</a></li>
	    <li><a href="#about">About</a></li>
	    <li><a href="loginController.jsp?command=myinfo&id=<%=ldto.getId()%>">나의정보</a></li>
	  </ul>
	</div><!--/.nav-collapse -->
	</div>
</nav>
<div class="container">
	<div class="starter-template">
		<div class="lead" style="text-align: right !important;">
			<span><%=ldto.getId()%> [<%=ldto.getRole()%>]님이 로그인함</span>
			<a href="loginController.jsp?command=logout">로그아웃</a>
		</div>
		<h1>사용자 페이지</h1>
	</div>
</div>
<!-- Carousel
    ================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner" role="listbox">
    <div class="item active">
<!--       <img class="first-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="First slide"> -->
      <img class="first-slide" src="https://www.instarem.com/blog/wp-content/uploads/2021/09/Blog-Images-8.png" alt="First slide">
      
      <div class="container">
        <div class="carousel-caption">
          <h1>What Is FinTech?</h1>
          <p>In its simplest form, fintech (financial technology) can be defined as the use of technology to improve financial services.</p>
          <p><a class="btn btn-lg btn-primary" href="https://www.instarem.com/blog/the-5-most-in-demand-skills-in-the-fintech-industry/" role="button">Learn more</a></p>
        </div>
      </div>
    </div>
    <div class="item">
      <img class="second-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Second slide">
      <div class="container">
        <div class="carousel-caption">
          <h1>Example headline.</h1>
          <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
          <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
        </div>
      </div>
    </div>
    <div class="item">
      <img class="third-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">
      <div class="container">
        <div class="carousel-caption">
          <h1>One more for good measure.</h1>
          <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
        </div>
      </div>
    </div>
  </div>
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div><!-- /.carousel -->
<div class="footer" style="text-align: center;color:white; line-height:50px; height:50px; background-color: #3c3c3c;">Copyright 1999-2023. 한경닷컴 All rights reserved.</div>
</body>
</html>









