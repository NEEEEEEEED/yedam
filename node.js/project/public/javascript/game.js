const url = "/game";
highscoreupt();

//점수판 갱신

//행 추가

// 세션id찾아오기

function addRow() {
  fetch("/game/find")
    .then((res) => res.json())
    .then((res) => {
      console.log(res);
      const resid = res;
      for (let i = 0; i < 10; i++) {
        const yscore = document.querySelectorAll(".yscore")[i];
        const player1total = document.querySelector("#player1total").value;
        if (parseInt(player1total) > parseInt(yscore.innerText)) {
          const table = document.getElementById("highscore");
          // 행(Row) 삭제

          table.deleteRow(10);

          // 새 행(Row) 추가 (테이블 중간에)
          const newRow = table.insertRow(parseInt([i]) + 1);
          // 새 행(Row)에 Cell 추가
          const newCell1 = newRow.insertCell(0);
          const newCell2 = newRow.insertCell(1);
          const newCell3 = newRow.insertCell(2);
          let aa = document.querySelector("#scoreboard").querySelectorAll("tr")[
            i
          ];
          aa.style.backgroundColor = "#FFFF66";
          let bb = document.querySelector("#scoreboard").querySelectorAll("tr")[
            i
          ].children[0];
          bb.setAttribute("class", "rank");
          // Cell에 텍스트 추가 - 세션 아이디와 현재점수
          newCell1.innerText = "";

          newCell2.innerText = resid;
          newCell3.innerText = player1total;
          break;
        }
      }
      for (let i = 0; i < 10; i++) {
        document.querySelectorAll(".rank")[i].innerText = parseInt([i]) + 1;
        console.log(document.querySelectorAll(".rank")[i].innerText);
      }
    });
}
function highscoreupt() {
  fetch(url)
    .then((res) => res.json())
    .then((res) => {
      scoreboard.innerHTML = "";
      for (let i = 0; i < res.length; i++) {
        /* let array = res;
        array.sort(function compare(a, b) {
          return b.yscore - a.yscore;
        }) */ const tr = `
        <tr>
          <td class="rank" scope="row">${parseInt([i]) + 1}</td>
          <td>${res[i].userid}</td>
          <td class="yscore">${res[i].yscore}</td>
        </tr>`;
        scoreboard.innerHTML += tr;
      }
    });
}
function sendscore() {
  let total = Number(document.getElementById("player1total").value);
  let data = { yscore: total };
  console.log(data);
  fetch(url, {
    method: "post",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  })
    .then((res) => res.json())
    .then((res) => {
      if (res.result == "no") {
        alert("세션이 만료되었습니다.");
        location.href = "/login.html";
      } else if (res.result == "yes") {
        window.location = document.referrer;
      }
    });
}
// 다이스 랜덤 배열변수

let arrDice = new Array();

// 족보 배열
let categories = [
  "aces",
  "deuces",
  "threes",
  "fours",
  "fives",
  "sixes",
  "choice",
  "4ofakind",
  "fullhouse",
  "sstraight",
  "lstraight",
  "yacht",
];

// 기회
let num = 3;

// player 교체변수
let play = 1;

// 족보 비교변수
let choice;

// 턴
let turn = 1;

// 배열정렬시 필요한변수
let temp;

// 주사위
let Dice1 = 1;
let Dice2 = 1;
let Dice3 = 1;
let Dice4 = 1;
let Dice5 = 1;

// 상단 족보
let ace1 = 1;
let ace2 = 1;
let deuce1 = 1;
let deuce2 = 1;
let three1 = 1;
let three2 = 1;
let four1 = 1;
let four2 = 1;
let five1 = 1;
let five2 = 1;
let sixe1 = 1;
let sixe2 = 1;

// 하단 족보
let choice1 = 1;
let choice2 = 1;
let _4ofakind1 = 1;
let _4ofakind2 = 1;
let fullhouse1 = 1;
let fullhouse2 = 1;
let sstraight1 = 1;
let sstraight2 = 1;
let lstraight1 = 1;
let lstraight2 = 1;
let yacht1 = 1;
let yacht2 = 1;

document.getElementById("chance").value = num + "회 / 3회";
document.getElementById("player" + play).style.color = "red";
document.getElementById("player" + play).style.fontWeight = "bold";

document.querySelector("#confirmation").addEventListener("click", () => {
  document.getElementById("start").disabled = true;
});

function movein(char) {
  document.getElementById("player" + play + char).style.cursor = "pointer";
}

function number(number) {
  num = number;
  document.getElementById("chance").value = num + "회 /3회";
  // 기회를 다썻을경우 dice 배열을 정렬 (오름차순) 및 정렬된 값을 표기
  if (num == 0) {
    for (let i = 0; i < arrDice.length; i++) {
      for (let j = 0; j < arrDice.length - i - 1; j++) {
        if (arrDice[j] > arrDice[j + 1]) {
          temp = arrDice[j];
          arrDice[j] = arrDice[j + 1];
          arrDice[j + 1] = temp;
        }
      }
    }
    for (let i = 1; i < 6; i++) {
      //  s.straight 일경우 고정 15점 표기
      if (
        (arrDice[1] == i &&
          arrDice[2] == i + 1 &&
          arrDice[3] == i + 2 &&
          arrDice[4] == i + 3) ||
        (arrDice[2] == i &&
          arrDice[3] == i + 1 &&
          arrDice[4] == i + 2 &&
          arrDice[5] == i + 3)
      ) {
        choice = "sstraight";
        document.getElementById("player" + play + choice).value = "15";
      }

      //  l.straight 일경우 고정 15점 표기
      if (
        arrDice[1] == i &&
        arrDice[2] == i + 1 &&
        arrDice[3] == i + 2 &&
        arrDice[4] == i + 3 &&
        arrDice[5] == i + 4
      ) {
        choice = "lstraight";
        document.getElementById("player" + play + choice).value = "30";
      }

      // fullhouse 일경우 5개의 총합 표기
      if (
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i &&
          arrDice[4] == i + 1 &&
          arrDice[5] == i + 1) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i &&
          arrDice[4] == i + 2 &&
          arrDice[5] == i + 2) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i &&
          arrDice[4] == i + 3 &&
          arrDice[5] == i + 3) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i &&
          arrDice[4] == i + 4 &&
          arrDice[5] == i + 4) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i &&
          arrDice[4] == i + 5 &&
          arrDice[5] == i + 5) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i + 1 &&
          arrDice[4] == i + 1 &&
          arrDice[5] == i + 1) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i + 2 &&
          arrDice[4] == i + 2 &&
          arrDice[5] == i + 2) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i + 3 &&
          arrDice[4] == i + 3 &&
          arrDice[5] == i + 3) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i + 4 &&
          arrDice[4] == i + 4 &&
          arrDice[5] == i + 4) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i + 5 &&
          arrDice[4] == i + 5 &&
          arrDice[5] == i + 5)
      ) {
        choice = "fullhouse";
        for (let i = 1; i < 6; i++) {
          document.getElementById("player" + play + choice).value =
            Number(document.getElementById("player" + play + choice).value) +
            Number(arrDice[i]);
        }
      }

      document.getElementById("result" + i).value = arrDice[i];
      document.getElementById("dice" + i).value = "0";
      document.getElementById("result" + i).disabled = true;
      document.getElementById("dice" + i).disabled = true;
    }
  }
}

function end(char) {
  // 킵한다이스 변수초기화
  Dice1 = 1;
  Dice2 = 1;
  Dice3 = 1;
  Dice4 = 1;
  Dice5 = 1;
  setTimeout(function () {
    addRow();
  }, 500);

  highscoreupt();

  // 상단 족보 end표시
  for (let i = 0; i < categories.length; i++) {
    if (char == categories[i]) {
      document.getElementById(
        "player" + play + categories[i] + "result"
      ).style.display = "block";
      document.getElementById(
        "player" + play + categories[i] + "result"
      ).value = document.getElementById("player" + play + categories[i]).value;
    }
  }
  if (char == categories[0]) {
    if (play == 1) {
      ace1 -= 1;
    } else if (play == 2) {
      ace2 -= 1;
    }
  }

  if (char == categories[1]) {
    if (play == 1) {
      deuce1 -= 1;
    } else if (play == 2) {
      deuce2 -= 1;
    }
  }

  if (char == categories[2]) {
    if (play == 1) {
      three1 -= 1;
    } else if (play == 2) {
      three2 -= 1;
    }
  }

  if (char == categories[3]) {
    if (play == 1) {
      four1 -= 1;
    } else if (play == 2) {
      four2 -= 1;
    }
  }

  if (char == categories[4]) {
    if (play == 1) {
      five1 -= 1;
    } else if (play == 2) {
      five2 -= 1;
    }
  }

  if (char == categories[5]) {
    if (play == 1) {
      sixe1 -= 1;
    } else if (play == 2) {
      sixe2 -= 1;
    }
  }

  // 하단 족보 end표시
  if (char == categories[6]) {
    if (play == 1) {
      choice1 -= 1;
    } else if (play == 2) {
      choice2 -= 1;
    }
  }

  if (char == categories[7]) {
    if (play == 1) {
      _4ofakind1 -= 1;
    } else if (play == 2) {
      _4ofakind2 -= 1;
    }
  }

  if (char == categories[8]) {
    if (play == 1) {
      fullhouse1 -= 1;
    } else if (play == 2) {
      fullhouse2 -= 1;
    }
  }

  if (char == categories[9]) {
    if (play == 1) {
      sstraight1 -= 1;
    } else if (play == 2) {
      sstraight2 -= 1;
    }
  }

  if (char == categories[10]) {
    if (play == 1) {
      lstraight1 -= 1;
    } else if (play == 2) {
      lstraight2 -= 1;
    }
  }

  if (char == categories[11]) {
    if (play == 1) {
      yacht1 -= 1;
    } else if (play == 2) {
      yacht2 -= 1;
    }
  }

  // subtotal, total 점수 초기화
  document.getElementById("player" + play + "result").value = "0";
  document.getElementById("player" + play + "total").value = "0";

  // subtotal 상단 족보 점수체크
  for (let i = 0; i < 6; i++) {
    document.getElementById("player" + play + "result").value =
      Number(
        document.getElementById("player" + play + "result").value.split("/")[0]
      ) +
      Number(
        document.getElementById("player" + play + categories[i] + "result")
          .value
      ) +
      "/63";
  }

  // total 상단 하단 족보 점수체크
  for (let i = 0; i < categories.length; i++) {
    document.getElementById("player" + play + "total").value =
      Number(document.getElementById("player" + play + "total").value) +
      Number(
        document.getElementById("player" + play + categories[i] + "result")
          .value
      ) +
      Number(document.getElementById("player" + play + "bonus").value);
  }

  if (
    Number(
      document.getElementById("player" + play + "result").value.split("/")[0]
    ) >= 63
  ) {
    document.getElementById("player" + play + "bonus").value = 35;
  }

  document.getElementById("player" + play).style.color = "red";
  document.getElementById("player" + play).style.fontWeight = "bold";

  // 상단 족보의 버튼을 없앰
  if (ace1 == 0) {
    document.getElementById("player1" + categories[0]).style.display = "none";
  }

  if (ace2 == 0) {
    document.getElementById("player2" + categories[0]).style.display = "none";
  }

  if (deuce1 == 0) {
    document.getElementById("player1" + categories[1]).style.display = "none";
  }

  if (deuce2 == 0) {
    document.getElementById("player2" + categories[1]).style.display = "none";
  }

  if (three1 == 0) {
    document.getElementById("player1" + categories[2]).style.display = "none";
  }

  if (three2 == 0) {
    document.getElementById("player2" + categories[2]).style.display = "none";
  }

  if (four1 == 0) {
    document.getElementById("player1" + categories[3]).style.display = "none";
  }

  if (four2 == 0) {
    document.getElementById("player2" + categories[3]).style.display = "none";
  }

  if (five1 == 0) {
    document.getElementById("player1" + categories[4]).style.display = "none";
  }

  if (five2 == 0) {
    document.getElementById("player2" + categories[4]).style.display = "none";
  }

  if (sixe1 == 0) {
    document.getElementById("player1" + categories[5]).style.display = "none";
  }

  if (sixe2 == 0) {
    document.getElementById("player2" + categories[5]).style.display = "none";
  }

  // 하단 족보의 버튼을 없앰
  if (choice1 == 0) {
    document.getElementById("player1" + categories[6]).style.display = "none";
  }

  if (choice2 == 0) {
    document.getElementById("player2" + categories[6]).style.display = "none";
  }

  if (_4ofakind1 == 0) {
    document.getElementById("player1" + categories[7]).style.display = "none";
  }

  if (_4ofakind2 == 0) {
    document.getElementById("player2" + categories[7]).style.display = "none";
  }

  if (fullhouse1 == 0) {
    document.getElementById("player1" + categories[8]).style.display = "none";
  }

  if (fullhouse2 == 0) {
    document.getElementById("player2" + categories[8]).style.display = "none";
  }

  if (sstraight1 == 0) {
    document.getElementById("player1" + categories[9]).style.display = "none";
  }

  if (sstraight2 == 0) {
    document.getElementById("player2" + categories[9]).style.display = "none";
  }

  if (lstraight1 == 0) {
    document.getElementById("player1" + categories[10]).style.display = "none";
  }

  if (lstraight2 == 0) {
    document.getElementById("player2" + categories[10]).style.display = "none";
  }

  if (yacht1 == 0) {
    document.getElementById("player1" + categories[11]).style.display = "none";
  }

  if (yacht2 == 0) {
    document.getElementById("player2" + categories[11]).style.display = "none";
  }
  if (play == 1) {
    for (let i = 0; i < categories.length; i++) {
      document.getElementById("player" + "1" + categories[i]).value = "0";
    }
  }

  // 기회 3으로 바꾸기
  num = 3;
  document.getElementById("chance").value = num + "회 / 3회";

  document.getElementById("start").disabled = false;

  // 다이스 버튼을 없애기
  for (let i = 1; i < 6; i++) {
    document.getElementById("result" + i).value = "0";
    document.getElementById("dice" + i).value = "0";
    document.getElementById("dice" + i).disabled = false;
  }
  // dice 값을 초기화
  function cleardice() {
    for (let i = 1; i < 6; i++) {
      document.getElementById("dice" + i).value = 0;
    }
  }
  //턴 확인 후 종료
  if (cleardice) {
    turn++;
    if (turn == 13) {
      let result = confirm(
        `총 점수 : ${Number(document.getElementById("player1total").value)}`
      );
      if (result) {
        sendscore();
        location.href = "../scoreboard.html";
      } else {
        sendscore();
        window.location.reload();
      }
    }
  }
  //점수 userid 보내기 함수
  //테이블 갱신
}

function start() {
  for (let i = 1; i < 6; i++) {
    document.getElementById("result" + i).disabled = false;
    document.getElementById("dice" + i).disabled = false;
  }
  // 모든 족보의 버튼을 0으로 초기화
  for (let i = 0; i < categories.length; i++) {
    document.getElementById("player" + play + categories[i]).value = "0";
  }

  // 첫시작일때 dice의 버튼을 보이게 설정
  if (num == 3) {
    for (let i = 1; i < 6; i++) {
      document.getElementById("dice" + i).style.display = "block";
    }
    // document.getElementById("confirmation").style.display = "block";
  }

  // dice의 값을 1~6 랜덤으로 설정
  for (let i = 1; i < 6; i++) {
    arrDice[i] = Math.round(Math.random() * 5 + 1);
    document.getElementById("dice" + i).value = arrDice[i];
  }

  // 1~5의 dice의값을 보존
  if (Dice1 == 0) {
    document.getElementById("dice1").value =
      document.getElementById("result1").value;
    arrDice[1] = document.getElementById("dice1").value;
  }

  if (Dice2 == 0) {
    document.getElementById("dice2").value =
      document.getElementById("result2").value;
    arrDice[2] = document.getElementById("dice2").value;
  }

  if (Dice3 == 0) {
    document.getElementById("dice3").value =
      document.getElementById("result3").value;
    arrDice[3] = document.getElementById("dice3").value;
  }

  if (Dice4 == 0) {
    document.getElementById("dice4").value =
      document.getElementById("result4").value;
    arrDice[4] = document.getElementById("dice4").value;
  }

  if (Dice5 == 0) {
    document.getElementById("dice5").value =
      document.getElementById("result5").value;
    arrDice[5] = document.getElementById("dice5").value;
  }

  for (let i = 1; i < 6; i++) {
    if (arrDice[i] == 1) {
      choice = "aces";
    }

    if (arrDice[i] == 2) {
      choice = "deuces";
    }

    if (arrDice[i] == 3) {
      choice = "threes";
    }

    if (arrDice[i] == 4) {
      choice = "fours";
    }

    if (arrDice[i] == 5) {
      choice = "fives";
    }

    if (arrDice[i] == 6) {
      choice = "sixes";
    }

    // 1~6족보에 값을 부여하기
    document.getElementById("player" + play + choice).value =
      Number(document.getElementById("player" + play + choice).value) +
      Number(arrDice[i]);

    // yacht일경우 고정 50점표기
    if (
      arrDice[1] == i &&
      arrDice[2] == i &&
      arrDice[3] == i &&
      arrDice[4] == i &&
      arrDice[5] == i
    ) {
      choice = "yacht";
      document.getElementById("player" + play + choice).value = "50";
    }

    // 4 of a kind 일경우 5개의 합 표기
    if (
      (arrDice[1] == i &&
        arrDice[2] == i &&
        arrDice[3] == i &&
        arrDice[4] == i) ||
      (arrDice[1] == i &&
        arrDice[2] == i &&
        arrDice[3] == i &&
        arrDice[5] == i) ||
      (arrDice[1] == i &&
        arrDice[2] == i &&
        arrDice[4] == i &&
        arrDice[5] == i) ||
      (arrDice[1] == i &&
        arrDice[3] == i &&
        arrDice[4] == i &&
        arrDice[5] == i) ||
      (arrDice[2] == i && arrDice[3] == i && arrDice[4] == i && arrDice[5] == i)
    ) {
      choice = "4ofakind";
      for (let i = 1; i < 6; i++) {
        document.getElementById("player" + play + choice).value =
          Number(document.getElementById("player" + play + choice).value) +
          Number(arrDice[i]);
      }
    }

    // choice 5개의 합 표기
    document.getElementById("player" + play + "choice").value =
      Number(document.getElementById("player" + play + "choice").value) +
      Number(arrDice[i]);
  }

  // 굴릴때마다 기회 1빼기
  num -= 1;
  document.getElementById("chance").value = num + "회 / 3회";

  // 기회를 다썻을경우 dice 배열을 정렬 (오름차순) 및 정렬된 값을 표기
  if (num == 0) {
    document.getElementById("start").disabled = true;
    for (let i = 0; i < arrDice.length; i++) {
      for (let j = 0; j < arrDice.length - i - 1; j++) {
        if (arrDice[j] > arrDice[j + 1]) {
          temp = arrDice[j];
          arrDice[j] = arrDice[j + 1];
          arrDice[j + 1] = temp;
        }
      }
    }
    for (let i = 1; i < 6; i++) {
      //  s.straight 일경우 고정 15점 표기
      if (
        (arrDice[1] == i &&
          arrDice[2] == i + 1 &&
          arrDice[3] == i + 2 &&
          arrDice[4] == i + 3) ||
        (arrDice[2] == i &&
          arrDice[3] == i + 1 &&
          arrDice[4] == i + 2 &&
          arrDice[5] == i + 3) ||
        (arrDice[1] == i &&
          arrDice[2] == i + 1 &&
          arrDice[3] == i + 2 &&
          arrDice[5] == i + 3) ||
        (arrDice[1] == i &&
          arrDice[2] == i + 1 &&
          arrDice[4] == i + 2 &&
          arrDice[5] == i + 3) ||
        (arrDice[1] == i &&
          arrDice[3] == i + 1 &&
          arrDice[4] == i + 2 &&
          arrDice[5] == i + 3)
      ) {
        choice = "sstraight";
        document.getElementById("player" + play + choice).value = "15";
      }

      //  l.straight 일경우 고정 30점 표기
      if (
        arrDice[1] == i &&
        arrDice[2] == i + 1 &&
        arrDice[3] == i + 2 &&
        arrDice[4] == i + 3 &&
        arrDice[5] == i + 4
      ) {
        choice = "lstraight";
        document.getElementById("player" + play + choice).value = "30";
      }

      // fullhouse 일경우 5개의 총합 표기
      if (
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i &&
          arrDice[4] == i + 1 &&
          arrDice[5] == i + 1) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i &&
          arrDice[4] == i + 2 &&
          arrDice[5] == i + 2) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i &&
          arrDice[4] == i + 3 &&
          arrDice[5] == i + 3) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i &&
          arrDice[4] == i + 4 &&
          arrDice[5] == i + 4) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i &&
          arrDice[4] == i + 5 &&
          arrDice[5] == i + 5) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i + 1 &&
          arrDice[4] == i + 1 &&
          arrDice[5] == i + 1) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i + 2 &&
          arrDice[4] == i + 2 &&
          arrDice[5] == i + 2) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i + 3 &&
          arrDice[4] == i + 3 &&
          arrDice[5] == i + 3) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i + 4 &&
          arrDice[4] == i + 4 &&
          arrDice[5] == i + 4) ||
        (arrDice[1] == i &&
          arrDice[2] == i &&
          arrDice[3] == i + 5 &&
          arrDice[4] == i + 5 &&
          arrDice[5] == i + 5)
      ) {
        choice = "fullhouse";
        for (let i = 1; i < 6; i++) {
          document.getElementById("player" + play + choice).value =
            Number(document.getElementById("player" + play + choice).value) +
            Number(arrDice[i]);
        }
      }

      document.getElementById("result" + i).value = arrDice[i];
      document.getElementById("dice" + i).value = arrDice[i];
      document.getElementById("result" + i).style.display = "block";
      document.getElementById("dice" + i).value = "0";
      document.getElementById("dice" + i).disabled = true;
      document.getElementById("result" + i).disabled = true;
    }
  }
}

// 다이스를 keep 했을때
function dice(num) {
  document.getElementById("result" + num).value = document.getElementById(
    "dice" + num
  ).value;
  document.getElementById("result" + num).style.display = "block";
  document.getElementById("dice" + num).style.display = "none";

  if (num == 1) {
    Dice1 -= 1;
  }

  if (num == 2) {
    Dice2 -= 1;
  }

  if (num == 3) {
    Dice3 -= 1;
  }

  if (num == 4) {
    Dice4 -= 1;
  }

  if (num == 5) {
    Dice5 -= 1;
  }
}

// keep한 다이스를 다시 가져올때
function backdice(num) {
  document.getElementById("result" + num).value = "";
  document.getElementById("result" + num).style.display = "none";
  document.getElementById("dice" + num).style.display = "block";

  if (num == 1) {
    Dice1 += 1;
  }

  if (num == 2) {
    Dice2 += 1;
  }

  if (num == 3) {
    Dice3 += 1;
  }

  if (num == 4) {
    Dice4 += 1;
  }

  if (num == 5) {
    Dice5 += 1;
  }
}
