<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath }/login">
	<div>
		<input type='text' name='username' value='admin'/>
	</div>
	<div>
		<input type='password' name='password' value='admin'/>
	</div>
	<div>
		<input type='submit' />
	</div>
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}" />
	</form>
</body>
</html>

