package com.yedam.moa.co.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CoMypageController {
		@Autowired
		
		@GetMapping("/coMypage")
		 public String coMypage(){ 
		 return "co/coMypage"; 
		 }
		
		@GetMapping("/coInfoPage")
		  public String coInfoPage() {
			return "co/coInfo";
		}
}
