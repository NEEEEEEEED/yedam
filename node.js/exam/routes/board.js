var express = require("express");
const pool = require("../pool");
var router = express.Router();

sql = {
  select: "select * from board order by title",
  selectOne: "select * from board where no =?",
  insert: "insert into board set ?",
  update: "update board set ? where no=?",
  delete: "delete from board where no=?",
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
    if (err) {
      console.log(err);
    }
    res.json(results);
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
    let resultData = {};
    if (err) {
      console.log(err);
      throw err;
    }
    console.log(results);
    if (results.affectedRows > 0) {
      resultData.result = true;
    } else {
      resultData.result = false;
    }
    res.send(resultData);
  });
});

module.exports = router;
