package com.yedam.product.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Command;
import com.yedam.product.service.ProductService;
import com.yedam.product.service.productServiceImpl;
import com.yedam.product.vo.ProductVO;

public class relatedProduct implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductService service = new productServiceImpl();
		List<ProductVO> list = service.relateList();
		String json ="";
		
		Gson gson = new GsonBuilder().create();
		json = gson.toJson(list);
		System.out.println(json);
		
		return json + ".json";
			
	}	
	

}
