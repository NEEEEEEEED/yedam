const url = "/board";

highscore();
//점수판 조회
function highscore() {
  fetch(url)
    .then((res) => res.json())
    .then((res) => {
      for (let i = 0; i < res.length; i++) {
        /* let array = res;
        array.sort(function compare(a, b) {
          return b.yscore - a.yscore;
        }) */ const tr = `
        <tr>
          <th scope="row">${parseInt([i]) + 1}</th>
          <td>${res[i].userid}</td>
          <td>${res[i].yscore}</td>
        </tr>`;
        scoreboard.innerHTML += tr;
      }
    });
}
