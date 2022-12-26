/*과제_work.js*/
// import http from 'http'; 아래와 동일 결과, 방식다름
const http = require("http");

let todoList = [
  { content: "test1", completed: false },
  { content: "test2", completed: true },
  { content: "test3", completed: false },
  { content: "test4", completed: false },
];

const server = http.createServer((req, res) => {
  const myURL = new URL("http://127.0.0.1:3000" + req.url);
  if (myURL.pathname == "/todoList") {
    res.end(JSON.stringify(todoList));
  } else if (myURL.pathname == "/todo") {
    let no = myURL.searchParams.get("no");
    res.end(JSON.stringify(todoList[no]));
  }
});
server.listen(3000, () => {
  console.log("server running http://127.0.0.1:3000");
});
