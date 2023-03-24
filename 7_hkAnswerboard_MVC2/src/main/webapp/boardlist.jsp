<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	th,td{padding:10px !important; }
</style>
</head>
<body>
<%@include file="header.jsp" %>
<jsp:useBean id="util" class="com.hk.utils.Util" />
<div id="container">
<div class="table-responsive" >
	<h1>게시판 글목록 보기</h1>
	<form action="muldel.board" method="post" onsubmit="return isChecked()">
	<table class="table table-striped">
		<tr>
			<th><input type="checkbox" name="all" onclick="allChk(this.checked)" /></th>
			<th>번호</th><th>작성자</th><th>제목</th>
			<th>조회수</th><th>작성일</th><th>삭제여부</th>
			<th>refer</th><th>step</th><th>depth</th>
		</tr>
		<c:set var="lists" value="${list}"/>
		<c:forEach items="${lists}" var="dto">
			<tr>
				<td><input type="checkbox" name="chk" value="${dto.seq}"/>  </td>
				<td>${dto.seq}</td>
				<td>${dto.id}</td>
				<td style="width: 300px;">
					<c:choose>
						<c:when test="${dto.delflag=='Y'}">
						 	---삭제된 글입니다.---
						</c:when>
						<c:otherwise>
							<jsp:setProperty property="arrow" name="util" value="${dto.depth}" />
							<jsp:getProperty property="arrow" name="util"/>
							<a href="boardDetail.board?seq=${dto.seq}">
							${fn:length(dto.title)<10?dto.title : fn:substring(dto.title,0,10)+="..."}
							</a>						
						</c:otherwise>
					</c:choose>
				</td>
				<td>${dto.readcount}</td>
				<td><fmt:formatDate value="${dto.regdate}" pattern="yyyy년MM월dd일" /> </td>
				<td>${dto.delflag}</td>
				<td>${dto.refer}</td>
				<td>${dto.step}</td>
				<td>${dto.depth}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10" style="text-align: center;">
<%-- 				<c:forEach var="i" begin="1" end="${pcount}"> --%>
<%-- 					<a href="boardlist.board?pnum=${i}">${i}</a>&nbsp;&nbsp; --%>
<%-- 					<a href="boardlist.board?snum=1&enum=10">${i}</a> --%>
<%-- 					<a href="boardlist.board?snum=11&enum=20">${i}</a> --%>
<%-- 				</c:forEach> --%>
				<!-- 페이징 처리부분 시작 -->
				<nav>
				  <ul class="pagination">
				    <li ><a href="boardlist.board?pnum=${pMap.prePageNum}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				    <c:forEach var="i" begin="${pMap.startPage}" end="${pMap.endPage}">
				    	<li ${sessionScope.pnum==i?"class='active'":""}><a href="boardlist.board?pnum=${i}">${i}<span class="sr-only">(current)</span></a></li>
				    </c:forEach> 
				    <li ><a href="boardlist.board?pnum=${pMap.nextPageNum}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				  </ul>
				</nav>
				<!-- 페이징 처리부분 종료 -->
			</td>
		</tr>
		<tr>
			<td colspan="10">
				<button type="button" onclick="location.href='insertForm.board'">글추가</button>
				<button type="submit">삭제</button>
			</td>
		</tr>
	</table>
	</form>
	</div>
</div>

<%@include file="footer.jsp" %>
<script type="text/javascript">
	function allChk(bool){
// 		var chks=document.getElementsByName("chk");
// 		for (var i = 0; i < chks.length; i++) {
// 			chks[i].checked=bool;
// 		}
		
		$("input[name=chk]").prop("checked",bool);
	}
	
	function isChecked(){
		if(confirm("정말 삭제할거냐??")){
			var count=$("input[name=chk]:checked").length;
			if(count>0){
				return true;
			}else{
				alert("최소 하나 이상 체크해야 됩니다.");
				return false;
			}
		}else{
			return false;
		}
		
//  javascript로 구현할 경우 코드
// 		var count=0;
// 		var chks=document.getElementsByName("chk");
// 		for (var i = 0; i < chks.length; i++) {
// 			if(chks[i].checked){
// 				count++;
// 			}
// 		}
		
// 		if(count==0){
// 			alert("최소 하나이상 체크해야 됩니다.");
// 			return false;
// 		}else{
// 			return true;
// 		}
	}
</script>
</body>
</html>










