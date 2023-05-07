package com.yedam.moa.hire.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.moa.hire.HireVO;
import com.yedam.moa.hire.service.HireService;

@Controller
public class HireController {

	@Autowired
	HireService hireService;
	
	Principal pr;
	
	// 구인공고목록 페이지
	@GetMapping("/hirePage")
	public String hireList(Model model) {
		return "hire/hirePage";
	}
	
	// 구인공고 전체조회 조건검색 스크랩정렬
	@GetMapping("/data")
	@ResponseBody
    public List<HireVO> getData(HireVO hireVO, Principal principal) {
		List<HireVO> hireList = new ArrayList<HireVO>();
		pr = principal;
		hireVO.setId(pr.getName());
		
		 hireList = hireService.hireList(hireVO);
         return hireList;
    }
	
	// 구인공고 등록 페이지
	@GetMapping("/hireInsert")
	public String hireInsert() {
		return "hire/hireInsert";
	}
}
