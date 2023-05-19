<template>
  <div>
    <!-- 컴포넌트의 내용을 작성합니다. -->
    <div class="row" style="margin-bottom: 10px">
      <span class="col-sm-1 col-form-label">제목</span>
      <div class="col-md-4">
        <input type="text" class="form-control" v-model="name" />
      </div>
      <div class="col-md-1"></div>
      <span class="col-sm-1 col-form-label">작성자</span>
      <div class="col-md-4">
        <div class="input-group mb-3">
          <input
            type="text"
            class="form-control"
            aria-label="Username"
            v-model="userName"
          />
        </div>
      </div>
    </div>
    <div class="row" style="margin-bottom: 25px">
      <span class="col-sm-1 col-form-label">아이디</span>
      <div class="col-md-4">
        <input type="text" class="form-control" v-model="id" />
      </div>
      <div class="col-md-1"></div>
      <span class="col-sm-1 col-form-label">작성일자</span>
      <div class="col-md-4">
        <div class="row">
          <div class="col-md-6">
            <input type="date" class="form-control" v-model="startDate" />
          </div>
          <div class="col-md-6">
            <input type="date" class="form-control" v-model="lastDate" />
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <span class="col-sm-1 col-form-label">처리결과</span>
      <div class="col-md-4">
        <input type="text" class="form-control" v-model="prcsResult" />
      </div>
      <div class="col-md-1"></div>
      <span class="col-sm-1 col-form-label">처리일자</span>
      <div class="col-md-4">
        <div class="row">
          <div class="col-md-6">
            <input type="date" class="form-control" v-model="prcsStart" />
          </div>
          <div class="col-md-6">
            <input type="date" class="form-control" v-model="prcsEnd" />
          </div>
        </div>
      </div>
    </div>
    <div class="row" style="margin-bottom: 10px">
      <span class="col-sm-1 col-form-label">승인상태</span>
      <div class="col-md-4">
        <input type="text" class="form-control" v-model="name" />
      </div>
      <div class="col-md-1"></div>
      <span class="col-sm-1 col-form-label">승인일자</span>
      <div class="col-md-4">
        <div class="row">
          <div class="col-md-6">
            <input type="date" class="form-control" v-model="startDate" />
          </div>
          <div class="col-md-6">
            <input type="date" class="form-control" v-model="lastDate" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "BoardSearchForm2",
  // 컴포넌트의 기능과 관련된 내용을 작성합니다.
};
</script>
