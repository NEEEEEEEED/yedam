<template>
  <section class="section">
    <div class="pagetitle">
      <h1>회원관리</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">Forms</li>
          <li class="breadcrumb-item active">Layouts</li>
        </ol>
      </nav>
    </div>

    <div class="row">
      <div class="col-lg-12">
        <div class="card">
          <div class="card-body">
            <p class="card-title">검색조건</p>
            <div class="row">
              <div
                class="col-md-2 spanTitle d-flex align-items-center justify-content-center"
              >
                <span>회원상태</span>
              </div>
              <div class="col-md-6">
                <div
                  class="form-check form-check-inline"
                  v-for="(item, index) in filteredTest"
                  :key="index"
                >
                  <label :for="item.commCd" class="form-check-label">{{
                    item.desct
                  }}</label>
                  <input
                    type="checkbox"
                    class="form-check-input"
                    :key="index"
                    :id="item.commCd"
                  />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-md-7 grid-margin stretch-card">
        <div class="card" style="min-height: 100%">
          <div class="card-body">
            <p class="card-title">유저목록</p>
            <DataTable
              :value="userList"
              selectionMode="single"
              dataKey="id"
              showGridlines
              sortField="joinDt"
              paginator
              :rows="10"
              :rowsPerPageOptions="[5, 10, 20]"
              tableStyle="min-width: 100%"
              v-model="selected"
              v-on:row-select="onRowSelect"
            >
              <Column field="clsf" header="분류"></Column>
              <Column field="id" header="아이디"></Column>
              <Column field="name" header="이름"></Column>
              <Column field="gen" header="성별"></Column>
              <Column field="email" header="이메일"></Column>
              <Column field="phCl" header="전화번호"></Column>
              <Column field="joinDt" header="가입일자"></Column>
            </DataTable>
          </div>
        </div>
      </div>
      <div class="col-md-5 grid-margin stretch-card">
        <div class="card" style="min-height: 100%">
          <div class="card-body">
            <p class="card-title">상세정보</p>
            <form class="row g-3">
              <div class="col-md-6">
                <label class="form-label">분류</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.clsf"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">이름</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.name"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">성별</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.gen"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">생년월일</label>
                <input
                  type="date"
                  class="form-control"
                  v-model="userDetail.birth"
                  readonly
                />
              </div>
              <div class="col-12">
                <label class="form-label">주소</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.addr"
                  readonly
                />
              </div>
              <div class="col-6">
                <label class="form-label">이메일</label>
                <input
                  type="email"
                  class="form-control"
                  v-model="userDetail.email"
                  readonly
                />
              </div>
              <div class="col-6">
                <label class="form-label">블로그</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.blog"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">가입일자</label>
                <input
                  type="email"
                  class="form-control"
                  v-model="userDetail.joinDt"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">최근로그인</label>
                <input
                  type="password"
                  class="form-control"
                  v-model="userDetail.ltstTm"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">전화번호</label>
                <input
                  type="email"
                  class="form-control"
                  v-model="userDetail.ph"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">핸드폰</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.phCl"
                  readonly
                />
              </div>
              <div class="col-12">
                <button type="button" class="btn btn-primary">Sign in</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import { userList } from "@/service/userList";
import { searchForm } from "@/service/searchForm";
import DataTable from "primevue/datatable";
import Column from "primevue/column";
export default {
  components: {
    DataTable,
    Column,
  },
  data() {
    return {
      userList: [],
      selected: null,
      test: [],
      userDetail: {},
    };
  },
  mounted() {
    userList.getUserData().then((data) => (this.userList = data));
    searchForm.getCommonCode().then((data) => (this.test = data));
  },
  methods: {
    onRowSelect(event) {
      const selectedRow = event.data;
      userList
        .getuserDetail(selectedRow)
        .then((data) => (this.userDetail = data));
    },
  },
  computed: {
    filteredTest() {
      return this.test.filter((item) => item.desct !== "관리자");
    },
  },
};
</script>
