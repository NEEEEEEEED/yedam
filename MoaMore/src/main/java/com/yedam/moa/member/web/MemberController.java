package com.yedam.moa.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.moa.member.service.SessionUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {
	
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
}
