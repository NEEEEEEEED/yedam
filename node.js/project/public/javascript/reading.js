const url = "/board";

const URLSearch = new URLSearchParams(location.search);
const no = URLSearch.get("no");
fetch(`${url}/${no}`, { method: "get" })
  .then((res) => res.json())
  .then((res) => {
    contenttitle.value = res.title;
    content.value = res.content;
  });
