package com.yedam.moa.mem;

import lombok.Data;

@Data
public class MemVO {
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
}
