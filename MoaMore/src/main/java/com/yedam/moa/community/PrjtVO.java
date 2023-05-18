package com.yedam.moa.community;

import lombok.Data;

@Data
public class PrjtVO {
	private String prjtNo;		// 프로젝트 모집 기본키
	private String progMthd;	// 진행방식
	private String collRcnt;	// 모집인원
	private String progTerm;	// 진행기간
	private String skill;		// 요구기술(기술스택)
	private String collPosi;	// 모집직무
	private String coctMthd;	// 연락방법
	private String contact;		// 연락
	private String ttl;			// 제목
	private String cntn;		// 프로젝트 소개
	private String rplyCnt;		// 댓글수
	private String inqCnt;		// 조회수
	private String expcDt;		// 시작예정일
	private String collSt;		// 모집상태
	private String clsDt;		// 모집마감일
	private String id;			// 아이디
	private String regDt;		// 등록일자
	
	private String postType;

	private String rprtCnt="0"; //총신고건수
	private String noneCnt="0"; 	//미처리 신고수
	
	
	private String no;
}
