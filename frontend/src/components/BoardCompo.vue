<template>
  <section class="section">
    <toast />
    <div class="pagetitle">
      <h1>게시글,댓글관리</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item active">게시글,댓글관리</li>
        </ol>
      </nav>
    </div>

    <div class="card">
      <div class="card-body">
        <p class="card-title">검색조건</p>
        <form class="row g-3">
          <div class="row" style="margin-bottom: 10px">
            <span class="col-sm-1 col-form-label">분류</span>
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
      <div class="col-md-12 grid-margin stretch-card">
        <div class="card" style="min-height: 100%">
          <div class="card-body">
            <span
              class="p-buttonset"
              data-v-d3f5b421=""
              style="float: right; margin-top: 3px"
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
                ><span class="p-button-label">Save</span
                ><!----><span
                  class="p-ink"
                  role="presentation"
                  aria-hidden="true"
                ></span></button
              ><button
                class="p-button p-component"
                type="button"
                aria-label="Delete"
                data-v-d3f5b421=""
                @click="deleteUser"
              >
                <!----><span
                  class="pi pi-trash p-button-icon p-button-icon-left"
                ></span
                ><span class="p-button-label">Delete</span
                ><!----><span
                  class="p-ink"
                  role="presentation"
                  aria-hidden="true"
                ></span></button
              ><button
                class="p-button p-component"
                type="button"
                aria-label="Cancel"
                data-v-d3f5b421=""
                @click="cancelBtn"
              >
                <!----><span
                  class="pi pi-times p-button-icon p-button-icon-left"
                ></span
                ><span class="p-button-label">Cancel</span
                ><!----><span
                  class="p-ink"
                  role="presentation"
                  aria-hidden="true"
                ></span></button
            ></span>
            <TabView>
              <TabPanel header="게시글목록">
                <DataTable
                  style="clear: both"
                  ref="dataTable"
                  :value="boardList"
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
                  <Column field="" header="분류"></Column>
                  <Column field="" header="제목"></Column>
                  <Column field="" header="작성자"></Column>
                  <Column field="" header="작성일자"></Column>
                  <Column field="" header="신고수"></Column>
                  <Column field="" header="조치내용"></Column>
                  <Column field="" header="조치일자"></Column>
                </DataTable>
              </TabPanel>
              <TabPanel header="공고목록">
                <p>
                  Sed ut perspiciatis unde omnis iste natus error sit voluptatem
                  accusantium doloremque laudantium, totam rem aperiam, eaque
                  ipsa quae ab illo inventore veritatis et quasi architecto
                  beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem
                  quia voluptas sit aspernatur aut odit aut fugit, sed quia
                  consequuntur magni dolores eos qui ratione voluptatem sequi
                  nesciunt. Consectetur, adipisci velit, sed quia non numquam
                  eius modi.
                </p>
              </TabPanel>
              <TabPanel header="댓글목록">
                <p>
                  At vero eos et accusamus et iusto odio dignissimos ducimus qui
                  blanditiis praesentium voluptatum deleniti atque corrupti quos
                  dolores et quas molestias excepturi sint occaecati cupiditate
                  non provident, similique sunt in culpa qui officia deserunt
                  mollitia animi, id est laborum et dolorum fuga. Et harum
                  quidem rerum facilis est et expedita distinctio. Nam libero
                  tempore, cum soluta nobis est eligendi optio cumque nihil
                  impedit quo minus.
                </p>
              </TabPanel>
            </TabView>
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
import TabView from "primevue/tabview";
import TabPanel from "primevue/tabpanel";

export default {
  components: {
    DataTable,
    Column,
    Toast,
    TabView,
    TabPanel,
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
      userList.getSearchUser(data);
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
      console.log(this.selectedUser);
      userList.modifyUser(this.selectedUser).then((data) => {
        const names = this.selectedUser.map((item) => item.name);
        if (data == "success") {
          this.$toast.add({
            severity: "success",
            summary: "유저정보 수정 성공",
            detail: names + " 정보 수정 성공.",
            life: 3000,
          });
          this.userDetail = {};
        } else {
          this.$toast.add({
            severity: "error",
            summary: "유저정보 수정 실패",
            detail: names + " 정보 수정 실패.",
            life: 3000,
          });
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
          } else {
            this.$toast.add({
              severity: "error",
              summary: "삭제 실패",
              detail: names + "의 정보가 삭제에 실패했습니다.",
              life: 3000,
            });
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
