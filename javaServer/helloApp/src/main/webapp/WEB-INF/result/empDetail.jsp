<%@page import="co.yedam.emp.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<%
EmpVO emp = (EmpVO) request.getAttribute("searchVO");
%>

<%
String id = (String) session.getAttribute("id");
%>
<h3>현재 페이지는 empDetail.do의 결과 empDetail.jsp입니다.</h3>
<table class="table">

	<tr>
		<th>사원번호</th>
		<td><%=emp.getEmployeeId()%></td>
	</tr>
	<tr>
		<th>FirstName</th>
		<td><%=emp.getFirstName()%></td>
	</tr>
	<tr>
		<th>LastName</th>
		<td><%=emp.getLastName()%></td>
	</tr>
	<tr>
		<th>email</th>
		<td><%=emp.getEmail()%></td>
	</tr>
	<tr>
		<th>JobId</th>
		<td><%=emp.getJobId()%></td>
	</tr>
	<tr>
		<th>HireDate</th>
		<td><%=emp.getHireDate().substring(0, 10)%></td>
	</tr>
	<%
	if (id != null) {
	%>
	<tr>
		<td colspan="2" align="center">
			<button class="btn btn-primary"
				onclick="location.href='empModForm.do?id=<%=emp.getEmployeeId()%>'">수정</button>
			<button class="btn btn-warning"
				onclick="location.href='empRemove.do?id=<%=emp.getEmployeeId()%>'">삭제</button>
		</td>
	</tr>
	<%
	} else {
	%>
	<tr>
		<td colspan="2" align="center">
			<button class="btn btn-primary" onclick="">뒤로</button>
		</td>
	</tr>
	<%
	}
	%>


</table>
<jsp:include page="../includes/footer.jsp"></jsp:include>