package com.yedam.moa.mem.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.service.MemService;

@Controller
public class MemController {

	
	@Autowired
	MemService mem;
	
	
	Principal pr;
	
	@GetMapping("mem/mypage")
	public String getMyPgae(Principal principal, Model model, MemVO vo) {
		vo.setId(principal.getName());
		pr = principal;
		model.addAttribute("list", mem.openSesame(vo));
		return "mem/mem_mypage";
	}
	
	@PostMapping("/getSearch")
	@ResponseBody
	public void getSearch(MemVO vo){
		vo.setId(pr.getName());
		System.out.println(vo);
		 
	}
}
