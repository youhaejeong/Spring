<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>게시글</h1></div>
		<div>
			<table id="table" border="1">
				<tr>
					<th width="70">작성자</th>
					<td width="870">${content.boardName}</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td>${content.boardTitle }</td>
				</tr>
				<tr>
					<th>작 성 일</th>
					<td>${content.boardDate }</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${content.boardHit }</td>
				<tr>
					<th height="400">작 성 글</th>
					<td>${content.boardContent}</td>
				</tr>
			</table>
			<div>
				<button type="button" onclick="location.href='boardModifyFrom.do?boardNum=${content.boardNum}'">글
						수정</button>
					<button type="button" onclick="delbtn()">글 삭제</button>
					<button type="button" onclick="location.href='boardList.do'">글
						목록</button>
			</div>
		</div>
	
	</div>

</body>
<script>
		function delbtn(){
		if(confirm("삭제하시겠습니까?") ==true){
			location.href="boardDelete.do?boardNum="+${content.boardNum};
		}else{
			false;
		}
		
		}
</script>
</html>