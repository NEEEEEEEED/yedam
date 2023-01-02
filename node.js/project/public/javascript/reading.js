const url = "/board";
listdelete();

Update();

readonlytoggle();

//단건조회
const URLSearch = new URLSearchParams(location.search);
const no = URLSearch.get("no");
fetch(`${url}/${no}`, { method: "get" })
  .then((res) => res.json())
  .then((res) => {
    contenttitle.value = res.title;
    content.value = res.content;
  });

//삭제
function listdelete() {
  document.querySelector("#btndel").addEventListener("click", function () {
    const URLSearch = new URLSearchParams(location.search);
    const no = URLSearch.get("no");
    fetch(`${url}/${no}`, { method: "delete" }).then(() => {});
  });
}

//수정
function Update() {
  document.querySelector("#btnupd").addEventListener("click", function () {
    let data = {
      title: contenttitle.value,
      content: content.value,
    };
    const URLSearch = new URLSearchParams(location.search);
    const no = URLSearch.get("no");
    fetch(`${url}/${no}`, {
      method: "put",
      headers: { "content-type": "application/json" },
      body: JSON.stringify(data),
    })
      .then((res) => res.json())
      .then((res) => {});
  });
}
function readonlytoggle() {
  const updcheck = document.querySelector("#updcheck");
  updcheck.addEventListener("click", function () {
    document.getElementById("contenttitle").readOnly = false;
    document.getElementById("content").readOnly = false;
    document.getElementById("btnupd").disabled = false;
  });
}
