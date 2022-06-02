<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeModifyFrom</title>
</head>
<body>
<div align="center">
	<div><h1>게시글 수정</h1></div>
	<div>
		<form id="frm" action="noticeModify.do" method="post" enctype="multipart/form-data">
		<div>
		<table id="tb" border="1">
				<tr>
					<th width="100">작성자</th>
					<td width="150">
					<input type="hidden" id="noticeId" name="noticeId" value="${notice.noticeId}">
					 ${notice.noticeName}
					 </td>
					<th width="100">작성일자</th>
					<td width="150">
					 ${notice.noticeDate }
					 </td>
				</tr>
				<tr>
					<th width="100">제목 </th>
					<td colspan="3"  >
					<input size="58" type="text" id="noticeTitle" name="noticeTitle" value="${notice.noticeTitle }">
					</td>
				</tr>
				<tr>
					<th width="100">내용 </th>
					<td colspan="3">
						<textarea rows="10" cols="60" id="noticeContents" name="noticeContents">${notice.noticeContents }</textarea>
					</td>
				</tr>
				<tr>
					<th width="100">첨부파일</th>
					<td colspan="3">
						<input type="file" id="file" name="file" multiple="multiple">
					</td></tr>
		</table>
		</div>
		<div>
		<input type="submit" value="수정">&nbsp;&nbsp;
		<input type="button" value="목록" onclick="location.href='noticeList.do'">
		</div>
		</form>
	</div>
</div>
</body>
</html>