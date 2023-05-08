package com.yedam.moa.mem.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.SearchVO;
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
		model.addAttribute("count",mem.getCount(vo));
		return "mem/mem_mypage";
	}
	
	@PostMapping("/getSearch")
	@ResponseBody
	public List<MemVO> getSearch(@RequestBody SearchVO vo, Principal principal){
		vo.setId(principal.getName());
		return mem.getSearch(vo);
	}
	@PostMapping("/delAnunSt")
	@ResponseBody
	public int delAnun(SearchVO sv, Principal principal) {
		sv.setId(principal.getName());
		System.out.println(sv);
		return mem.delAnun(sv);
	}
	@GetMapping("mem/mkResume")
	public String createResume(Principal principal, Model model) {
		return "mem/mem_resume";
	}
}
