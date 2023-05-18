<template>
<div>

 
  <!-- 댓글 영역 -->
  <form id="replyForm">
    <input id="qaNotiwrNo" v-model="qaNotiwrNo" name="qaNotiwrNo" type="hidden"/>
    <div class="input-group mb-4">
      <textarea id="rplyCntn" v-model="rplyCntn" name="rplyCntn" class="form-control radius" style="resize: none; height: 50px;" placeholder="댓글을 작성해주세요" ></textarea>
      <button id="replyBtn" @click="replyAdd()" class="btn btn-dark radius" type="button">댓글등록</button>
    </div>
  </form>

    <hr style="color:#ddd;">

    <!-- 반복 -->
    <div v-for="(reply, index) in qnaReplyList" :key="reply.rplyNo" class="mb-2 p-3">
      <div class="mb-2" style="display:flex">
        <div>
          <img src="self/profile.JPG" class="circleImg" alt="이미지안보임" >
          <span>{{reply.id}}</span>
        </div>
        <div style="margin-left:auto;">
          <div class="d-flex">
            <div class="ms-1" v-if="!reply.modFormVisible">
                <button v-if="userId === reply.id" type="button" @click="replyMod(index, reply.rplyNo)" class="btn btn-secondary radius btn-sm">수정</button>
            </div>
            <div class="mx-3" v-if="!reply.modFormVisible">
                <button v-if="userId === reply.id" type="button" class="btn btn-danger radius btn-sm" >삭제</button>
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
      <form v-if="reply.modFormVisible" id="replyModForm" class="m-3">
        <div>
          <input type="text" class="border-bottom"  style="width:50%; border : none;" name="rplyCntn" v-model="reply.rplyCntn">
          <button type="button" class="btn btn-danger radius btn-sm">수정</button>
          <button type="button" class="btn btn-dark radius btn-sm">취소</button>
        </div>
      </form>
      <p v-if="!reply.modFormVisible">{{reply.rplyCntn}}</p>
      <span class="fw-bold" style="color:blue; cursor:pointer" @click="commentsList(index)">답글 N</span>
      
      
      <!-- 답글버튼 눌렀을때 보이는 영역 -->
      <div v-if="reply.isVisible" class="mt-2 p-4" style="background-color:#f9f9f9">
        <div class="mb-2" style="display:flex">
          <div>
            <img src="self/profile.JPG" class="circleImg" alt="이미지안보임" >
            <span>아이디</span>
          </div>
          <div style="margin-left:auto;">
            <div class="d-flex">
              <div>
                  <p>2023/05/13</p>
                </div>
              <div class="cursor ms-3">
                  <i class="fa-solid fa-land-mine-on"></i>
                  <span class="fs--1">신고하기</span>
                </div>
              </div>
          </div>
        </div>
        <p>대댓글 아직 안됐음 가짜임2</p>
        
        <hr class="mb-4" style="color:#ddd;">
        
        
        <div class="mb-2" style="display:flex">
          <div>
            <img src="self/profile.JPG" class="circleImg" alt="이미지안보임" >
            <span>아이디</span>
          </div>
          <div style="margin-left:auto;">
            <div class="d-flex">
              <div>
                  <p>2023/05/13</p>
                </div>
              <div class="cursor ms-3">
                  <i class="fa-solid fa-land-mine-on"></i>
                  <span class="fs--1">신고하기</span>
                </div>
              </div>
          </div>
        </div>
        <p>대댓글 아직 안됐음 가짜임3</p>
        
        <hr class="mb-4" style="color:#ddd;">
        
        <div class="input-group my-2">
          <input class="form-control radius" style="height:50px;" placeholder="답글을 작성해주세요" >
            <button class="btn btn-dark radius btn-sm" type="button" id="button-addon2">답글등록</button>
          </div>
      </div><!-- 답글버튼 눌렀을때 보이는 영역 -->
    
    <hr style="color:#ddd;">

    </div>
</div>
</template>

<script>
  module.exports = {
    data() {
      return {
        qnaReplyList : [],
        qaNotiwrNo : '',
        isVisible : false,
        rplyCntn: '',
        userId : '',
        modFormVisible : false,
      };
    },
    mounted(){
      
      this.getQaNotiwrNo();  // 댓글 리스트
      this.getLoginUserId(); // 로그인한 userid
    },
    methods: {

      getQaNotiwrNo() {
        // 현재 페이지의 URL에서 쿼리스트링 값 가져옴
        const queryString = window.location.search;

        // 쿼리스트링 값을 파싱하여 객체로 변환
        const params = new URLSearchParams(queryString);
        const value = params.get('qaNotiwrNo');
        this.qaNotiwrNo = value;
        console.log(this.qaNotiwrNo); // 쿼리스트링의 값 출력
        this.ReplyList(this.qaNotiwrNo);

      },
      // 댓글 리스트 출력 
      ReplyList (qaNotiwrNo){
        axios.post('/qnaReplyList', {qaNotiwrNo : qaNotiwrNo})
          .then(res => {
            
            this.qnaReplyList = res.data;
            console.log(this.qnaReplyList);

            for(let i = 0; i <this.qnaReplyList.length; i++){
              this.qnaReplyList[i].isVisible = false;
              this.qnaReplyList[i].modFormVisible = false;
            }

          }).catch(function(error){
              console.log(error)
          })
        },

      commentsList(index){
        this.qnaReplyList[index].isVisible = !this.qnaReplyList[index].isVisible;
      },

      // 댓글 등록
      replyAdd(){

        let formData = new FormData($('#replyForm')[0]); // 폼데이터

        axios.post('/qnaReplyAdd', formData , {
            headers: {
              'Content-Type': 'multipart/form-data'
            }
        })
        .then(res => {

          if(res.data.result === 'Success'){
            //console.log('댓글등록 성공');
            this.rplyCntn = ''; // 초기화
            this.ReplyList(this.qaNotiwrNo); // 추가된 댓글리스트 출력

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
      // 로그인한 유저 ID
      getLoginUserId(){
        axios.get('/userId')
          .then(response => {

            this.userId = response.data;

            // 사용자 ID 사용
            // 예: this.userId = userId;
            //console.log(response.data);
            //console.log('유저아이디', this.userId);
          })
          .catch(error => {
            console.error(error);
          });
      },
      // 수정 버튼 클릭시
      replyMod(index, rplyNo){

        this.qnaReplyList[index].modFormVisible = !this.qnaReplyList[index].modFormVisible;
     /*   axios.post('/qnaReplyList', {rplyNo : rplyNo})
          .then(res => {
            
            this.qnaReplyList = res.data;
            console.log(this.qnaReplyList);

            for(let i = 0; i <this.qnaReplyList.length; i++){
              this.qnaReplyList[i].isVisible = false;
            }

          }).catch(function(error){
              console.log(error)
          }) */
      }
    }
  }
</script>