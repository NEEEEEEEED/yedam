package com.yedam.moa.community;

import lombok.Data;

@Data
public class StudyVO {
	private String studyNo;
	private String studyFg;
	private String progMthd;
	private String ttl;
	private String cntn;
	private String coctMthd;
	private String collRcnt;
	private String rplyCnt;
	private String inqCnt;
	private String expcDt;
	private String collSt;
	private String clsDt;
	private String id;
	private String regDt;
	private String postType;
	
	private String rprtCnt="0"; //신고건수
	private String rprtSt; //처리결과
	private String dispoDt="-"; //처리일자
	
	private String no;
}
