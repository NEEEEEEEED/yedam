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
        <p class="card-title">검색</p>
        <form class="row g-3">
          <div class="row" style="margin-bottom: 10px">
            <span class="col-sm-1 col-form-label">회원</span>
            <div class="col-md-5">
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
                  :value="item.commCd"
                  v-model="checkedCommCds"
                />
              </div>
            </div>
            <span class="col-sm-1 col-form-label">가입일자</span>
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
          <div class="row" style="margin-bottom: 10px">
            <span class="col-sm-1 col-form-label">회원명</span>
            <div class="col-md-4">
              <input type="text" class="form-control" v-model="name" />
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
                  v-model="userName"
                />
                <span class="input-group-text">@</span>
                <input
                  type="text"
                  class="form-control"
                  placeholder="Server"
                  aria-label="Server"
                  v-model="server"
                />
              </div>
            </div>
          </div>
          <div class="row" style="margin-bottom: 10px">
            <span class="col-sm-1 col-form-label">아이디</span>
            <div class="col-md-4">
              <input type="text" class="form-control" v-model="id" />
            </div>
            <div class="col-md-6">
              <div class="row">
                <div class="col-md-8"></div>
                <div class="col-md-4">
                  <button
                    style="float: right; margin-left: 5px"
                    class="btn btn-outline-primary"
                    type="submit"
                    @click.prevent="searchBtn"
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
            <p class="card-title" style="float: left">유저목록</p>
            <span
              class="p-buttonset"
              data-v-d3f5b421=""
              style="float: right; padding-top: 10px"
              ><button
                class="p-button p-component"
                type="button"
                aria-label="Save"
                data-v-d3f5b421=""
                @click="submitUserForm"
              >
                <!----><span
                  class="pi pi-check p-button-icon p-button-icon-left"
                ></span
                ><span class="p-button-label">저장</span
                ><!----><span
                  class="p-ink"
                  role="presentation"
                  aria-hidden="true"
                ></span>
              </button>
              <button
                class="p-button p-component"
                type="button"
                aria-label="Delete"
                data-v-d3f5b421=""
                @click="deleteUser"
              >
                <!----><span
                  class="pi pi-trash p-button-icon p-button-icon-left"
                ></span
                ><span class="p-button-label">삭제</span
                ><!----><span
                  class="p-ink"
                  role="presentation"
                  aria-hidden="true"
                ></span>
              </button>
            </span>
            <DataTable
              style="clear: both"
              ref="dataTable"
              :value="userList"
              class="p-datatable-sm"
              dataKey="email"
              showGridlines
              sortField="joinDt"
              paginator
              :rows="10"
              :rowsPerPageOptions="[5, 10, 20]"
              tableStyle="min-width: 100%"
              v-model:selection="selectedUser"
              @row-select="onRowSelect"
              selectionMode="sigle"
            >
              <Column
                selectionMode="multiple"
                headerStyle="width: 3rem"
              ></Column>
              <Column field="clsfname" header="분류"></Column>
              <Column field="id" header="아이디"></Column>
              <Column field="name" header="이름"></Column>
              <Column field="gen" header="성별"></Column>
              <Column field="email" header="이메일"></Column>
              <Column field="phCl" header="전화번호"></Column>
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
              <div class="col-12"></div>
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
      searchCondition: {},
      selectedUser: null,
      metaKey: true,
      readonly: true,
      userList: [],
      test: [],
      userDetail: {},
      editableField: null,
      readonlyStyle: {
        backgroundColor: "#f5f5f5",
        cursor: "not-allowed",
      },
      id: "",
      name: "",
      startDate: "",
      lastDate: "",
      userName: "",
      server: "",
      checkedCommCds: [],
    };
  },
  mounted() {
    this.getUserData().then((data) => (this.userList = data));
    searchForm.getCommonCode().then((data) => (this.test = data));
  },
  methods: {
    // 검색
    searchBtn() {
      const data = this.formData;
      const CommCds = Object.values(this.checkedCommCds);

      data.commds = CommCds;
      console.log(data);
      userList.getSearchUser(data).then((data) => (this.userList = data));
    },
    // 유저 전체 조회 선언
    getUserData() {
      return userList.getUserData();
    },
    cancelBtn() {
      userList.getUserData().then((data) => (this.userList = data));
      this.userDetail = {};
    },
    // 유저 디테일 가져오기
    onRowSelect(event) {
      this.userDetail = event.data;
    },
    //유저 정보 수정
    submitUserForm() {
      if (this.selectedUser == null) {
        this.$toast.add({
          severity: "info",
          summary: "수정할 유저정보를 선택하세요.",
          life: 2000,
        });
        return;
      }
      userList.modifyUser(this.selectedUser).then((data) => {
        const names = this.selectedUser.map((item) => item.name);
        if (data == "success") {
          this.$toast.add({
            severity: "success",
            summary: "유저정보 수정 성공",
            detail: names + " 정보 수정 성공.",
            life: 3000,
          });
          this.selectedUser = null;
          this.userDetail = {};
        } else {
          this.$toast.add({
            severity: "error",
            summary: "유저정보 수정 실패",
            detail: names + " 정보 수정 실패.",
            life: 3000,
          });
          this.selectedUser = null;
        }
      });
    },
    // 더블클릭시 input 열리기
    onInputDoubleClick(refName) {
      // 해당 ref를 가진 input 요소의 readonly 속성 제거
      this.$refs[refName].removeAttribute("readonly");

      // 해당 ref를 가진 input 요소에 스타일 적용
      this.$refs[refName].style.backgroundColor = "yellow";

      // editableField 변수에 해당 ref 할당
      this.editableField = this.$refs[refName];
    },
    // 유저 정보 삭제
    deleteUser() {
      //선택된 행의 이메일 값을 가져와 배열로 변환
      if (this.selectedUser == null) {
        this.$toast.add({
          severity: "info",
          summary: "삭제할 유저정보를 선택하세요.",
          life: 2000,
        });
        return;
      }
      const emails = this.selectedUser.map((item) => item.email);
      userList
        .deleteUsers(emails)
        .then((data) => {
          const names = this.selectedUser.map((item) => item.name);
          if (data == "success") {
            this.userList = this.userList.filter(
              (item) => !emails.includes(item.email)
            );
            this.selectedUser = null; // 선택한 상품을 초기화합니다.
            this.$toast.add({
              severity: "success",
              summary: "삭제 완료",
              detail: names + "의 정보가 삭제되었습니다.",
              life: 3000,
            });
            this.userDetail = {};
            this.selectedUser = null;
          } else {
            this.$toast.add({
              severity: "error",
              summary: "삭제 실패",
              detail: names + "의 정보가 삭제에 실패했습니다.",
              life: 3000,
            });
            this.selectedUser = null;
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },

  computed: {
    filteredTest() {
      return this.test.filter((item) => item.desct !== "관리자");
    },
    readonlyInputs() {
      return this.$el.querySelectorAll("input[readonly]");
    },
    formData() {
      return {
        id: this.id,
        name: this.name,
        startDate: this.startDate,
        lastDate: this.lastDate,
        userName: this.userName,
        server: this.server,
      };
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
