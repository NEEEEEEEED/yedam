package com.yedam.moa.self.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.moa.self.service.Impl.SelfServiceImpl;

@Controller
public class SelfController {

	@Autowired 
	SelfServiceImpl selfServiceImpl; 
	
	// 셀프구직 목록 페이지
	@GetMapping("/selfJobList")
	public String selfJobList() {
		return "self/selfJobList";
	}
	
	// 셀프구직 내프로필 관리 페이지
	@GetMapping("/selfJobProfile")
	public String selfJobProfile() {
		return "self/selfJobProfile";
	}
	 
	 
}
