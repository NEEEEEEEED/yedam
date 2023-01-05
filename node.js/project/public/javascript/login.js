document.querySelector("#btnlogin").addEventListener("click", () => {
  inputCheck();
});

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
