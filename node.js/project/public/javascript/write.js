const url = "/board";
insert();

//입력
function insert() {
  document.querySelector("#btnadd").addEventListener("click", function () {
    let data = {
      title: contenttitle.value,
      content: content.value,
    };
    if (!inputCheck()) {
      return;
    }
    fetch(url, {
      method: "post",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    })
      .then((res) => res.json())
      .then((res) => {
        if (res.result == "no") {
          alert("로그인");
          location.href = "/login.html";
        } else if (res.result == "yes") {
          window.location = document.referrer;
        }
      });
  });
}
//입력값 확인
function inputCheck() {
  if (contenttitle.value == "") {
    alert("제목 입력");
    contenttitle.focus();
    return false;
  }
  if (content.value == "") {
    alert("내용 입력");
    content.focus();
    return false;
  }
  return true;
}
