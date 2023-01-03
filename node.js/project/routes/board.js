var express = require("express");
const pool = require("../project_DB/pool");
var router = express.Router();

const sql = {
  select: "select * from project.board limit 0,10",
  selectOne: "select * from project.board where no =? ",
  insert: "insert into project.board set ?",
  update: "update project.board set ? where no=?",
  delete: "delete from project.board where no=?",
  scoreselect: "select * from project.board order by yscore desc limit 0,10",
  loginprocess: "select * from login where userid = ? and userpw = ?",
  cntclick: "update board set count=IFNULL(count,0)+1 where no =?",
};
//조회수 증가
router.put("/count/:no", (req, res) => {
  pool.query(sql.cntclick, req.params.no, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    res.json(results);
  });
});

//로그인 프로세스
router.post("/login", function (req, res) {
  let username = req.body.userid;
  let password = req.body.userpw;

  if (username && password) {
    // id와 pw가 입력되었는지 확인
    pool.query(
      sql.loginprocess,
      [username, password],
      function (err, results, fields) {
        console.log(err);
        if (results.length > 0) {
          // db에서의 반환값이 있으면 로그인 성공
          req.session.is_logined = true; // 세션 정보 갱신
          req.session.userid = username;
          req.session.save(function () {
            res.redirect(`../board.html`);
          });
        } else {
          res.send(`<script type="text/javascript">alert("로그인 정보가 일치하지 않습니다."); 
            document.location.href="/logIn.html";</script>`);
        }
      }
    );
  } else {
    response.send(`<script type="text/javascript">alert("아이디와 비밀번호를 입력하세요!"); 
    document.location.href="/auth/login";</script>`);
  }
});
//로그아웃
router.post("/logout", (req, res, next) => {
  req.session.destroy();
  res.redirect(`../login.html`);
});

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
  const sessionid = req.session.userid;
  console.log(sessionid);
  const no = req.params.no;
  pool.query(sql.selectOne, no, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    //resuts 배열에 session id 추가
    results[0].test = sessionid;
    res.json(results[0]);
  });
});

//점수조회
router.get("/", function (req, res) {
  pool.query(sql.scoreselect, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    pool.connectionrelease;
    res.json(results);
  });
});

//등록
router.post("/", function (req, res) {
  if (req.session.userid) {
    console.log(req.session.userid);
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
