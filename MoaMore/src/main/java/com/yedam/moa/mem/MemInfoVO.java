package com.yedam.moa.mem;

import lombok.Data;

@Data
public class MemInfoVO {
	
	private String id;
	private String pw;
	private String name;	//이름
	private String birth;	//생일
	private String email;	//이메일
	private String ph;		//전화번호
	private String phCl;	//휴대폰
	private String addr;	//주소
	private String post;	//우편번호
	private String gen;		//성별
	private String pscheck;
	private String bizno;	//사업자번호
	private String authr;	//권한	
	private String clsf; 	//회원 분류
	private String profileImg; //회원 이미지
	private String addrDt;	//상세주소
}
