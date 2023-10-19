<template>
  <div>
    <button type="button" @click="getData">데이터 출력</button>
    <table>
      <thead>
        <tr>
          <th>지역</th>
          <th>미세먼지 농도/대기질</th>
          <th>초미세먼지 농도/대기질</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in seoulArray" :key="item.idx">
          <td>{{ item.MSRSTE_NM }}</td>
          <td>{{ item.PM10 }} / {{ item.status }}</td>
          <td>{{ item.PM25 }} / {{ item.status }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
export default {
  data() {
    return {
      seoulArray: [],
    };
  },
  methods: {
    getData() {
      fetch(
        "http://openapi.seoul.go.kr:8088/6d4d776b466c656533356a4b4b5872/json/RealtimeCityAir/1/99"
      )
        .then((res) => res.json())
        .then((data) => {
          console.log(data.RealtimeCityAir.row);
          this.seoulArray = data.RealtimeCityAir.row;
          console.log(this.seoulArray);
          for (let i = 0; i < this.seoulArray.length; i++) {
            if (this.seoulArray[i].PM10 <= 50) {
              this.seoulArray[i].status = "좋음";
            } else {
              this.seoulArray[i].status = "나쁨";
            }
            if (this.seoulArray[i].PM25 <= 20) {
              this.seoulArray[i].status25 = "좋음";
            } else {
              this.seoulArray[i].status25 = "나쁨";
            }
          }
        })
        .catch((err) => console.log(err));
    },
  },
};
</script>
