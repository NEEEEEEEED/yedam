var express = require("express");
const pool = require("../project_DB/pool");
var router = express.Router();

const sql = {
  select: "select * from project.board limit 0,10",
  selectOne: "select * from project.board where no =? ",
  insert: "insert into project.board set ?",
  update: "update project.board set ? where no=?",
  delete: "delete from project.board where no=?",
  scoreselect: "select * from project.score order by yscore desc limit 0,10",
  loginprocess: "select * from login where userid = ? and userpw = ?",
  cntclick: "update board set count=IFNULL(count,0)+1 where no =?",
  checkid: "select userid from login",
  signup: "insert into login set ?",
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
//회원가입 아이디 중복확인
router.get("/checkid", function (req, res) {
  pool.query(sql.checkid, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    console.log(results);
    res.json(results);
  });
});
//아이디, 비밀번호 등록
router.post("/signup", function (req, res) {
  pool.query(sql.signup, req.body, function (err, results, fields) {
    console.log(err);

    res.json({ result: "success" });
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
            res.redirect(`../page.html?pageNum=1`);
          });
        } else {
          res.send(`<script type="text/javascript">alert("로그인 정보가 일치하지 않습니다."); 
            document.location.href="/logIn.html";</script>`);
        }
      }
    );
  } else {
    response.send(`<script type="text/javascript">alert("아이디와 비밀번호를 입력하세요!"); 
    document.location.href="/logIn.html";</script>`);
  }
});
//로그아웃
router.post("/logout", (req, res, next) => {
  req.session.destroy();
  res.redirect(`../login.html`);
});
//이거 열면 안됨 점수판 board에서 가져오게됨
//만약 board.html을 쓸려면 열긴해야함
/* //전체조회
router.get("/", function (req, res) {
  pool.query(sql.select, function (err, results, fields) {
    if (err) {
      console.log(err);
    }

    res.json(results);
  });
}); */

//단건조회
router.get("/:no", (req, res) => {
  const sessionid = req.session.userid;
  const no = req.params.no;
  pool.query(sql.selectOne, no, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    //results 배열에 session id 추가
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
    res.json(results);
  });
});

//등록
router.post("/", function (req, res) {
  if (req.session.userid) {
    //작성자 등록
    req.body.userid = req.session.userid;
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
