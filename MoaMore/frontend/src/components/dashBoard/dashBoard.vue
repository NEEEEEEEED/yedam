<template>
  <section class="section">
    <div class="row">
      <div class="col-lg-12">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">월별 매출액</h5>
            <Chart type="bar" :data="chartData" :options="chartOptions" />
          </div>
        </div>
      </div>

      <div class="col-lg-12">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Pie Chart</h5>
            <DataTable :value="plist" tableStyle="min-width: 50rem">
              <Column field="orderNo" header="주문번호"></Column>
              <Column field="id" header="구매자"></Column>
              <Column field="prdtNm" header="구매상품"></Column>
              <Column field="totalPrice" header="결제금액"></Column>
              <Column field="recruitNo" header="적용공고"></Column>
              <Column field="sttlDt" header="결제일자"></Column>
              <Column field="reserDts" header="예약일자"></Column>
            </DataTable>
          </div>
        </div>
      </div>

      <div class="col-lg-6">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Doughnut Chart</h5>
          </div>
        </div>
      </div>

      <div class="col-lg-6">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Radar Chart</h5>
          </div>
        </div>
      </div>

      <div class="col-lg-6">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Polar Area Chart</h5>
          </div>
        </div>
      </div>

      <div class="col-lg-6">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Stacked Bar Chart</h5>
          </div>
        </div>
      </div>

      <div class="col-lg-6">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Bubble Chart</h5>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import Chart from "primevue/chart";
import DataTable from "primevue/datatable";
import Column from "primevue/column";
import { PayService } from "@/service/PayService.js";
export default {
  components: { Chart, DataTable, Column },
  data() {
    return {
      chartData: {
        labels: ["Q1", "Q2", "Q3", "Q4"],
        datasets: [
          {
            label: "Sales",
            data: [],
            backgroundColor: [
              "rgba(255, 159, 64, 0.2)",
              "rgba(75, 192, 192, 0.2)",
              "rgba(54, 162, 235, 0.2)",
              "rgba(153, 102, 255, 0.2)",
            ],
            borderColor: [
              "rgb(255, 159, 64)",
              "rgb(75, 192, 192)",
              "rgb(54, 162, 235)",
              "rgb(153, 102, 255)",
            ],
            borderWidth: 1,
          },
        ],
      },
      chartOptions: {
        scales: {
          y: {
            beginAtZero: true,
          },
        },
      },
      plist: [],
      columns: null,
    };
  },
  mounted() {
    this.getPayList().then((data) => (this.plist = data));
  },
  methods: {
    getPayList() {
      return PayService.getPayList();
    },
  },
};
</script>
