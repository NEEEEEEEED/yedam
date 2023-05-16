package com.yedam.moa.community;

import lombok.Data;

@Data
public class StudyVO {
	
	private String studyNo;		// 스터디 모집 게시글 기본키
	private String id;			// 아이디
	private String studyFg;		// 스터디 구분
	private String studySjt;	// 스터디과목
	private String progMthd;	// 진행방식
	private String ttl;			// 제목
	private String cntn;		// 내용(스터디 소개)
	private String coctMthd;	// 연락방법
	private String contact;		// 연락
	private String collRcnt;	// 모집인원
	private String rplyCnt;		// 댓글수
	private String inqCnt;		// 조회수
	private String expcDt;		// 시작예정일
	private String progTerm;	// 진행기간
	private String collSt;		// 모집상태
	private String clsDt;		// 모집마감일
	private String regDt;		// 등록일자
	
	private String postType;
	private String rprtCnt="0"; //신고건수
	private String rprtSt; //처리결과
	private String dispoDt="-"; //처리일자
	
	private String no;
}
