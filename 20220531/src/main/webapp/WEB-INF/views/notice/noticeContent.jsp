<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeContent</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>공지사항</h1>
		</div>
		<div>
			<table id="tb" border="1">
				<tr>
					<th width="70">작 성 자</th>
					<td width="870">${content.noticeId }</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td>${content.noticeTitle }</td>
				</tr>
				<tr>
					<th>작 성 일</th>
					<td>${content.noticeDate }</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${content.noticeHit }</td>
				<tr>
					<th height="400">작 성 글</th>
					<td>${content.noticeContents }</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						 <c:choose>
							<c:when test="${not empty content.noticeAttech }">
								<a href="downLoad.do?saveName=${content.noticeDir}&fileName=${content.noticeAttech }">
									${content.noticeAttech }</a>
							</c:when>
							<c:otherwise>
								<p>등록된 첨부파일이 없습니다.</p>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				</tbody>

			</table>
			<div>
				<button type="button" onclick="location.href='noticeModifyFrom.do?noticeId=${content.noticeId}'">글
					수정</button>
				<button type="button" onclick="delbtn()">글 삭제</button>
				<button type="button" onclick="location.href='noticeList.do'">글
					목록</button>
			</div>
		</div>
	</div>
</body>
<script>

		function delbtn(){
		if(confirm("삭제하시겠습니까?") ==true){
			location.href="noticeDelete.do?noticeId="+${content.noticeId};
		}else{
			false;
		}
		
		}
</script>
</html>