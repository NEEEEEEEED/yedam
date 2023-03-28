<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#container{
	margin : 0 auto;
}
form label {
	text-align : center ;
}
</style>
</head>
<body>
<div id="container">
<h1>게시글 내용</h1>
<form name="updateForm" action="boardUpdate" method="POST" onsubmit="return false">
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">번호</label>
		<div class="col-sm-10">
			${boardInfo.bno }
		</div>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">제목</label>
		<div class="col-sm-10">
			${boardInfo.title }
		</div>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">작성자</label>
		<div class="col-sm-10">
			${boardInfo.writer }
		</div>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">내용</label>
		<div class="col-sm-10">
			<textarea >${boardInfo.contents }</textarea>
		</div>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">첨부이미지</label>
		<c:choose>
			<c:when test="${not empty boardInfo.image }">
				<div class="col-sm-10">
				<!-- contextpath(uri/spring/)를 자동으로 지정하기 위해서 c태그 사용 -->
					<img name="image" src="<c:url value="/resources/images/${boardInfo.image }"/>" />
				</div>
			</c:when>
			<c:otherwise>
				<div class="col-sm-10"></div>
			</c:otherwise>
		</c:choose>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">작성일자</label>
		<div class="col-sm-10">
			<fmt:formatDate value="${boardInfo.regdate }" pattern="yyyy/MM/dd"/>
		</div>
		</div>
		<button class="btn btn-primary" type="submit" onclick="location.href='boardUpdate?bno=${boardInfo.bno}'">수정</button>
		<button class="btn btn-primary" type="button" onclick="location.href='boardDelete?bno=${boardInfo.bno}'">삭제</button>
		<button class="btn btn-primary" type="button" onclick="location.href='getBoardList'">취소</button>
	</form>
</div>
</body>
</html>