var IMP = window.IMP; // 생략가능
IMP.init('imp42753804'); // <-- 본인 가맹점 식별코드 삽입


function requestPay() {

	//결제내용 확인 체크
	if (!document.querySelector('#paymentInfoCheck').checked) {
		alert("주문정보를 확인 해주세요.");
		return;
	}

	//총 결제 금액
	var totalPrice = document.querySelectorAll('.totalPrice')[1].textContent;
	//결제 상품 이름
	var name = "";
	var productName = document.querySelectorAll('.selectBox:checked')
	if (productName.length > 0) {
		name = productName[0].dataset.name + " 외 " + (productName.length - 1) + "개";

	} else {
		name = productName[0].dataset.name
	}
	//결제자 이메일
	var buyerEmail = document.querySelector('#bemail').value;
	//결제자 이름
	var buyerName = document.querySelector('#bname').value;
	//결제자 번호
	var buyerTel = document.querySelector('#bphone').value;
	//결제자 주소

	//결제자 ID
	var memId = document.querySelector('#couponList').dataset.id;

	//수신자 이름
	var ordReciever = document.querySelector('#rname').value;
	if (!ordReciever) {
		alert("수신자 이름을 확인 해주세요.");
		return;
	}
	//수신자 연락처
	var ordPhone = document.querySelector('#rphone').value;
	if (!ordPhone) {
		alert("수신자 연락처를 확인 해주세요.");
		return;
	}
	//수신자 주소
	var ordAddr = document.querySelector('#sample4_roadAddress').value + "/"
		+ document.querySelector('#sample4_extraAddress').value + "/"
		+ document.querySelector('#sample4_detailAddress').value
	if (!document.querySelector('#sample4_detailAddress').value) {
		alert("주소를 확인 해주세요.");
		return;
	}

	//결제자 우편번호
	var ordPostcode = document.querySelector('#sample4_postcode').value;
	if (!ordPostcode) {
		alert("우편번호를 확인 해주세요.");
		return;
	}
	//쿠폰 id
	var coupId = document.querySelector('#payBtn').dataset.id;
	//쿠폰 가격
	var payCouponprice = document.querySelector('#payBtn').dataset.price;
	//할인전 가격
	var payTotalprice = document.querySelectorAll('.sumCartPrice')[0].textContent;
	console.log(payTotalprice)
	//결제코드
	var merchant_uid = 'chamsu_' + new Date().getTime();
	//pro_id
	var proId =
	//상품당 구입 개수
	var ordQuant =
	//상품당 합계금액
	var ordProSumprice =
	IMP.init('iamport'); //iamport 대신 자신의 "가맹점 식별코드"를 사용
	IMP.request_pay({
		pg: "inicis",
		pay_method: "card",
		merchant_uid: merchant_uid,
		name: name,	//수정부분
		amount: 100,		//수정부분
		buyer_email: buyerEmail,	//수정
		buyer_name: buyerName,			//수정
		buyer_tel: buyerTel	//수정
		//		    buyer_addr : '서울특별시 강남구 삼성동',	//수정
		//		    buyer_postcode : '123-456'		//수정
	}, function(rsp) { // callback
		console.log(rsp)
		if (rsp.success) {
			console.log(rsp.success)
			let msg = '결제가 완료되었습니다.';
			//주문정보 저장 -orders table
			$.ajax({
				url: "addOrder.do",
				type: "POST",
				data: {
					ordStatus: '결제완료',
					memId: memId,
					ordReceiver: ordReciever,
					ordAddr: ordAddr,
					ordPhone: ordPhone,
					ordPostcode: ordPostcode,
					ordTotalPrice: totalPrice,
					coupId: coupId,
					payCouponprice: payCouponprice,
					payTotalprice: payTotalprice,
					payCode: merchant_uid
				},
				success: function(result) {
					if (result.retCode == "Success") {
						console.log("주문테이블 등록 성공")
					} else {
						console.log("주문테이블 등록 실패")
					}
				},
				error: function(error) {
					console.log("실패");
				}
			})
//			orderProduct table	
			$.ajax({
				url: "addOrderProduct.do",
				type: "POST",
				traditional: true,
				data: {
					ordQuant: ordQuant,
					proId: proId,
					ordProSumprice: ordProSumprice
				},
			})
			
			alert(msg);
//			location.href = "main.do"
		} else {
			let msg = '결제에 실패하였습니다.';
			msg += '에러내용 : ' + rsp.error_msg;
			alert(msg);
		}
	});
}	