<template>
  <div>
    <!-- 컴포넌트의 내용을 작성합니다. -->

    <div class="row" style="margin-bottom: 10px">
      <span class="col-sm-1 col-form-label">제목</span>
      <div class="col-md-4">
        <input type="text" class="form-control" v-model="boardCondi.title" />
      </div>
      <div class="col-md-1"></div>
      <span class="col-sm-1 col-form-label">작성자</span>
      <div class="col-md-4">
        <div class="input-group mb-3">
          <input type="text" class="form-control" v-model="boardCondi.id" />
        </div>
      </div>
    </div>
    <div class="row" style="margin-bottom: 25px">
      <span class="col-sm-1 col-form-label">게시글분류</span>
      <div class="col-md-5">
        <div class="form-check form-check-inline" style="padding-top: 6px">
          <label class="form-check-label"> 취업Q&A </label>
          <input
            type="checkbox"
            class="form-check-input"
            value="K3"
            v-model="boardCondi.postType"
          />
        </div>
        <div class="form-check form-check-inline" style="padding-top: 6px">
          <label class="form-check-label"> 면접후기 </label>
          <input
            type="checkbox"
            class="form-check-input"
            value="K4"
            v-model="boardCondi.postType"
          />
        </div>
        <div class="form-check form-check-inline" style="padding-top: 6px">
          <label class="form-check-label"> 프로젝트모집 </label>
          <input
            type="checkbox"
            class="form-check-input"
            value="K5"
            v-model="boardCondi.postType"
          />
        </div>
        <div class="form-check form-check-inline" style="padding-top: 6px">
          <label class="form-check-label"> 스터디모집 </label>
          <input
            type="checkbox"
            class="form-check-input"
            value="K6"
            v-model="boardCondi.postType"
          />
        </div>
      </div>

      <span class="col-sm-1 col-form-label">작성일자</span>
      <div class="col-md-4">
        <div class="row">
          <div class="col-md-6">
            <input
              type="date"
              class="form-control"
              v-model="boardCondi.startDate"
            />
          </div>
          <div class="col-md-6">
            <input
              type="date"
              class="form-control"
              v-model="boardCondi.lastDate"
            />
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <span class="col-sm-1 col-form-label">처리결과</span>
      <div class="col-md-4">
        <div class="form-check form-check-inline" style="padding-top: 6px">
          <label class="form-check-label"> 미처리 </label>
          <input
            type="checkbox"
            class="form-check-input"
            value="G4"
            v-model="boardCondi.prcsResult"
          />
        </div>
        <div class="form-check form-check-inline" style="padding-top: 6px">
          <label class="form-check-label"> 수정처리 </label>
          <input
            type="checkbox"
            class="form-check-input"
            value="G3"
            v-model="boardCondi.prcsResult"
          />
        </div>
        <div class="form-check form-check-inline" style="padding-top: 6px">
          <label class="form-check-label"> 삭제처리 </label>
          <input
            type="checkbox"
            class="form-check-input"
            value="G2"
            v-model="boardCondi.prcsResult"
          />
        </div>
        <div class="form-check form-check-inline" style="padding-top: 6px">
          <label class="form-check-label"> 강제탈퇴 </label>
          <input
            type="checkbox"
            class="form-check-input"
            value="G1"
            v-model="boardCondi.prcsResult"
          />
        </div>
      </div>
      <div class="col-md-1"></div>
      <span class="col-sm-1 col-form-label">처리일자</span>
      <div class="col-md-4">
        <div class="row">
          <div class="col-md-6">
            <input
              type="date"
              class="form-control"
              v-model="boardCondi.prcsStart"
            />
          </div>
          <div class="col-md-6">
            <input
              type="date"
              class="form-control"
              v-model="boardCondi.prcsEnd"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "BoardSearchForm1",
  // 컴포넌트의 기능과 관련된 내용을 작성합니다.
  data() {
    return {
      boardCondi: {},
    };
  },
};
</script>
