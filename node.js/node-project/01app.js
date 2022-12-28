import express from "express";
import boardRouter from "./routes/board.js";
import customerRounter from "./routes/customer.js";
const app = express();
const port = 3000;

app.get("/logIn", function (req, res) {
  console.log(req.query.email);
  res.send("로그인완료");
});
//이거뭐임
app.use(express.urlencoded({ extended: false }));

//body를 parsing 해줌으로써 req.body를 받을 수 있게해줌,
// 위에 올려서 다른 애들이 json을 읽을 수 있게 만들어줘야함
app.use(express.json());

app.use(express.static("public"));
app.use("/board", boardRouter);
app.use("/customer", customerRounter);
app.use(function (err, req, res, next) {
  res.status(500).json({ code: res.statusCode, msg: err.message });
});
app.get("/", (req, res) => {
  res.send("hello world!!!!!");
});
// /정규표현식을 이용해서 라우트 찾기
app.get("/ab+cd", (req, res) => {
  res.send("정규표현식");
});
app.listen(port, () => {
  console.log(`server runing http://localhost:${port}`);
});
//핸들러가 2개
app.get(
  "/example",
  (req, res, next) => {
    // throw new Error("에러발생");
    console.log("첫번째 콜백");
    next();
  },
  (req, res) => {
    res.send("두번째 콜백");
  }
);
