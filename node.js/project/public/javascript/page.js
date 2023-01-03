const url = "/page";
const boardurl = "/board";

selectAll();

// pagebtn();
//페이징 function
function selectAll(pageNum) {
  console.log(pageNum);
  fetch("/page/" + pageNum)
    .then((res) => res.json())
    .then((res) => {
      let resarray = res.contents;

      resarray.sort(function compare(a, b) {
        return b.no - a.no;
      });
      for (let i = 0; i < res.contents.length; i++) {
        const tr = `
        <tr id="trlist" onclick="readlist(${res.contents[i].no})">
          <th scope="row">${parseInt([i]) + 1}</th>
          <td>${res.contents[i].title}</td>
          <td>${res.contents[i].userid}</td>
          <td>${getYmd10(res.contents[i].wdate)}</td>
          <td>${change(res.contents[i].count)}</td>
        </tr>
        `;

        list.innerHTML += tr;
      }
      for (let i = res.pnStart; i <= res.pnEnd; i++) {
        const pagebtn = `
        
          <button><a href="?pageNum=${[i]}">${[i]}</a></button>
          `;
        pagination.innerHTML += pagebtn;
      }
    });
}
/* function pagebtn(pageNum) {
  fetch("/page/" + pageNum)
    .then((res) => res.json())
    .then((res) => {
      for (let i = res.pnStart; i <= res.pnEnd; i++) {
        const pagebtn = `
          <button><a href="?pageNum=${[i]}">${[i]}</a></button>
          `;
        pagination.innerHTML += pagebtn;
      }
    });
} */
//해당 pageNum 찾기
function searchpage(pageNum) {
  location.href = "./page.html?pageNum=" + pageNum;
}
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

//null 변환
function change(value) {
  if (value == null) {
    return 0;
  } else {
    return value;
  }
}

/* if (articles.contents.length != 0) { 
  <div class="" style="text-align:center;">
    <ul class="pagination">

      <li>
       <a href="?pageNum=articles.pageNum-1">왼</a>
     </li>

     for(let i=articles.pnStart; i<=articles.pnEnd; i++){  
      <li><a href="?pageNum==[i]">=i</a></li>
       } 

    <li>
       <a href="?pageNum=articles.pageNum+1">오</a>
     </li>

   </ul>
  </div>
   }   */

/* if (articles.contents.length != 0) {
  <tr id="trlist" onclick="readlist(${res[i].no})">
    <th scope="row">${parseInt([i]) + 1}</th>
    <td>${res[i].title}</td>
    <td>${res[i].userid}</td>
    <td>${getYmd10(res[i].wdate)}</td>
    <td>${change(res[i].count)}</td>
  </tr>;
} else {
  <tr>
    <td>등록된 글이 없습니다.</td>
  </tr>;
} */

//페이징 처리

//해당 page 찾기
/* function searchpage(page) {
  for(let i =)
  location.href = "?page=" + page;
} */
