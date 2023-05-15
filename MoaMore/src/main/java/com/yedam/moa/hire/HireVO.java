package com.yedam.moa.hire;

import lombok.Data;

@Data
public class HireVO {
	// 공통코드
	private String prov;  		// 공통 코드
	private String desct; 		// 공통 코드명

	private String recruitNo; // 구인공고 번호
	private String id; // 회원아이디
	private String ttl; // 구인공고 제목
	private String skill; // 기술스펙
	private String shcr; // 학력
	private String carr; // 경력
	private String maBuss; // 주요업무
	private String qualCond; // 자격요건
	private String prefCond; // 우대사항
	private String welf; // 복지 및 혜택
	private String exprDt; // 마갈일
	private String wksite; // 근무지역
	private String coIntro; // 기업 소개
	private String coImg; // 기업 대표 이미지 썸네일
	private String accpDt; // 승인날짜
	private String imgNo; // 이미지 그룹번호
	private String job; // 직군
	private String recruitImg; // 기업이미지들
	
	private String coNm; // 기업이름
	private String addr; // 기업주소
	
	private String scrapYn; // 스크랩 여부
	private String followYn; // 팔로우 여부
	
	private String resumeNo; // 이력서 번호
	private String regDt; // 이력서 작성일자
	
	private String idCo; // 팔로우 받는 기업
	private String idMem; // 팔로우 하는 회원
	private String scrapNo; // 스크랩 번호
	private String skillNo; // 스킬 번호
	
}
