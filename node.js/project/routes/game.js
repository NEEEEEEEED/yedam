var express = require("express");
const pool = require("../project_DB/pool");
var router = express.Router();

sql = {
  select: "select * from board",
  selectOne: "select * from board where no =?",
  insert: "insert into score set ?",
  update: "update board set ? where no=?",
  delete: "delete from board where no=?",
  scoreselect: "select * from project.score order by yscore desc limit 0,10",
};
//session id 찾기
router.get("/find", function (req, res) {
  const sessionid = req.session.userid;
  pool.query(sql.scoreselect, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    res.json(sessionid);
  });
});

//점수판 조회
router.get("/", function (req, res) {
  pool.query(sql.scoreselect, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    res.json(results);
  });
});
module.exports = router;

//userid, yscore 등록
router.post("/", function (req, res) {
  if (req.session.userid) {
    req.body.userid = req.session.userid;
    pool.query(sql.insert, req.body, function (err, results, fields) {
      console.log(err);
      res.json({ result: "yes" });
    });
  } else {
    res.json({ result: "no" });
  }
});
