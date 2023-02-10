<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js">
</script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>현재 페이지는 myPageForm.do의 결과 mypage.jsp입니다.</h3>
<form action="modifyMember.do" method="post">
<input type="file" id="fileUpLoad" accept="image/*" style="display: none" onchange="imageChangeFnc()">
<table class="table">
	<tr>
		<th>아이디</th>
		<td><input type="text" name="mid" value="${vo.memberId }" readonly></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="mname" value="${vo.memberName }" ></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="text" name="mpw" value="${vo.memberPw }" ></td>
	</tr>
	<tr>
		<th>연락처</th>
		<td><input type="text" name="mphone" value="${vo.memberPhone }" ></td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input type="text" name="maddr" value="${vo.memberAddr }" ></td>
	</tr>
	<tr>
		<th>image</th>
		<td><img id="imgSrc" src="upload/${vo.image }" width="300px"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="수정">
		</td>
	</tr>
</table>

</form>

<script>
// event등록 : js -> addEventListener('',function(){})
// 			  jquery -> elem.on('',function(){})
	$('#imgSrc').on('click',function(){
		$('#fileUpLoad').click();
	})
	
	function imageChangeFnc() {
		console.log($('#fileUpLoad')[0].files[0]);
		let file = $('#fileUpLoad')[0].files[0];
		
		let formData = new FormData(); // multipart 처리
		formData.append('id','${vo.memberId }'); // id, file 업로드 : db변경
		formData.append('image',file);
		
		//서버에 multipart/form-data : ajax 요청.
		$.ajax({
			url : 'imageUpload.do',
			method : 'post',
			data:formData,
			contentType: false, // multipart 요청일 경우 옵션
			processData:false,	// multipart 요청일 경우 옵션
			success : function(result) {
				let reader = new FileReader();
				reader.onload = function (ev) {
					$('#imgSrc').attr('src',ev.target.result);
				}
				reader.readAsDataURL(file);
			},
			error : function(err) {
				console.log(err);
			}		

		});
		
	}	



















</script>
