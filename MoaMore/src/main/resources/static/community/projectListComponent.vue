<template>
  <!-- 반복 -->
  <div v-for="project in projectBoards" v-bind:key="project.prjtNo" class="col-md-3 cursor mb-4" @click="projectDetail(project.prjtNo)"> 
    <div class="card" style="border: 10px solid #EBECF0;">
      <div class="card-body pb-4">
        <div class="text-start" style="position:relative; right:30px; bottom:30px;">
          <span class="fs--1">마감일 | </span><span class="fs--1">{{project.clsDt}}</span>
        </div>
        <div class="text-end" style="position:relative; left:30px; bottom:55px;">
          <span class="badge bg-dark radius">{{project.collSt}}</span>
        </div>
        <div>
          <h5 class="text-center">{{project.ttl}}</h5>
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
            <i class="fa-regular fa-eye fa-sm"></i>
            <span>{{project.inqCnt}}</span>
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
        projectBoards : []
      };
    },
    mounted(){
      this.projectList();
    },
    methods: {
      projectList (){
        axios.get('/projectBoards')
            .then(res => {
              this.projectBoards = res.data;
            }).catch(function(error){
                console.log(error)
            })
        },
      projectDetail(prjtNo){
        location.href = "/projectDetail?prjtNo=" + prjtNo;
        }
    }
  }
</script>