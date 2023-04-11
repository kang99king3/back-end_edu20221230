<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="header.jsp" %>
<script type="text/javascript">
function allSel(bool){
	var chks=document.getElementsByName("chk");// [chk,chk,chk,chk..]
	for (var i = 0; i < chks.length; i++) {
		chks[i].checked=bool;//각각의 체크박스에 체크여부를 true/false로 적용
	}
}

//체크박스에 체크여부를 확인: 하나이상 체크가 되어 있는지..
function isAllCheck(){
	
	if(confirm("정말 삭제 하시겠습니까?")){
		var count=0;
		var chks=document.getElementsByName("chk");// [chk,chk,chk,chk..]
		for (var i = 0; i < chks.length; i++) {
			if(chks[i].checked){
				count++;
			}
		}
// 		javascript에서 submit취소하는 방법
// 		docuemnt.getElementsByTagName("form")[0].submit();
		return count>0?true:false;
	}
	
	return false;
}

</script>
</head>
<body>
<div id="container">
<jsp:useBean id="util" class="com.hk.calboard.utils.Util" />
<h1>일정목록보기</h1>
<form action="calMulDel.do" method="post" onsubmit="return isAllCheck()">
<input type="hidden" name="year" value="${empty list?'': fn:substring(list[0].mdate,0,4) }"/>
<input type="hidden" name="month" value="${empty list?'': fn:substring(list[0].mdate,4,6) }"/>
<input type="hidden" name="date" value="${empty list?'': fn:substring(list[0].mdate,6,8) }"/>
<table class="table">
	<col width="50px">
	<col width="200px">
	<col width="300px">
	<col width="200px">
	<tr><th><input type="checkbox" name="all" onclick="allSel(this.checked)"> </th>
		<th>일정</th><th>제목</th><th>작성일</th></tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr><td colspan="4" style="text-align: center;">---작성된 일정이 없습니다.---</td></tr>			
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.list}" var="dto">
					<tr>
						<td><input type="checkbox" name="chk" value="${dto.seq}" /> </td>
						<td>
							<jsp:setProperty property="toDates" name="util" value="${dto.mdate}"/>   
							<jsp:getProperty property="toDates" name="util" />    
						</td>
						<td><a href="calBoardDetail.do?seq=${dto.seq}">${dto.title}</a></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.regdate}"/> </td>
					</tr>					
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
	
	<tr>
		<td colspan="5">
			<button type="submit" title="일정삭제">
				<span class="glyphicon glyphicon-trash"></span>
			</button> 
			<button type="button" onclick="location.href='calendar.do'" title="달력보기">
				<span class="glyphicon glyphicon-calendar"></span>
			</button>    
		</td>
	</tr>
</table>
</form>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>








