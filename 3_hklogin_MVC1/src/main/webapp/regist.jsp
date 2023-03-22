<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<script type="text/javascript">
	
	onload=function(){
// 		form.onsubmit=()=>{
			
// 		}

		//기능: 아이디 중복체크를 한 뒤에 다른 정보를 입력할 수 있게 처리
		var inputs=document.querySelectorAll("input[name]");
		//inputs[input(name속성),input(name속성),input(name속성)...]
		for (var i = 2; i < inputs.length; i++) {
			inputs[i].onfocus=function(){
// 				if(inputs[1].className=='n'){ // input.class -> class가 예약어 --> className 표현	
				if(document.getElementById("idchk").textContent=="n"){	
					alert("아이디의 중복체크를 먼저 확인하세요");
					inputs[1].focus();
				}
			}
			
		}
	}
	
	function isPassword(form){
// 		alert(form.password.value);
		if(form.password.value!=form.password2.value){
			alert("비밀번호를 확인하세요");
			form.password.value="";//비밀번호 입력값 초기화
			form.password2.value="";//비밀번호 입력값 초기화
			form.password.focus();//바로 입력할 수 있게 커서 넣어주기
			return false;//유효하지 않은 값이 존재하면 submit 이벤트를 취소시켜야 한다!!
		}
	}
	
	function idChk(){
		//입력한 ID값 가져오기
		var id=document.getElementsByName("id")[0].value;
		if(id==""){
			alert("아이디를 입력하세요");
		}else{
			window.open("loginController.jsp?command=idchk&id="+id,
					    "아이디 확인",
					    "width=300px,height=300px");			
		}
		
	}
</script>
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
	  <a class="navbar-brand" href="#">회원관리</a>
	</div>
	<div id="navbar" class="collapse navbar-collapse">
	  <ul class="nav navbar-nav">
	    <li class="active"><a href="#">Home</a></li>
	    <li><a href="#about">About</a></li>
	    <li><a href="#contact">Contact</a></li>
	  </ul>
	</div><!--/.nav-collapse -->
	</div>
</nav>

<div class="container">
	<div class="starter-template">
		<h1>회원 가입</h1>
		<form class="form-horizontal" action="loginController.jsp" method="post"
		      onsubmit="return isPassword(this)">
			<input type="hidden" name="command" value="adduser" />
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">ID</label>
				<div class="col-sm-7">
					<input required="required" type="text" name="id" class="form-control" id="inputEmail3" placeholder="ID"> 
					<span id="idchk" style="display: none">n</span>
				</div>
				<label class="col-sm-1 control-label">
					<a href="#" onclick="idChk()">중복체크</a>
				</label>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">이름</label>
				<div class="col-sm-8">
					<input required="required" type="text" name="name" class="form-control" id="inputPassword3" placeholder="이름">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-8">
					<input required="required" type="password" name="password" class="form-control"
						id="inputPassword3" placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password
					확인</label>
				<div class="col-sm-8">
					<input required="required" type="password" name="password2" class="form-control"
						id="inputPassword3" placeholder="Password 확인">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">주소</label>
				<div class="col-sm-8">
					<input required="required" type="text" name="address" class="form-control"
						id="inputPassword3" placeholder="주소">
				</div>
				
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">이메일</label>
				<div class="col-sm-8">
					<input required="required" type="email" name="email" class="form-control"
						id="inputPassword3" placeholder="email">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">가입 완료</button>
					<input type="button" class="btn btn-default" value="메인"
						onclick="location.href='index.jsp'" />
				</div>
			</div>
		</form>
	</div>
</div><!-- /.container -->

</body>
</html>


