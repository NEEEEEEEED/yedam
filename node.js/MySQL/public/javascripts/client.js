const url = "/customers";
//조회
selectAll();
//등록버튼 이벤트 지정
insert();

customerDelete();

customerSelect();

customerUpdate();
//전체조회 function
function selectAll() {
  fetch(url)
    .then((res) => res.json())
    .then((res) => {
      //list 클리어
      list.innerHTML = "";
      for (let i = 0; i < res.length; i++) {
        const tr = `
      <tr data-id=${res[i].id}>
        <td><input type="checkbox" /></td>
        <td>${res[i].id}</td>
        <td>${res[i].name}</td>
        <td>${res[i].email}</td>
        <td>${res[i].phone}</td>
        <td>${res[i].address}</td>
        <td><button id="btnDel">삭제</button><button id="btnSel">조회</button></td>
        </tr>`;
        list.innerHTML += tr;
      }
    });
}
//단건조회
function customerSelect() {
  list.addEventListener("click", function (ev) {
    if (ev.target.id == "btnSel") {
      let id = ev.target.closest("tr").getAttribute("data-id");
      fetch(`${url}/${id}`, { method: "get" })
        .then((res) => res.json())
        .then((res) => {
          userid.value = res.id;
          u_name.value = res.name;
          email.value = res.email;
          phone.value = res.phone;
          address.value = res.address;
        });
    }
  });
}
//등록
function insert() {
  btnAdd.addEventListener("click", function () {
    let data = {
      name: u_name.value,
      email: email.value,
      phone: phone.value,
      address: address.value,
    };
    fetch(url, {
      method: "post",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    })
      .then((res) => res.json())
      .then((res) => {
        selectAll();
      });
  });
}
//삭제
function customerDelete() {
  list.addEventListener("click", function (ev) {
    if (ev.target.id == "btnDel") {
      let id = ev.target.closest("tr").getAttribute("data-id");
      fetch(`${url}/${id}`, { method: "delete" }).then(() => {
        selectAll();
      });
    }
  });
}

//수정
function customerUpdate() {
  btnUpdate.addEventListener("click", function (ev) {
    let id = userid.value;
    let data = {
      name: u_name.value,
      email: email.value,
      phone: phone.value,
      address: address.value,
    };

    fetch(`${url}/${id}`, {
      method: "put",
      headers: { "content-type": "application/json" },
      body: JSON.stringify(data),
    })
      .then((res) => res.json())
      .then((res) => {
        if (res.result == true) {
          alert("수정완료");
          selectAll();
        } else {
          alert("수정실패");
        }
      })
      .catch(() => {
        alert("수정실패");
      });
  });
}
