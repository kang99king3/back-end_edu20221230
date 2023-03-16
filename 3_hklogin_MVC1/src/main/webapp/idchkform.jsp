<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function confirmId(resultId){
		var isS=(resultId=='null')?true:false;
		
		//현재 페이지를 열어준 부모 페이지를 구하는 속성: opener
// 		var parentInputId=opener.document.getElementsByName("id")[0];
		var parentInputId=opener.document.getElementById("idchk");
		if(isS){
			opener.document.getElementsByName("name")[0].focus();
			parentInputId.textContent='y';//y는 사용가능한 표시
			
		}else{
// 			parentInputId.setAttribute("class","n");//n은 중복 표시
			parentInputId.textContent='n';
			opener.document.getElementsByName("id")[0].focus();//id입력박스에 포커스
		}
		
		self.close();// 현재(self) 창을 닫는다(close())
		
	}
</script>
</head>
<body>
<%
	String resultId=(String)request.getAttribute("resultId");
%>
<div>
	<span><%=resultId==null?"사용가능합니다.":"중복된 아이디입니다." %></span>
	<span><button onclick="confirmId('<%=resultId%>')">확인</button></span>
</div>
</body>
</html>






