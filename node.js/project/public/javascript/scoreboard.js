const url = "/board";

function selectAll() {
  fetch(url)
    .then((res) => res.json())
    .then((res) => {
      for (let i = 0; i < res.length; i++) {
        const tr = `
        <tr>
          <th scope="row">${count([i])}</th>
          <td>${res[i].userid}</td>
          <td>${res[i].yscore}</td>
        </tr>`;
        scoreboard.innerHTML += tr;
      }
    });
}

function count(value) {
  console.log(value);
  return value++;
}
