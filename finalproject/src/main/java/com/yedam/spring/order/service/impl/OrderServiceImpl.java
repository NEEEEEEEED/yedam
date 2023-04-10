package com.yedam.spring.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.spring.order.mapper.OrderMapper;
import com.yedam.spring.order.service.OrderPrdTestVO;
import com.yedam.spring.order.service.OrderService;
import com.yedam.spring.order.service.OrderTestVO;
import com.yedam.spring.vend.mapper.VendMapper;
import com.yedam.spring.vend.service.VendVO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderMapper orderMapper;
	
	@Autowired
	VendMapper vendMapper;

	@Override
	public List<OrderTestVO> selectOrderList() {
		return orderMapper.selectOrderList();
	}

	@Override
	public OrderTestVO selectOrderNo() {
		return orderMapper.selectOrderNo();
	}

	@Override
	public List<OrderPrdTestVO> selectOrderPrd() {
		return orderMapper.selectOrderPrd();
	}

	@Override
	public int insertOrder(OrderTestVO vo) {
		return orderMapper.insertOrder(vo);
	}

	@Override
	public int insertOrderPrd(OrderPrdTestVO vo) {
		return orderMapper.insertOrderPrd(vo);
	}

	@Override
	public int deleteOrder(OrderTestVO vo) {
		return orderMapper.deleteOrder(vo);
	}

	@Override
	public int updateOrderProg(OrderTestVO vo) {
		return orderMapper.updateOrderProg(vo);
	}

	@Override
	public List<OrderTestVO> selectOrderDetail(String orderNo) {
		return orderMapper.selectOrderDetail(orderNo);
	}

	@Override
	public List<OrderTestVO> searchOrder(OrderTestVO vo) {
		return orderMapper.searchOrder(vo);
	}

	@Override
	public int updateOrder(OrderTestVO vo) {
		return orderMapper.updateOrder(vo);
	}

	@Override
	public int updateOrderDetail(OrderTestVO vo) {
		return orderMapper.updateOrderDetail(vo);
	}

	@Override
	public int deleteOrderDetail(OrderTestVO vo) {
		return orderMapper.deleteOrderDetail(vo);
	}

}
