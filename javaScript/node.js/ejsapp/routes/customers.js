var express = require("express");
var router = express.Router();
const pool = require("../mysql/pool");

router.get("/", (req, res) => {
  const sql = " select * from customers";
  pool.query(sql, (err, result, fields) => {
    res.render("customers", { list: result });
  });
});

module.exports = router;
