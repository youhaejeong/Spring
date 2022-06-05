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
	<div><h1>게시글 등록 </h1></div>
		<div>
			<form id="frm" action="boardInsert.do" method="post">
				<div>
				<table id="table" border="1">
					<tr>
						<th width="100">작성자</th>
						<td width="150">
						 <input type="text" id="boardName" name="boardName">
						 </td>
						<th width="100">작성일자</th>
						<td width="150">
						 <input type="date" id="boardDate" name="boardDate">
						 </td>
					</tr>
					<tr>
						<th width="100">제목 </th>
						<td colspan="3"  >
						<input size="58" type="text" id="boardTitle" name="boardTitle">
						</td>
					</tr>
					<tr>
						<th width="100">내용 </th>
						<td colspan="3">
							<textarea rows="10" cols="60" id="boardContent" name="boardContent"></textarea>
						</td>
					</tr>		
				</table>				
				</div>
				<div>
				<input type="submit" value="저장">
				<input type="reset" value="작성 취소">
				<button type="button" onclick="location.href='boardList.do'">목록</button>
				</div>
			</form>
		</div>
</div>
</body>

</html>