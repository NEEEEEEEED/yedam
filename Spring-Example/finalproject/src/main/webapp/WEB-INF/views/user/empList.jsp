<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<style>
table, tr, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<div>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<div>
				<button type="button" onclick="location.href='empInsert'">등록</button>
			</div>
		</sec:authorize>
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
					<tr>
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
		<!-- 6) 페이징 버튼 제작 -->
		<div class='pull-right'>
			<ul class="pagination">
				<c:if test="${pageMaker.prev }">
					<li class="paginate_button previous"><a
						href="${pageMaker.startPage -1}">Prev</a></li>
				</c:if>
				<c:forEach var="num" begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }">
					<li class="paginate_button"
						${pageMaker.cri.pageNum == num ? "active":"" }><a
						href="${num }">${num }</a></li>
				</c:forEach>
				<c:if test="${pageMaker.next }">
					<li class="paginate_button next"><a
						href="${pageMaker.endPage +1}">next</a></li>
				</c:if>
			</ul>
		</div>
		<!-- 해당 페이지 클릭시 페이지번호와 가져올 데이터 개수(default 10개) -->
		<form action="${pageContext.request.contextPath }/empList"
			id='actionForm' method='get'>
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
			<input type="hidden" name="amout" value="${pageMaker.cri.amount }">
		</form>
	</div>
	<script>
	//페이징 이동
	$(document).ready(function() {
		var actionForm = $("#actionForm");
		
		$(".paginate_button a").on("click", function(e) {
			//a 태그 클릭시 이벤트 방지
			e.preventDefault();
			//페이징 버튼의 속성값을 form태그의 input값에 입력
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			//페이징 이동 form 실행
			actionForm.submit();
		})
	})
	
	//등록 결과 알림
	function printAlert(message) {
		if(message == null || message == "") return	;		
		alert(message);
		
	}
	printAlert(`${result}`);
	
	//목록 삭제
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