const url = "/board";
//조회
selectAll();
//조회수증가

//전체조회 function
function selectAll() {
  fetch(url)
    .then((res) => res.json())
    .then((res) => {
      for (let i = 0; i < res.length; i++) {
        let array = res;
        array.sort(function compare(a, b) {
          return b.no - a.no;
        });
        const tr = `
        <tr id="trlist" onclick="readlist(${res[i].no})">
          <th scope="row">${parseInt([i]) + 1}</th>
          <td data-id="${res[i].no}">${res[i].title}</td>
          <td>${res[i].userid}</td>
          <td>${getYmd10(res[i].wdate)}</td>
          <td>${change(res[i].count)}</td>
        </tr>`;
        list.innerHTML += tr;
      }
    });
}
//null 변환
function change(value) {
  if (value == null) {
    return 0;
  } else {
    return value;
  }
}
//조회수
//해당 no 찾기
function readlist(no) {
  fetch("/board/count/" + no, {
    method: "put",
  })
    .then((res) => res.json())
    .then((res) => {
      location.href = "./reading.html?no=" + no;
    });
}

//날짜 포맷 변경 yyyy-mm-dd
function getYmd10(wdata) {
  var d = new Date(wdata);
  return (
    d.getFullYear() +
    "-" +
    (d.getMonth() + 1 > 9
      ? (d.getMonth() + 1).toString()
      : "0" + (d.getMonth() + 1)) +
    "-" +
    (d.getDate() > 9 ? d.getDate().toString() : "0" + d.getDate().toString())
  );
}
