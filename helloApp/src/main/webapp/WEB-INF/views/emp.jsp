<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
    <form name="myFrm" action="employee.do" method="post">
    <div>
      <label for="exampleFormControlInput1" class="form-label">사원번호:</label>
      <input type="number" name="eid" class="form-control" id="exampleFormControlInput1" />
    </div>
    <div>
      <label for="exampleFormControlInput1" class="form-label">LastName:</label>
      <input type="text" name="last_name" class="form-control" id="exampleFormControlInput1" />
    </div>
    <div>
      <label for="exampleFormControlInput1" class="form-label">이메일:</label>
      <input type="email" name="email" class="form-control" id="exampleFormControlInput1" />
    </div>  
    <div>
      <label for="exampleFormControlInput1" class="form-label">입사일:</label>
      <input type="date" name="hire_date"  class="form-control" id="exampleFormControlInput1"/>
    </div>
    <div>    
      <label for="exampleFormControlInput1" class="form-label">직무:</label>
      <select name="job" class="form-select" aria-label="Default select example">
        <option value="IT_PROG">개발자</option>
        <option value="SA_REP" selected>영업사원</option>
        <option value="SA_MAN">영업팀장</option>
      </select>
    </div>
    <div>
      <input type="submit" value="전송" />
      <input type="button" value="조회" onclick="empGetFnc()" />
      <input type="button" value="이세계버튼" onclick="daumGetFnc()" />
    </div>
      <a href="../result/empList.jsp">조회</a>
      
    </form>
    
    <script>
    	function empGetFnc(){
    		document.forms.myFrm.method = 'get';
    		document.forms.myFrm.action = 'empList.do';
    		document.forms.myFrm.submit();
    	}
    	function daumGetFnc(){
    		document.forms.myFrm.method = 'update';
    		document.forms.myFrm.submit();
    	}
    </script>
<jsp:include page="../includes/footer.jsp"></jsp:include>
