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
<h1>파일업로드</h1>
<form action="FileController.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="command" value="upload"/>
	<table border="1">
		<tr>
			<th>파일:</th>
			<td><input type="file" name="filename" multiple="multiple" /> </td>
		</tr>
<!-- 		<tr> -->
<!-- 			<th>파일:</th> -->
<!-- 			<td> -->
<!-- 				<input type="file" name="filename1"  />  -->
<!-- 				<input type="file" name="filename2"  /> -->
<!-- 				<input type="file" name="filename3"  /> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<th>다운로드:</th> -->
<%-- 			<td><a href="upload/${param.filename}">${param.filename}</a></td> --%>
<!-- 		</tr> -->
		<tr>
			<th>다운로드:</th>
			<td><a href="FileController.do?command=downloadlist">목록보기</a></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="첨부" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>






