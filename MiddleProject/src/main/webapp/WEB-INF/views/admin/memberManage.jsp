<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript" src="js/manage.js"></script>
<style>
table:nth-of-type(2) input {
	width: 100px;
	display: inline-block;
}

/* 버튼 스타일링 */
.search-btn {
	background-color: #4caf50;
	border: none;
	color: white;
	padding: 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin-left: 10px;
	cursor: pointer;
}

/* 입력창 스타일링 */
.search-input {
	padding: 10px;
	font-size: 16px;
	border: 2px solid #ccc;
	border-radius: 5px;
	vertical-align: middle;
}

#search-btn-group {
	margin-top : 10px;
	margin-right: 20px;
	margin-bottom: 20px;
	float : right;
}
#pageName{
	margin-top : 10px;
	float : left;
}
#line {
	clear: both;
}
</style>
	<main>
                    <div class="container-fluid px-4">
                    	<div id="pageName">
	                        <h1>회원관리페이지</h1>
                    	</div>
                    	<div>
	                        <form action="#" method="POST" id="search-btn-group">
								<label for="search-input"></label> 
								<input type="text" id="search-input" name="search-input" class="search-input" placeholder="아이디를 입력하세요">
								<button type="submit" class="search-btn"><i class="fa fa-search"></i></button>
							</form>
                    	</div>
                        <div id="line" class="card mb-4">
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                DataTable Example
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple" class="table">
                                    <thead>
										<tr>
											<th>ID</th>
											<th>Password</th>
											<th>Name</th>
											<th>Phone Number</th>
											<th>Email</th>
											<th>Authority</th>
											<th colspan="2" style="text-align: center">Action</th>
										</tr>
									</thead>
                                    <tbody id="list"></tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>

