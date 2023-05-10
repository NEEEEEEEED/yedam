<template>
  <section class="section">
    <toast />
    <div class="pagetitle">
      <h1>회원관리</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item active">회원관리</li>
        </ol>
      </nav>
    </div>

    <div class="card">
      <div class="card-body">
        <p class="card-title">검색조건</p>
        <form class="row g-3">
          <div class="row" style="margin-bottom: 10px">
            <span class="col-sm-1 col-form-label">회원분류</span>
            <div class="col-md-4">
              <div
                class="form-check form-check-inline"
                v-for="(item, index) in filteredTest"
                style="padding-top: 6px"
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
            <div class="col-md-1"></div>
            <span class="col-sm-1 col-form-label">가입일자</span>
            <div class="col-md-4">
              <div class="row">
                <div class="col-md-6">
                  <input type="date" class="form-control" />
                </div>
                <div class="col-md-6">
                  <input type="date" class="form-control" />
                </div>
              </div>
            </div>
          </div>
          <div class="row" style="margin-bottom: 10px">
            <span class="col-sm-1 col-form-label">회원명</span>
            <div class="col-md-4">
              <input type="text" class="form-control" />
            </div>
            <div class="col-md-1"></div>
            <span class="col-sm-1 col-form-label">이메일</span>
            <div class="col-md-4">
              <div class="input-group mb-3">
                <input
                  type="text"
                  class="form-control"
                  placeholder="Username"
                  aria-label="Username"
                />
                <span class="input-group-text">@</span>
                <input
                  type="text"
                  class="form-control"
                  placeholder="Server"
                  aria-label="Server"
                />
              </div>
            </div>
          </div>
          <div class="row" style="margin-bottom: 10px">
            <span class="col-sm-1 col-form-label">아이디</span>
            <div class="col-md-4">
              <input type="text" class="form-control" />
            </div>
            <div class="col-md-6">
              <div class="row">
                <div class="col-md-8"></div>
                <div class="col-md-4">
                  <button
                    style="float: right; margin-left: 5px"
                    class="btn btn-outline-primary"
                    type="button"
                  >
                    검색</button
                  ><button
                    style="float: right"
                    class="btn btn-outline-secondary"
                    type="reset"
                  >
                    초기화
                  </button>
                </div>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>

    <div class="row">
      <div class="col-md-7 grid-margin stretch-card">
        <div class="card" style="min-height: 100%">
          <div class="card-body">
            <p class="card-title">유저목록</p>
            <DataTable
              ref="dataTable"
              :value="userList"
              selectionMode="single"
              dataKey="email"
              showGridlines
              sortField="joinDt"
              paginator
              :rows="10"
              :rowsPerPageOptions="[5, 10, 20]"
              tableStyle="min-width: 100%"
              v-model="selected"
              v-on:row-select="onRowSelect"
            >
              <Column field="clsfname" header="분류"></Column>
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
            <form class="row g-3" id="userForm">
              <div class="col-md-6">
                <label class="form-label">분류</label>
                <select
                  class="form-select"
                  id="clsfSelect"
                  v-model="userDetail.clsf"
                >
                  <option
                    v-for="(item, index) in filteredTest"
                    :key="index"
                    :value="item.commCd"
                  >
                    {{ item.desct }}
                  </option>
                </select>
              </div>
              <div class="col-md-6">
                <label class="form-label">이름</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.name"
                  readonly
                  @dblclick="($event) => ($event.target.readOnly = false)"
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">성별</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.gen"
                  readonly
                  @dblclick="($event) => ($event.target.readOnly = false)"
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">생년월일</label>
                <input
                  type="date"
                  class="form-control"
                  v-model="userDetail.birth"
                  readonly
                  @dblclick="($event) => ($event.target.readOnly = false)"
                />
              </div>
              <div class="col-12">
                <label class="form-label">주소</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.addr"
                  readonly
                  @dblclick="($event) => ($event.target.readOnly = false)"
                />
              </div>
              <div class="col-6">
                <label class="form-label">이메일</label>
                <input
                  type="email"
                  class="form-control"
                  v-model="userDetail.email"
                  readonly
                  @dblclick="($event) => ($event.target.readOnly = false)"
                />
              </div>
              <div class="col-6">
                <label class="form-label">블로그</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.blog"
                  readonly
                  @dblclick="($event) => ($event.target.readOnly = false)"
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
                  type="date"
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
                  @dblclick="($event) => ($event.target.readOnly = false)"
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">핸드폰</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.phCl"
                  readonly
                  @dblclick="($event) => ($event.target.readOnly = false)"
                />
              </div>
              <div class="col-12">
                <button
                  type="button"
                  style="float: right; margin-left: 5px"
                  class="btn btn-outline-primary"
                  @click="submitUserForm"
                >
                  수정
                </button>
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
import Toast from "primevue/toast";

export default {
  components: {
    DataTable,
    Column,
    Toast,
  },
  data() {
    return {
      readonly: true,
      userList: [],
      selected: null,
      test: [],
      userDetail: {},
      editableField: null,
      readonlyStyle: {
        backgroundColor: "#f5f5f5",
        cursor: "not-allowed",
      },
    };
  },
  mounted() {
    this.getUserData().then((data) => (this.userList = data));
    searchForm.getCommonCode().then((data) => (this.test = data));
  },
  methods: {
    getUserData() {
      return userList.getUserData();
    },
    // 유저 디테일 가져오기
    onRowSelect(event) {
      const selectedRow = event.data.email;
      userList
        .getuserDetail(selectedRow)
        .then((data) => {
          this.userDetail = data;
        })
        .then(() => {
          const form = document.getElementById("userForm");
          const inputs = form.querySelectorAll("input");
          inputs.forEach((input) => (input.readOnly = true));
        });
    },
    //유저 정보 수정
    submitUserForm() {
      console.log(this.userDetail);
      userList.modifyUser(this.userDetail).then((data) => {
        if (data == "success") {
          this.$toast.add({
            severity: "success",
            summary: "유저정보 수정 성공",
            detail: this.userDetail.name + " 정보 수정 성공.",
            life: 3000,
          });
          this.getUserData().then((data) => (this.userList = data));
          this.userDetail = {};
        } else {
          this.$toast.add({
            severity: "error",
            summary: "유저정보 수정 실패",
            detail: this.userDetail.name + " 정보 수정 실패.",
            life: 3000,
          });
        }
      });
    },
    onInputDoubleClick(refName) {
      // 해당 ref를 가진 input 요소의 readonly 속성 제거
      this.$refs[refName].removeAttribute("readonly");

      // 해당 ref를 가진 input 요소에 스타일 적용
      this.$refs[refName].style.backgroundColor = "yellow";

      // editableField 변수에 해당 ref 할당
      this.editableField = this.$refs[refName];
    },
  },

  computed: {
    filteredTest() {
      return this.test.filter((item) => item.desct !== "관리자");
    },
    readonlyInputs() {
      return this.$el.querySelectorAll("input[readonly]");
    },
  },
};
</script>
<style scoped>
input[readonly] {
  background-color: #f5f5f5;
  cursor: not-allowed;
}
</style>
