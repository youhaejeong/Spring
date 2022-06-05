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
		<div><h1>게시글 목록</h1></div>
		<div>
			<table border="1">
				<thead>
				<tr>
					<th width="70">순 번</th>
					<th width="150">작성자</th>
					<th width="300">제 목 </th>
					<th width="150">작성일자</th>
					<th width="70">조회수</th>
				</tr>
				</thead>
				</tbody>
					<c:if test="${!empty board  }">
						<c:forEach items="${board }" var="bo">
							<tr onclick="eventList(${bo.boardNum})">
								<td>${bo.boardNum }</td>
								<td>${bo.boardName }</td>
								<td>${bo.boardTitle }</td>
								<td>${bo.boardDate }</td>
								<td>${bo.boardHit }</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty board }">
						<tr>
							<td colspan="6" align="center">게시글이 존재하지 않습니다</td>
						</tr>
					</c:if>
				</tbody>
			</table>
			<form id="frm1" action="" method="post">
				<input type="hidden" id="boardNum" name="boardNum">
			</form>
		</div>
		<br>
		<div>
			<button type="button" onclick="location.href='boardInsertForm.do'">글 작성</button>
		</div>
</div>

</body>
<script type="text/javascript">
function eventList(data){
	let frm1=document.getElementById('frm1');
	
	frm1.boardNum.value = data;
	frm1.action="content.do";
	frm1.submit();
}

</script>
</html>