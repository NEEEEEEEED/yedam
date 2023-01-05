const url = "/board";

//아이디 중복체크
document.querySelector("#idcheck").addEventListener("click", () => {
  if (userid.value == "") {
    alert("아이디를 입력하세요");
    document.querySelector("#userid").focus();
  } else {
    fetch("/board/checkid")
      .then((res) => res.json())
      .then((res) => {
        console.log(res);
        for (let i = 0; i < res.length; i++) {
          if (res[i].userid == userid.value) {
            alert("중복된 아이디 입니다.");
            document.querySelector("#userid").value = "";
            document.querySelector("#userid").focus();
            break;
          } else {
            alert("사용가능한 아이디 입니다.");
            document.querySelector("#userpw").focus();
            break;
          }
        }
      });
  }
});
//유저 등록

document.querySelector("#signup").addEventListener("click", function () {
  if (userpw.value == checkpw.value) {
    let data = {
      userid: userid.value,
      userpw: userpw.value,
    };
    if (!inputCheck()) {
      return;
    }
    fetch("/board/signup", {
      method: "post",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    })
      .then((res) => res.json())
      .then((res) => {
        console.log(res);
        if (res.result == "success") {
          alert("가입을 축하드립니다.");
          window.close();
        } else {
          alert("가입에 실패했습니다.");
          location.href = "/login.html";
          window.close();
        }
      });
  } else {
    alert("비밀번호를 확인하세요!!");
  }
});

//입력값 확인
function inputCheck() {
  if (userid.value == "") {
    alert("아이디 입력");
    userid.focus();
    return false;
  }
  if (userpw.value == "") {
    alert("비밀번호 입력");
    userpw.focus();
    return false;
  }
  return true;
}
