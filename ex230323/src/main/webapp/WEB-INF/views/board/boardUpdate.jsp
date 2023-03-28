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
<div id="container">
<h1>게시글 수정</h1>
<form name="updateForm" action="boardUpdate" method="POST" onsubmit="return false">
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">번호</label>
		<div class="col-sm-10">
			<input type="text" name="bno" value="${boardInfo.bno }" readonly/>
		</div>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">제목</label>
		<div class="col-sm-10">
			<input type="text" name="title" value="${boardInfo.title }"/>
		</div>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">작성자</label>
		<div class="col-sm-10">
			<input type="text" name="writer" value="${boardInfo.writer }" readonly/>
		</div>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">내용</label>
		<div class="col-sm-10">
			<textarea  name="contents" >${boardInfo.contents }</textarea>
		</div>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">첨부이미지</label>
		<div class="col-sm-10">
			<input type="text" name="image" value="${boardInfo.image }"/>
		</div>
		</div>
		<div class="mb-3 row">
		<label class="col-sm-2 col-form-label">수정날짜</label>
		<div class="col-sm-10">
			<input type="date" name="updatedate" value=""/>
		</div>
		</div>
		<button class="btn btn-primary" type="submit">수정완료</button>
		<button class="btn btn-primary" type="button" onclick="location.href='getBoardInfo?bno=${boardInfo.bno}'">취소</button>
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
				alert("내용이 입력되지 않았습니다.");
				writer.focus();
				return;
			}
			//form의 name 속성을 사용
			updateForm.submit();
		}
		document.querySelector('button[type="submit"]')
				.addEventListener('click', formOptionchk);
	</script>
</body>
</html>