<template>
  <section class="section">
    <div class="row">
      <div class="col-lg-12">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">공고예약현황</h5>
            <FullCalendar :options="calendarOptions" />
          </div>
        </div>
      </div>

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
            <h5 class="card-title">Radar Chart</h5>
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
import FullCalendar from "@fullcalendar/vue3";
import dayGridPlugin from "@fullcalendar/daygrid";

export default {
  components: { Chart, DataTable, Column, FullCalendar },
  data() {
    return {
      calendarOptions: {
        plugins: [dayGridPlugin],
        initialView: "dayGridMonth",
        weekends: false,
        events: [],
        eventColor: "default", // 기본 색상 설정
      },
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
    this.getPayList().then((data) => {
      this.plist = data;
    });
    this.getReservList().then((data) => {
      this.calendarOptions.events = data;
      this.setEventColors(); // 일정 색상 설정
    });
  },
  methods: {
    getPayList() {
      return PayService.getPayList();
    },
    getReservList() {
      return PayService.getReservList();
    },
    setEventColors() {
      const events = this.calendarOptions.events;
      events.forEach((event, index) => {
        const colors = ["red", "blue", "green", "yellow", "orange"]; // 5가지 색상
        const color = colors[index % colors.length]; // 순환하면서 색상 선택
        event.backgroundColor = color; // 일정의 배경색 설정
      });
    },
    eventDidMount(info) {
      const colors = ["red", "blue", "green", "yellow", "orange"]; // 5가지 색상
      const index = this.calendarOptions.events.findIndex(
        (event) => event === info.event
      );
      const color = colors[index % colors.length]; // 순환하면서 색상 선택
      info.el.style.backgroundColor = color; // 일정 요소의 배경색 설정
    },
  },
};
</script>
