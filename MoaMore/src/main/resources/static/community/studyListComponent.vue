<template>
  <!-- 반복 -->
  <div v-for="study in studyBoards" v-bind:key="study.studyNo" class="col-md-3 cursor" @click="studyDetail(study.studyNo)">
    <div class="card">
      <div class="card-body pb-4">
        <div class="text-start" style="position:relative; right:30px; bottom:30px;">
          <span class="fs--1">마감일 | </span><span class="fs--1">{{study.clsDt}}</span>
        </div>
        <div class="text-end" style="position:relative; left:30px; bottom:55px;">
          <span v-if="study.collSt === '모집중'" class="badge bg-secondary radius">{{study.collSt}}</span>
          <span v-else="study.collSt === '모집완료'" class="badge bg-dark radius">{{study.collSt}}</span>
        </div>
        <div>
          <h5 class="text-center">{{study.ttl}}</h5>
          <hr style="color:#ddd;">
        </div>
        
        <ul class="listStyle text-start">
          <li><span>ㆍ목적 : </span><span>{{study.studyFg}}</span></li>
          <li><span>ㆍ모집입원 : </span><span>{{study.collRcnt}}</span></li>
          <li><span>ㆍ진행방식 : </span><span>{{study.progMthd}}</span></li>
          <li><span>ㆍ시작예정 : </span><span>{{study.expcDt}}</span></li>
        </ul>
        <hr style="color:#ddd;">
        
        <div class="d-flex">
          <div>
            <img src="self/profile.JPG" class="circleImg" alt="이미지안보임" >
            <span>{{study.id}}</span>
          </div>
          <div style="margin-left:auto">
            <i class="fa-regular fa-eye fa-sm"></i>
              <span>&nbsp{{study.inqCnt}}</span>
            </div>
          </div>
      </div>
    </div>
  </div>
</template>

<script>
  module.exports = {
    data() {
      return {
        studyBoards : []
      };
    },
    mounted(){
      this.studyList();
    },
    methods: {
      studyList(){
        axios.get('/studyBoards')
            .then(res => {
              this.studyBoards = res.data;
            }).catch(function(error){
                console.log(error)
            })
        },
      studyDetail(studyNo){
        location.href = "/studyDetail?studyNo=" + studyNo;
        }
    }
  }
</script>