package com.yedam.spring.order.service;

import java.util.List;

import com.yedam.spring.production.service.OrderSheetVO;
import com.yedam.spring.vend.service.VendVO;

public interface OrderService {
	//전체조회
	public List<OrderSheetVO> selectOrderList();
	
	//주문번호 조회
	public OrderSheetVO selectOrderNo();
	
	//거래처 조회
	public List<VendVO> getVendAll();

}
