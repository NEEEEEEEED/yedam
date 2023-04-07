<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
   uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
   href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap5.min.css">
<script
   src="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.js"></script>
<script>
        jQuery(function($){
            $("#matOrderList").DataTable({
               lengthChange: false,
                info: false,
                aaSorting : []
            });
        });
    </script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">



<!-- jQuery and Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


<meta charset="UTF-8">
<title>Material List</title>
<style>
table, tr, th, td {
   border: 1px solid black;
}

#matOrderList th:first-child::after {
   display: none;
}

#matOrderList th:first-child::before {
   display: none;
}

#btnGrp {
   text-align: right;
}

.card-body {
   display: flex;
   justify-content: space-between;
   align-items: center;
}
</style>
</head>
<body>
   <div>
      <!-- ============================================================== -->
      <!-- pageheader -->
      <!-- ============================================================== -->
      <div class="row">
         <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
               <li class="breadcrumb-item"><a href="#"
                  class="breadcrumb-link">자재관리</a></li>
               <!-- <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Tables</a></li> -->
               <li class="breadcrumb-item active" aria-current="page">자재정보</li>
            </ol>
         </nav>
      </div>
      <!-- ============================================================== -->
      <!-- basic table  -->
      <!-- ============================================================== -->
      <div class="row">
         <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
            <div class="card">
               <div class="card-body d-flex justify-content-between">
                  <h3 class="">자재발주</h3>
                  <div id="btnGrp">
                     <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <button type="button" class="btn btn-success"
                           data-bs-toggle="modal" data-bs-target="#orderModal">추가</button>
                        <button type="button" class="btn btn-info" onclick="updateBtn()">수정</button>
                        <button type="button" class="btn btn-danger"
                           onclick="deleteBtn()">삭제</button>
                     </sec:authorize>
                  </div>
               </div>
               <div class="table-responsive">
                  <table id="matOrderList"
                     class="table table-striped table-bordered first">
                     <thead>
                        <tr>
                           <th><input type="checkbox" id="cbx_chkAll" /></th>
                           <th>No.</th>
                           <th>발주번호</th>
                           <th>발주신청일</th>
                           <th>거래처코드</th>
                           <th>거래처명</th>
                           <th>자재코드</th>
                           <th>자재명</th>
                           <th>발주량</th>
                           <th>납기요청일</th>
                        </tr>
                     </thead>
                     <tbody>
                        <c:forEach var="matOrder" items="${matOrderList }"
                           varStatus="loop">
                           <tr data-id="${matOrder.ordrCd }">
                              <td><input type="checkbox" name="chk"
                                 value="${matOrder.ordrCd }" /></td>
                              <td>${loop.count }</td>
                              <td>${matOrder.ordrCd }</td>
                              <td><fmt:formatDate value="${matOrder.ordrReqDt }"
                                    pattern="yyyy-MM-dd" /></td>
                              <td>${matOrder.vendCd }</td>
                              <td>${matOrder.vendNm }</td>
                              <td>${matOrder.rscCd }</td>
                              <td>${matOrder.rscNm }</td>
                              <td>${matOrder.ordrCnt }</td>
                              <td><fmt:formatDate value="${matOrder.paprdCmndDt }"
                                    pattern="yyyy-MM-dd" /></td>
                           </tr>
                        </c:forEach>
                     </tbody>
                  </table>
               </div>
            </div>
         </div>
      </div>
      <!-- ################Extra Large Modal################################## -->
      <div class="modal fade" id="orderModal" tabindex="-1">
         <div class="modal-dialog modal-xl">
            <div class="modal-content">
               <div class="modal-header">
                  <h3 class="modal-title">자재발주</h3>
                  <button type="button" class="btn-close" data-bs-dismiss="modal"
                     aria-label="Close"></button>
               </div>
               <form class="row g-3" name="insertForm" action="matOrderInsert"
                  method="post" onsubmit="return false"
                  style="margin: 0px 5px 5px 5px;">


                  <div class="col-md-3">
                     <label for="country" class="form-label">발주번호</label><input
                        type="text" class="form-control" id="ordrCd" name="ordrCd"
                        placeholder="발주번호를 입력해주세요..">
                  </div>

                  <div class="col-md-3">
                     <label for="country" class="form-label">발주신청일</label> <input
                        type="date" class="form-control" id="ordrReqDt" name="ordrReqDt"
                        placeholder="">
                  </div>

                  <div class="col-md-3">
                     <label for="country" class="form-label">거래처코드</label><select
                        class="form-control" id="vendCd" name="vendCd" required="">
                        <option value="none" disabled selected>=== 선택 ===</option>
                        <option value="VEI1000">VEI1000</option>
                        <option value="VEI1001">VEI1001</option>
                     </select>
                  </div>

                  <div class="col-md-3">
                     <label for="country" class="form-label">거래처명</label> <input
                        type="text" class="form-control" id="vendNm" name="vendNm">
                  </div>

                  <div class="col-md-3">
                     <label for="country" class="form-label">자재코드</label> <input
                        type="text" class="form-control" id="rscCd" name="rscCd">
                  </div>

                  <div class="col-md-3">
                     <label for="country" class="form-label">자재명</label> <input
                        type="text" class="form-control" id="rscNm" name="rscNm">
                  </div>

                  <div class="col-md-3">
                     <label for="country" class="form-label">발주량</label> <input
                        type="text" class="form-control" id="ordrCnt" name="ordrCnt">
                  </div>

                  <div class="col-md-3">
                     <label for="country" class="form-label">납기요청일</label> <input
                        type="date" class="form-control" id="paprdCmndDt"
                        name="paprdCmndDt">
                  </div>
               </form>
               <div class="modal-footer">                  
                  <button type="submit" class="btn btn-primary" id="insertBtn">
                     등록</button>
               </div>
            </div>
         </div>
      </div>
      <!-- End Extra Large Modal-->



      <!-- ============================================================== -->
      <!-- end basic table  -->
      <!-- ============================================================== -->

<script>
<!-- ============================================================== -->
 <!-- 등록  등록  등록  등록  등록  등록  등록  등록  등록  등록  등록  등록  등록 -->
<!-- ============================================================== -->   
      
      function formOptionChk() {
          let ordrCd = document.getElementsByName('ordrCd')[0];
          let ordrReqDt = document.getElementsByName('ordrReqDt')[0];
          let vendCd = $("#vendCd option:selected").val();
          let vendNm = document.getElementsByName('vendNm')[0];
          let rscCd = document.getElementsByName('rscCd')[0];
          let rscNm = document.getElementsByName('rscNm')[0];
          let ordrCnt = document.getElementsByName('ordrCnt')[0];
          let paprdCmndDt = document.getElementsByName('paprdCmndDt')[0];

          if (ordrCd.value == "") {
              alert("발주번호가 입력되지 않았습니다.");
              ordrCd.focus();
              return false; // 페이지 이동을 막기 위해 false를 반환합니다.
          }
          if (ordrReqDt.value == "") {
              alert("발주신청일이 입력되지 않았습니다.");
              ordrReqDt.focus();
              return false;
          }
          if (vendCd == "none") {
              alert("거래처코드가 선택되지 않았습니다.");
              $("#vendCd").focus();
              return false;
          }
          if (vendNm.value == "") {
              alert("거래처명이 선택되지 않았습니다.");
              $("#vendNm").focus();
              return false;
          }
          if (rscCd.value == "") {
              alert("자재코드가 입력되지 않았습니다.");
              rscCd.focus();
              return false;
          }
          if (rscNm.value == "") {
              alert("자재명이 입력되지 않았습니다.");
              $("#rscNm").focus();
              return false;
          }
          if (ordrCnt.value == "") {
              alert("발주량이 입력되지 않았습니다.");
              $("#ordrCnt").focus();
              return false;
          }
          if (paprdCmndDt.value == "") {
              alert("납기요청일이 입력되지 않았습니다.");
              $("#paprdCmndDt").focus();
              return false;
          }
          
          // Swal.fire를 추가합니다.
          Swal.fire({
              title: '등록하시겠습니까?',
              icon: 'question',
              showCancelButton: true,
              confirmButtonColor: '#3085d6',
              cancelButtonColor: '#d33',
              confirmButtonText: '등록',
              cancelButtonText: '취소'
          }).then((result) => {
              if (result.value) {
                  insertForm.submit();
              }
          });

          return false; // 이벤트의 기본 동작인 페이지 이동을 막기 위해 false를 반환합니다.
      }

      $("#insertBtn").on("click", formOptionChk)
      
       // 닫기버튼 시 초기화
      $(".btn-close").on("click", function () {
      $('form[name="insertForm"] input').val("");
      $('form[name="insertForm"] textarea').val("");
      $("#vendCd").val("none");
    });

<!-- 등록 끝  등록 끝 등록 끝 등록 끝 등록 끝 등록 끝 등록 끝 등록 끝 등록 끝 -->
<!-- ============================================================== -->   
<!-- 체크박스 체크박스 체크박스 체크박스 체크박스 체크박스 체크박스 체크박스 체크박스 -->

//체크박스 전체 선택
$(document).ready(function () {

  $("#cbx_chkAll").click(function () {
    if ($(this).is(":checked"))
      $("input[name=chk]")
        .prop("checked", true)
        .closest("tr")
        .addClass("selected");
    else
      $("input[name=chk]")
        .prop("checked", false)
        .closest("tr")
        .removeClass("selected");
  });

  $(document).on("click", "input[name=chk]", function () {
    var total = $("input[name=chk]").length;
    var checked = $("input[name=chk]:checked").length;

    if (total != checked) $("#cbx_chkAll").prop("checked", false);
    else $("#cbx_chkAll").prop("checked", true);
  });
});

//행 선택하면 체크
$(document).on("click", "table tr", function (event) {
  if (event.target.type !== "checkbox") {
    $(":checkbox", this).trigger("click");
  }
});

$(document).on("change", "table tr :checkbox", function (event) {
  $(this).closest("tr").toggleClass("selected", this.checked);
});
<!-- 체크박스 체크박스 체크박스 체크박스 체크박스 체크박스 체크박스 체크박스 체크박스 -->
<!-- ============================================================== -->
<!-- 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 -->

function updateBtn() {
    // 체크된 체크박스가 없으면 함수 종료
    if ($("input[name=chk]:checked").length === 0) {
      Swal.fire({
        icon: "warning",
        title: "선택된 글이 없습니다.",
      });
      return;
    }

    disableCheckBoxes();

    // 수정 버튼의 텍스트를 "수정완료"로 변경
    $(".btn-info").text("수정완료");

    // 수정완료 버튼 클릭 이벤트 핸들러 설정
    // $(".btn-info").off("click").on("click", submitBtn);
    $(".btn-info").removeAttr("onclick");
    $(".btn-info").attr("onclick", "submitBtn();");

    $('input[name="chk"]:checked').each(function () {
      var row = $(this).closest("tr");
      var vendTyp = row.find("td:eq(2)").text().trim();
      var vendCd = row.find("td:eq(3)").text().trim();
      var vendNm = row.find("td:eq(4)").text().trim();
      var vendMag = row.find("td:eq(5)").text().trim();
      var brNum = row.find("td:eq(6)").text().trim();
      var vendTel = row.find("td:eq(7)").text().trim();
      var remk = row.find("td:eq(8)").text().trim();

      row
        .find("td:eq(2)")
        .html(
          '<input type="text" class="form-control" value="' + vendTyp + '">'
        );
      row
        .find("td:eq(3)")
        .html(
          '<input type="text" class="form-control" value="' + vendCd + '">'
        );
      row
        .find("td:eq(4)")
        .html(
          '<input type="text" class="form-control" value="' + vendNm + '">'
        );
      row
        .find("td:eq(5)")
        .html(
          '<input type="text" class="form-control" value="' + vendMag + '">'
        );
      row
        .find("td:eq(6)")
        .html(
          '<input type="text" class="form-control" value="' + brNum + '">'
        );
      row
        .find("td:eq(7)")
        .html(
          '<input type="text" class="form-control" value="' + vendTel + '">'
        );
      row
        .find("td:eq(8)")
        .html(
          '<input type="text" class="form-control" value="' + remk + '">'
        );
    });
  }

  function submitBtn() {
    // 체크된 체크박스가 없으면 함수 종료
    if ($("input[name=chk]:checked").length === 0) return;

    // 데이터를 저장할 배열 선언
    var dataArr = [];

    // 체크된 체크박스의 개수만큼 반복하며 데이터 저장
    $('input[name="chk"]:checked').each(function () {
      var row = $(this).closest("tr");
      var vendTyp = row.find("td:eq(2) input").val().trim();
      var vendCd = row.find("td:eq(3) input").val().trim();
      var vendNm = row.find("td:eq(4) input").val().trim();
      var vendMag = row.find("td:eq(5) input").val().trim();
      var brNum = row.find("td:eq(6) input").val().trim();
      var vendTel = row.find("td:eq(7) input").val().trim();
      var remk = row.find("td:eq(8) input").val().trim();

      // 객체 형식으로 데이터 저장
      var dataObj = {
        vendTyp: vendTyp,
        vendCd: vendCd,
        vendNm: vendNm,
        vendMag: vendMag,
        brNum: brNum,
        vendTel: vendTel,
        remk: remk,
      };

      // 데이터 배열에 객체 추가
      dataArr.push(dataObj);
    });

    $.ajax({
      url: "updateVend",
      method: "POST",
      headers: { "Content-Type": "application/json" },
      data: JSON.stringify(dataArr),
      success: function (result) {
        if (result.result == "success") {
          $("tbody").empty();
          $(result.data).each(function (idx, item) {
            var $row = $("<tr>").attr("data-id", item.vendCd);
            $row.append(
              $("<td>").html(
                '<input type="checkbox" name="chk" value="' +
                  item.vendCd +
                  '" />'
              )
            );
            $row.append($("<td>").text(idx + 1));
            $row.append($("<td>").text(item.vendTyp));
            $row.append($("<td>").text(item.vendCd));
            $row.append($("<td>").text(item.vendNm));
            $row.append($("<td>").text(item.vendMag));
            $row.append($("<td>").text(item.brNum));
            $row.append($("<td>").text(item.vendTel));
            $row.append($("<td>").text(item.remk));
            $("tbody").append($row);
          });
          enableCheckBoxes();
          $(".btn-info").text("수정");
          $(".btn-info").removeAttr("onclick");
          $(".btn-info").attr("onclick", "updateBtn();");
        }

        let Toast = Swal.mixin({
          toast: true,
          position: "top",
          showConfirmButton: false,
          timer: 1500,
          timerProgressBar: true,
          didOpen: (toast) => {
            toast.addEventListener("mouseenter", Swal.stopTimer);
            toast.addEventListener("mouseleave", Swal.resumeTimer);
          },
        });

        Toast.fire({
          icon: "success",
          title: "수정이 정상적으로 되었습니다.",
        });
      },
      error: function (reject) {
        console.log(reject);
      },
    });
  }

  function disableCheckBoxes() {
    $('input[name="chk"]').prop("disabled", true);
  }

  function enableCheckBoxes() {
    $('input[name="chk"]').prop("disabled", false);
  }
      
      
      
      
      </script>
</body>
</html>