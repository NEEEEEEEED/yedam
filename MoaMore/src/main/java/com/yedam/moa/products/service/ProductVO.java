package com.yedam.moa.products.service;

import lombok.Data;

@Data
public class ProductVO {
	//5일 꽉찬 예약 목록
	private String reserDt;
	
	//상품
	private String prdtCd;
	private String prdtNm;
	private String svcCnt;
	private String prdtPrc;
	private String discount;
	private String totalPrice;
}
