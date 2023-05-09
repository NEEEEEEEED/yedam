package com.yedam.moa.products.service;

import lombok.Data;

@Data
public class ProductVO {
	//5일 꽉찬 예약일자 목록
	private String reserDt;
	
	//상품
	private String prdtCd;
	private String prdtNm;
	private String svcCnt;
	private String prdtPrc;
	private String discount;
	private String totalPrice;
	private String discRate;
	
	//결제완료 이후 필요 데이터
	private String orderNo; //주문번호
	private String recruitNo; //공고게시글번호
	private String id; 
	private String reserDts; //광고적용날짜들 a,b,c
}
