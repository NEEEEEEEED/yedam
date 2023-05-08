package com.yedam.moa.products.service;

import java.util.List;



public interface ProductService {
	//5일꽉 날짜들
	public List<ProductVO> disabledDates();
	//상품목록
	public List<ProductVO> selectProducts();
	//상품단건조회
	public ProductVO getProduct(String prdtCd);

}
