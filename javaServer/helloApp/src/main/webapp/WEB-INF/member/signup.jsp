<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Set a style for all buttons */
button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

/* Extra styles for the cancel button */
.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
	float: left;
	width: 50%;
}

/* Add padding to container elements */
.container {
	padding: 16px;
}

/* The Modal (background) */
.modal {
	display: block; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: #474e5d;
	padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 35px;
	top: 15px;
	font-size: 40px;
	font-weight: bold;
	color: #f1f1f1;
}

.close:hover, .close:focus {
	color: #f44336;
	cursor: pointer;
}

/* Clear floats */
.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
	.cancelbtn, .signupbtn {
		width: 100%;
	}
}
</style>
<h3>현재 페이지는 signUpForm.do의 결과 signup.jsp입니다.</h3>

<div id="id01" class="modal">
	<span onclick="document.getElementById('id01').style.display='none'"
		class="close" title="Close Modal">&times;</span>
	<!-- 파일 등록을 위해서 필요	enctype="multipart/form-data" -->
	<form class="modal-content" action="signUp.do" enctype="multipart/form-data" method="post">
		<div class="container">
			<h1>Sign Up</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>
			<label for="member_id"><b>Member ID</b></label> 
			<input type="text" placeholder="Enter id" name="member_id" required> 
			
			<label for="Member_pw"><b>Password</b></label> 
			<input type="password" placeholder="Enter Password" name="member_pw" required> 
			
			<label for="member_name"><b>이름</b></label> 
			<input type="text" placeholder="Repeat Name" name="member_name" required>
			
			<label for="member_phone"><b>연락처</b></label> 
			<input type="text" placeholder="Repeat Phone" name="member_phone" required>  
			
			<label for="image"><b>이미지</b></label> 
			<input type="file" multiple="multiple" name="image" required>  

			<div class="clearfix">
				<button type="button"
					onclick="document.getElementById('id01').style.display='none'"
					class="cancelbtn">Cancel</button>
				<button type="submit" class="signupbtn">Sign Up</button>
			</div>
		</div>
	</form>
</div>

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>
