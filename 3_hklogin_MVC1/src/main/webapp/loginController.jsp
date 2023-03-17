<%@page import="java.util.List"%>
<%@page import="java.net.URLEncoder"%>
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
			response.sendRedirect("index.jsp?msg="
		                      +URLEncoder.encode("회원이 아닙니다. 가입해 주세요", "utf-8"));
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
	}else if(command.equals("idchk")){//아이디 중복체크
		String id =request.getParameter("id");
		//id값을 DB에 존재하는지 확인하기 ----> DAO에 JDBC를 구현해야 함
		String resultId=dao.idCheck(id);// null이면 사용가능
		
		request.setAttribute("resultId", resultId);
		pageContext.forward("idchkform.jsp");
	}else if(command.equals("myinfo")){
		String id =request.getParameter("id");
		LoginDto dto=dao.getUserInfo(id);
		
		request.setAttribute("dto",dto);
		pageContext.forward("userinfo.jsp");
		
	}else if(command.equals("updateUserForm")){
		String id =request.getParameter("id");
		LoginDto dto=dao.getUserInfo(id);
		
		request.setAttribute("dto", dto);
		pageContext.forward("userupdateform.jsp");
	}else if(command.equals("updateuser")){
		String id =request.getParameter("id");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		
		boolean isS=dao.updateUser(new LoginDto(id,address,email));
		
		if(isS){
			response.sendRedirect("loginController.jsp?command=myinfo&id="+id);
		}else{
			response.sendRedirect("error.jsp?msg="+URLEncoder.encode("수정실패", "utf-8"));
		}
	}else if(command.equals("delUser")){
		String id =request.getParameter("id");
		boolean isS=dao.delUser(id);
		if(isS){
			response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("error.jsp?msg="+URLEncoder.encode("탈퇴실패", "utf-8"));
		}
	}else if(command.equals("userAllList")){
		List<LoginDto> lists=dao.getUserAllList();
		
		request.setAttribute("lists", lists);
		pageContext.forward("userAllList.jsp");
	}else if(command.equals("userlist")){
		List<LoginDto> lists=dao.getUserList();
		
		request.setAttribute("lists", lists);
		pageContext.forward("userList.jsp");
	}else if(command.equals("roleForm")){
		String id=request.getParameter("id");
		
		LoginDto dto=dao.getUserInfo(id);
		request.setAttribute("dto", dto);
		pageContext.forward("userUpdateRole.jsp");
	}else if(command.equals("userUpdateRole")){
		String id=request.getParameter("id");
		String role=request.getParameter("role");
		
		boolean isS=dao.userUpdateRole(id, role);
		if(isS){
			// controller에 요청을 한다면 redirect로 요청하자
			response.sendRedirect("loginController.jsp?command=userlist");
		}else{
			response.sendRedirect("error.jsp?msg="
								  +URLEncoder.encode("등급수정실패", "utf-8"));
		}
	}
%>
</body>
</html>







