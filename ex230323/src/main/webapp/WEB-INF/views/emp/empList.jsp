<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
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
	<button type="button" onclick="location.href='empInsert'">등록</button>
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
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${empList }">
				<tr onclick="location.href='empInfo?employeeId=${emp.employeeId}'">
					<td>${emp.employeeId }</td>
					<td>${emp.firstName }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.hireDate }</td>
					<td>${emp.jobId }</td>
					<td>${emp.salary }</td>
					<td><button type="button" 
						onclick="deleteInfo(${emp.employeeId}, event)">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
	function printAlert(message) {
		if(message == null || message == "") return	;		
		alert(message);
		
	}
	printAlert(`${result}`);
	
	function deleteInfo(id,event) {
		$.ajax({
			url : 'empDelete',
			method : 'post',
			data : { employeeId : id},
			// dataType : 'json', (생략) // html, text, json, xml
			success : function(data) {
				/* if(data != null && data['결과'] =='Success') {
					alert('사원번호 : ' + data['사원번호'] + '의 정보가 삭제되었습니다.');
				} else {
					alert('해당 사원의 정보가 정상적으로 삭제되지 않았습니다.');
				} */
				console.log(data);
			},
			error : function(reject) {
				console.log(reject);
			}
		});
		//버블링 방지
		event.stopPropagation();
	}
	</script>
</body>
</html>