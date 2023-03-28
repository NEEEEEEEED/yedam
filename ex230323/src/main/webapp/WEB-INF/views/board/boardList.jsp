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
	table, tr, th, td{
		border : 1px solid black;
	}
</style>
</head>
<body>
<h1>게시판</h1>
<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${boardList }">
				<tr onclick="location.href='getBoardInfo?bno=${list.bno}'">
					<td>${list.bno }</td>
					<td>${list.title }</td>
					<td>${list.writer }</td>
					<td><fmt:formatDate value="${list.regdate }" pattern="yyyy년 MM월 dd일"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>