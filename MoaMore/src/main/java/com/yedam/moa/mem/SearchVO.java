package com.yedam.moa.mem;

import lombok.Data;


@Data
public class SearchVO {
	
	private String recruitNo; //공고 번호
	private int period;		//기간
	private String startDt;	//검색 시작 날짜
	private String endDt;	//검색 종료 날짜
	private String expir;	//마감여부
	private String st;		//열람 상태
	private String aplySt;	//지원 상태
	private String id;		//회원 아이디
	private int countAplySt;//지원완료 개수
	private int countSt;	//열람 개수
	private int countDeny;	//지원취소 개수
}
