package com.yedam.moa.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.moa.co.service.CoVO;
import com.yedam.moa.mem.MemVO;
import com.yedam.moa.member.service.MemberService;
import com.yedam.moa.member.service.SessionUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	//private final HttpSession httpSession = null;
	
	@GetMapping("/")
	public String index(Model model, HttpSession httpSession) {
	    SessionUser user = (SessionUser) httpSession.getAttribute("user");
	    
	    if (user != null) {
	    	model.addAttribute("userName", user.getName());
	        model.addAttribute("NickName", user.getNickName());
	        model.addAttribute("Email", user.getEmail());
	        model.addAttribute("Gender", user.getGender());
	        model.addAttribute("Age", user.getAge());
	    }
	    return "main";
	}
	
	@PostMapping("/find/Id")
	@ResponseBody
	public String findId(MemVO vo) {
		System.out.println(vo);
		return memberService.findId(vo);
	}
	
	// 이메일 인증
	@PostMapping("/find/pw")
	@ResponseBody
	String findPw(MemVO vo) throws Exception {
	   return memberService.findpw(vo);
	}
	
	@PostMapping("/find/coId")
	@ResponseBody
	public String findCoId(CoVO vo) {
		return memberService.findCoId(vo);
	}
	
	// 이메일 인증
	@PostMapping("/find/coPw")
	@ResponseBody
	String findCoPw(CoVO vo) throws Exception {
	   return memberService.findCoPw(vo);
	}
}
