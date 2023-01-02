var express = require("express");
const pool = require("../project_DB/pool");
var router = express.Router();
const http = require("http");

sql = {
  select: "select * from board limit 10 offset 1",
  selectOne: "select * from board where no =? ",
  insert: "insert into board set ?",
  update: "update board set ? where no=?",
  delete: "delete from board where no=?",
  scoreselect: "select * from board limit 10 offset 1 order by userscore ",
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

module.exports = router;
