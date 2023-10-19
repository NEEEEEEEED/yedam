<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>현재 페이지는 empForm.do의 결과 emp.jsp입니다.</h3>
<%
Map<String, String> list = (Map<String, String>) request.getAttribute("jobList");
%>

<form name="myFrm" action="employee.do" method="post">
	<div>
		<label for="exampleFormControlInput1" class="form-label">사원번호:</label>
		<input type="number" name="eid" class="form-control"
			id="exampleFormControlInput1" />
	</div>
	<div>
		<label for="exampleFormControlInput1" class="form-label">LastName:</label>
		<input type="text" name="last_name" class="form-control"
			id="exampleFormControlInput1" />
	</div>
	<div>
		<label for="exampleFormControlInput1" class="form-label">이메일:</label>
		<input type="email" name="email" class="form-control"
			id="exampleFormControlInput1" />
	</div>
	<div>
		<label for="exampleFormControlInput1" class="form-label">입사일:</label>
		<input type="date" name="hire_date" class="form-control"
			id="exampleFormControlInput1" />
	</div>
	<div>
		<label for="exampleFormControlInput1" class="form-label">직무:</label> <select
			name="job" class="form-select" aria-label="Default select example">
			<%
			for (Entry<String, String> ent : list.entrySet()) {
			%>
			<option value="<%=ent.getKey()%>"><%=ent.getValue()%></option>
			<%
			}
			%>
		</select>
	</div>
	<div class="container text-center">
		<button class="btn btn-primary" type="submit">전송</button>
		<button class="btn btn-primary" type="button" onclick="empGetFnc()">
			조회</button>
		<button class="btn btn-primary" type="button" onclick="daumGetFnc()">이세계버튼</button>
	</div>
	<a href="../result/empList.jsp">조회</a>

</form>

<script>
	function empGetFnc() {
		document.forms.myFrm.method = 'get';
		document.forms.myFrm.action = 'empList.do';
		document.forms.myFrm.submit();
	}
	function daumGetFnc() {
		document.forms.myFrm.method = 'update';
		document.forms.myFrm.submit();
	}
</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>
