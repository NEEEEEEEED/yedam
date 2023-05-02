package com.yedam.moa.self.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.moa.self.service.Impl.SelfServiceImpl;

@Controller
public class SelfController {

	@Autowired 
	SelfServiceImpl selfServiceImpl; 
	
	@GetMapping("/selfJobList")
	public String selfJobList() {
		return "self/selfJobList";
	}
	
	@GetMapping("/selfJobProfile")
	public String selfJobProfile() {
		return "self/selfJobProfile";
	}
	 
	 
}
