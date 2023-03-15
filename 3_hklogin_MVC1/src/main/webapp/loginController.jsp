<%@page import="com.hk.dtos.LoginDto"%>
<%@page import="com.hk.daos.LoginDao"%>
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
	String command=request.getParameter("command");

	LoginDao dao=LoginDao.getLoginDao();//dao객체 생성[싱글톤패턴 적용]
	
	if(command.equals("registForm")){
		response.sendRedirect("regist.jsp");
	}else if(command.equals("adduser")){
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		
		boolean isS=dao.insertUser(new LoginDto(id,name,password,address,email));
		if(isS){
			%>
			<script type="text/javascript">
				alert("회원에 가입이 되셨습니다.^^");
				location.href="index.jsp";
			</script>
			<%
		}else{
			%>
			<script type="text/javascript">
				alert("회원에 가입이 실패함. ㅜㅜ");
				location.href="loginController.jsp?command=registForm";
			</script>
			<%
		}
	}else if(command.equals("login")){
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		LoginDto ldto=dao.getLogin(id, password);
		
		if(ldto==null||ldto.getId()==null){
			
		}else{
			//id와 password가 맞다면
			session.setAttribute("ldto", ldto);// sessionScope에 ldto를 담기
			session.setMaxInactiveInterval(10*60);//10분간 요청이 없으면 세션 삭제
			
			//등급[ADMIN, MANAGER, USER]을 확인해서 해당 MAIN 페이지로 이동하자
			if(ldto.getRole().toUpperCase().equals("ADMIN")){
				response.sendRedirect("admin_main.jsp");
			}else if(ldto.getRole().toUpperCase().equals("MANAGER")){
// 				response.sendRedirect("manager_main.jsp");
				response.sendRedirect("user_main.jsp");
			}else if(ldto.getRole().toUpperCase().equals("USER")){
				response.sendRedirect("user_main.jsp");
			}
		}
	}else if(command.equals("logout")){
		session.invalidate();//session안에 저장되어 있던 객체들을 모두 삭제
// 		session.removeAttribute("ldto");//원하는 객체 삭제
		response.sendRedirect("index.jsp");
	}
%>
</body>
</html>







