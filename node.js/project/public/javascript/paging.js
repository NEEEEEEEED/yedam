const url = "/board";
//조회
selectAll();

//단건조회

//전체조회 function

//reading 페이지 이동(해당 no)
function readlist(no) {
  location.href = "./reading.html?no=" + no;
}

//날짜 포맷 변경 yyyy-mm-dd
function getYmd10(wdata) {
  var d = new Date(wdata);
  return (
    d.getFullYear() +
    "-" +
    (d.getMonth() + 1 > 9
      ? (d.getMonth() + 1).toString()
      : "0" + (d.getMonth() + 1)) +
    "-" +
    (d.getDate() > 9 ? d.getDate().toString() : "0" + d.getDate().toString())
  );
}
