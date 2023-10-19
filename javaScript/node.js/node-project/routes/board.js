//라우드 찾기위해 코드가 너무 길어지는 것에 대한 대책
import { Router } from "express";
const route = Router();

//매소드 타입별 라우트 찾기
route
  .get("/", (req, res) => {
    //query string 방식으로 req가 왔을 경우(?writer=kim&wdt=20221228)
    console.log("writer:", req.query.writer);
    console.log("wdt:", req.query.wdt);
    res.send("board get");
  })
  .post("/", (req, res) => {
    console.log("title :", req.body);
    res.send("board post");
  })
  .put("/", (req, res) => {
    res.send("board put");
  })
  .delete("/:boardno", (req, res) => {
    console.log("boardno:", req.params.boardno);
    res.send("board delete");
  });

export default route;
