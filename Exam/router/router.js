import main from "../components/main.js";
import movieList from "../components/movieList.js";
import movieDetail from "../components/movieDetail.js";

export default new VueRouter({
  // hash -> # + 경로 (server로 요청을 보내지 않고 페이지 이동)
  // url # 뒤에 있는 내용을 읽을 수가 없습니다.
  // history -> #을 제외하고 SPA 구현하기 위한 모드
  // mode default : hash
  mode: "history",
  routes: [
    //main
    {
      path: "/",
      name: "main",
      component: main,
    },
    {
      path: "/movieList",
      name: "movieList",
      component: movieList,
    },
    {
      path: "/movieDetail/:item",
      name: "movieDetail",
      component: movieDetail,
      props: true,
    },
  ],
});
