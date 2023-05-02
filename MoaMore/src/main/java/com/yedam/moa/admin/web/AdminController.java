package com.yedam.moa.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.moa.admin.service.AdminService;

@Controller
public class AdminController {

	@Autowired 
	AdminService adminService; 
	
	  @GetMapping("/admin") 
	  public String job() { 
		  return "admin/dashboard"; 
	  }
	  @GetMapping("/member/common") 
	  public String commonMember() { 
		  return "admin/commonMember"; 
	  }
	 
	
}
