const http = require("http"); //http.js http 객체 참조
const fs = require("fs");
// import total from "./01server.js";
// 서버 선언(클라이언트 요청 시 호출(처리)될 핸들러)
const server = http.createServer((req, res) => {
  const myUrl = new URL("http://localhost:3000" + req.url);
  console.log("pathname:", myUrl.pathname);
  console.log("searchParams:", myUrl.searchParams);
  if (myUrl.pathname.startsWith("/page")) {
    const pagename = "./template" + myUrl.pathname.substring(5) + ".html";
    fs.readFile(pagename, "utf8", (err, data) => {
      res.end(data);
    });
  } else {
    res.end("no path");
  }
});

server.listen(3000, () => {
  console.log("server running http://localhost:3000");
});
