package com.yedam.moa.hire.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.moa.hire.service.Impl.HireServiceImpl;

@Controller
public class HireController {

	@Autowired
	HireServiceImpl hireServiceImpl;
	
	@GetMapping("/hirePage")
	public String hire() {
		return "hire/hirePage";
	}
}
