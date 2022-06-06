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
			<form id="frm" action="ajaxSelect.do" method="post">
				<select name="state" id="state">
					<option value="1">전 체</option>
					<option value="2">작성자</option>
					<option value="3">제 목</option>
					<option value="4">내 용</option>
				</select>&nbsp; <input type="text" id="key" name="key">
				<button type="button" onclick="searchList()">검 색</button>
			</form>
		</div>
		<div>
			<table id="tab" border="1">
				<thead>
				<tr>
					<th width="70">순 번</th>
					<th width="150">작성자</th>
					<th width="300">제 목 </th>
					<th width="150">작성일자</th>
					<th width="70">조회수</th>
				</tr>
				</thead>
				<tbody >
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
<script>
function eventList(data){
	let frm1=document.getElementById('frm1');
	
	frm1.boardNum.value = data;
	frm1.action="content.do";
	frm1.submit();
}


function searchList(){
	let state= ${"#state"}.val();
	let key = ${"#key"}.val();
	
	$ajax({
		url : "ajaxSelect.do",
		type : "post",
		data : {"state" : state,"key" : key},
		dataType :"json",
		success :function(data) {
			htmlConvert(data);
		},
		error : function(){
			alert("검색 실패");
		}
	});
}

	function htmlConvert(data){
		$("tbody").remove();
		let tbody = $("<tbody/>");
		$.each(data,function(index,n){
			var cols =  $("<tr onclick='eventList("+n.boardNum+")'/>").append(
							$("<td/>").text(n.boardNum),
							$("<td/>").text(n.boardName),
							$("<td/>").text(n.boardTitle),
							$("<td/>").text(n.boardContent),
							$("<td/>").text(n.boardHit)
			);
			tbody.append(cols);
			
		});
		$("#tab").append(tbody);
		
	}

</script>
</html>