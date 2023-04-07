<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="header.jsp"/>
<style type="text/css">
	#calendar td > p {
		margin-bottom: 5px ;
		background-color: orange;
	}
	#calendar td{
		height: 115px;
	}
</style>

</head>
<body>
<%

	//달력의 날짜를 바꾸기 위해 전달된 year와 month 파라미터를 받는 코드
	String paramYear=request.getParameter("year");
	String paramMonth=request.getParameter("month");
	
	Calendar cal=Calendar.getInstance(); // new(X)
	int year=cal.get(Calendar.YEAR);
	int month=cal.get(Calendar.MONTH)+1;// API: 0월~11월
	
	//달이 바뀌면서 년도와 월 값에 대한 처리 코드 작성
	if(paramYear!=null){
		year=Integer.parseInt(paramYear);
	}
	if(paramMonth!=null){
		month=Integer.parseInt(paramMonth);
	}
	
	//여기에 작성하세요 0월 -1월....   13월 14월 ....  월을 변경할 때 오류를 처리하기
	//월이 증가하다가 12에서 13으로 넘어가는 과정에서 14,15,16...증가되는거 처리하기
	if(month>12){
		month=1;
		year++;
	}
	
	//월이 감소하다가 1에서 0또는 -1,-2... 변경되는거 처리하기
	if(month<1){
		month=12;
		year--;
	}
	
	//현재 월의 1일에 대한 요일 구하기: 1~7 --> 1(일), 2(월), 3(화), 4(수)...
	cal.set(year,month-1,1);
	int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);//1~7 중에 반환
	
	//현재 월의 마지막 날 구하기
	int lastDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
%>
<div id="container">
<h1>일정관리2[달력보기]</h1>
<table class="table" id="calendar">
	<caption style="text-align: center; font-size: 30px;">
		<a href="calendar.do?year=${calMap.year-1}&month=${calMap.month}">◁</a>
		<a href="calendar.do?year=${calMap.year}&month=${calMap.month-1}">◀</a>
		<span class="y">${calMap.year}</span>
		<span>년</span>
		<span class="m">${calMap.month}</span>
		<span>월</span>
		<a href="calendar.do?year=${calMap.year}&month=${calMap.month+1}">▶</a>
		<a href="calendar.do?year=${calMap.year+1}&month=${calMap.month}">▷</a>
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
	<c:forEach begin="1" end="${calMap.dayOfWeek}">
		
	</c:forEach>
	<%                 
		for(int i=0;i<dayOfWeek-1;i++){
			out.print("<td>&nbsp;</td>");
		}
		for(int i=1;i<=lastDay;i++){
			%>
			<td>
				<a href="#"><%=i%></a>
<!-- 				<p>aaa</p> -->
<!-- 				<p>aaa</p> -->
<!-- 				<p>aaa</p> -->
			</td>
			<%
			if((dayOfWeek-1+i)%7==0){
				out.print("</tr><tr>");
			}
		}
		//달력의 마지막 날 이후 공백 작성하여 달력폼을 완성
		for(int i=0;i<(7-(dayOfWeek-1+lastDay)%7)%7;i++){
			out.print("<td>&nbsp;</td>");
		}
	%>
	</tr>		
	</table>								
</div>                                 
<jsp:include page="footer.jsp"/>
</body>
</html>









