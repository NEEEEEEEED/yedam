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
  const no = req.params.no;
  pool.query(sql.selectOne, no, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
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

/* router.get("/paging/:no", (req, res) => {
  const { no } = req.params;
  connection.query(sql.pagenum, [no], (err, results) => {
    console.log(err);
    res.render("paging", {
      article: results[0],
    });
  });
}); */

/* //페이징
router.get("/", function (req, res) {
  const pageNum = Number(req.query.pageNum) || 1; // NOTE: 쿼리스트링으로 받을 페이지 번호 값, 기본값은 1
  const contentSize = 5; // NOTE: 페이지에서 보여줄 컨텐츠 수.
  const pnSize = 5; // NOTE: 페이지네이션 개수 설정.
  const skipSize = (pageNum - 1) * contentSize; // NOTE: 다음 페이지 갈 때 건너뛸 리스트 개수.
  pool.query(sql.select, function (err, results, fields) {
    if (err) {
      console.log(err);
    }
    const totalCount = Number(results[0].count); // NOTE: 전체 글 개수.
    const pnTotal = Math.ceil(totalCount / contentSize); // NOTE: 페이지네이션의 전체 카운트
    const pnStart = (Math.ceil(pageNum / pnSize) - 1) * pnSize + 1; // NOTE: 현재 페이지의 페이지네이션 시작 번호.
    let pnEnd = pnStart + pnSize - 1; // NOTE: 현재 페이지의 페이지네이션 끝 번호.
    connection.query(
      sql.pageselect,
      [skipSize, contentSize],
      (err, results, fields) => {
        console.log(err);
        if (pnEnd > pnTotal) pnEnd = pnTotal; // NOTE: 페이지네이션의 끝 번호가 페이지네이션 전체 카운트보다 높을 경우.
        const result = {
          pageNum,
          pnStart,
          pnEnd,
          pnTotal,
          contents: results,
        };
        res.render("index", {
          articles: result,
        });
      }
    );
  });
}); */
module.exports = router;
