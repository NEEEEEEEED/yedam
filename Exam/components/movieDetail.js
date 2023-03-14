export default {
  template: `
          <div>
            <p>제목 : {{movieDetail.movieNm}}</p>
                <div id="list">
                  <ul>
                    <li>배우 : <span v-for="name in movieDetail.actors"> {{name.peopleNm}}</span></li>
                    <li>감독 : <span v-for="director in movieDetail.directors"> 한글 - {{director.peopleNm}} / 영문 - {{director.peopleNmEn}}</span></li>
                    <li>장르 : <span v-for="genre in movieDetail.genres"> {{genre.genreNm}}</span></li>
                    <li>상영시간 : {{movieDetail.showTm}}분</li>
                  </ul>
                </div>
                <router-link 
                  tag="button" 
                  style="float:right;" 
                  v-bind:to="{name:'movieList'}">
                목록</router-link>
            </div>
`,
  data: function () {
    return {
      movieDetail: {},
    };
  },
  props: ["item"],
  created: function () {
    fetch(
      "	http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=" +
        this.item.movieCd
    )
      .then((response) => response.json())
      .then((data) => {
        this.movieDetail = data.movieInfoResult.movieInfo;
      })
      .catch((err) => console.log(err));
  },
};
