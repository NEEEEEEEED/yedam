package com.yedam.moa.products.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {

	@Autowired

	@GetMapping("/products")
	public String products() {
		return "products/products";
	}
	
	@GetMapping("/payCheck")
	public String payCheckPage() {
		return "products/payCheck";
	}

}
