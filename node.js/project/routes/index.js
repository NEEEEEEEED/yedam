var express = require("express");
const pool = require("../project_DB/pool");
var router = express.Router();

/* GET home page. */
router.get("/", function (req, res, next) {
  res.redirect("login.html");
});

module.exports = router;
