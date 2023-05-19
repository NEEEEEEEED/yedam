package com.yedam.moa.products.service;

import java.util.List;

import com.yedam.moa.co.service.CoVO;



public interface ProductService {
	//5일꽉 날짜들
	public List<ProductVO> disabledDates();
	//상품목록
	public List<ProductVO> selectProducts();
	//상품단건조회
	public ProductVO getProduct(String prdtCd);
	//결제이후
	public int afterPay(ProductVO vo);
	//기업 보유상품정보
	public List<ProductVO> selectCoProducts(CoVO vo);
	//광고 적용할 공고의 이전 예약일자들
	public List<ProductVO> addDisabledDates(ProductVO vo);

}
