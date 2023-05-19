<template>
  <div>
    <DataTable
      :value="rprtList"
      v-model:selection="selectedRprt"
      dataKey="rprtNo"
    >
      <Column selectionMode="multiple" headerStyle="width: 3rem"></Column>
      <Column field="rprtNo" header="신고번호"></Column>
      <Column field="rprter" header="신고자"></Column>
      <Column field="rprtResn" header="신고사유"></Column>
      <Column field="rprtTm" header="신고날짜"></Column>
      <Column field="rprtSt" header="처리상태"></Column>
      <Column style="width: 5rem">
        <template #body="rowdata">
          <div class="card flex justify-content-center" style="margin: 0px">
            <Dropdown
              v-model="rowdata.data.selectedSt"
              :options="status"
              optionLabel="name"
              placeholder="신고처리"
              class="w-full md:w-14rem"
            />
          </div>
        </template>
      </Column>
    </DataTable>
    <br />
    <Button
      type="button"
      label="Cancel"
      icon="pi pi-times"
      @click="closeDialog()"
      text
    ></Button>
    <Button
      type="button"
      label="Save"
      icon="pi pi-check"
      @click="saveDialog()"
      autofocus
    ></Button>
    <toast />
  </div>
</template>

<script>
import DataTable from "primevue/datatable";
import Column from "primevue/column";
import { reportList } from "@/service/ReportService.js";
import "primeicons/primeicons.css";
import Dropdown from "primevue/dropdown";
import Button from "primevue/button";
import Toast from "primevue/toast";
export default {
  inject: ["dialogRef"],
  props: ["no"],
  components: {
    Dropdown,
    DataTable,
    Column,
    Button,
    Toast,
  },
  data() {
    return {
      selectedRprt: null,
      rprtList: [],
      status: [],
    };
  },
  async mounted() {
    console.log(this.dialogRef.data.no);
    reportList.getReportData(this.dialogRef.data.no).then((data) => {
      this.rprtList = data.list;
      this.status = data.rprt;
      for (let i = 0; i < this.rprtList.length; i++) {
        // 각 아이템의 selectedSt를 초기값으로 설정
        this.rprtList[i].selectedSt = {};
        for (let j = 0; j < this.status.length; j++) {
          if (this.rprtList[i].rprtSt === this.status[j].name) {
            this.rprtList[i].selectedSt = this.status[j];
          }
        }
      }
    });
  },
  methods: {
    selectProduct(data) {
      this.dialogRef.close(data);
    },
    saveDialog() {
      if (this.selectedRprt == null) {
        this.$toast.add({
          severity: "info",
          summary: "수정할 신고내역을 선택해주세요",
          life: 1000,
        });
        return;
      }
      let voList = [];
      for (let j = 0; j < this.selectedRprt.length; j++) {
        let rprtVO = {};
        console.log(this.selectedRprt[j].selectedSt.code);
        console.log(this.selectedRprt[j].rprtNo);
        rprtVO.rprtNo = this.selectedRprt[j].rprtNo;
        rprtVO.rprtSt = this.selectedRprt[j].selectedSt.code;
        voList.push(rprtVO);
      }
      console.log(voList);
      reportList.modifyRprt(voList).then((data) => {
        this.dialogRef.close(data);
      });
    },
    closeDialog() {
      this.dialogRef.close();
    },
  },
};
</script>
