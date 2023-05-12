package com.yedam.moa.community;

import lombok.Data;

@Data
public class IntrvVO {
	//면접
	private String intrvNo;
	private String coNm;
	private String duty;
	private String carr;
	private String intrvDt;
	private String appr;
	private String dif;
	private String intrvTyp;
	private String intrvRcnt;
	private String intrvMthd;
	private String spcCtnt;
	private String passYn;
	private String proofPht;
	private String regDt;
	private String accpYn;
	private String id;
	private String ttl;
	private String postType;
	
	private String rprtCnt="0"; //신고건수
	private String rprtSt; //처리결과
	private String dispoDt="-"; //처리일자

}
