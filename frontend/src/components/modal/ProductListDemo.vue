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
          <Button
            type="button"
            icon="pi pi-plus"
            text
            rounded
            @click="selectProduct(slotProps.data)"
          ></Button>
        </template>
      </Column>
    </DataTable>
  </div>
</template>

<script>
import Button from "primevue/button";
import DataTable from "primevue/datatable";
import Column from "primevue/column";
import { reportList } from "@/service/ReportService.js";
export default {
  inject: ["dialogRef"],
  props: ["No"],
  components: {
    Button,
    DataTable,
    Column,
  },
  data() {
    return { rprtList: [] };
  },
  mounted() {
    console.log(this.$props.No);
    reportList
      .getReportData(this.$props.No)
      .then((data) => (this.rprtList = data));
  },
  methods: {
    selectProduct(data) {
      this.dialogRef.close(data);
    },
  },
};
</script>
