/**
 * manage.js
 */
$(document).ready(function() {//화면 다 읽고 실행하시오 (실행 시점 중요!!)
	//목록 가져오는 ajax 호출
//	clone 봉인 이해못함
//	let clone = $('#template').clone(true);
//
//	let tr = clone.find('.name').val('test');
//	$('#list').append(tr);
	
	$.ajax({
		url: 'memberList.do',
		success: function(result) {
			$(result).each(function(idx, item) {
				$('#list').append(makeRow(item));
			})
		},
		error: function(err) {
			console.log(err);
		}
	})

	
}); 
	//등록이벤트
	$('#addBtn').on('click', function() {
		let id = $('#mid').val();//==element.value
		let name = $('#mname').val();
		let phone = $('#mphone').val();
		let addr = $('#maddr').val();
		let img = $('#image')[0].files[0];

		let formData = new FormData();
		formData.append('id', id);
		formData.append('name', name);
		formData.append('phone', phone);
		formData.append('addr', addr);
		formData.append('img', img);

		$.ajax({
			url: 'addMember.do',
			method: 'post',
			data: formData,
			contentType: false,
			processData: false,
			success: function(result) {
				//처리된 정보를화면 생성.
				if (result.retCode == "Success") {
					$('#list').append(makeRow(result.member))
				} else {
					alert('등록 실패');
				}
			},
			error: function(err) {
				console.log(err);
			}
		})




	})

	function makeRow(member) {
		let tr = $('<tr />'); //createElement('tr');
		tr.on('dblclick', function(ev) {
			let id = $(this).children().eq(0).text();
			let name = $(this).children().eq(1).text();
			let phone = $(this).children().eq(2).text();
			let addr = $(this).children().eq(3).text();
			let resp = $(this).children().eq(4).text();

			let nTr = $('<tr />').append(
				$('<td />').text(id),
				$('<td />').append($('<input class="name"/>').val(name)),
				$('<td />').append($('<input class="phone"/>').val(phone)),
				$('<td />').append($('<input class="addr"/>').val(addr)),
				$('<td />').append($('<input class="resp"/>').val(resp)),
				$('<td />').append($('<button>수정</button>')
								.attr('id','uptBtn')
								.attr('class', 'btn btn-success')
								.on('click', updateMemberFnc))

			);
			$(this).replaceWith(nTr);

		});
		tr.append(
			$('<td />').text(member.memberId),
			$('<td />').text(member.memberName),
			$('<td />').text(member.memberPhone),
			$('<td />').text(member.memberAddr),
			$('<td />').text(member.responsibility),
			$('<td />').append($('<button>삭제</button>')
				.attr('mid', member.memberId)
				.attr('class', 'btn btn-secondary')
				.on('click', deleteMemberFnc))
		);
		return tr;
	}
	function deleteMemberFnc(ev) {
		if (!window.confirm("삭제 ㅇㅋ?")) {
			return;
		} else {
			let user = $(ev.target).attr('mid');

			$.ajax({
				url: 'removeMember.do',
				data: { id: user },
				success: function(result) {
					if (result.retCode == 'Success') {
						$(ev.target).parent().parent().remove();
					} else {
						alert('삭제오류')
					}
				},
				error: function(reject) {
					console.log(reject);
				}

			});
		}
	}
	
	function updateMemberFnc(ev) {
		let tr = $(ev.target).parent().parent();
		let id = tr.children().eq(0).text();
		let name = tr.find("input.name").val();
		let phone = tr.find("input.phone").val();
		let addr = tr.find("input.addr").val();
		let resp = tr.find("input.resp").val();
//		let name = tr.children().eq(1).children().eq(0).val();
//		let phone = tr.children().eq(2).children().eq(0).val();
//		let addr = tr.children().eq(3).children().eq(0).val();
//		let resp = tr.children().eq(4).children().eq(0).val();
		console.log(id);
		console.log(name);
		console.log(phone);
		console.log(addr);
		console.log(resp);
		$.ajax({
			url:'modifyMember.do',
			method: 'post',
			data : {mid:id, mname:name, mphone:phone, maddr:addr, resp:resp},

			success: function(result) {
				if (result.retCode == "Success") {
					let newTr = makeRow(result.mvo)
					tr.replaceWith(newTr);
				} else {
					alert('수정 실패');
				}
			},
			error: function(err) {
				
			}
		})
	}