var express = require("express");
const pool = require("../project_DB/pool");
var router = express.Router();

sql = {
  select: "select * from board",
  selectOne: "select * from board where no =?",
  insert: "insert into board set ?",
  update: "update board set ? where no=?",
  delete: "delete from board where no=?",
};

module.exports = router;
