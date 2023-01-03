var express = require("express");
const pool = require("../project_DB/pool");
var router = express.Router();

router.get("/:pageNum", (req, res) => {
  // NOTE: 쿼리스트링으로 받을 페이지 번호 값, 기본값은 1

  console.log(parseInt(req.params.pageNum));
  const pageNum = parseInt(req.params.pageNum) || 1;
  // NOTE: 페이지에서 보여줄 컨텐츠 수.
  const contentSize = 10;
  // NOTE: 페이지네이션 개수 설정.
  const pnSize = 10;
  // NOTE: 다음 페이지 갈 때 건너뛸 리스트 개수.
  const skipSize = (pageNum - 1) * contentSize;
  console.log(skipSize);

  pool.query(
    "SELECT count(*) as `count` FROM `board`",
    (countQueryErr, countQueryResult) => {
      // console.log(countQueryErr);
      // NOTE: 전체 글 개수.
      const totalCount = Number(countQueryResult[0].count);
      // NOTE: 페이지네이션의 전체 카운트
      const pnTotal = Math.ceil(totalCount / contentSize);
      // NOTE: 현재 페이지의 페이지네이션 시작 번호.
      const pnStart = (Math.ceil(pageNum / pnSize) - 1) * pnSize + 1;
      // NOTE: 현재 페이지의 페이지네이션 끝 번호.
      let pnEnd = pnStart + pnSize - 1;
      pool.query(
        "SELECT * FROM `board` ORDER BY no DESC LIMIT ?, ?",
        [skipSize, contentSize],
        (contentQueryErr, contentQueryResult) => {
          // console.log(contentQueryErr);
          // NOTE: 페이지네이션의 끝 번호가 페이지네이션 전체 카운트보다 높을 경우.
          if (pnEnd > pnTotal) pnEnd = pnTotal;
          const result = {
            pageNum,
            pnStart,
            pnEnd,
            pnTotal,
            contents: contentQueryResult,
          };
          // console.log(contentQueryResult);
          res.json(result);
        }
      );
    }
  );
});

/* router.get("/", (req, res) => {
  console.log(req.params);
  const { id } = req.params;
  pool.query("SELECT * FROM `board` WHERE id = ?", [id], (err, results) => {
    console.log(err);
    res.json(results);
  });
}); */

module.exports = router;
