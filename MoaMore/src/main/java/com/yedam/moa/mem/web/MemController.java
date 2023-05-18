package com.yedam.moa.mem.web;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.moa.comm.service.CommService;
import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.PrtflVO;
import com.yedam.moa.mem.ResumeVO;
import com.yedam.moa.mem.SearchVO;
import com.yedam.moa.mem.service.MemService;

@Controller
public class MemController {

	@Autowired
	MemService mem;

	@Autowired
	CommService com;

	@Value("${site.upload}")
	String uploadPath;

	@Value("${site.pofol}")
	String uploadPofolPath;

//	마이페이지 홈
//	마이페이지 홈 화면
	@GetMapping("mem/mypage")
	public String getMyPgae(Principal principal, Model model, MemVO vo) {
		vo.setId(principal.getName());
		model.addAttribute("list", mem.openSesame(vo));
		model.addAttribute("count", mem.getCount(vo));
		return "mem/mem_mypage";
	}

//	마이페이지 지원한 공고 단위 검색
	@PostMapping("/getSearch")
	@ResponseBody
	public List<MemVO> getSearch(@RequestBody SearchVO vo, Principal principal) {
		vo.setId(principal.getName());
		return mem.getSearch(vo);
	}

//	마이페이지 검색한 공고 선택 삭제
	@PostMapping("/delAnunSt")
	@ResponseBody
	public int delAnun(SearchVO sv, Principal principal) {
		sv.setId(principal.getName());
		System.out.println(sv);
		return mem.delAnun(sv);
	}

//	이력서 시작
//	이력서 폼 접속
	@GetMapping("mem/mkResume")
	public String createResume(Principal principal, Model model, MemVO vo, ResumeVO rvo) {
		vo.setId(principal.getName());
		rvo=mem.lastRe(vo);
		if(rvo.getResumeNo() == null) {
		rvo.setResumeNo("none");
		};
		System.out.println(rvo);
		model.addAttribute("resume", rvo);
		System.out.println(rvo);
		model.addAttribute("list", com.getCodes("Z", "D", "E", "B", "d", "N", "A"));
		model.addAttribute("info", mem.getMemInfo(vo));
		;

		return "mem/mem_resumeSec";
	}
	
	
//	이력서 폼 접속
	@GetMapping("mem/mkResumeTest")
	public String tesResume(Principal principal, Model model, MemVO vo, ResumeVO rvo) {
		vo.setId(principal.getName());
			rvo=mem.lastRe(vo);
		if(rvo.getResumeNo()==null) {
			rvo.setResumeNo("none");
//			rvo.setShcrNo("dummy");
			};
			System.out.println(rvo);
		
		model.addAttribute("resume", rvo);
		model.addAttribute("list", com.getCodes("Z", "D", "E", "B", "d", "N", "A"));
		model.addAttribute("info", mem.getMemInfo(vo));
		;

		return "mem/mem_resumeThird";
	}

//	이력서 데이터 입력
	@PostMapping("/insertResume")
	@ResponseBody
	public String insertRes(@RequestBody ResumeVO vo, Principal pr) {
		System.out.println(vo);
		vo.setId(pr.getName());
		 return mem.insertResume(vo);
	}


//  회원탈퇴 기능
	@PostMapping("/withdraw")
	public String withdraw(Principal pr) {
		String id = pr.getName();
		mem.withdraw(id);
		
		return "redirect:logout";
	}
	
//  회원탈퇴 페이지
	@GetMapping("/withdraw")
	public String withdrawPage(Principal pr, Model model) {
		model.addAttribute("id",pr.getName());
		
		return "mem/withdraw";
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
