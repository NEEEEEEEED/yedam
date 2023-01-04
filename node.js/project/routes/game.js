var express = require("express");
const pool = require("../project_DB/pool");
var router = express.Router();

sql = {
  select: "select * from board",
  selectOne: "select * from board where no =?",
  insert: "insert into score set ?",
  update: "update board set ? where no=?",
  delete: "delete from board where no=?",
};

//등록
router.post("/", function (req, res) {
  if (req.session.userid) {
    //작성자 등록
    req.body.userid = req.session.userid;
    console.log(req.body);
    pool.query(sql.insert, req.body, function (err, results, fields) {
      console.log(err);
      res.json({ result: "yes" });
    });
  } else {
    res.json({ result: "no" });
  }
});

module.exports = router;
