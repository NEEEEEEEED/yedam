/**
 *
 */
//목록 출력
let totalAry = []; //전체목록을 담아둘 용도
fetch("../empListJson")
  .then((resolve) => resolve.json())
  .then((result) => {
    // console.log(result);
    // 배열관련 메소드 : forEach, map, filter, reduce..
    localStorage.setItem("total", result.length);
    totalAry = result;
    // result.forEach(function (item) {
    //   //tr 생성
    //   let tr = makeTr(item);
    //   list.append(tr);
    // }); //result배열에 등록된 값의 갯수만큼 funcion()실행
    changeListCnt();
  })
  .catch((reject) => {
    console.log(reject);
  });
// 저장버튼에 submit 이벤트 등록,
document
  .querySelector('form[name="empForm"]')
  .addEventListener("submit", addMemberFnc);

//전체선택 체크박스.
document
  .querySelector('thead input[type="checkbox"]')
  .addEventListener("change", allCheckChange);

document
  .querySelector("#delSelectedBtn")
  .addEventListener("click", deleteCheckedFnc);

document.querySelector("#pageCnt").addEventListener("change", changeListCnt);

// document.querySelector("select").addEventListener("change", changeListCnt());

//체크된 tr 삭제(다중 삭제) + 삭제 메세지 띄우기
// fetch API -> 비동기방식처리 => async await 동기식
async function deleteCheckedFnc() {
  let ids = [];
  let chks = document.querySelectorAll(
    '#list input[type = "checkbox"]:checked'
  );

  for (let i = 0; i < chks.length; i++) {
    let id = chks[i].parentElement.parentElement.firstChild.innerText;
    let resp = await fetch("../empListJson?del_id=" + id, {
      method: "DELETE",
    });
    let json = await resp.json();
    console.log(json);
    ids.push(json);
  }
  processAfterFetch(ids);
}
// 화면처리
function processAfterFetch(ary = []) {
  let targetTr = document.querySelectorAll("#list tr");

  targetTr.forEach((tr) => {
    for (let i = 0; i < ary.length; i++) {
      if (tr.children[0].innerText == ary[i].id) {
        if (ary[i].retCode == "Success") {
          tr.remove(); // Success
        } else {
          tr.setAttribute("class", "delError");
        }
      }
    }
  });
}
// 전체선택 체크박스.
function allCheckChange() {
  //tbody에 있는 체크박스 선택.
  document.querySelectorAll('tbody input[type = "checkbox"]').forEach((chk) => {
    chk.checked = this.checked;
  });
}

//전체 선택 체크박스와 개별 체크박스 동기화
function checkAllFnc() {
  //전체 건수, 선택 건수 비교
  let allTr = document.querySelectorAll("tbody#list tr");
  let chkTr = document.querySelectorAll('tbody input[type="checkbox"]:checked');
  //전체,선택 건수가 같으면 전체 선택 박스 체크 아니면 체크x
  if (allTr.length == chkTr.length) {
    document.querySelector('thead input[type="checkbox"]').checked = true;
  } else {
    document.querySelector('thead input[type="checkbox"]').checked = false;
  }
}

//데이터 한건 활용해서 tr 요소를 생성
function makeTr(item) {
  // DOM 요소 생성.
  let titles = ["id", "lastName", "email", "hireDate", "job"];
  //데이터 건수만큼 반복.
  let tr = document.createElement("tr");
  //columns 개수만큼 반복.
  // console.log(item);
  titles.forEach(function (title) {
    let td = document.createElement("td");
    td.innerText = item[title];
    tr.append(td);
  });
  //삭제
  let td = document.createElement("td");
  let btn = document.createElement("button");
  btn.innerHTML = "삭제";
  btn.addEventListener("click", deleteRowFunc);
  td.append(btn);
  tr.append(td);

  //수정
  td = document.createElement("td");
  btn = document.createElement("button");
  btn.innerHTML = "수정";
  btn.addEventListener("click", updateRowFunc);
  btn.setAttribute("name", "uptBtn");
  td.append(btn);
  tr.append(td);

  //체크박스
  td = document.createElement("td");
  let checkbox = document.createElement("input");
  checkbox.addEventListener("click", checkAllFnc);
  checkbox.setAttribute("type", "checkbox");
  td.append(checkbox);
  tr.append(td);

  //tr 반환
  return tr;
}

//모두선택 후 하나라도 지우면 전체선택 박스 해제
function changeAllbox() {
  if (document.querySelector('thead input[type="checkbox"]').checked == true) {
    document.querySelector('thead input[type="checkbox"]').checked = false;
  }
}

//삭제버튼 이벤트 콜백함수.
function deleteRowFunc() {
  id = this.parentElement.parentElement.firstChild.innerText;
  fetch("../empListJson?del_id=" + id, {
    method: "DELETE",
  })
    .then((resolve) => resolve.json()) //가져온 값을 json으로 받음
    .then((result) => {
      if (result.retCode == "Success") {
        alert("정상적으로 삭제");
        this.parentElement.parentElement.remove();
      } else if (result.retCode == "Fail") {
        alert("삭제중 오류 발생");
      }
    })
    .catch((reject) => console.log(reject));
}

function updateRowFunc() {
  //this->수정버튼
  let thisTr = this.parentElement.parentElement;

  let id = thisTr.children[0].innerHTML;
  let lastName = thisTr.children[1].innerHTML;
  let mail = thisTr.children[2].innerHTML;
  let hDate = thisTr.children[3].innerHTML;
  let job = thisTr.children[4].innerHTML;

  let modItems = [lastName, mail, hDate, job];

  let newTr = document.createElement("tr");
  let td = document.createElement("td");
  td.innerHTML = id; //변경불가 항목
  newTr.append(td);
  modItems.forEach((item) => {
    td = document.createElement("td");
    let inp = document.createElement("input");
    inp.style = "width: 100px;";
    inp.value = item;
    td.append(inp);
    newTr.append(td);
  });
  //삭제:비활성화, 변경:DB반영
  //삭제
  let td3 = document.createElement("td");
  let btn3 = document.createElement("button");
  btn3.innerHTML = "삭제";
  btn3.disabled = true;
  td3.append(btn3);
  newTr.append(td3);

  //변경
  let td1 = document.createElement("td");
  let btn1 = document.createElement("button");
  btn1.innerHTML = "변경";
  btn1.addEventListener("click", updateFunc);
  td1.append(btn1);
  newTr.append(td1);

  //체크박스
  td1 = document.createElement("td");
  let checkbox = document.createElement("input");
  checkbox.addEventListener("change", changeAllbox);
  checkbox.setAttribute("type", "checkbox");
  td1.append(checkbox);
  newTr.append(td1);

  thisTr.replaceWith(newTr);
  //수정 중 수정버튼 비활성화
  document.querySelectorAll('tbody button[name = "uptBtn"]').forEach((btn) => {
    btn.disabled = true;
  });
}

// 수정 처리 함수
function updateFunc() {
  let currTr = this.parentElement.parentElement;
  let id = currTr.children[0].innerText;
  let lastName = currTr.children[1].children[0].value;
  let mail = currTr.children[2].children[0].value;
  let hDate = currTr.children[3].children[0].value;
  let job = currTr.children[4].children[0].value;

  fetch("../empListJson", {
    method: "POST",
    headers: { "Content-Type": "application/x-www-form-urlencoded" },
    body:
      "param=update&id=" +
      id +
      "&lastName=" +
      lastName +
      "&mail=" +
      mail +
      "&hDate=" +
      hDate +
      "&job=" +
      job,
  })
    .then((resolve) => resolve.text())
    .then((result) => {
      if (result.indexOf("Success") != -1) {
        let newTr = makeTr({
          id: id,
          lastName: lastName,
          email: mail,
          hireDate: hDate,
          job: job,
        });
        currTr.replaceWith(newTr);
        alert("정상처리");
      } else {
        console.log("error");
      }
    })
    .catch((reject) => {
      console.log(reject);
    });
}

// 저장 처리 함수
function addMemberFnc(ev) {
  //폼은 페이지 이동이 디폴트 <- 페이지 이동을 막아주는 코드
  ev.preventDefault();
  let id = document.querySelector('input[name="emp_id"]').value;
  let lastName = document.querySelector('input[name="last_name"]').value;
  let mail = document.querySelector('input[name="email"]').value;
  let hDate = document.querySelector('input[name="hire_date"]').value;
  let job = document.querySelector('input[name="job_id"]').value;

  if (!id || !lastName || !mail || !hDate || !job) {
    alert("입력값 확인");
    return;
  }
  fetch("../empListJson", {
    method: "POST",
    headers: { "Content-Type": "application/x-www-form-urlencoded" }, //key=value&key1=value1 형태
    body:
      "param=&id=" +
      id +
      "&lastName=" +
      lastName +
      "&mail=" +
      mail +
      "&hDate=" +
      hDate +
      "&job=" +
      job,
  })
    .then((resolve) => resolve.json())
    .then((result) => {
      if (result.retCode == "Success") {
        alert("정상적으로 저장");
        list.append(
          makeTr({
            id: id,
            lastName: lastName,
            email: mail,
            hireDate: hDate,
            job: job,
          })
        );
        document.querySelector('input[name="emp_id"]').value = "";
        document.querySelector('input[name="last_name"]').value = "";
        document.querySelector('input[name="email"]').value = "";
        document.querySelector('input[name="hire_date"]').value = "";
        document.querySelector('input[name="job_id"]').value = "";
      } else if (result.retCode == "Fail") {
        alert("처리중 에러!");
      }
    });
}

//페이징
function showPages(curPage = 1) {
  //초기화
  document.querySelectorAll("#paging a").forEach((item) => {
    item.remove();
  });
  //전체건수
  let curList = document.querySelector("select").value;
  let totalCnt = parseInt(localStorage.getItem("total"));
  let endPage = Math.ceil(curPage / 10) * 10;
  let startPage = endPage - 9;
  let realEnd = Math.ceil(totalCnt / curList);

  //이전페이지, 다음 페이지 확인
  let prev, next;
  prev = startPage > 1 ? true : false;
  next = endPage < realEnd ? true : false;
  let paging = document.getElementById("paging");
  endPage = endPage > realEnd ? realEnd : endPage;

  //prev & next page
  if (prev) {
    let aTag = document.createElement("a");
    aTag.addEventListener("click", showListPages);
    aTag.href = "#";
    aTag.innerHTML = `&laquo;`;
    aTag.page = startPage - 1;
    paging.append(aTag);
  }

  for (let i = startPage; i <= endPage; i++) {
    let aTag = document.createElement("a");
    aTag.addEventListener("click", showListPages);
    aTag.href = "#";
    aTag.innerText = i;
    aTag.page = i; //innerText 속성이 페이지 값으로 사용하면
    if (i == curPage) {
      aTag.className = "active"; //aTag.setAttribute("class", "active");
    }
    paging.append(aTag);
  }

  if (next) {
    let aTag = document.createElement("a");
    aTag.addEventListener("click", showListPages);
    aTag.href = "#";
    aTag.innerHTML = `&raquo;`;
    aTag.page = endPage + 1;
    paging.append(aTag);
  }
}
//페이지 클릭 이동 이벤트
function showListPages(ev) {
  //페이지 번호
  let page = ev.target.page;
  showPages(page);
  employeeList(page);
}

//사원목록
function employeeList(curPage = 1) {
  //초기화
  let curemp = document.querySelector("select").value;
  document.querySelectorAll("#list tr").forEach((item) => {
    item.remove();
  });
  let end = curPage * curemp;
  let start = end - curemp - 1;
  let newList = totalAry.filter((emp, idx) => {
    return idx + 1 >= start && idx < end;
  });
  let lst = document.getElementById("list");
  newList.forEach((emp) => {
    let tr = makeTr(emp);
    lst.append(tr);
  });
}

function changeListCnt() {
  showPages(1);
  employeeList(1);
}
