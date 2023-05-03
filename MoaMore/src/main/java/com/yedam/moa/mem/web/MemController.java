package com.yedam.moa.mem.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.service.MemService;

@Controller
public class MemController {


	@Autowired
	MemService mem;
	
	
	@GetMapping("mem/mypage")
	public String getMyPgae(Principal principal, Model model, MemVO vo) {
		vo.setId(principal.getName());
		model.addAttribute("list", mem.openSesame(vo));
		return "mem/mem_mypage";
	}
}
