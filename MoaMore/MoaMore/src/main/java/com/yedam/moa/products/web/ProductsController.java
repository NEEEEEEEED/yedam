package com.yedam.moa.products.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.moa.co.service.CoService;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.products.service.ProductService;
import com.yedam.moa.products.service.ProductVO;

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
	
	//상품클릭시 해당상품 결제 페이지로 이동
	@GetMapping("/payCheck")
	public String payCheckPage(Principal principal, 
			                   Model model,
			                   HireVO vo,
			                   @RequestParam("prdtCd") String prdtCd) {
		vo.setId(principal.getName()); 
		
		model.addAttribute("id", principal.getName());
		model.addAttribute("RecList", coservice.selectRec(vo)); // 광고 적용할 공고 목록 가져오기
		model.addAttribute("disabledDates", pservice.disabledDates()); // 5일 꽉 날짜들 가져오기
		model.addAttribute("product",pservice.getProduct(prdtCd));
		
		return "products/payCheck";
	}
	
	// 광고 적용 공고 선택 시 추가로 막을 날짜(이미 해당날짜에 광고를 결제한경우) 가져오기
	@GetMapping("/addDisabledDates")
	@ResponseBody
	public List<ProductVO> addDisabledDates(ProductVO vo) {
		return pservice.addDisabledDates(vo);
	}
	
	//결제완료 이후
	@PostMapping("/afterPay")
	@ResponseBody
	public ProductVO afterPay(@RequestBody ProductVO vo) {
		pservice.afterPay(vo);
		return vo;
	}

}
