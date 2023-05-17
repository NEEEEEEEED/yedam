<template>
    <!-- 반복 -->
    <div v-for="(reply, index) in qnaReplyList" :key="reply.rplyNo" class="mb-2 p-3">
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
            <div class="ms-3">
                <i class="fa-regular fa-comment-dots fa-sm"></i>
                <span>0</span>
              </div>
            <div class="cursor ms-3">
                <i class="fa-solid fa-land-mine-on"></i>
                <span class="fs--1">신고하기</span>
              </div>
            </div>
        </div>
      </div>
      <p>{{reply.rplyCntn}}</p>
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

</template>

<script>
  module.exports = {
    data() {
      return {
        qnaReplyList : [],
        qaNotiwrNo : '',
        //isVisible : false,
      };
    },
    mounted(){
      this.getQaNotiwrNo();
  
    },
    methods: {

      getQaNotiwrNo(){
        // 현재 페이지의 URL에서 쿼리스트링 값 가져옴
        const queryString = window.location.search;

        // 쿼리스트링 값을 파싱하여 객체로 변환
        const params = new URLSearchParams(queryString);
        const value = params.get('qaNotiwrNo');
        this.qaNotiwrNo = value;
        //console.log(this.qaNotiwrNo); // 쿼리스트링의 값 출력

        this.ReplyList(this.qaNotiwrNo); // 댓글 리스트 출력

      },

      // 댓글 리스트 출력 
      ReplyList (qaNotiwrNo){
        axios.post('/qnaReplyList', {qaNotiwrNo : qaNotiwrNo})
          .then(res => {
            
            this.qnaReplyList = res.data;
            console.log(this.qnaReplyList);

            for(let i = 0; i <this.qnaReplyList.length; i++){
              this.qnaReplyList[i].isVisible = false;
            }


          }).catch(function(error){
              console.log(error)
          })
        },
      commentsList(index){
        this.qnaReplyList[index].isVisible = !this.qnaReplyList[index].isVisible;

      }
    }
  }
</script>