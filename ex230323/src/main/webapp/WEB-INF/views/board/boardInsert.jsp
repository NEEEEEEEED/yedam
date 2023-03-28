<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#container{
	margin : 0 auto;
}
form label {
	text-align : center ;
}
</style>
</head>
<body>
<h1>게시글 등록</h1>
<div id="container">
<form name="insertForm" action="boardInsert" method="POST" onsubmit="return false">
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">번호</label>
		<div class="col-sm-10">
			<input type="text" name="bno" value="${boardNo }" readonly/>
		</div>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">제목</label>
		<div class="col-sm-10">
			<input type="text" name="title"/>
		</div>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">작성자</label>
		<div class="col-sm-10">
			<input type="text" name="writer"/>
		</div>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">내용</label>
		<div class="col-sm-10">
			<textarea type="text" name="contents" rows="5" cols="20"></textarea>
		</div>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">첨부이미지</label>
		<div class="col-sm-10">
			<input type="text" name="image"/>
		</div>
		</div>
		<button class="btn btn-primary" type="submit">등록</button>
		<button class="btn btn-primary" type="button" onclick="location.href='getBoardList'">목록</button>
	</form>
</div>
	<script>
		function formOptionchk(){
			let title = document.getElementsByName('title')[0];
			let writer = document.getElementsByName('writer')[0];
			let contents = document.getElementsByName('contents')[0];
			
			if(title.value == "") {
				alert("제목이 입력되지 않았습니다.");
				title.focus();
				return;
			}
			if(writer.value == "") {
				alert("작성자가 입력되지 않았습니다.");
				writer.focus();
				return;
			}
			if(writer.value == "") {
				alert("내용이 입력되지 않았습니다.");
				writer.focus();
				return;
			}
			//form의 name 속성을 사용
			insertForm.submit();
		}
		document.querySelector('button[type="submit"]')
				.addEventListener('click', formOptionchk);
	</script>
</body>
</html>