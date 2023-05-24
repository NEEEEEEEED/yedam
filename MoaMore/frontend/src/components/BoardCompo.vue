<template>
  <section class="section">
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
          <span class="col-sm-1 col-form-label">분류</span>
          <div class="col-md-5" style="padding-top: 7px">
            <div class="form-check form-check-inline">
              <input
                class="form-check-input"
                type="radio"
                name="gridRadios"
                id="gridRadios1"
                value="option1"
                checked=""
                @click="active = 0"
                v-model="activeIndex"
              />
              <label class="form-check-label" for="gridRadios1">
                게시글 목록
              </label>
            </div>
            <div class="form-check form-check-inline">
              <input
                class="form-check-input"
                type="radio"
                name="gridRadios"
                id="gridRadios3"
                value="option3"
                @click="active = 2"
                v-model="activeIndex"
              />
              <label class="form-check-label" for="gridRadios3">
                댓글목록
              </label>
            </div>
          </div>
          <div v-if="active === 0">
            <board-search-form1 />
          </div>
          <div v-if="active === 2">
            <board-search-form3 />
          </div>
          <div>
            <div class="row">
              <div class="col-md-8"></div>
              <div class="col-md-3">
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
        </form>
      </div>
    </div>

    <div class="row">
      <div class="col-md-12 grid-margin stretch-card">
        <div class="card" style="min-height: 100%">
          <div class="card-body">
            <div
              class="mt-1"
              style="float: right; position: relative; z-index: 2"
            >
              <button
                class="p-button p-component"
                type="button"
                aria-label="Delete"
                data-v-d3f5b421=""
                @click="deleteList"
              >
                Delete
              </button>
            </div>
            <TabView :activeIndex="active">
              <TabPanel header="게시글목록">
                <DataTable
                  style="clear: both"
                  ref="dataTable"
                  :value="boardList"
                  class="p-datatable-sm"
                  dataKey=""
                  showGridlines
                  sortField="regDt"
                  :sortOrder="-1"
                  paginator
                  :rows="10"
                  :rowsPerPageOptions="[5, 10, 20]"
                  tableStyle="min-width: 100%"
                  v-model:selection="selectedBoard"
                  selectionMode="sigle"
                >
                  <Column
                    selectionMode="multiple"
                    headerStyle="width: 3rem"
                  ></Column>
                  <Column field="no" sortable header="글번호"></Column>
                  <Column field="postType" sortable header="분류"></Column>
                  <Column
                    field="ttl"
                    header="제목"
                    :body-style="descriptionColumnStyle"
                  ></Column>
                  <Column field="cntn" header="  본문/신고내용">
                    <template #body="rowData">
                      <div class="g-3" style="text-align: center">
                        <Button
                          icon="pi pi-search"
                          @click="getDetail(rowData)"
                        />
                        <Button
                          class="ms-2"
                          icon="pi pi-search"
                          severity="danger"
                          aria-label="Cancel"
                          @click="showProducts(rowData)"
                        />
                      </div>
                    </template>
                  </Column>
                  <Column field="id" header="작성자"></Column>
                  <Column field="regDt" sortable header="작성일자"></Column>
                  <Column field="rprtCnt" sortable header="총신고수"></Column>
                  <Column
                    field="noneCnt"
                    sortable
                    header="미처리 신고수"
                  ></Column>
                </DataTable>
              </TabPanel>
              <!-- <TabPanel header="공고목록">
                <DataTable
                  style="clear: both"
                  ref="dataTable"
                  :value="notiList"
                  class="p-datatable-sm"
                  dataKey=""
                  showGridlines
                  sortField=""
                  paginator
                  :rows="10"
                  :rowsPerPageOptions="[5, 10, 20]"
                  tableStyle="min-width: 100%"
                  v-model:selection="selectedUser"
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
                  <Column field="" header="승인일자"></Column>
                  <Column field="" header="승인상태"></Column>
                  <Column field="rprtCnt" header="신고수"></Column>
                  <Column field="rprtSt" header="처리결과"></Column>
                  <Column field="dispoDt" header="처리일자"></Column>
                </DataTable>
              </TabPanel> -->
              <TabPanel header="댓글목록">
                <DataTable
                  style="clear: both"
                  ref="dataTable"
                  :value="replList"
                  class="p-datatable-sm"
                  dataKey=""
                  showGridlines
                  sortField=""
                  paginator
                  :rows="10"
                  :rowsPerPageOptions="[5, 10, 20]"
                  tableStyle="min-width: 100%"
                  v-model:selection="selectedUser"
                  selectionMode="sigle"
                >
                  <Column
                    selectionMode="multiple"
                    headerStyle="width: 3rem"
                  ></Column>
                  <Column field="" header="본문분류"></Column>
                  <Column field="" header="작성자"></Column>
                  <Column field="" header="작성일자"></Column>
                  <Column field="rprtCnt" header="신고수"></Column>
                  <Column field="rprtSt" header="처리결과"></Column>
                  <Column field="dispoDt" header="처리일자"></Column>
                </DataTable>
              </TabPanel>
            </TabView>
          </div>
        </div>
      </div>
    </div>
    <DynamicDialog />
    <toast />
  </section>
</template>
<script>
import BoardSearchForm1 from "@/components/searchForm/BoardSearchForm1.vue";
import BoardSearchForm3 from "@/components/searchForm/BoardSearchForm3.vue";
import DataTable from "primevue/datatable";
import Column from "primevue/column";
import Toast from "primevue/toast";
import TabView from "primevue/tabview";
import TabPanel from "primevue/tabpanel";
import { boardList } from "@/service/boardList.js";
import Button from "primevue/button";
import "primeicons/primeicons.css";
import DynamicDialog from "primevue/dynamicdialog";
import { defineAsyncComponent } from "vue";
const ReportModal = defineAsyncComponent(() =>
  import("../components/modal/ReportModal.vue")
);

export default {
  components: {
    DataTable,
    Column,
    Toast,
    TabView,
    TabPanel,
    BoardSearchForm1,
    BoardSearchForm3,
    Button,
    DynamicDialog,
  },
  data() {
    return {
      activeIndex: 0, //탭=>라디오
      active: 0, //라디오=>탭
      searchCondition: {},
      selectedBoard: null,
      metaKey: true,
      editableField: null,
      readonlyStyle: {
        backgroundColor: "#f5f5f5",
        cursor: "not-allowed",
      },
      boardList: [],
      replList: [],
      boardCondi: {
        title: "",
        id: "",
        postType: [],
        startDate: "",
        lastDate: "",
        prcsResult: [],
        prcsStart: "",
        prcsEnd: "",
      },
      descriptionColumnStyle: {
        width: "200px",
        overflow: "hidden",
        "text-overflow": "ellipsis",
        "white-space": "nowrap",
        "max-width": "200px",
      },
    };
  },

  mounted() {
    this.getBoardData().then((data) => {
      //배열합치기 spread operator
      this.boardList = [
        ...data.commVO,
        //...data.intrvVO,
        ...data.prjtVO,
        ...data.studyVO,
      ];
    });
  },
  methods: {
    getBoardData() {
      return boardList.getBoardData();
    },
    searchBtn() {
      console.log(this.boardCondi);
      // boardList.getSearchUser();
    },
    //모달창 시작
    showProducts(rowData) {
      const selectedRow = [rowData];
      const selectedNo = selectedRow[0].data.no;

      this.$dialog.open(ReportModal, {
        props: {
          header: "본문 내용",
          style: {
            width: "70vw",
          },
          breakpoints: {
            "960px": "75vw",
            "640px": "90vw",
          },
          modal: true,
        },
        data: {
          no: selectedNo,
        },
        onClose: (options) => {
          const data = options.data;
          if (data == null) {
            return;
          }
          this.$toast.add({
            severity: "info",
            summary: "신고처리수정에 성공했습니다.",
            detail: data,
            life: 3000,
          });
          this.getBoardData().then((data) => {
            this.boardList = [...data.commVO, ...data.prjtVO, ...data.studyVO];
          });
        },
      });
    },
    getDetail(rowData) {
      // 선택된 행의 데이터 가져오기
      const selectedRow = [rowData];
      console.log(selectedRow[0]);
      if (selectedRow && selectedRow.length > 0) {
        const selectedNo = selectedRow[0].data.no; // 선택된 행의 'no' 컬럼 값 가져오기
        const width = 1000;
        const height = 700;
        const left = (window.innerWidth - width) / 2;
        const top = (window.innerHeight - height) / 2;
        if (selectedNo.substr(0, 3) == "STD") {
          window.open(
            "/api/adminStudyDetial?studyNo=" + selectedNo,
            "popupWindow",
            `width=${width}, height=${height}, left=${left}, top=${top} location=no`
          );
        } else if (selectedNo.substr(0, 3) == "PRJ") {
          window.open(
            "/api/adminProjectDetail?prjtNo=" + selectedNo,
            "popupWindow",
            `width=${width}, height=${height}, left=${left}, top=${top} location=no`
          );
        } else {
          window.open(
            "/api/adminQnaDetail?qaNotiwrNo=" + selectedNo,
            "popupWindow",
            `width=${width}, height=${height}, left=${left}, top=${top} location=no`
          );
        }
      }
    },
    deleteList() {
      if (this.selectedBoard == null) {
        this.$toast.add({
          severity: "info",
          summary: "삭제할 유저정보를 선택하세요.",
          life: 2000,
        });
        return;
      }
      const nos = this.selectedBoard.map((item) => item.no);
      console.log(nos);
      boardList.removeBoard(nos).then((data) => {
        console.log(data);
        this.$toast.add({
          severity: "success",
          summary: "삭제 완료",
          detail: data + "의 정보가 삭제되었습니다.",
          life: 3000,
        });
        this.getBoardData().then((data) => {
          //배열합치기 spread operator
          this.boardList = [
            ...data.commVO,
            //...data.intrvVO,
            ...data.prjtVO,
            ...data.studyVO,
          ];
        });
      });
    },
  },
};
</script>
