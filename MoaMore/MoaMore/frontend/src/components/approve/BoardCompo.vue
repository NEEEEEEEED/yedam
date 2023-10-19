<template>
  <section class="section">
    <div class="pagetitle">
      <h1>승인게시물관리</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/admin">Home</a></li>
          <li class="breadcrumb-item active">승인게시물관리</li>
        </ol>
      </nav>
    </div>

    <div class="card">
      <div class="card-body">
        <p class="card-title">검색조건</p>
        <form class="row g-3">
          <div class="row" style="margin-bottom: 10px">
            <span class="col-sm-1 col-form-label">회원</span>
            <div class="col-md-5">
              <div
                class="form-check form-check-inline"
                style="padding-top: 6px"
              >
                <label for="recruit" class="form-check-label">구인공고</label>
                <input id="recruit" type="checkbox" class="form-check-input" />
              </div>
              <div
                class="form-check form-check-inline"
                style="padding-top: 6px"
              >
                <label for="self" class="form-check-label">구직공고</label>
                <input id="self" type="checkbox" class="form-check-input" />
              </div>
              <div
                class="form-check form-check-inline"
                style="padding-top: 6px"
              >
                <label for="interview" class="form-check-label">면접후기</label>
                <input
                  id="interview"
                  type="checkbox"
                  class="form-check-input"
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
            <span class="col-sm-1 col-form-label">작성자</span>
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
          <div class="row" style="margin-bottom: 10px">
            <span class="col-sm-1 col-form-label">제목</span>
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
        <div class="card" style="min-height: 637px">
          <div class="card-body">
            <span
              class="p-buttonset"
              data-v-d3f5b421=""
              style="float: right; padding-top: 10px; padding-bottom: 10px"
              ><button
                class="p-button p-component"
                type="button"
                aria-label="Save"
                data-v-d3f5b421=""
                @click="approveBtn"
              >
                <!----><span
                  class="pi pi-check p-button-icon p-button-icon-left"
                ></span
                ><span class="p-button-label">승인</span
                ><!----><span
                  class="p-ink"
                  role="presentation"
                  aria-hidden="true"
                ></span>
              </button>

              <button
                class="p-button p-component"
                type="button"
                aria-label="Cancel"
                data-v-d3f5b421=""
                @click="approveCancelBtn"
              >
                <!----><span
                  class="pi pi-times p-button-icon p-button-icon-left"
                ></span
                ><span class="p-button-label">승인취소</span
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
                @click="deleteBtn"
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
              :value="ApproveList"
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
                :body-style="titleStyle"
              ></Column>
              <Column header="본문" :body-style="ColumnStyle">
                <template #body="rowData">
                  <div class="g-3" style="text-align: center">
                    <Button icon="pi pi-search" @click="getDetail(rowData)" />
                  </div>
                </template>
              </Column>
              <Column field="id" header="작성자"></Column>
              <Column field="regDt" sortable header="작성일자"></Column>
              <Column field="accpDt" sortable header="승인날짜"></Column>
            </DataTable>
          </div>
        </div>
      </div>
    </div>
    <toast />
  </section>
</template>
<script>
import DataTable from "primevue/datatable";
import Column from "primevue/column";
import Toast from "primevue/toast";
import { reportList } from "@/service/ApproveService.js";
import Button from "primevue/button";
import "primeicons/primeicons.css";

export default {
  components: {
    DataTable,
    Column,
    Toast,
    Button,
  },
  data() {
    return {
      ApproveList: [],
      selectedBoard: null,
      ColumnStyle: {
        width: "66px",
        "max-width": "66px",
      },
      titleStyle: {
        width: "200px",
        overflow: "hidden",
        "text-overflow": "ellipsis",
        "white-space": "nowrap",
        "max-width": "200px",
      },
    };
  },

  mounted() {
    this.getApprvList().then((data) => {
      //배열합치기 spread operator
      this.ApproveList = [...data.hireVO, ...data.intrvVO, ...data.selfVO];
    });
  },
  methods: {
    getApprvList() {
      return reportList.getApprvList();
    },
    getDetail(rowData) {
      // 선택된 행의 데이터 가져오기
      const selectedRow = [rowData];
      if (selectedRow && selectedRow.length > 0) {
        // 선택된 행의 'no' 컬럼 값 가져오기
        const selectedNo = selectedRow[0].data.no;
        let resumeNo = "";
        if (selectedRow[0].data.resumeNo) {
          resumeNo = selectedRow[0].data.resumeNo;
        }
        const width = 800;
        const height = 700;
        const left = (window.innerWidth - width) / 2;
        const top = (window.innerHeight - height) / 2;
        if (selectedNo.substr(0, 3) == "REA") {
          window.open(
            "/api/adminReaDetail?recruitNo=" + selectedNo,
            "popupWindow",
            `width=${width}, height=${height}, left=${left}, top=${top} location=no`
          );
        } else if (selectedNo.substr(0, 3) == "JSN") {
          window.open(
            "/api/adminJSNDetail?jobSearchNo=" +
              selectedNo +
              "&resumeNo=" +
              resumeNo,
            "popupWindow",
            `width=${width}, height=${height}, left=${left}, top=${top} location=no`
          );
        } else {
          window.open(
            "/api/adminITVDetail?intrvNo=" + selectedNo,
            "popupWindow",
            `width=${width}, height=${height}, left=${left}, top=${top} location=no`
          );
        }
      }
    },
    deleteBtn() {
      if (this.selectedBoard == null) {
        this.$toast.add({
          severity: "info",
          summary: "삭제할 게시물을 선택하세요.",
          life: 2000,
        });
        return;
      }
      const nos = this.selectedBoard.map((item) => item.no);
      console.log(nos);
      reportList.removeBoard(nos).then((data) => {
        console.log(data);
        this.$toast.add({
          severity: "success",
          summary: "삭제 완료",
          detail: data + "의 정보가 삭제되었습니다.",
          life: 3000,
        });
        this.getApprvList().then((data) => {
          //배열합치기 spread operator
          this.ApproveList = [...data.hireVO, ...data.intrvVO, ...data.selfVO];
          this.selectedBoard = null;
        });
      });
    },
    approveBtn() {
      if (this.selectedBoard == null) {
        this.$toast.add({
          severity: "info",
          summary: "승인할 게시물을 선택하세요.",
          life: 2000,
        });
        return;
      }
      const nos = this.selectedBoard.map((item) => item.no);
      console.log(nos);
      reportList.approveBoard(nos).then((data) => {
        this.$toast.add({
          severity: "success",
          summary: "승인 완료",
          detail: data + "의 정보가 승인되었습니다.",
          life: 3000,
        });
        this.getApprvList().then((data) => {
          this.ApproveList = [...data.hireVO, ...data.intrvVO, ...data.selfVO];
          this.selectedBoard = null;
        });
      });
    },
    approveCancelBtn() {
      if (this.selectedBoard == null) {
        this.$toast.add({
          severity: "info",
          summary: "승인취소할 게시물을 선택하세요.",
          life: 2000,
        });
        return;
      }
      const nos = this.selectedBoard.map((item) => item.no);
      console.log(nos);
      reportList.approveCancelBoard(nos).then((data) => {
        console.log(data);
        this.$toast.add({
          severity: "success",
          summary: "승인 취소 완료",
          detail: data + "의 정보가 승인 취소되었습니다.",
          life: 3000,
        });
        this.getApprvList().then((data) => {
          //배열합치기 spread operator
          this.ApproveList = [...data.hireVO, ...data.intrvVO, ...data.selfVO];
          this.selectedBoard = null;
        });
      });
    },
  },
};
</script>
