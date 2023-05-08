package com.yedam.moa.products.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.moa.co.service.CoService;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.products.service.ProductService;

@Controller
public class ProductsController {

	@Autowired
	CoService coservice;
	@Autowired
	ProductService pservice;
	
	@GetMapping("/products")
	public String products(Model model) {
		model.addAttribute("products",pservice.selectProducts());
		return "products/products";
	}
	
	@GetMapping("/payCheck")
	public String payCheckPage(Principal principal, Model model,HireVO vo,@RequestParam("prdtCd") String prdtCd) {
		vo.setId(principal.getName()); 
		
		model.addAttribute("id", principal.getName());
		model.addAttribute("RecList", coservice.selectRec(vo));
		model.addAttribute("disabledDates", pservice.disabledDates());
		model.addAttribute("product",pservice.getProduct(prdtCd));
		
		return "products/payCheck";
	}

}
