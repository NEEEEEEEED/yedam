<template>

  <div class="mt-3 mb-5">
    <ul class="nav justify-content-end nav-pills">
      <li class="nav-item border" style="cursor: pointer;" @click="showRecruiting = true">
        <span class="nav-link" :class="{ 'active': showRecruiting }" aria-current="page">모집중</span>
      </li>
      <li class="nav-item border" style="cursor: pointer;" @click="showRecruiting = false">
        <span class="nav-link" :class="{ 'active': !showRecruiting }">모집마감</span>
      </li>
    </ul>
  </div>

  <!-- 반복 -->
  <div v-for="study in filteredStudies" v-bind:key="study.studyNo" class="col-md-3 cursor" @click="studyDetail(study.studyNo)">
    <div class="card" style="border: 3px solid #EBECF0;">
      <div class="card-body pb-4">
        <div class="text-start" style="position:relative; right:30px; bottom:30px;">
          <span class="fs--1">마감일 | </span><span class="fs--1">{{study.clsDt}}</span>
        </div>
        <div class="text-end" style="position:relative; left:30px; bottom:55px;">
          <span v-if="study.collSt === '모집중'" class="badge bg-secondary radius">{{study.collSt}}</span>
          <span v-else class="badge bg-dark radius">{{study.collSt}}</span>
        </div>
        <div>
          <h5 class="text-center">{{ truncatedTitle(study.ttl) }}</h5>
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
        studyBoards : [],
        showRecruiting: true // 모집중, 모집마감 필터해서 보여줄값
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

      // 버튼 클릭시 스터디모집 상세 페이지 이동
      studyDetail(studyNo){
        location.href = "/studyDetail?studyNo=" + studyNo;
      },

      // 제목의 글자수가 일정이상 넘어가면 ..처리
      truncatedTitle(title) {
        let characterLimit = 12; // 글자 수 제한 설정
        if (title.length > characterLimit) {
          return title.slice(0, characterLimit) + "..";
        } else {
          return title;
        }
      },

    },

    computed: {
      // showRecruiting의 값에 따라 모집중, 모집마감 리스트를 필터해서 보여줌
      filteredStudies() {
        if (this.showRecruiting) {
          return this.studyBoards.filter((study) => study.collSt === '모집중');
        } else {
          return this.studyBoards.filter((study) => study.collSt === '모집마감');
        }
      }
    }
  }
</script>