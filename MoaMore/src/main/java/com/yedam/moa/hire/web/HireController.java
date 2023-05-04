package com.yedam.moa.hire.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.moa.hire.HireVO;
import com.yedam.moa.hire.service.HireService;

@Controller
public class HireController {

	@Autowired
	HireService hireService;
	
	Principal pr;
	
	// 구인공고목록 페이지
	@GetMapping("/hirePage")
	public String hireList(Model model,Principal principal) {
		HireVO hireVO = new HireVO();
		
		pr = principal;
		hireVO.setId(pr.getName());
		
		List<HireVO> hireList = new ArrayList<HireVO>();
		hireList = hireService.hireList(hireVO );
		
		List<HireVO> hireScrapList = new ArrayList<HireVO>();
		hireScrapList = hireService.hireScrapList(hireVO);
		
		model.addAttribute("hireScrapList",hireScrapList);
		model.addAttribute("hireList",hireList);
		return "hire/hirePage";
	}
	
	// 구인공고 등록 페이지
	@GetMapping("/hireInsert")
	public String hireInsert() {
		return "hire/hireInsert";
	}
}
