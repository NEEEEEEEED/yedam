const http = require("http");
let infoArr = [];
infoArr["kim"] = { name: "김유신", hobby: "게임" };
infoArr["park"] = { name: "박기자", hobby: "독서" };

const server = http.createServer((req, res) => {
  const myurl = new URL("http://127.0.0.1:3000" + req.url);
  console.log(myurl.pathname);
  console.log(myurl.searchParams);
  if (myurl.pathname == "/") {
    res.end("main");
  } else if (myurl.pathname == "/info") {
    /* res.setHeader("content-type", "text/html"); //mime type - 파일 형식
    let html = ` */
    let userid = myurl.searchParams.get("userid");
    res.end(info(userid));
  } else if (myurl.pathname == "/boardReg") {
    res.end(boardReg());
  } else if (myurl.pathname == "/boardRegAction") {
    let title = myurl.searchParams.get("title");
    let content = myurl.searchParams.get("content");
    res.end("등록완료");
    console.log(title);
    console.log(content);
  } else if (myurl.pathname == "/userReg") {
    res.end(userReg());
  } else if (myurl.pathname == "/userRegAction") {
    let userid = myurl.searchParams.get("userid");
    let username = myurl.searchParams.get("username");
    let pw = myurl.searchParams.get("pw");
    let hp = myurl.searchParams.get("hp");
    console.log(userid);
    console.log(username);
    console.log(pw);
    console.log(hp);
    res.end("등록완료");
  } else {
    res.statusCode = 404;
    res.end();
  }
});

server.listen(3000, () => {
  console.log("surver is running http://127.0.0.1:3000");
}); //서버구축

function info(userid) {
  if (!userid || !infoArr[userid]) {
    return "no user";
  }
  let html = `
    <!DOCTYPE html>
      <html lang="en">
      <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>info.html</title>
      </head>
      <body>
        <h3>my info</h3>
        <div>id: ${userid ? userid : ""}</div>
        <div>이름: ${infoArr[userid].name}</div>
        <div>취미: ${infoArr[userid].hobby}</div>
      </body>
      </html>`;
  return html;
}
function boardReg() {
  let board = `
    <!DOCTYPE html>
    <html lang="en">
      <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
        <style>
          div {
            margin-bottom: 10px;
          }
        </style>
      </head>
      <body>
        <h3>!@@@게시글 작성!</h3>
        <form action="/boardRegAction">
          <div>@123제목123@<input type="text" name="title" /></div>
          <div>
            @내용@<textarea id="text" name="content" cols="40" rows="20"></textarea>
          </div>
          <div><button>버튼</button></div>
        </form>
      </body>
    </html>`;
  return board;
}
function userReg() {
  let userReg = `
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <form action="userRegAction">
  <div><input type="text" name="userid" placeholder="userid"></div>
  <div><input type="text" name="username" placeholder="username"></div>
  <div><input type="text" name="pw" placeholder="pw"></div>
  <div><input type="text" name="hp" placeholder="hp"></div>
  <div><button>버튼</button></div>
  </form>
</body>
</html>
  `;
  return userReg;
}
