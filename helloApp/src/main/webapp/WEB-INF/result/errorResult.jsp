<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result/ErrorResult</title>
</head>
<body>
	<h3>처리중 에러 발생</h3>
	<p>html안에 자바코드 제커. jstl 연습</p>
	
	<c:set var="myname" value="홍길동"></c:set>
	<c:out value="${myname }"></c:out>
	<p>EL : ${myname }</p>
	
	<c:set var="score" value="5"></c:set>
	<c:if test="${score > 60 }">
		<p>합격</p>
	</c:if>
	
	<c:if test="${score < 60 }">
		<p>불합격</p>
	</c:if>
	
	<c:choose>
		<c:when test="${score > 90 }"><p>A</p></c:when>
		<c:when test="${score > 80 }"><p>B</p></c:when>
		<c:when test="${score > 70 }"><p>C</p></c:when>
		<c:otherwise><p>D</p></c:otherwise>
	</c:choose>
	
	<c:forEach begin="1" end="10" var="num">
		<p class='<c:out value="${num }"/>'>${num }</p>
	</c:forEach>
	
	<p>3단 출력하기</p>
	<c:set var="dan" value="3"></c:set>
	<c:forEach begin="1" end="9" var="num">
		<p>${dan} x ${num } = ${dan*num }</p>
	</c:forEach>
	
	<c:forEach items="${empList }" var="emp">
		<p>사번: ${emp.employeeId} 이름: ${emp.firstName }, 이메일: ${emp.email }, 직무: ${emp.jobId }</p>
	</c:forEach>
	
	<h3>Expression Language (EL)</h3>
	<p>${3>5 }</p>
	<p>${'test' }</p>
	<p>${5-4 }</p>
	<p>${5*4 }</p>
	<p>${id }</p>
	<p>${id } EL안에서 ${id } => getAttribute()</p>
	<p>${id eq null }
	<p>${empty id }</p>
	<p>${obj }</p>
	<p>ID : ${obj.memberId }</p>
	<p>NAME : ${obj.memberName }</p>
	<p>List: ${empList }</p>
	
	
	
</body>
</html>