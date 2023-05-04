package com.yedam.moa.admin.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.moa.admin.service.AdminService;
import com.yedam.moa.admin.service.PostListVO;
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
	 
	
	  @PostMapping("/getUserPost") 
	  @ResponseBody
	  public Map<String, List<PostListVO>> getUserPost(@RequestParam String id) {
		  System.out.println(id);
		  return adminService.getUserPost(id); 
	  }
}
