package com.yedam.moa;

import java.security.Principal;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.moa.community.CommunityVO;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.hire.service.HireService;
import com.yedam.moa.self.SelfVO;

@EnableScheduling	// 스케쥴러
@SpringBootApplication
@EnableJpaRepositories
@MapperScan(basePackages="com.yedam.moa.**.mapper")
@Controller
public class MoaMoreApplication {
	
	@Autowired
	HireService hireService;

	public static void main(String[] args) {
		SpringApplication.run(MoaMoreApplication.class, args);
	}
	@GetMapping("/login")
	public String hello() {
		return "loginForm";
	}		
	@GetMapping("/main")
	public String home(Model model) {
		
		HireVO hireVO = new HireVO();
		CommunityVO communityVO = new CommunityVO();
		
		
		
		model.addAttribute("prdtSelect",hireService.prdtSelect(hireVO)); // 유료공고
		model.addAttribute("newSelect",hireService.newSelect(hireVO)); // 최신공고
		model.addAttribute("popSelect",hireService.popSelect(hireVO)); // 인기공고
		model.addAttribute("jobQnaBest", hireService.jobQnaBest(communityVO)); // 취업QnA 베스트3
		
		return "main";
	}
	
	@GetMapping("/selfMain")
	@ResponseBody
	public List<SelfVO> selfMain(Principal pr, SelfVO selfVO) {
		selfVO.setId(pr.getName());
		return hireService.popSelf(selfVO);
	}
	
	@GetMapping("/vueAdmin")
	public String vueTest() {
		return "admin";
	}
	
	
}
