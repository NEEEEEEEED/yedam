package com.yedam.moa.community.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.moa.community.service.Impl.CommunityServiceImpl;

@Controller
public class CommunityController {

	@Autowired 
	CommunityServiceImpl communityServiceImpl; 
	
	  @GetMapping("/jobQnA") 
	  public String job() { 
		  return "community/jobQnA"; 
	  }
	 
}
