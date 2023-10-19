package com.yedam.product.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Command;
import com.yedam.product.service.ProductService;
import com.yedam.product.service.productServiceImpl;
import com.yedam.product.vo.ProductVO;

public class productDetail implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		
		ProductService service = new productServiceImpl();
		
		req.setAttribute("vo", service.getProduct(pid));
		
		List<ProductVO> list = service.relateList();
		req.setAttribute("list", list);
		System.out.println(list);
		return "product/product.tiles";
	}

}
