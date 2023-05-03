package com.yedam.moa.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.moa.admin.service.AdminService;
import com.yedam.moa.mem.MemVO;

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
	  
	  @GetMapping("/getUserInfo") 
	  @ResponseBody
	  public List<MemVO> getUserInfo() {
		  return adminService.getUserInfo(); 
	  }
	 
	
}
