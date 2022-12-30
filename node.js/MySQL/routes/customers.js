var express = require("express");

const pool = require("../test/pool");
var router = express.Router();

//전체조회
router.get("/", function (req, res) {
  sql = "SELECT * FROM customers";
  pool.query(sql, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    res.json(results);
  });
});
//단건조회
router.get("/:id", function (req, res) {
  const id = req.params.id;
  let sql = "SELECT * FROM customers where id=?";
  pool.query(sql, id, function (err, results, fields) {
    res.json(results[0]);
  });
});

//등록
router.post("/", function (req, res) {
  let sql = "insert into customers set ?";
  pool.query(sql, req.body, function (err, results, fields) {
    res.json(results);
    console.log(err);
  });
});
//삭제
router.delete("/:id", function (req, res) {
  const id = req.params.id;
  let sql = "delete from customers where id=?";
  pool.query(sql, id, function (err, results, fields) {
    console.log(err);
  });
  res.statusCode = 200;
  res.end();
});
//수정
router.put("/:id", function (req, res) {
  let sql = "update customers set ? where id=?";
  let data = [req.body, req.params.id];
  pool.query(sql, data, function (err, results, fields) {
    let resultData = {};
    console.log(results);
    if (err) {
      console.log(err);
      throw err;
    }
    if (results.changedRows > 0) {
      resultData.result = true;
      resultData.data = req.body;
    } else {
      resultData.result = false;
    }
    res.send(resultData);
  });
});

module.exports = router;
