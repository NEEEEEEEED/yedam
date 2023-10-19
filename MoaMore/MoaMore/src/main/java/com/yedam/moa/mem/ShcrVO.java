package com.yedam.moa.mem;

import lombok.Data;

@Data
public class ShcrVO {
	private String shcrNo;		//학력 번호
	private String breu;		//학교이름
	private String mj;			//전공
	private String joinYy;		//입학년도
	private String retiYy;		//졸업년도
	private String pnt;			//학점
	private String shcrSt;		//학력상태 (졸업,휴학..)
	private String ttScore;		//총점 (4.5...)
	private String fg;			//학교 구분 (고등 대학)
	private String shcrStCo;			//학교 구분 (고등 대학)
	private String ttCo;			//학교 구분 (고등 대학)
	private String fgCo;			//학교 구분 (고등 대학)
}
