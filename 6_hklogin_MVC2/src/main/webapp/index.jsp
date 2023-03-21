<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
<link href="css/signin.css" rel="stylesheet">
</head>
<body>
<div class="container">

	<form class="form-signin" action="loginController.jsp" method="post">
		  <input type="hidden" name="command" value="login"/>
		  <h2 class="form-signin-heading">Please sign in</h2>
		  <label for="inputEmail" class="sr-only">Email address</label>
		  <input type="text" name="id" id="inputEmail" class="form-control" placeholder="ID" required autofocus>
		  <label for="inputPassword" class="sr-only">Password</label>
		  <input type="password" name="password"  id="inputPassword" class="form-control" placeholder="Password" required>
		  <div class="checkbox">
		    <label>
		      <input type="checkbox" value="remember-me"> Remember me<br/>
		      <span style="color:red;">${param.msg}</span>
		    </label>
		  </div>
		  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		  <button class="btn btn-lg btn-primary btn-block" type="button" onclick="registForm()">Sign up</button>
	</form>

</div> <!-- /container -->
<script type="text/javascript">
	//회원가입 폼으로 이동
	function registForm(){
		location.href="loginController.jsp?command=registForm";
	}
</script>
</body>
</html>







