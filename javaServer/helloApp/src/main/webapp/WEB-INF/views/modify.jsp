<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="co.yedam.emp.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<%
EmpVO emp = (EmpVO) request.getAttribute("searchVO");
%>
<%
Map<String, String> list = (Map<String, String>) request.getAttribute("jobList");
%>
<script>
function chageJob(){
	document.getElementById("jobInput").value = document.querySelectorAll('#selectJob option')[document.getElementById("selectJob").selectedIndex].value
}
</script>


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
			<td>
				<select id="selectJob" name="jobId" onchange=chageJob()>
	       		<%
				for (Entry<String, String> ent : list.entrySet()) {
					if(ent.getKey().equals(emp.getJobId())){%>
						<option value="<%=ent.getKey()%>" selected><%=ent.getKey()%></option>
					<%}
				%>
				<option value="<%=ent.getKey()%>"><%=ent.getKey()%></option>
				<%
				}
				%>
      			</select></td>
		</tr>

		<tr>
			<th>HireDate</th>
			<td><input type="text" name="hireDate" readonly
				value="<%=emp.getHireDate().substring(0,10)%>"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-primary">수정완료</button>
			</td>
		</tr>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>