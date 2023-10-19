export default {
  template: `
            <header>
              <h2>영화 검색 게시판</h2>
              <p>영화 검색(오늘 날짜 : {{today}})</p>
              <input type="date"/>
              <button v-on:click="loadData()">검색</button>
            </header>
            `,
  props: ["parentData"],
  methods: {
    loadData: function () {
      // 파일을 읽어들이는 메소드
      let selectDate = document.querySelector("input").value;

      let date = new Date();
      let year = date.getFullYear();
      let month = String(date.getMonth() + 1);
      let day = String(date.getDate());
      if (month.length == 1) month = "0" + month;
      if (day.length == 1) day = "0" + day;
      let today = year + month + day;

      let dateForm = selectDate.replace(/\-/g, "");

      if (dateForm >= today) {
        alert("오늘 이전의 날짜를 입력하세요");
        return;
      }

      if (dateForm) {
        fetch(
          "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=" +
            dateForm
        )
          .then((response) => response.json())
          .then((data) => {
            this.parentData.dataArray = data.boxOfficeResult.dailyBoxOfficeList;
            this.$emit("update:parentData", this.parentData);
            this.$router.push({ name: "movieList" });
          })
          .catch((err) => console.log(err));
      } else {
        alert("날짜를 입력하세요.");
      }
    },
  },
  computed: {
    today: function () {
      let date = new Date();
      let year = date.getFullYear();
      let month = String(date.getMonth() + 1);
      let day = String(date.getDate());
      let edate = year + " 년 " + month + " 월 " + day + " 일 ";
      return edate;
    },
  },
};
