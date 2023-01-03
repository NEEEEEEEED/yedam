var express = require("express");
var router = express.Router();

/* GET users listing. */
router.get("/", function (req, res, next) {
  console.log(req.session.username);
  res.send("respond with a resource");
});
router.post("/logIn", function (req, res) {
  req.session.email = req.query.email;
  req.session.is_logined = true;
  req.session.save((err) => {
    if (err) throw err;
    res.send("login ok");
  });
});
router.get("/logout", (req, res, next) => {
  req.session.destroy();
  res.redirect("/logIn.html");
});
module.exports = router;
