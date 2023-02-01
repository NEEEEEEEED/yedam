/**
 *
 */
selectAll();

document
  .querySelector('thead input[type="checkbox"]')
  .addEventListener("change", allCheckChange);

function selectAll() {
  fetch("../checkOutJson")
    .then((resolve) => resolve.json())
    .then((result) => {
      result.forEach(function (item) {
        //tr 생성
        let tr = makeTr(item);
        list.append(tr);
      });
    })
    .catch((reject) => {
      console.log(reject);
    });
}

function makeTr(item) {
  // DOM 요소 생성.
  let titles = [
    "no",
    "bookName",
    "uName",
    "uPhone",
    "rentalDate",
    "returnDate",
    "deadline",
  ];

  //데이터 건수만큼 반복.
  let tr = document.createElement("tr");
  //columns 개수만큼 반복.
  // console.log(item);
  titles.forEach(function (title) {
    let td = document.createElement("td");
    td.innerText = item[title];
    tr.append(td);
  });
  //대여(수정)
  let td = document.createElement("td");
  let btn = document.createElement("button");
  btn.innerHTML = "대여";
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

  return tr;
}

function updateRowFunc() {
  //this->수정버튼
  let thisTr = this.parentElement.parentElement;

  let no = thisTr.children[0].innerHTML;
  let bookName = thisTr.children[1].innerHTML;
  let uName = thisTr.children[2].innerHTML;
  let uPhone = thisTr.children[3].innerHTML;
  let rentalDate = thisTr.children[4].innerHTML;
  let returnDate = thisTr.children[5].innerHTML;
  let deadline = thisTr.children[6].innerHTML;

  let modItems = [uName, uPhone];

  let newTr = document.createElement("tr");
  let td = document.createElement("td");
  td.innerHTML = no; //변경불가 항목
  let newTd = document.createElement("td");
  newTd.innerHTML = bookName;
  newTr.append(td);
  newTr.append(newTd);
  modItems.forEach((item) => {
    td = document.createElement("td");
    let inp = document.createElement("input");
    inp.style = "width: 100px;";
    inp.value = item;
    td.append(inp);
    newTr.append(td);
  });
  let td4 = document.createElement("td");
  td4.innerHTML = rentalDate; //변경불가 항목

  let td2 = document.createElement("td");
  td2.innerHTML = returnDate; //변경불가 항목

  let td3 = document.createElement("td");
  td3.innerHTML = deadline; //변경불가 항목

  newTr.append(td4);
  newTr.append(td2);
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
  let no = currTr.children[0].innerText;
  let bookName = currTr.children[1].innerText;
  let uName = currTr.children[2].children[0].value;
  let uPhone = currTr.children[3].children[0].value;
  let rentalDate = currTr.children[4].innerText;
  let returnDate = currTr.children[5].innerText;
  let deadline = currTr.children[6].innerText;

  fetch("../checkOutJson", {
    method: "POST",
    headers: { "Content-Type": "application/x-www-form-urlencoded" },
    body:
      "param=update&no=" +
      no +
      "&bookName=" +
      bookName +
      "&uName=" +
      uName +
      "&uPhone=" +
      uPhone +
      "&rentalDate=" +
      rentalDate +
      "&returnDate=" +
      returnDate +
      "&deadline=" +
      deadline,
  })
    .then((resolve) => resolve.text())
    .then((result) => {
      if (result.indexOf("Success") != -1) {
        let newTr = makeTr({
          no: no,
          bookName: bookName,
          uName: uName,
          uPhone: uPhone,
          rentalDate: rentalDate,
          returnDate: returnDate,
          deadline: deadline,
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

function allCheckChange() {
  //tbody에 있는 체크박스 선택.
  document.querySelectorAll('tbody input[type = "checkbox"]').forEach((chk) => {
    chk.checked = this.checked;
  });
}

function changeAllbox() {
  if (document.querySelector('thead input[type="checkbox"]').checked == true) {
    document.querySelector('thead input[type="checkbox"]').checked = false;
  }
}
