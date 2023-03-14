<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.hk.dtos.HkDto"%>
<%@page import="java.util.List"%>
<%@page import="com.hk.daos.HkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<script type="text/javascript">
	function insertBoardForm(){
		location.href="hkController.jsp?command=insertBoardForm";
	}
	
	function allSel(bool){
		var chks=document.getElementsByName("chk");// [chk,chk,chk,chk..]
		for (var i = 0; i < chks.length; i++) {
			chks[i].checked=bool;//각각의 체크박스에 체크여부를 true/false로 적용
		}
	}
</script>
</head>
<% //scriptlet: java의 실행코드를 작성할 수 있는 영역   
//   	HkDao dao=new HkDao(); 
//   	List<HkDto> lists=dao.getAllList();  // boardlist.jsp -> boardlist_jsp.class

//   request객체에 저장을 하게 되면 모두 Object객체로 자동형변환이 된다.
//   List<> list  ---> list.add("text") ---> "text"는 Object 변환
//                ---> String str=(String)list.get(0);
	List<HkDto> lists =(List<HkDto>) request.getAttribute("lists");
	//javastandard: 개념 확인 --> 형변환[업/다운캐스팅], 
	//                         참조타입 형변환 --> 계층구조(상속) 만들어서 형변환 개념을 적용             
%> 
<body>
<h1>글목록 조회</h1>
<form action="hkController.jsp" method="post">
	<input type="hidden" name="command" value="muldel"/>

<table border="1">
	<col width="50px">
	<col width="50px">
	<col width="100px">
	<col width="300px">
	<col width="200px">
	<tr><th><input type="checkbox" name="all" onclick="allSel(this.checked)"> </th>
		<th>No</th><th>작성자</th><th>제목</th><th>작성일</th></tr>
	<%
		if(lists==null||lists.size()==0){
			%>
			<tr><td colspan="5" style="text-align: center;">---작성된 글이 없습니다.---</td></tr>
			<%
		}else{
			for(int i=0;i<lists.size();i++){
				HkDto dto=lists.get(i);
				%>
				<tr>
					<td><input type="checkbox" name="chk" value="<%=dto.getSeq()%>" /> </td>
					<td><%=dto.getSeq()%></td>
					<td><%=dto.getId()%></td>
					<td><a href="hkController.jsp?command=board_detail&seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
					<td><%=dto.getRegdate()%></td>
				</tr>
				<%
			}
			
		}
	
	%>
	<tr>
		<td colspan="5">
			<button type="button" onclick="insertBoardForm()" >글쓰기</button>
			<input type="submit" value="삭제"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>










