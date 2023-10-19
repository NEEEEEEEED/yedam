const url = "/page";
const boardurl = "/board";

//페이징 처리
const URLSearch = new URLSearchParams(location.search);
const pageNum = URLSearch.get("pageNum");
fetch(`${url}/${pageNum}`)
  .then((res) => res.json())
  .then((res) => {
    let resarray = res.contents;
    resarray.sort(function compare(a, b) {
      return b.no - a.no;
    });
    for (let i = 0; i < res.contents.length; i++) {
      const tr = `
        <tr class="trlist" onclick="readlist(${res.contents[i].no})">
          <th scope="row">${parseInt([i]) + 1}</th>
          <td>${res.contents[i].title}</td>
          <td>${res.contents[i].userid}</td>
          <td>${res.contents[i].wdate}</td>
          <td>${change(res.contents[i].count)}</td>
        </tr>
        `;
      list.innerHTML += tr;
    }
    for (let i = res.pnStart; i <= res.pnEnd; i++) {
      const pagebtn = `
      <button type="button" class="btn btn-primary onclick="location.href='/page.html?pageNum=${[
        i,
      ]}">${[i]}'"><a class="tagA" href="?pageNum=${[i]}">${[i]}</a></button>
      `;
      pagination.innerHTML += pagebtn;
    }
  });

//해당 no 찾기, 조회수
function readlist(no) {
  fetch("/board/count/" + no, {
    method: "put",
  })
    .then((res) => res.json())
    .then((res) => {
      location.href = "./reading.html?no=" + no;
    });
}

//조회수 null 변환
function change(value) {
  if (value == null) {
    return 0;
  } else {
    return value;
  }
}
