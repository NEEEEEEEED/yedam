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
            $("#receipt").DataTable({
               lengthChange: false,
                info: false,
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

.insert {
	display: inline-blcok;
	float: left;
}

form {
	clear: both;
}

#btnGrp {
	display: inline-blcok;
	float: right;
	text-align: right;
}

#receipt th:first-child::after {
	display: none;
}

#receipt th:first-child::before {
	display: none;
}
</style>
</head>
<body>
	<!-- ============================================================== -->
	<!-- 페이지 헤더 -->
	<!-- ============================================================== -->
	<div class="row">
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#" class="breadcrumb-link">자재관리</a></li>
				<li class="breadcrumb-item active" aria-current="page">자재입고</li>
			</ol>
		</nav>
	</div>
		<!-- ============================================================== -->
		<!-- 자재 입고 등록 자재 입고 등록 자재 입고 등록 자재 입고 등록 자재 입고 등록 자재 입고 등록 -->
		<div class="card">
			<div class="card-body">
				<h3 class="insert">자재입고등록</h3>
				<div id="btnGrp">
					<button type="submit" class="btn btn-primary" id="insertBtn">등록</button>
					<button type="reset" class="btn btn-secondary">초기화</button>
				</div>
				<form class="row g-3" name="insertForm" action="matReceiptInsert"
					method="post" onsubmit="return false"
					style="margin: 0px 5px 5px 5px;">

					<div class="col-md-2">
						<label for="country" class="form-label">LOT번호</label> RLT<input
							type="text" class="form-control" id="rscLotCd" name="rscLotCd"
							placeholder="숫자만 입력해주세요.">
					</div>

					<div class="col-md-2">
						<label for="country" class="form-label">자재코드</label> <input
							type="text" class="form-control" id="rscCd" name="rscCd"
							placeholder="">
					</div>

					<div class="col-md-2">
						<label for="country" class="form-label">발주번호</label> <input
							type="text" class="form-control" id="ordrCd" name="ordrCd">
					</div>

					<div class="col-md-2">
						<label for="country" class="form-label">검사코드</label> <input
							type="text" class="form-control" id="rscInspCd" name="rscInspCd">
					</div>

					<div class="col-md-2">
						<label for="country" class="form-label">입고수량</label> <input
							type="text" class="form-control" id="istCnt" name="istCnt"
							placeholder="숫자를 입력하세요.">
					</div>

					<div class="col-md-2">
						<label for="country" class="form-label">입고일</label> <input
							type="date" class="form-control" id="istDt" name="istDt">
					</div>

				</form>
			</div>
		</div>
	<!-- 자재입고등록 자재입고등록 자재입고등록 자재입고등록 자재입고등록 자재입고등록  -->
	<!-- ============================================================== -->
<!-- 자재입고현황테이블 자재입고현황테이블 자재입고현황테이블 자재입고현황테이블 자재입고현황테이블  -->

<div class="row">
	<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
		<div class="card">
			<div class="card-body d-flex justify-content-between">
				<h3 >자재입고현황</h3>
				<div id="btnGrp">
					<sec:authorize access="hasRole('ROLE_ADMIN')">						
						<button type="button" class="btn btn-primary" id="updateBtn" onclick="updateBtn()">수정</button>
						<button type="button" class="btn btn-danger"
							onclick="deleteBtn()">삭제</button>
					</sec:authorize>
				</div>
			</div>
			<div class="table-responsive">
				<table id="receipt"
					class="table table-striped table-bordered first">
					<thead>
						<tr>
							<th><input type="checkbox" id="cbx_chkAll" /></th>
							<th>No.</th>
							<th>LOT번호</th>
							<th>자재코드</th>
							<th>자재명</th>
							<th>발주번호</th>
							<th>발주수량</th>
							<th>검사코드</th>
							<th>입고수량</th>
							<th>입고일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="matReceipt" items="${matReceiptList }"
							varStatus="loop">
							<tr data-id="${matReceipt.rscLotCd }">
								<td><input type="checkbox" name="chk"/></td>
								<td>${loop.count }</td>
								<td>${matReceipt.rscLotCd }</td>
								<td>${matReceipt.rscCd }</td>
								<td>${matReceipt.rscNm }</td>
								<td>${matReceipt.ordrCd }</td>
								<td>${matReceipt.ordrCnt }</td>
								<td>${matReceipt.rscInspCd }</td>
								<td>${matReceipt.istCnt }</td>
								<td><fmt:formatDate value="${matReceipt.istDt }"
										pattern="yyyy-MM-dd" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>


	<script>
	<!-- ============================================================== -->
	<!-- 자재입고등록 자재입고등록 자재입고등록 자재입고등록 자재입고등록 자재입고등록  -->
      
      function formOptionChk() {
          let rscLotCd = document.getElementsByName('rscLotCd')[0];
          let rscCd = document.getElementsByName('rscCd')[0];
          let ordrCd = document.getElementsByName('ordrCd')[0];
          let rscInspCd = document.getElementsByName('rscInspCd')[0];
          let istCnt = document.getElementsByName('istCnt')[0];
          let istDt = document.getElementsByName('istDt')[0];

          if (rscLotCd.value == "") {
              alert("LOT번호가 입력되지 않았습니다.");
              rscLotCd.focus();
              return false; // 페이지 이동을 막기 위해 false를 반환합니다.
          }
          if (rscCd.value == "") {
              alert("자재코드가 입력되지 않았습니다.");
              rscCd.focus();
              return false;
          }          
          if (ordrCd.value == "") {
              alert("발주번호가 입력되지 않았습니다.");
              ordrCd.focus();
              return false;
          }
          if (rscInspCd.value == "") {
              alert("검사코드 입력되지 않았습니다.");
              rscInspCd.focus();
              return false;
          }
          if (istCnt.value == "") {
              alert("입고수량이 입력되지 않았습니다.");
              istCnt.focus();
              return false;
          }
          if (istDt.value == "") {
              alert("입고일이 입력되지 않았습니다.");
              istDt.focus();
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

          return false;
      }

      $("#insertBtn").on("click", formOptionChk);

<!-- 자재입고등록 자재입고등록 자재입고등록 자재입고등록 자재입고등록 자재입고등록  -->
<!-- ============================================================== -->      
<!-- ============================================================== -->   
<!-- 체크박스 체크박스 체크박스 체크박스 체크박스 체크박스 체크박스 체크박스 체크박스 -->

//체크박스 전체 선택
$(document).on("click", "#cbx_chkAll", function () {
      if ($("#cbx_chkAll").is(":checked")) {
        $("input[name=chk]")
          .prop("checked", true)
          .closest("tr")
          .addClass("selected");
        $("input[name=chk]").closest("tr").addClass("table-danger");
      } else {
        $("input[name=chk]")
          .prop("checked", false)
          .closest("tr")
          .removeClass("selected");
        $("input[name=chk]").closest("tr").removeClass("table-danger");
      }
    });

    $(document).on("click", "input[name=chk]", function () {
      var total = $("input[name=chk]").length;
      var checked = $("input[name=chk]:checked").length;

      if (total != checked) $("#cbx_chkAll").prop("checked", false);
      else $("#cbx_chkAll").prop("checked", true);
    });

    //체크되면 빨간색으로 바뀜
    $(document).on("change", ":checkbox", function () {
      if ($(this).prop("checked")) {
        if (!$(this).closest("tr").children().eq(0).is("th")) {
          $(this).closest("tr").addClass("table-danger");
        }
      } else {
        $(this).closest("tr").removeClass("table-danger");
      }
    });

    // tr 선택해도 체크 됨
    $(document).on("click", "table tr", function (event) {
      if (event.target.type !== "checkbox") {
        const $checkbox = $(":checkbox", this);
        const td = $(".my-td-class", this);
        if (td.is(event.target)) {
          event.stopPropagation();
        } else {
          $checkbox.trigger("click");
        }
      }
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
    $("#cbx_chkAll").prop("disabled", true);
    disableCheckBoxes();

    // 수정 버튼의 텍스트를 "수정완료"로 변경
    $("#updateBtn").text("수정완료");

    // 수정완료 버튼 클릭 이벤트 핸들러 설정
    // $(".btn-info").off("click").on("click", submitBtn);
    $("#updateBtn").removeAttr("onclick");
    $("#updateBtn").attr("onclick", "submitBtn();");

    $('input[name="chk"]:checked').each(function () {
      var row = $(this).closest("tr");
      var rscLotCd = row.find("td:eq(2)").text().trim();
      var rscCd = row.find("td:eq(3)").text().trim();
      var ordrCd = row.find("td:eq(5)").text().trim();
      var rscInspCd = row.find("td:eq(7)").text().trim();      
      var istDt = row.find("td:eq(9)").text().trim();
           
      row
        .find("td:eq(2)")
        .html(
          '<input type="text" class="form-control" value="' + rscLotCd + '">'
        );
      row
        .find("td:eq(3)")
        .html(
          '<input type="text" class="form-control" value="' + rscCd + '">'
        );      
      row
        .find("td:eq(5)")
        .html(
          '<input type="text" class="form-control" value="' + ordrCd + '">'
        );
      row
        .find("td:eq(7)")
        .html(
          '<input type="text" class="form-control" value="' + rscInspCd + '">'
        );
      row
      .find("td:eq(9)")
      .html(
   		  '<input type="date" class="form-control" value="' + istDt + '">'
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
      var rscLotCd = row.find("td:eq(2) input").val().trim();
      var rscCd = row.find("td:eq(3) input").val().trim();
      var ordrCd = row.find("td:eq(5) input").val().trim();
      var rscInspCd = row.find("td:eq(7) input").val().trim();
      var istDt = row.find("td:eq(9) input").val().trim();

      // 객체 형식으로 데이터 저장
      var dataObj = {
    		  rscLotCd: rscLotCd,
    		  rscCd: rscCd,
    		  ordrCd: ordrCd,
    		  rscInspCd: rscInspCd,
    		  istDt: istDt
      };

      // 데이터 배열에 객체 추가
      dataArr.push(dataObj);
    });

    $.ajax({
      url: "updateMatReceipt",
      method: "POST",
      headers: { "Content-Type": "application/json" },
      data: JSON.stringify(dataArr),
      success: function (result) {
        if (result.result == "success") {
          $("tbody").empty();
          $(result.data).each(function (idx, item) {
            var $row = $("<tr>").attr("data-id", item.rscLotCd);
            $row.append(
              $("<td>").html(
                '<input type="checkbox" name="chk" value="' +
                  item.rscLotCd +
                  '" />'
              )
            );
            $row.append($("<td>").text(idx + 1));
            $row.append($("<td>").text(item.rscLotCd));
            $row.append($("<td>").text(item.rscCd));
            $row.append($("<td>").text(item.rscNm));
            $row.append($("<td>").text(item.ordrCd));
            $row.append($("<td>").text(item.ordrCnt));
            $row.append($("<td>").text(item.rscInspCd));
            $row.append($("<td>").text(item.istCnt));
            $row.append($("<td>").text(new Date(item.istDt).toISOString().slice(0, 10)));
            $("tbody").append($row);
          });
          enableCheckBoxes();
          $("#updateBtn").text("수정");
          $("#updateBtn").removeAttr("onclick");
          $("#updateBtn").attr("onclick", "updateBtn();");
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
      
  <!-- 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 수정 -->
  <!-- ============================================================== -->
  <!-- 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 -->
  function deleteBtn() {
      let valueArr = new Array();
      let list = $("input[name=chk]");
      for (let i = 0; i < list.length; i++) {
        if (list[i].checked) {
          valueArr.push(list[i].value);
        }
      }
      if (valueArr.length == 0) {
        Swal.fire({
          icon: "warning",
          title: "선택된 글이 없습니다.",
        });
      } else {
        Swal.fire({
          title: "삭제 하시겠습니까?",
          text: "복구 할 수 없습니다.",
          icon: "warning",
          showCancelButton: true,
          confirmButtonColor: "#d33",
          cancelButtonColor: "#3085d6",
          confirmButtonText: "삭제",
          cancelButtonText: "취소",
        }).then((result) => {
          if (result.value) {
            $.ajax({
              url: "matReceiptDelete",
              method: "post",
              traditional: true,
              data: { valueArr: valueArr },
              success: function (result) {
                if (result == "success") {
                  for (let i = 0; i < valueArr.length; i++) {
                    $('tr[data-id="' + valueArr[i] + '"]').remove();
                  }
                } else if (result == "error") {
                  Swal.fire({
                    icon: "error",
                    title: "오류가 발생했습니다.",
                  });
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
                  title: "삭제가 정상적으로 되었습니다.",
                });
              },
              error: function (reject) {
                console.log(reject);
              },
            });
          }
        });
      }
    }
  <!-- 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 삭제 -->
  <!-- ============================================================== --> 	
	
	</script>
</body>
</html>