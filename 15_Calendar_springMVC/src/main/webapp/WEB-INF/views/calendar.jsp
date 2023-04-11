<%@page import="com.hk.calboard.dtos.CalDto"%>
<%@page import="java.util.List"%>
<%@page import="com.hk.calboard.utils.Util"%>
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
<jsp:include page="header.jsp"/>
<style type="text/css">
	#calendar td > p {
		margin-bottom: 5px ;
		background-color: 	#28A8A8;
		font-size: 7px;
		color:white;
		font-weight: bold;
		padding-left: 5px;
	}
	#calendar td{
		height: 115px;
	}
	.pen{width: 20px; height: 20px;}
	.d{font-size: 15px; font-family: bold;}
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
	if(paramYear!=null){// 사용자가 요청을 했다는 의미
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
	
	//달력에 보여줄 일일별 일정제목 리스트
	List<CalDto> clist=(List<CalDto>)request.getAttribute("clist");
%>
<div id="container">
<h1>일정관리[달력보기]</h1>
<table class="table" id="calendar">
	<caption style="text-align: center; font-size: 30px;">
		<a href="calendar.do?year=<%=year-1%>&month=<%=month%>">
		<span class="glyphicon glyphicon-backward"></span></a>
		<a href="calendar.do?year=<%=year%>&month=<%=month-1%>">
		<span class="glyphicon glyphicon-chevron-left"></span></a>
		<span class="y"><%=year%></span>
		<span>년</span>
		<span class="m"><%=month%></span>
		<span>월</span>
		<a href="calendar.do?year=<%=year%>&month=<%=month+1%>">
		<span class="glyphicon glyphicon-chevron-right"></span></a>
		<a href="calendar.do?year=<%=year+1%>&month=<%=month%>">
		<span class="glyphicon glyphicon-forward"></span></a>
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
				<a href="calBoardList.do?year=<%=year%>&month=<%=month%>&date=<%=i%>" style="color:<%=Util.fontColor(dayOfWeek, i)%>;"  class="d" ><%=i%></a>
				<a href="addCalBoardForm.do?year=<%=year%>&month=<%=month%>&date=<%=i%>"><img class="pen" src="resources/img/pen.png" alt="일정추가"/></a>
				<%=Util.getCalViewList(i, clist) %>
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
<%! //선언부: 메서드
	//파라미터 선언: 
// 	public String fontColor(int dayOfWeek,int i){
// 		//토요일:(dayOfWeek-1+i)%7==0
// 		//일요일:(dayOfWeek-1+i)%7==1
// 		String str="black";//기본은 평일
// 		if((dayOfWeek-1+i)%7==0){ // 토요일
// 			str="blue";
// 		}else if((dayOfWeek-1+i)%7==1){ //일요일
// 			str="red";
// 		}
// 		return str;
// 	}
%>        
<jsp:include page="footer.jsp"/>
</body>
</html>









