package com.yedam.moa.products.mapper;

import java.util.List;

import com.yedam.moa.co.service.CoVO;
import com.yedam.moa.products.service.ProductVO;

public interface ProductMapper {
	// 5일꽉 날짜들
	public List<ProductVO> disabledDates();

	// 상품목록
	public List<ProductVO> selectProducts();

	// 상품 단건조회
	public ProductVO getProduct(String prdtCd);

	// 결제이후
	public int afterPay(ProductVO vo);

	public List<ProductVO> selectCoProducts(CoVO vo);
}
