<template>
  <div>
    <DataTable :value="rprtList">
      <Column field="notiwrNo" header="게시글번호"></Column>
      <Column field="rprter" header="신고자"></Column>
      <Column field="rprtResn" header="신고사유"></Column>
      <Column field="rprtTm" header="신고날짜"></Column>
      <Column field="rprtSt" header="처리상태"></Column>
      <Column style="width: 5rem">
        <template #body="slotProps">
          <div
            v-if="slotProps.data.rprtSt === '미처리'"
            class="card flex justify-content-center"
            style="margin: 0px"
          >
            <Dropdown
              v-model="selectedSt"
              editable
              :options="status"
              optionLabel="name"
              placeholder="Select a City"
              class="w-full md:w-14rem"
            />
          </div>
        </template>
      </Column>
    </DataTable>
  </div>
</template>

<script>
import DataTable from "primevue/datatable";
import Column from "primevue/column";
import { reportList } from "@/service/ReportService.js";
import "primeicons/primeicons.css";
import Dropdown from "primevue/dropdown";

export default {
  inject: ["dialogRef"],
  props: ["no"],
  components: {
    Dropdown,
    DataTable,
    Column,
  },
  data() {
    return {
      rprtList: [],
      selectedSt: null,
      status: [],
    };
  },
  async mounted() {
    console.log(this.dialogRef.data.no);
    reportList.getReportData(this.dialogRef.data.no).then((data) => {
      this.rprtList = data.list;
      this.status = data.rprt;
    });
  },
  methods: {
    selectProduct(data) {
      this.dialogRef.close(data);
    },
  },
};
</script>
