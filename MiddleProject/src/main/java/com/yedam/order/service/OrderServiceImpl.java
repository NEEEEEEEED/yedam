
package com.yedam.order.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.yedam.common.DataSource;
import com.yedam.order.mapper.OrderMapper;
import com.yedam.order.vo.OrderVO;
import com.yedam.product.mapper.ProductMapper;
import com.yedam.product.vo.ProductVO;

public class OrderServiceImpl implements OrderService {
	SqlSession session = DataSource.getInstance().openSession(true);
	OrderMapper mapper = session.getMapper(OrderMapper.class);

	@Override
	public List<OrderVO> orderList() {
		return mapper.getOrderList();
	}

	@Override
	public OrderVO getOrder(String orderId) {
		return mapper.getOrder(orderId);
	}
	
	@Override
	public int addOrder(OrderVO ovo) {
		return mapper.insertOrder(ovo);
	}

	@Override
	public int addPayment(OrderVO ovo) {
		return mapper.insertPayment(ovo);
	}

	@Override
	public int addOrderProduct(List<OrderVO> opList) {
		return mapper.insertOrderProduct(opList);
	}
}
