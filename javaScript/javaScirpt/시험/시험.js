//배열추가 function
let books = [
  { no: "inbn0002", title: "스프링", writer: "김기자", price: 40000 },
  { no: "inbn0003", title: "자바", writer: "이순신", price: 25000 },
  { no: "inbn0004", title: "SQL", writer: "을지문덕", price: 32000 },
];
//배열의 데이터로 태그 그리기
addlist();
//가격 총금액
priceTotalCalc();
//삭제버튼 addEventListener
list.addEventListener("click", function (ev) {
  let node = ev.target;
  if (node.nodeName == "BUTTON") {
    //추가된 배열 지우기
    let no = node.closest("tr").children[1].innerText;
    for (let i = 0; i < books.length; i++) {
      if (books[i].no == no) {
        books.splice(i, 1);
      }
    }
    //태그 그리기
    addlist();
    //금액계산
    priceTotalCalc();
  }
});
//추가버튼 addEventListener, 배열에 input 값 추가
btnAdd.addEventListener("click", function (ev) {
  let addObj = {
    no: no.value,
    title: title.value,
    writer: writer.value,
    price: parseInt(price.value),
  };
  //입력값 체크
  if (!check()) {
    return;
  }
  //배열에 추가
  books.push(addObj);
  //금액계산
  priceTotalCalc();
  //배열 내용을 태그로 보냄
  addlist();
  //추가 후  input창 비우기
  inputClear();
});

function addlist() {
  list.innerHTML = "";
  for (let i = 0; i < books.length; i++) {
    let bklist = `
    <tr>
      <td><input type="checkbox"></td>
      <td>${books[i].no}</td>
      <td>${books[i].title}</td>
      <td>${books[i].writer}</td>
      <td class="price">${books[i].price}</td>
      <td><button class="btnDel">삭제</button></td>
    </tr>
    `;
    list.innerHTML += bklist;
  }
}
function inputClear() {
  no.value = "";
  writer.value = "";
  price.value = "";
  title.value = "";
}
function check() {
  if (no.value == "") {
    alert("경고");
    no.focus();
    return false;
  }
  if (title.value == "") {
    alert("경고");
    title.focus();
    return false;
  }
  return true;
}
function priceTotalCalc() {
  let total = 0;
  for (let i = 0; i < books.length; i++) {
    total += books[i].price;
  }
  totalPrice.innerHTML = total;
}
