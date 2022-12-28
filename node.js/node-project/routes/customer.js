//라우드 찾기위해 코드가 너무 길어지는 것에 대한 대책
import { Router } from "express"; //express모듈을 가져옴
const route = Router();

route
  .get("/", (req, res) => {
    res.send("customer get");
  })
  .post("/", (req, res) => {
    res.send("customer post");
  })
  .put("/", (req, res) => {
    res.send("customer put");
  })
  .delete("/", (req, res) => {
    res.send("customer delete");
  });

export default route;
