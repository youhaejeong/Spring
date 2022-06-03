<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div>전체 목록 </div>
	<table border="1">
	<tr>
		<th width="70">순 번</th>
		<th width="70">작성자</th>
		<th width="100">제 목</th>
		<th width="70">작성일</th>
	</tr>
	
		<c:forEach items="${board }" var="b">
		<tr>
		<td>${b.boradNum }</td>
		<td>${b.boardName }</td>
		<td>${b.boardTitle }</td>
		<td>${b.boardDate }</td>
		</tr>
		</c:forEach>
	
	
	</table>
	<a href="home.do">홈으로</a>
	</div>
</body>
</html>