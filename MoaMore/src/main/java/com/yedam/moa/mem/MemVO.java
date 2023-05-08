package com.yedam.moa.mem;

import com.yedam.moa.hire.HireVO;

import lombok.Data;

@Data
public class MemVO {

// 회원정보
	private String id;		//아이디
	private String name;	//이름
	private String pw;		//비밀번호
	private String ph;		//전화번호
	private String phCl;	//휴대폰
	private String email;	//이메일
	private String blog;	//개인홈페이지
	private String post;	//우편번호
	private String authr;	//권한
	private String clsf;	//회원분류
	private String kakao;	//카카오
	private String naver;	//네이버
	private String logCnt;	//로그인횟수
	private String ltstTm;	//최근로그인시간
	private String gen;		//성별
	private String birth;	//생년월일
	private String addr;	//주소
	private String joinDt;	//가입일자

	
//	관심기업
	private String idMem; 	//회원 아이디
	private String idCo;	//기업 아이디
	
//	구인공고
	private String recruitNo;   //공고 번호
	private String ttl;		    //공고 제목
	private String skill;		//공고에서 요구하는 기술
	private String carr;		//커리어
	private String shcr;		//학력
	private String maBuss;		//주요 업무
	private String qualCoud;	//자격요건
	private String prefCound;	//우대사항
	private String welf;		//복지 및 혜택
	private String exprDt;		//마감기한
	private String wksite;		//근무지역
	private String coIntro;		//기업 서비스 소개
	private String coImg;		//회사 이미지
	private String accpDt;		//승인 날짜
	private String imgNo;		//이미지 번호
	private String resumeNo;	//이력서 번호
	private String regDt;		//승인 날짜
	private int	   exprSt;		//현재날짜 마감일 차이
	private String exprStatus;  //마감 상태
//	구인공고 지원상태 
	private String aplySt;		//지원상태
	private String aplyDt;		//지원일자
	private String period;			//검색기간 
	private String startDt;		//검색 시작
	private String endDt;		//검색 끝
	private String st;			//열람여부
	private HireVO hireVO;
//	기업 정보
	private String coNm;		//기업 이름
	
	
	

}
