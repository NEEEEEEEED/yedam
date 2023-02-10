<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js">
</script>

<table class="table">
	<tr>
		<th>글번호</th>
		<td>${vo.noticeId }</td>
		<th style="text-align: right">조회수</th>
		<td>${vo.hitCount }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${vo.noticeWriter }</td>
		<th style="text-align: right">작성일자</th>
		<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
				value="${vo.noticeDate }" /></td>
	</tr>
	<tr>
		<th colspan="1">제목</th>
		<td colspan="3">${vo.noticeTitle }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><textarea cols="50" rows="4">${vo.noticeSubject }</textarea>
		</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td colspan="3"><a target="_blank"
			href="upload/${vo.attachFile }">${vo.attachFile }</a></td>
	</tr>
</table>
<div>
	<span><b>제 목</b>:</span><span><input type="text" id="title" /></span>
	<span><b>작성자</b>:</span><span><input type="text" id="writer" value="${id }" readonly /></span>
	<span><b>내 용</b>:</span><span><input type="text" id="subject" /></span>
	<button class="btn btn-primary" id="addReply">댓글등록</button>
</div>
<div>
	<table style="margin: 0 auto; width: 80%" class="table">
		<thead>
			<tr style="border: 1px solid">
				<th colspan="4">댓글정보</th>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
</div>
<script>
let logid = '${id}';

  fetch('replyList.do?nid='+${vo.noticeId})
  .then(resolve => resolve.json())
  .then(result => {
     result.forEach(reply => {
		makeTr(reply);
     })
   })
   .catch(error => {
      console.log(error)
   })

   function deleteReply(replyId) {
   //ajax호출 fetch()
   $.ajax({
     method: "POST",
     url: "removeReply.do",
     data: { rid : replyId},
     success : function(result) {
     	if(result.retCode == 'Success'){
     	  $("tr[data-id="+replyId+"]").remove();
      	} else {
     	  alert('안됨')
        }
     },
     error : function (reject) {
     	console.log(reject);
     	}
     })
   }
  let nid = ${vo.noticeId};
      	$("#addReply").on('click',function() {
      		let writer = $("#writer").val();
      		let subject = $("#subject").val();
      		let title = $("#title").val();
  			 $.ajax({
      		url:"addReply.do",
      		method:"POST",
      		data: { title: title, writer: writer, subject:subject, nid : nid},
      		success: function(result){
      			console.log(result)
      			makeTr(result)
      		},
      		error : function(reject) {
          		console.log(reject)
      		},
      	});
     })
     
     function makeTr(reply) {
      		let tr1 = $('<tr />').attr('data-id',reply.replyId)
				.append(
				 $("<td />").html("<b>번호</b> " + reply.replyId),
				 $("<td />").html("<b>제목</b> " + reply.replyTitle),
				 $("<td />").html("<b>작성자</b> " + reply.replyWriter),
				 $("<td />").html("<b>날짜</b> " + reply.replyDate),
			    )

		let tr2 = $('<tr />').attr('data-id',reply.replyId)
				 .append(
				  $("<td colspan='3' />").html("<b>내용</b> " + reply.replySubject),
				  $("<td />")
				  .html(function(){
					  if(logid==reply.replyWriter) {
						 return "<button onclick='deleteReply("+reply.replyId+")' class= 'btn btn-warning'>삭제</button>"
					  } else {
						 return ;
					  }
				  })
				  .css('text-align','right'),
				)

		$("#list").prepend(tr1,tr2);
      	}
     
</script>
