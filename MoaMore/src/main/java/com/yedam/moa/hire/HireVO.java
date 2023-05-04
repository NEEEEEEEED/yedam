package com.yedam.moa.hire;

import lombok.Data;

@Data
public class HireVO {
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
	private String coImg; // 기업 이미지
	private String accpDt; // 승인날짜
	private String imgNo; // 이미지 그룹번호
	
	private String coNm; // 기업이름
	private String addr; // 기업주소
}
