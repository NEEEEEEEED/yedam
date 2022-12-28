/*과제_work.js*/
// import http from 'http'; 아래와 동일 결과, 방식다름
// http 모듈 포함
const http = require("http");
// 배열 생성
let todoList = [
  { content: "test1", completed: false },
  { content: "test2", completed: true },
  { content: "test3", completed: false },
  { content: "test4", completed: false },
];
//http 서버생성
const server = http.createServer((req, res) => {
  // 새로운 요청 수신되면 request 이벤트 호출
  // URL을 도메인과 path, parameters로 구분
  const myURL = new URL("http://127.0.0.1:3000" + req.url);
  // pathname찾기
  if (myURL.pathname == "/todoList") {
    res.end(JSON.stringify(todoList));
  } else if (myURL.pathname == "/todo") {
    //parameters 찾기
    let no = myURL.searchParams.get("no");
    res.end(JSON.stringify(todoList[no]));
  }
});
// 지정된 포트 및 호스트 이름(도메인)으로 수신대기
server.listen(3000, () => {
  // 서버 준비되면 콜백함수 호출
  console.log("server running http://127.0.0.1:3000");
});
