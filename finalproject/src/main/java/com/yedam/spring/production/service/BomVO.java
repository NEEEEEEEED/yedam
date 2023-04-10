package com.yedam.spring.production.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BomVO {
	//bom
	private String bomCd;
	private String edctsCd; 	//완제품 코드
	private String standard;	//규격
	
	//bom_detail
	private String rscCd;		//자재코드
	private int useCnt;		//사용량
	private String unit;	//단위
	private String prcsCd;	//공정코드
	
	// + 자재
	private String rscNm;
	private String rscTyp;
	private String prcsNm;    
	
	// + lot 재고 정보
	private String rscSpec;
	private String rscLotCd;
	private int LotRmnCnt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expDt;
}
