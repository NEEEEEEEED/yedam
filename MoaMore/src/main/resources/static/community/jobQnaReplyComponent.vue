<template>
<div>

  <!-- 댓글 영역 -->
  <form id="replyForm">
    <input id="qaNotiwrNo" v-model="qaNotiwrNo" name="qaNotiwrNo" type="hidden"/>
    <input v-model="userId" name="id" type="hidden"/>
    <div class="input-group mb-4">
      <textarea id="rplyCntn" v-model="rplyCntn" name="rplyCntn" class="form-control radius" style="resize: none; height: 50px;" placeholder="댓글을 작성해주세요" ></textarea>
      <button id="replyBtn" @click="replyAdd()"  class="btn btn-dark radius" type="button">댓글등록</button>
    </div>
  </form>

    <hr style="color:#ddd;">

    <!-- 댓글 리스트 반복 -->
    <div v-for="(reply, index) in qnaReplyList" :key="reply.rplyNo" class="mb-2 p-3">
      <!-- 삭제 되지 않은 댓글일때 -->
      <div v-if="reply.rplyDelYn === 'N'">
        <div class="mb-2" style="display:flex">
          <div>
            <img src="self/profile.JPG" class="circleImg" alt="이미지안보임" >
            <span>{{reply.id}}</span>
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
        <span class="fw-bold" style="color:blue; cursor:pointer" @click="commentsList(index)">댓글 {{reply.childCount}}</span>
        
        
        <!-- 답글버튼 눌렀을때 보이는 영역 -->
        <div v-if="reply.isVisible" class="mt-2 p-4" style="background-color:#f9f9f9">
          <!-- 대댓글 리스트 반복 -->
          <div v-for="(chreply, chIndex) in reply.chreplyList" :key="chreply.rplyNo">
            <!-- 삭제 되지 않은 대댓글일때 -->
            <div v-if="chreply.rplyDelYn === 'N'">
              <div class="mb-2" style="display:flex">
                <div>
                  <img src="self/profile.JPG" class="circleImg" alt="이미지안보임" >
                  <span>{{chreply.id}}</span>
                </div>
                <div style="margin-left:auto;">
                  <div class="d-flex">

                    <!-- 해당 대댓글의 수정 폼이 나타났을때 사라지는 부분 -->
                    <div class="ms-1" v-if="!chreply.chModFormVisible">
                        <!-- 현재 로그인한 유저 아이디와 댓글을단 아이디가 동일하다면 나타나는 수정 버튼 -->
                        <button v-if="userId === chreply.id" type="button" @click="chReplyModForm(index, chIndex)" class="btn btn-secondary radius btn-sm">수정</button>
                    </div>
                    <!-- 해당 댓글의 수정 폼이 나타났을때 사라지는 부분 -->
                    <div class="mx-3" v-if="!chreply.chModFormVisible">
                        <!-- 현재 로그인한 유저 아이디와 댓글을단 아이디가 동일하다면 나타나는 삭제 버튼 -->
                        <button v-if="userId === chreply.id" type="button" @click="chReplyDelete(index, chIndex)" class="btn btn-danger radius btn-sm">삭제</button>
                    </div>

                    <div>
                        <p>{{chreply.regDt}}</p>
                    </div>
                    <div class="cursor ms-3">
                        <i class="fa-solid fa-land-mine-on"></i>
                        <span class="fs--1">신고하기</span>
                      </div>
                  </div>
                </div>
              </div>

              <!-- 해당 대댓글의 수정버튼을 클릭했을때 나타나는 수정폼 -->
              <form v-if="chreply.chModFormVisible" @submit.prevent class="m-3">
                  <!-- 기존 대댓글의 내용부분 가져옴 -->
                  <input name="rplyCntn" v-model="chreply.modifyRplyCntn" @keyup.enter.prevent="chReplyModifyFn(index, chIndex)" type="text" class="border-bottom" style="width:60%; border : none; background-color:#f9f9f9">
                  <button type="button" @click="chReplyModifyFn(index, chIndex)" class="btn btn-secondary radius btn-sm">수정</button>
                  <button type="button" @click="chReplyModForm(index, chIndex)" class="btn btn-dark radius btn-sm">취소</button>
              </form>
              <!-- 해당 대댓글의 내용부분 출력 = 수정버튼을 클릭하기전 출력되는 화면-->
              <p v-if="!chreply.chModFormVisible">{{chreply.rplyCntn}}</p>
              
              <hr class="mb-4" style="color:#ddd;">
          </div> <!-- 삭제되지 않은 대댓글 닫는 태그 -->

          <!-- 삭제된 대댓글일때 -->
          <div v-else>
            <div class="mb-2" style="display:flex">
              <div>
                <img src="self/profile.JPG" class="circleImg" alt="이미지안보임" >
                <span>{{chreply.id}}</span>
              </div>
              <div style="margin-left:auto;">
                <div class="d-flex">
                  <div>
                      <p>{{chreply.regDt}}</p>
                  </div>
                  <div class="cursor ms-3">
                      <i class="fa-solid fa-land-mine-on"></i>
                      <span class="fs--1">신고하기</span>
                    </div>
                </div>
              </div>
            </div>
            <p style="font-style: italic;">삭제된 댓글입니다.</p>
            <hr class="mb-4" style="color:#ddd;">
        </div> <!-- 삭제된 대댓글 닫는 태그 -->

        </div> <!-- 대댓글 반복부분 닫는 태그 -->
        
        <!-- 대댓글 등록 폼 부분 -->
        <form :id="reply.rplyNo" @submit.prevent>
          <input v-model="qaNotiwrNo" name="qaNotiwrNo" type="hidden"/> <!-- 게시글 번호 -->
          <input v-model="userId" name="id" type="hidden"/> <!-- 로그인한 유저 아이디 -->
          <input v-model="reply.rplyNo" name="rplyGroup" type="hidden"/> <!-- 그룹 번호 = 부모 댓글 번호 -->
          <div class="input-group my-2">
            <input class="form-control radius" v-model="reply.chRplyCntn" @keyup.enter.prevent="chReplyAdd(index)" name="rplyCntn" style="height:50px;" placeholder="댓글을 작성해주세요" >
            <button class="btn btn-dark radius btn-sm" @click="chReplyAdd(index)" type="button" id="button-addon2">댓글등록</button>
          </div>
        </form>
      </div><!-- 답글버튼 눌렀을때 보이는 영역 닫기-->
      
      <hr style="color:#ddd;">
    </div> <!-- v-if="reply.rplyDelYn==='N'" div 닫기-->

    <!-- 삭제된 댓글 일때 -->
    <div v-else>
        <div class="mb-2" style="display:flex">
          <div>
            <img src="self/profile.JPG" class="circleImg" alt="이미지안보임" >
            <span>{{reply.id}}</span>
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
        <span class="fw-bold" style="color:blue; cursor:pointer" @click="commentsList(index)">댓글 {{reply.childCount}}</span>
        
        <!-- 답글버튼 눌렀을때 보이는 영역 -->
        <div v-if="reply.isVisible" class="mt-2 p-4" style="background-color:#f9f9f9">
          <div v-for="(chreply, chIndex) in reply.chreplyList" :key="chreply.rplyNo">
            <div class="mb-2" style="display:flex">
              <div>
                <img src="self/profile.JPG" class="circleImg" alt="이미지안보임" >
                <span>{{chreply.id}}</span>
              </div>
              <div style="margin-left:auto;">
                <div class="d-flex">
                  <div>
                      <p>{{chreply.regDt}}</p>
                    </div>
                  <div class="cursor ms-3">
                      <i class="fa-solid fa-land-mine-on"></i>
                      <span class="fs--1">신고하기</span>
                    </div>
                  </div>
              </div>
            </div>
            <p>{{chreply.rplyCntn}}</p>
            
            <hr class="mb-4" style="color:#ddd;">
          </div>

          <div class="input-group my-2">
            <input class="form-control radius" style="height:50px;" readonly placeholder="원댓글이 삭제되어 더이상 댓글을 작성 하실 수 없습니다." >
          </div>
        </div><!-- 답글버튼 눌렀을때 보이는 영역 -->
    
      <hr style="color:#ddd;">

    </div><!-- 삭제된 댓글일때 div 닫기-->
  </div>
</div>
</template>

<script>
  module.exports = {
    data() {
      return {
        qnaReplyList : [], // 취업 Q&A 댓글 리스트
        qaNotiwrNo : '',  // 취업 Q&A 게시글 번호
        rplyCntn: '',     // 댓글 내용
        userId : '',      // 로그인한 아이디
        openIndex : -1    // 특정 대댓글창 열어 놓는값
      };
    },
    mounted(){

      this.getQaNotiwrNo();  // 취업 Q&A 게시글 번호 , 댓글 리스트
      this.getLoginUserId(); // 현재 로그인한 userid

    },
    methods: {

      getQaNotiwrNo() {
        // 현재 페이지의 URL에서 쿼리스트링 값 가져옴
        const queryString = window.location.search;

        // 쿼리스트링 값을 파싱하여 객체로 변환
        const params = new URLSearchParams(queryString);
        const value = params.get('qaNotiwrNo'); // 게시글 번호
        
        this.qaNotiwrNo = value;

        this.ReplyList(this.qaNotiwrNo); // 해당 게시글의 댓글 출력

      },
      // 댓글 리스트 출력 
      ReplyList (qaNotiwrNo){
        axios.post('/qnaReplyList', {qaNotiwrNo : qaNotiwrNo})
          .then(res => {
            
          this.qnaReplyList = res.data; // 해당 게시글의 댓글 리스트

          /*
          for(let i = 0; i <this.qnaReplyList.length; i++){
            this.qnaReplyList[i].isVisible = false; // 해당 댓글의 댓글 부분 보이게하는 값 초기화
            this.qnaReplyList[i].modFormVisible = false; // 해당 댓글의 수정폼 부분 보이게하는 값 초기화
          }*/

          if(this.openIndex != -1){ // 특정 대댓글 리스트 열어 놓음
            this.commentsList(this.openIndex);
          }
          
          }).catch(function(error){
              console.log(error)
          })
      },

      // 해당 댓글의 댓글 리스트 보이게 하는 토굴함수(하나의 대댓글 리스트만 볼수있도록함)
      commentsList(index){
        for (let i = 0; i < this.qnaReplyList.length; i++) {
          if (i === index) {
            // 현재 클릭된 댓글이면 상태를 토글
            this.qnaReplyList[i].isVisible = !this.qnaReplyList[i].isVisible;
          } else {
            // 클릭된 댓글이 아니면 닫음
            this.qnaReplyList[i].isVisible = false;
          }
        } 
      },

      // 댓글 등록버튼 클릭시 실행하는 함수
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
            this.rplyCntn = ''; // 댓글 작성 input칸 초기화
            this.openIndex = -1; // 열어 놓은 대댓글 리스트 닫히도록함
            this.ReplyList(this.qaNotiwrNo); // 댓글리스트 화면에서 재출력(insert한 댓글 나옴)

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
        this.qnaReplyList[index].modifyRplyCntn = this.qnaReplyList[index].rplyCntn; // 기존 댓글 내용
        this.qnaReplyList[index].modFormVisible = !this.qnaReplyList[index].modFormVisible;
      },

      // 댓글 수정 기능이 일어나는 함수
      replyModifyFn(index){
        let rplyCntn = this.qnaReplyList[index].modifyRplyCntn; // 댓글 수정 내용 부분
        let rplyNo = this.qnaReplyList[index].rplyNo; // 수정할 댓글번호
        //console.log('rplyCntn : ', rplyCntn );
        //console.log('rplyNo : ' ,rplyNo);
        axios.post('/qnaReplyMod', {rplyNo : rplyNo, rplyCntn : rplyCntn})
          .then(res => {
            // 수정 성공시
            if(res.data.result === 'Success'){

              this.openIndex = -1; // 열어 놓은 대댓글 리스트 닫히도록함
              this.ReplyList(this.qaNotiwrNo); // 댓글리스트 화면에서 재출력

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
        let rplyNo = this.qnaReplyList[index].rplyNo; // 삭제할 댓글번호
        axios.post('/qnaReplyDelete', {rplyNo : rplyNo})
          .then(res => {

            // 삭제 성공시
            if(res.data.result === 'Success'){
              this.openIndex = -1; // 열어 놓은 대댓글 리스트 닫히도록함
              this.ReplyList(this.qaNotiwrNo); // 댓글리스트 화면에서 재출력
              
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

      // 대댓글 등록 함수
      chReplyAdd(index){
        
        let formId = '#' + this.qnaReplyList[index].rplyNo; // 대댓글 등록폼 ID

        let formData = new FormData($(formId)[0]); // 폼데이터

        axios.post('/chQnaReplyAdd', formData , {
            headers: {
              'Content-Type': 'multipart/form-data'
            }
        })
        .then(res => {

          if(res.data.result === 'Success'){
            //console.log('대댓글등록 성공');
            // this.qnaReplyList[index].chRplyCntn = ''; // 댓글 작성 input칸 초기화
            
            this.openIndex = index; // 대댓글을 단 대댓글 리스트 열어 놓게하는 값 

            this.ReplyList(this.qaNotiwrNo); // 댓글리스트 화면에서 재출력 => 비동기라서 응답이 언제 올지 모름
            
            // 1. 따라서 setTimeout으로 시간을 지연시켜주거나 2. 동기식으로 바꿔줘야함

            // window.setTimeout이라 그안의 function에서의 this는 안먹음 따라서 밖에서 this를 따로 하나줌
            // var temp = this; 

            // 비동기라 시간을 지연시킴
            // window.setTimeout(function(){
            //   temp.commentsList(index); // temp = 바깥의 this  // 해당 댓글의 대댓글 리스트 출력하는 토굴함수
            // },100);

          }else{
            Swal.fire({
                icon: 'error',
                title: '대댓글 등록실패!'
            });
          }
        })
        .catch(function(error){
              console.log(error)
        })   
      },

      // 대댓글 수정 버튼 클릭시 실행하는함수
      chReplyModForm(index, chIndex){
        this.qnaReplyList[index].chreplyList[chIndex].modifyRplyCntn = this.qnaReplyList[index].chreplyList[chIndex].rplyCntn; // 기존 대댓글 내용
        this.qnaReplyList[index].chreplyList[chIndex].chModFormVisible = !this.qnaReplyList[index].chreplyList[chIndex].chModFormVisible;
      },

       // 대댓글 수정 기능이 일어나는 함수
      chReplyModifyFn(index, chIndex){

        let rplyCntn = this.qnaReplyList[index].chreplyList[chIndex].modifyRplyCntn; // 대댓글 수정할 내용 부분
        let rplyNo = this.qnaReplyList[index].chreplyList[chIndex].rplyNo; // 수정할 대댓글번호
  
        axios.post('/qnaReplyMod', {rplyNo : rplyNo, rplyCntn : rplyCntn})
          .then(res => {
            // 대댓글 수정 성공시
            if(res.data.result === 'Success'){

              this.openIndex = index; // 대댓글을 단 대댓글 리스트 열어 놓게하는 값 

              this.ReplyList(this.qaNotiwrNo); // 댓글리스트 화면에서 재출력
              
              // window.setTimeout이라 그안의 function에서의 this는 안먹음 따라서 밖에서 this를 따로 하나줌
              //var temp = this; 

              // 비동기라 시간을 지연시킴
              // window.setTimeout(function(){
              //   temp.commentsList(index); // temp = 바깥의 this  // 해당 댓글의 대댓글 리스트 출력하는 토굴함수
              //  },100);

            }else{
              Swal.fire({
                  icon: 'error',
                  title: '대댓글 수정실패!'
              });
            }
          }).catch(function(error){
              console.log(error)
          })
      },

      // 대댓글 삭제 기능이 일어나는 함수
      chReplyDelete(index, chIndex){

        let rplyNo = this.qnaReplyList[index].chreplyList[chIndex].rplyNo; // 삭제할 대댓글번호

        axios.post('/qnaReplyDelete', {rplyNo : rplyNo})
          .then(res => {
            // 대댓글 삭제 성공시
            if(res.data.result === 'Success'){

              this.openIndex = index; // 대댓글을 단 대댓글 리스트 열어 놓게하는 값
              
              this.ReplyList(this.qaNotiwrNo); // 댓글리스트 화면에서 재출력
             
              // window.setTimeout이라 그안의 function에서의 this는 안먹음 따라서 밖에서 this를 따로 하나줌
              //var temp = this; 

              // 비동기라 시간을 지연시킴
              // window.setTimeout(function(){
              //   temp.commentsList(index); // temp = 바깥의 this  // 해당 댓글의 대댓글 리스트 출력하는 토굴함수
              //  },100);

            }else{
              Swal.fire({
                  icon: 'error',
                  title: '대댓글 삭제실패!'
              });
            }
          }).catch(function(error){
              console.log(error)
          })
      }

    }
  }
</script>