package com.yedam.moa.mem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.moa.mem.service.MemService;

@Controller
public class MemController {
	
	@Autowired
	MemService mem;
	
	@GetMapping("mem/mypage")
	public String getMyPgae() {
		return "mem/mem_mypage";
	}
}
