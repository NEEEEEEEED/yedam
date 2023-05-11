package com.yedam.moa.community;

import lombok.Data;

@Data
public class CommunityVO {

	private String qaNotiwrNo; 	// 취업 Q&A 게시글 번호
	private String id; 			// id
	private String ttl;			// 제목
	private String cntn;		// 내용
	private String htmlCntn;	// 내용(HTML 태그포함)
	private String inqCnt;		// 조회수
	private String rplyCnt;		// 댓글수
	private String regDt;		// 등록일자

	
	

}
