<%@page import="co.yedam.emp.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<%
	List<EmpVO> list = (List<EmpVO>) request.getAttribute("empList");
	%>
	<h3>사원목록(empControl.do의 결과 페이지).</h3>
	<table border="1" class="table">
		<thead>
			<tr>
				<th>사원번호</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>email</th>
				<th>job</th>
				<th>hireDate</th>
				
			</tr>
		</thead>
		<tbody>
			<%
			for (EmpVO emp : list) {
			%>
			<tr>
				<td><a href="empDetail.do?id=<%=emp.getEmployeeId()%>"><%=emp.getEmployeeId()%></a></td>
				<td><%=emp.getFirstName()%></td>
				<td><%=emp.getLastName()%></td>
				<td><%=emp.getEmail()%></td>
				<td><%=emp.getJobId()%></td>
				<td><%=emp.getHireDate().substring(0,10)%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

<jsp:include page="../includes/footer.jsp"></jsp:include>