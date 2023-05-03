package com.yedam.moa.mem;

import lombok.Data;

@Data
public class MemVO {
	
//	회원정보
	private String id;
	private String name;
	private String pw;
	private String ph;
	private String email;
	private String blog;
	private String post;
	private String clsf;
	private String logCnt;
	private String ltstTm;
	private String gen;
	private String birth;
	private String addr;
	private String joinDt;
	
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
