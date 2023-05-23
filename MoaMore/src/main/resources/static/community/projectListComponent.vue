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
  <div v-for="project in filteredProjects" v-bind:key="project.prjtNo" class="col-md-3 cursor mb-4" @click="projectDetail(project.prjtNo)"> 
    <div class="card" style="border: 3px solid #EBECF0;">
      <div class="card-body pb-4">
        <div class="text-start" style="position:relative; right:30px; bottom:30px;">
          <span class="fs--1">마감일 | </span><span class="fs--1">{{project.clsDt}}</span>
        </div>
        <div class="text-end" style="position:relative; left:30px; bottom:55px;">
          <span v-if="project.collSt === '모집중'" class="badge bg-secondary radius">{{project.collSt}}</span>
          <span v-else class="badge bg-dark radius">{{project.collSt}}</span>
        </div>
        <div>
          <h5 class="text-center">{{ truncatedTitle(project.ttl) }}</h5>
          <hr style="color:#ddd;">
        </div>

        <ul class="listStyle text-start">
          <li><span>ㆍ직무 : </span><span>{{project.collPosi}}</span></li>
          <li><span>ㆍ모집입원 : </span><span>{{project.collRcnt}}</span></li>
          <li><span>ㆍ진행방식 : </span><span>{{project.progMthd}}</span></li>
          <li><span>ㆍ시작예정 : </span><span>{{project.expcDt}}</span></li>
        </ul>
        <hr style="color:#ddd;">

        <div class="d-flex">
          <div>
            <img src="self/profile.JPG" class="circleImg" alt="이미지안보임">
            <span>{{project.id}}</span>
          </div>
          <div style="margin-left:auto">
            <i class="fa-regular fa-comment-dots fa-sm"></i>
            <span>&nbsp{{project.rplyCnt}}&nbsp</span>
            <i class="fa-regular fa-eye fa-sm"></i>
            <span>&nbsp{{project.inqCnt}}</span>
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
        projectBoards : [],
        showRecruiting: true // 모집중, 모집마감 필터해서 보여줄값
      };
    },

    mounted(){
      this.projectList();  // 프로젝트 모집 전체 리스트
    },

    methods: {
      // 프로젝트 모집 전체 리스트
      projectList (){ 
        axios.get('/projectBoards')
            .then(res => {
              
              this.projectBoards = res.data;
      
            }).catch(function(error){
                console.log(error)
            })
      },

      // 버튼 클릭시 프로젝트 상세 페이지 이동
      projectDetail(prjtNo){
        location.href = "/projectDetail?prjtNo=" + prjtNo;
      },

      // 제목의 글자수가 일정이상 넘어가면 ..처리
      truncatedTitle(title) {
        let characterLimit = 10; // 글자 수 제한 설정
        if (title.length > characterLimit) {
          return title.slice(0, characterLimit) + "..";
        } else {
          return title;
        }
      },

    },

    computed: {
      // showRecruiting의 값에 따라 모집중, 모집마감 리스트를 필터해서 보여줌
      filteredProjects() {
        if (this.showRecruiting) {
          return this.projectBoards.filter((project) => project.collSt === '모집중');
        } else {
          return this.projectBoards.filter((project) => project.collSt === '모집마감');
        }
      }
    }
  }
</script>