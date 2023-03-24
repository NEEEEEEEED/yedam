<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<style>
	table, tr, th, td{
		border : 1px solid black;
	}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${empList }">
				<tr>
					<td>${emp.employeeId }</td>
					<td>${emp.firstName }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.hireDate }</td>
					<td>${emp.jobId }</td>
					<td>${emp.salary }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
	function printAlert(message) {
		alert(message);
	}
	printAlert(`${result}`);
	</script>
</body>
</html>