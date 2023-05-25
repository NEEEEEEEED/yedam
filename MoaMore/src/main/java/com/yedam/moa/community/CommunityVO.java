package com.yedam.moa.community;

import lombok.Data;

@Data
public class CommunityVO {
	
	// 취업 Q&A
	private String qaNotiwrNo; 	// 취업 Q&A 게시글 번호
	private String id; 			// id
	private String ttl;			// 제목
	private String cntn;		// 내용
	private String htmlCntn;	// 내용(HTML 태그포함)
	private String inqCnt;		// 조회수
	private String rplyCnt;		// 댓글수
	private String regDt;		// 등록일자
	private String recoCnt;		// 추천수
	private String recoYn;		// 개별적인 추천여부
	
	// Member 테이블
	private String profileImg;	// 회원정보 프로필 이미지
  
	// 신고 테이블
	private String postType;
	private String rprtCnt="0"; //신고건수
	private String noneCnt="0"; //처리결과
	private String dispoDt="-"; //처리일자
	
	private String no;

	

}
