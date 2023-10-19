let users = [
  { userno: "100", email: "aa@b.com", username: "김기자", point: 250 },
  { userno: "101", email: "bb.yedam.ac", username: "이순신", point: 150 },
  { userno: "102", email: "cc.naver.com", username: "을지문덕", point: 100 },
];
//배열 출력
addlist();
//배열추가 버튼
btnAdd.addEventListener("click", function (ev) {
  let addObj = {
    userno: userno.value,
    email: email.value,
    username: username.value,
    point: parseInt(point.value),
  };
  //입력확인
  if (!check()) {
    return;
  }
  //배열 추가
  users.push(addObj);
  //화면 리셋
  addlist();
  //입력창 비우기
  inputClear();
});
//포인트합계 버튼
document.querySelector("#btnSum").addEventListener("click", function (ev) {
  pointTotalCalc();
});
//삭제 및 배열 삭제
list.addEventListener("click", function (ev) {
  let node = ev.target;
  let no = node.closest("tr").children[0].innerHTML;
  if (node.nodeName == "BUTTON") {
    for (let i = 0; i < users.length; i++) {
      if (users[i].userno == no) {
        users.splice(i, 1);
        addlist();
        return;
      }
    }
  }
});
//배열 출력
function addlist() {
  //이전 출력 클리어
  list.innerHTML = "";
  for (let i = 0; i < users.length; i++) {
    let userlist = `
    <tr>
      <td>${users[i].userno}</td>
      <td>${users[i].email}</td>
      <td>${users[i].username}</td>
      <td class="point">${users[i].point}</td>
      <td><button>삭제</button></td>
    </tr>
    `;
    list.innerHTML += userlist;
  }
}
//입력창 비우기
function inputClear() {
  userno.value = "";
  email.value = "";
  username.value = "";
  point.value = "";
}
//입력확인
function check() {
  if (email.value == "") {
    alert("경고");
    no.focus();
    return false;
  }
  return true;
}
//포인트 합계 구하기
function pointTotalCalc() {
  let total = 0;
  for (let i = 0; i < users.length; i++) {
    total += users[i].point;
  }
  document.querySelector("span").innerHTML = total;
}
