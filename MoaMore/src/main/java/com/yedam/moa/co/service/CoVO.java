package com.yedam.moa.co.service;

import lombok.Data;

@Data
public class CoVO {
	//기업정보
	private String id;
	private String rpstr; //대표자
	private String sale; //매출액
	private String coFg; //기업구분
	private String empTtl; //사원수
	private String fondtDt; //설립일
	private String idst; //산업
	private String addr; //주소
	private String cptl; //자본금
	private String homePage; //홈페이지
	private String bizno; //사업자등록번호
	private String coNm; //기업명
}
