package com.yedam.moa.faq.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.moa.faq.service.FaqService;

@Controller
public class FaqController {
	@Autowired
	FaqService service;
	
	
	@GetMapping("/faq")
	public String faqPage(Model model) {
		model.addAttribute("faqList",service.selectFaq()); //faqList에 Map<String, List<FaqVO>>가 들어가 있음
		return "faq/faq";
	}
}
