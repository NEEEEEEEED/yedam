package com.yedam.spring.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.spring.order.mapper.OrderMapper;
import com.yedam.spring.order.service.OrderService;
import com.yedam.spring.production.service.OrderSheetVO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderMapper orderMapper;
	

	@Override
	public List<OrderSheetVO> selectOrderList() {
		return orderMapper.selectOrderList();
	}

	@Override
	public OrderSheetVO selectOrderNo() {
		return orderMapper.selectOrderNo();
	}

	@Override
	public List<OrderSheetVO> selectOrderPrd() {
		return orderMapper.selectOrderPrd();
	}

	@Override
	public int insertOrder(OrderSheetVO vo) {
		return orderMapper.insertOrder(vo);
	}

	@Override
	public int insertOrderPrd(OrderSheetVO vo) {
		return orderMapper.insertOrderPrd(vo);
	}

	@Override
	public int deleteOrder(OrderSheetVO vo) {
		return orderMapper.deleteOrder(vo);
	}

	@Override
	public int updateOrderProg(OrderSheetVO vo) {
		return orderMapper.updateOrderProg(vo);
	}

	@Override
	public List<OrderSheetVO> selectOrderDetail(String orderNo) {
		return orderMapper.selectOrderDetail(orderNo);
	}

	@Override
	public List<OrderSheetVO> searchOrder(OrderSheetVO vo) {
		return orderMapper.searchOrder(vo);
	}

	@Override
	public int updateOrder(OrderSheetVO vo) {
		return orderMapper.updateOrder(vo);
	}

	@Override
	public int updateOrderDetail(OrderSheetVO vo) {
		return orderMapper.updateOrderDetail(vo);
	}

	@Override
	public int deleteOrderDetail(OrderSheetVO vo) {
		return orderMapper.deleteOrderDetail(vo);
	}

}
