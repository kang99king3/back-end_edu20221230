<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<!--1. jquery 라이브러리 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

<!--2. 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!--3. 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!--4. 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
	#container{
		width:80%;
		margin: 0 auto;
	}
	
</style>

</head>
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
	  <a class="navbar-brand" href="index.jsp">MAIN</a>
	</div>
	<div id="navbar" class="collapse navbar-collapse">
	  <ul class="nav navbar-nav">
	    <li class="active"><a href="#">Home</a></li>
	    <li><a href="#about">About</a></li>
	    <li><a href="#">나의정보</a></li>
	  </ul>
	</div><!--/.nav-collapse -->
	</div>
</nav>
<div style="height: 50px;"></div>
</body>
</html>




