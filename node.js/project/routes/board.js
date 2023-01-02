var express = require("express");
const pool = require("../project_DB/pool");
var router = express.Router();

sql = {
  select: "select * from project.board limit 10",
  selectOne: "select * from project.board where no =? ",
  insert: "insert into project.board set ?",
  update: "update project.board set ? where no=?",
  delete: "delete from project.board where no=?",
  scoreselect: "select * from project.board order by yscore desc ",
};

//전체조회
router.get("/", function (req, res) {
  pool.query(sql.select, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    res.json(results);
  });
});
//점수조회
router.get("/", function (req, res) {
  pool.query(sql.scoreselect, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    res.json(results);
  });
});
//단건조회
router.get("/:no", (req, res) => {
  const no = req.params.no;
  pool.query(sql.selectOne, no, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    res.json(results[0]);
  });
});

//등록
router.post("/", function (req, res) {
  pool.query(sql.insert, req.body, function (err, results, fields) {
    res.json(results);
    console.log(err);
  });
});
//수정
router.put("/:no", (req, res) => {
  let data = [req.body, req.params.no];
  pool.query(sql.update, data, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    res.json(results);
  });
});
//삭제
router.delete("/:no", function (req, res) {
  const no = req.params.no;
  pool.query(sql.delete, no, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    res.json(results);
  });
});

module.exports = router;
