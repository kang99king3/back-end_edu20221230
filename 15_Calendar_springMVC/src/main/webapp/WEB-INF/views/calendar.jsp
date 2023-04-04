<%@page import="java.util.Calendar"%>
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
	#calendar td > p {
		margin-bottom: 5px ;
		background-color: orange;
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<%

	//달력의 날짜를 바꾸기 위해 전달된 year와 month 파라미터를 받는 코드
	//코드작성
	
	Calendar cal=Calendar.getInstance(); // new(X)
	int year=cal.get(Calendar.YEAR);
	int month=cal.get(Calendar.MONTH)+1;// API: 0월~11월
	
	//달이 바뀌면서 년도와 월 값에 대한 처리 코드 작성
	
	//현재 월의 1일에 대한 요일 구하기: 1~7 --> 1(일), 2(월), 3(화), 4(수)...
	cal.set(year,month-1,1);
	int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);//1~7 중에 반환
	
	//현재 월의 마지막 날 구하기
	int lastDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
%>
<div id="container">
<h1>일정관리[달력보기]</h1>
<table class="table" id="calendar">
	<caption>
		<a href="#"></a>
		<a href="#"></a>
		<span class="y"><%=year%></span>
		<span>년</span>
		<span class="m"><%=month%></span>
		<span>월</span>
		<a href="#"></a>
		<a href="#"></a>
	</caption>
	<tr>
		<th>일</th>
		<th>월</th>
		<th>화</th>
		<th>수</th>
		<th>목</th>
		<th>금</th>
		<th>토</th>
	</tr>
	<tr>
	<%                 
		for(int i=0;i<dayOfWeek-1;i++){
			out.print("<td>&nbsp;</td>");
		}
		for(int i=1;i<=lastDay;i++){
			%>
			<td>
				<a href="#"><%=i%></a>
				<p>aaa</p>
				<p>aaa</p>
				<p>aaa</p>
			</td>
			<%
			if((dayOfWeek-1+i)%7==0){
				out.print("</tr><tr>");
			}
		}
	%>
	</tr>		
	</table>								
</div>                                 
<jsp:include page="footer.jsp"/>
</body>
</html>









