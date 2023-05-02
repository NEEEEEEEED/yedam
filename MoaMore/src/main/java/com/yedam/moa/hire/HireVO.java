package com.yedam.moa.hire;

import lombok.Data;

@Data
public class HireVO {
	String recruitNo; // 구인공고 번호
	String id; // 회원아이디
	String ttl; // 구인공고 제목
	String skill; // 기술스펙
	String shcr; // 학력
	String carr; // 경력
	String maBuss; // 주요업무
	String qualCond; // 자격요건
	String prefCond; // 우대사항
	String welf; // 복지 및 혜택
	String exprDt; // 마갈일
	String wksite; // 근무지역
	String coIntro; // 기업 소개
	String coImg; // 기업 이미지
	String accpDt; // 승인날짜
	String imgNo; // 이미지 그룹번호
	
	String coNm; // 기업이름
	String addr; // 기업주소
}
