<template>
  <section class="section">
    <div class="pagetitle">
      <h1>승인게시물관리</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item active">승인게시물관리</li>
        </ol>
      </nav>
    </div>

    <div class="card">
      <div class="card-body">
        <p class="card-title">검색조건</p>
        <form class="row g-3">
          <div class="row">
            <div class="col-md-8"></div>
            <div class="col-md-3"></div>
          </div>
        </form>
      </div>
    </div>

    <div class="row">
      <div class="col-md-12 grid-margin stretch-card">
        <div class="card" style="min-height: 100%">
          <div class="card-body">
            <div
              class="mt-1 mb-1"
              style="float: right; position: relative; z-index: 2"
            >
              <Button
                label="success"
                severity="success"
                style="margin-left: 5px"
                @click="approveBtn"
                >승인</Button
              >
              <Button
                label="secondary"
                severity="secondary"
                style="margin-left: 5px"
                @click="approveCancelBtn"
                >승인취소</Button
              >
              <Button
                label="Danger"
                severity="danger"
                style="margin-left: 5px"
                @click="deleteBtn"
                >삭제</Button
              >
            </div>
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
    <DynamicDialog />
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
import DynamicDialog from "primevue/dynamicdialog";
//import { defineAsyncComponent } from "vue";
//const ReportModal = defineAsyncComponent(() =>
//  import("../components/modal/ReportModal.vue")
//);

export default {
  components: {
    DataTable,
    Column,
    Toast,
    Button,
    DynamicDialog,
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
      console.log(selectedRow[0]);
      if (selectedRow && selectedRow.length > 0) {
        const selectedNo = selectedRow[0].data.no; // 선택된 행의 'no' 컬럼 값 가져오기
        let resumeNo = "";
        if (selectedRow[0].data.resumeNo) {
          resumeNo = selectedRow[0].data.resumeNo;
        }
        console.log(resumeNo);
        console.log(selectedNo);
        const width = 800;
        const height = 700;
        const left = (window.innerWidth - width) / 2;
        const top = (window.innerHeight - height) / 2;
        if (selectedNo.substr(0, 3) == "REA") {
          window.open(
            "http://localhost:8000/adminReaDetail?recruitNo=" + selectedNo,
            "popupWindow",
            `width=${width}, height=${height}, left=${left}, top=${top} location=no`
          );
        } else if (selectedNo.substr(0, 3) == "JSN") {
          window.open(
            "http://localhost:8000/adminJSNDetail?jobSearchNo=" +
              selectedNo +
              "&resumeNo=" +
              resumeNo,
            "popupWindow",
            `width=${width}, height=${height}, left=${left}, top=${top} location=no`
          );
        } else {
          window.open(
            "http://localhost:8000/adminITVDetail?intrvNo=" + selectedNo,
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
        console.log(data);
        this.$toast.add({
          severity: "success",
          summary: "승인 완료",
          detail: data + "의 정보가 승인되었습니다.",
          life: 3000,
        });
        this.getApprvList().then((data) => {
          //배열합치기 spread operator
          this.ApproveList = [...data.hireVO, ...data.intrvVO, ...data.selfVO];
        });
      });
    },
    approveCancelBtn() {
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
        });
      });
    },
  },
};
</script>
