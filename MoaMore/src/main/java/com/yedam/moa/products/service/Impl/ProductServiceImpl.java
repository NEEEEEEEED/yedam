package com.yedam.moa.products.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.products.mapper.ProductMapper;
import com.yedam.moa.products.service.ProductService;
import com.yedam.moa.products.service.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductMapper mapper;
	
	@Override
	public List<ProductVO> disabledDates() {
		return mapper.disabledDates();
	}

	@Override
	public List<ProductVO> selectProducts() {
		return mapper.selectProducts();
	}

	@Override
	public ProductVO getProduct(String prdtCd) {
		return mapper.getProduct(prdtCd);
	}

}
