<template>
  <section class="section">
    <div class="row">
      <div class="col-lg-12">
        <div class="card">
          <div class="card-body">
            <h3 class="card-title">공고예약현황</h3>
            <FullCalendar :options="calendarOptions" />
          </div>
        </div>
      </div>

      <div class="col-lg-12">
        <div class="card" style="min-height: 500px">
          <div class="card-body">
            <h3 class="card-title">월별 매출액</h3>
            <Chart type="bar" :data="chartData" :options="chartOptions" />
          </div>
        </div>
      </div>

      <div class="col-lg-12">
        <div class="card">
          <div class="card-body">
            <h3 class="card-title">결제내역</h3>
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
            <h3 class="card-title">Radar Chart</h3>
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
        weekends: true,
        events: [],
        eventColor: "#0A2640", // 기본 색상 설정
        contentHeight: "650px",
      },
      chartData: null,
      chartOptions: null,
      plist: [],
      columns: null,
    };
  },
  mounted() {
    this.getPayList().then((data) => {
      this.plist = data;
      this.chartData = this.setChartData();
      this.chartOptions = this.setChartOptions();
    });
    this.getReservList().then((data) => {
      this.calendarOptions.events = data;
    });
  },
  methods: {
    getPayList() {
      return PayService.getPayList();
    },
    getReservList() {
      return PayService.getReservList();
    },
    setChartData() {
      const documentStyle = getComputedStyle(document.documentElement);
      var arr1 = new Array(12).fill(0);
      var arr3 = new Array(12).fill(0);
      var arr5 = new Array(12).fill(0);
      console.log(this.plist);
      for (let obj of this.plist) {
        let product = obj.prdtNm;
        let month = obj.sttlDt.substr(5, 2);
        let price = parseInt(obj.totalPrice);
        if (product == "1회 이용권") {
          if (month == "01") {
            arr1[0] += price;
          } else if (month == "02") {
            arr1[1] += price;
          } else if (month == "03") {
            arr1[2] += price;
          } else if (month == "04") {
            arr1[3] += price;
          } else if (month == "05") {
            arr1[4] += price;
          } else if (month == "06") {
            arr1[5] += price;
          } else if (month == "07") {
            arr1[6] += price;
          } else if (month == "08") {
            arr1[7] += price;
          } else if (month == "09") {
            arr1[8] += price;
          } else if (month == "10") {
            arr1[9] += price;
          } else if (month == "11") {
            arr1[10] += price;
          } else {
            arr1[11] += price;
          }
        } else if (product == "3회 이용권") {
          if (month == "01") {
            arr3[0] += price;
          } else if (month == "02") {
            arr3[1] += price;
          } else if (month == "03") {
            arr3[2] += price;
          } else if (month == "04") {
            arr3[3] += price;
          } else if (month == "05") {
            arr3[4] += price;
          } else if (month == "06") {
            arr3[5] += price;
          } else if (month == "07") {
            arr3[6] += price;
          } else if (month == "08") {
            arr3[7] += price;
          } else if (month == "09") {
            arr3[8] += price;
          } else if (month == "10") {
            arr3[9] += price;
          } else if (month == "11") {
            arr3[10] += price;
          } else {
            arr3[11] += price;
          }
        } else {
          if (month == "01") {
            arr5[0] += price;
          } else if (month == "02") {
            arr5[1] += price;
          } else if (month == "03") {
            arr5[2] += price;
          } else if (month == "04") {
            arr5[3] += price;
          } else if (month == "05") {
            arr5[4] += price;
          } else if (month == "06") {
            arr5[5] += price;
          } else if (month == "07") {
            arr5[6] += price;
          } else if (month == "08") {
            arr5[7] += price;
          } else if (month == "09") {
            arr5[8] += price;
          } else if (month == "10") {
            arr5[9] += price;
          } else if (month == "11") {
            arr5[10] += price;
          } else {
            arr5[11] += price;
          }
        }
      }
      console.log(arr1);
      console.log(arr3);
      console.log(arr5);

      return {
        labels: [
          "1월",
          "2월",
          "3월",
          "4월",
          "5월",
          "6월",
          "7월",
          "8월",
          "9월",
          "10월",
          "11월",
          "12월",
        ],
        datasets: [
          {
            type: "bar",
            label: "1회 이용권",
            backgroundColor: documentStyle.getPropertyValue("--blue-500"),
            data: arr1,
          },
          {
            type: "bar",
            label: "3회 이용권",
            backgroundColor: documentStyle.getPropertyValue("--green-500"),
            data: arr3,
          },
          {
            type: "bar",
            label: "5회 이용권",
            backgroundColor: documentStyle.getPropertyValue("--yellow-500"),
            data: arr5,
          },
        ],
      };
    },
    setChartOptions() {
      const documentStyle = getComputedStyle(document.documentElement);
      const textColor = documentStyle.getPropertyValue("--text-color");
      const textColorSecondary = documentStyle.getPropertyValue(
        "--text-color-secondary"
      );
      const surfaceBorder = documentStyle.getPropertyValue("--surface-border");

      return {
        maintainAspectRatio: true,
        plugins: {
          tooltips: {
            mode: "index",
            intersect: false,
          },
          legend: {
            labels: {
              color: textColor,
            },
          },
        },
        scales: {
          x: {
            stacked: true,
            ticks: {
              color: textColorSecondary,
            },
            grid: {
              color: surfaceBorder,
            },
          },
          y: {
            stacked: true,
            ticks: {
              color: textColorSecondary,
            },
            grid: {
              color: surfaceBorder,
            },
          },
        },
      };
    },
  },
};
</script>
