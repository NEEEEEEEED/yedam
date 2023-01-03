const http = require("http");
const cookie = require("cookie");
/* const server = http.createServer((req, res) => {
  res.end("hello");
});

server.listen(3000); */
//매서드 체인
http
  .createServer((req, res) => {
    //쿠키읽기
    let cookies;
    if (req.headers.cookie) {
      cookies = cookie.parse(req.headers.cookie);
      console.log(cookies.username);
    }
    console.log(cookies);
    // 쿠키설정;
    res.writeHead(200, {
      "Set-Cookie": [
        "  yummy_cookie=choco",
        `username=hong; Max-Age=${5 * 60}; HttpOnly; Path=/user`,
      ],
    });

    res.end("hello");
  })
  .listen(3000, () => {
    console.log("server running http://localhost:3000");
  });
