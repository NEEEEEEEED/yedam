package com.yedam.moa.community;

import lombok.Data;

@Data
public class StudyVO {
	private String STUDY_NO;
	private String STUDY_FG;
	private String PROG_MTHD;
	private String TTL;
	private String CNTN;
	private String COCT_MTHD;
	private String COLL_RCNT;
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
}
