package com.yedam.moa.community;

import lombok.Data;

@Data
public class PrjtVO {
	private String prjtNo;
	private String progMthd;
	private String collRcnt;
	private String progTerm;
	private String skill;
	private String collPosi;
	private String COCT_MTHD;
	private String TTL;
	private String INTRO_SMRY;
	private String CNTN;
	private String RPLY_CNT;
	private String INQ_CNT;
	private String EXPC_DT;
	private String COLL_ST;
	private String CLS_DT;
	private String ID;
	private String REG_DT;
	private String postType;
	
	private String rprtCnt="0"; //신고건수
	private String rprtSt; //처리결과
	private String dispoDt="-"; //처리일자
	
	private String no;
}
