package com.yedam.moa.mem;

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
	private String idMem;
	private String idCo;
	
//	구인공고
	private String recruitNo;
	private String ttl;
	private String skill;
	private String carr;
	private String shcr;
	private String maBuss;
	private String qualCoud;
	private String prefCound;
	private String welf;
	private String exprDt;
	private String wksite;
	private String coIntro;
	private String coImg;
	private String accpDt;
	private String imgNo;
	private String resumeNo;
	private String aplySt;
	
//	기업 정보
	private String coNm;
	
	

}
