<%@page import="co.yedam.emp.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<%
EmpVO emp = (EmpVO) request.getAttribute("searchVO");
%>
<form action="empModify.do" method="post">
	<table class="table">
		<tr>
			<th>사원번호</th>
			<td><input type="number" name="employeeId" readonly
				value="<%=emp.getEmployeeId()%>"></td>
		</tr>
		<tr>
			<th>FirstName</th>
			<td><input type="text" name="firstName"
				value="<%=emp.getFirstName()%>"></td>
		</tr>
		<tr>
			<th>LastName</th>
			<td><input type="text" name="lastName"
				value="<%=emp.getLastName()%>"></td>
		</tr>
		<tr>
			<th>email</th>
			<td><input type="text" name="email" value="<%=emp.getEmail()%>"></td>
		</tr>
		<tr>
			<th>JobId</th>
			<td><input type="text" name="jobId" value="<%=emp.getJobId()%>"></td>
			<td><select name="job" class="form-select" aria-label="Default select example">
        <option value="IT_PROG">개발자</option>
        <option value="SA_REP" selected>영업사원</option>
        <option value="SA_MAN">영업팀장</option>
      </select></td>
		</tr>

		<tr>
			<th>HireDate</th>
			<td><input type="text" name="hireDate" readonly
				value="<%=emp.getHireDate()%>"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-primary">수정완료</button>
				<button class="btn btn-warning">취소</button>
			</td>
		</tr>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>