package com.yedam.moa.community;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class IntrvVO {
	//면접
	private String intrvNo; 	// 면접 후기 기본키
	private String coNm;		// 회사명
	private String duty;		// 직무(지원분야)
	private String carr;		// 면접당시 경력
	private String appr;		// 전반적인 평가
	private String dif;			// 난이도
	private String intrvTyp;	// 전형 및 면접유형
	private String intrvRcnt;	// 면접인원
	private String spcCtnt;		// 특이사항
	private String passYn;		// 합격여부
	private String regDt;		// 등록일자
	private String accpYn;		// 승인여부
	private String id;			// 아이디
	private String intrvImg;	// 면접증빙 이미지
	private String qstCntn;		// 면접질문
	private String intrvDt;		// 면접일자
	
	private MultipartFile upload;	// 이미지파일
	
	private String ttl;
	private String postType;
	
	private String rprtCnt="0"; //신고건수
	private String rprtSt; //처리결과
	private String dispoDt="-"; //처리일자
	
	private String no;

}
