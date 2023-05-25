<template>
	<div>
	
		<!-- 댓글 영역 -->
		<form id="replyForm">
			<input id="prjtNo" v-model="prjtNo" name="prjtNo" type="hidden"/>
			<input v-model="userId" name="id" type="hidden"/>
			<div class="input-group mb-4">
				<textarea id="rplyCntn" v-model="rplyCntn" name="rplyCntn" class="form-control radius" style="resize: none; height: 50px;" placeholder="댓글을 작성해주세요" ></textarea>
				<button id="replyBtn" @click="replyAdd()"  class="btn btn-dark radius" type="button">댓글등록</button>
			</div>
		</form>
	
		<hr style="color:#ddd;">
	
		<!-- 댓글 리스트 반복 -->
		<div v-for="(reply, index) in proReplyList" :key="reply.rplyNo" class="mb-2 pt-2 px-3">
			<!-- 삭제 되지 않은 댓글일때 -->
			<div v-if="reply.rplyDelYn === 'N'">
				<div class="mb-2" style="display:flex">
					<div>
						<img :src="'/moamoreImg/' + reply.profileImg" class="circleImg" alt="이미지오류" @error="imgError">
						<span class="ms-1">{{reply.id}}</span>
					</div>
					<div style="margin-left:auto;">
						<div class="d-flex">
							<!-- 해당 댓글의 수정 폼이 나타났을때 사라지는 부분 -->
							<div class="ms-1" v-if="!reply.modFormVisible">
									<!-- 현재 로그인한 유저 아이디와 댓글을단 아이디가 동일하다면 나타나는 수정 버튼 -->
									<button v-if="userId === reply.id" type="button" @click="replyModForm(index)" class="btn btn-secondary radius btn-sm">수정</button>
							</div>
							<!-- 해당 댓글의 수정 폼이 나타났을때 사라지는 부분 -->
							<div class="mx-3" v-if="!reply.modFormVisible">
									<!-- 현재 로그인한 유저 아이디와 댓글을단 아이디가 동일하다면 나타나는 삭제 버튼 -->
									<button v-if="userId === reply.id" type="button" @click="replyDelete(index)" class="btn btn-danger radius btn-sm">삭제</button>
							</div>
							<div>
									<p>{{reply.regDt}}</p>
							</div>
							<div class="cursor ms-3">
									<i class="fa-solid fa-land-mine-on"></i>
									<span class="fs--1">신고하기</span>
								</div>
							</div>
					</div>
				</div>
	
				<!-- 해당 댓글의 수정버튼을 클릭했을때 나타나는 수정폼 -->
				<form v-if="reply.modFormVisible" @submit.prevent class="m-3">
						<!-- 기존 댓글의 내용부분 가져옴 -->
						<input name="rplyCntn" @keyup.enter.prevent="replyModifyFn(index)" v-model="reply.modifyRplyCntn" type="text" class="border-bottom" style="width:60%; border : none;">
						<button type="button" @click="replyModifyFn(index)" class="btn btn-secondary radius btn-sm">수정</button>
						<button type="button" @click="replyModForm(index)" class="btn btn-dark radius btn-sm">취소</button>
				</form>
	
				<!-- 해당 댓글의 내용부분 출력 = 수정버튼을 클릭하기전 출력되는 화면-->
				<p v-if="!reply.modFormVisible">{{reply.rplyCntn}}</p>
				
				<hr style="color:#ddd;">
			</div> <!-- v-if="reply.rplyDelYn==='N'" div 닫기-->
	
			<!-- 삭제된 댓글 일때 -->
			<div v-else>
					<div class="mb-2" style="display:flex">
						<div>
							<img :src="'/moamoreImg/' + reply.profileImg" class="circleImg" alt="이미지오류" @error="imgError">
							<span class="ms-1">{{reply.id}}</span>
						</div>
						<div style="margin-left:auto;">
							<div class="d-flex">
								<div>
										<p>{{reply.regDt}}</p>
								</div>
								<div class="cursor ms-3">
										<i class="fa-solid fa-land-mine-on"></i>
										<span class="fs--1">신고하기</span>
									</div>
								</div>
						</div>
					</div>

					<p style="font-style: italic;">삭제된 댓글입니다.</p>
					
					<hr style="color:#ddd;">
	
			</div><!-- 삭제된 댓글일때 div 닫기-->
		</div>
	</div>
	</template>
	
	<script>
		module.exports = {
			data() {
				return {
					proReplyList : [], // 댓글 리스트
					prjtNo : '',  // 프로젝트 게시글 번호
					rplyCntn: '',     // 댓글 내용
					userId : '',      // 로그인한 아이디
				};
			},
			mounted(){
	
				this.getPrjtNo();  // 프로젝트 게시글 번호 , 댓글리스트
				this.getLoginUserId(); // 현재 로그인한 userid
	
			},
			methods: {
	
				getPrjtNo() {
					// 현재 페이지의 URL에서 쿼리스트링 값 가져옴
					const queryString = window.location.search;
	
					// 쿼리스트링 값을 파싱하여 객체로 변환
					const params = new URLSearchParams(queryString);
					const value = params.get('prjtNo'); // 게시글 번호
					
					this.prjtNo = value;
	
					this.ReplyList(this.prjtNo); // 해당 게시글의 댓글 출력
	
				},
				// 댓글 리스트 출력 
				ReplyList (prjtNo){
					axios.post('/projectReplyList', {prjtNo : prjtNo})
						.then(res => {
							
						this.proReplyList = res.data; // 해당 게시글의 댓글 리스트
	
						/*
						for(let i = 0; i <this.qnaReplyList.length; i++){
							this.qnaReplyList[i].isVisible = false; // 해당 댓글의 댓글 부분 보이게하는 값 초기화
							this.qnaReplyList[i].modFormVisible = false; // 해당 댓글의 수정폼 부분 보이게하는 값 초기화
						}*/
						
						}).catch(function(error){
								console.log(error)
						})
				},
	
				// 댓글 등록버튼 클릭시 실행하는 함수
				replyAdd(){
	
					let formData = new FormData($('#replyForm')[0]); // 폼데이터
	
					axios.post('/projectReplyAdd', formData , {
							headers: {
								'Content-Type': 'multipart/form-data'
							}
					})
					.then(res => {
	
						if(res.data.result === 'Success'){
							//console.log('댓글등록 성공');
							this.rplyCntn = ''; // 댓글 작성 input칸 초기화
							this.ReplyList(this.prjtNo); // 댓글리스트 화면에서 재출력(insert한 댓글 나옴)
	
						}else{
							Swal.fire({
									icon: 'error',
									title: '댓글 등록실패!'
							});
						}
	
					})
					.catch(function(error){
								console.log(error)
					})    
				},

				// 이미지 오류시 실행하는 src경로 변경 함수
				imgError(event) {
        	event.target.src = 'self/profile.JPG';
      	},
	
				// 로그인한 유저 ID 받아오는 함수
				getLoginUserId(){
					axios.get('/userId')
						.then(response => {
	
							this.userId = response.data; // 현재 로그인한 유저ID
	
						})
						.catch(error => {
							console.error(error);
						});
				},
	
				// (수정,삭제 버튼에서) 수정 버튼을 클릭하였을때 해당 댓글의 수정폼 토굴 함수
				replyModForm(index){
					this.proReplyList[index].modifyRplyCntn = this.proReplyList[index].rplyCntn; // 기존 댓글 내용
					this.proReplyList[index].modFormVisible = !this.proReplyList[index].modFormVisible;
				},
	
				// 댓글 수정 기능이 일어나는 함수
				replyModifyFn(index){

					let rplyCntn = this.proReplyList[index].modifyRplyCntn; // 댓글 수정 내용 부분
					let rplyNo = this.proReplyList[index].rplyNo; // 수정할 댓글번호
		
					axios.post('/projectReplyMod', {rplyNo : rplyNo, rplyCntn : rplyCntn})
						.then(res => {

							// 수정 성공시
							if(res.data.result === 'Success'){

								this.ReplyList(this.prjtNo); // 댓글리스트 화면에서 재출력
	
							}else{
								Swal.fire({
										icon: 'error',
										title: '댓글 수정실패!'
								});
							}
						}).catch(function(error){
								console.log(error)
						})
				},
	
				// 댓글 삭제 기능이 일어나는 함수
				replyDelete(index){
					let rplyNo = this.proReplyList[index].rplyNo; // 삭제할 댓글번호
					axios.post('/projectReplyDelete', {rplyNo : rplyNo})
						.then(res => {
							
							// 삭제 성공시
							if(res.data.result === 'Success'){

								this.ReplyList(this.prjtNo); // 댓글리스트 화면에서 재출력
								
							}else{
								Swal.fire({
										icon: 'error',
										title: '댓글 삭제실패!'
								});
							}
						}).catch(function(error){
								console.log(error)
						})
				},
			}
		}
	</script>