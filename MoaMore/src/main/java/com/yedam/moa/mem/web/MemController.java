package com.yedam.moa.mem.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

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
import com.yedam.moa.self.SelfVO;
import com.yedam.moa.self.mapper.SelfMapper;
import com.yedam.moa.self.service.SelfService;

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
	
	//  포트폴리오 등록 - 첨부파일 업로드 처리 // 피드백 : 받오는값을 커멘트 객체 형식으로 VO에 한꺼번에 받아도됨(대신 이름이 일치해야함)
		@PostMapping("/insertPofol")
		@ResponseBody
		public List<PrtflVO> pofolUpload(PrtflVO vo	   
								   		 ) throws IllegalStateException, IOException {
			System.out.println(vo);
			
			ResumeVO rvo = new ResumeVO();
			if(vo.getUuidImg() !=null && !vo.getUuidImg().isEmpty() && vo.getUuidImg().getSize()>0
			&& vo.getUuid() !=null && !vo.getUuid().isEmpty() && vo.getUuid().getSize()>0) {

//				// 동일 파일명 처리 UUID 사용
				UUID uuid = UUID.randomUUID();
				vo.setPrtflFile(uuid.toString()+"_"+vo.getUuid().getOriginalFilename());  // uuid 적용한 파일 이름
				vo.setPrtflImg(uuid.toString()+"_"+vo.getUuidImg().getOriginalFilename()); // uuid 적용한 파일 이름
				 
				

//				
				vo.getUuid().transferTo(new File(uploadPofolPath,vo.getPrtflFile())); //파일 업로드 
				vo.getUuidImg().transferTo(new File(uploadPath,vo.getPrtflImg()));		//이미지 업로드
				
				rvo.setPrtflNo(mem.insertPofl(vo).getPrtflNo());
				


			}   
			return  mem.getPrtfl(rvo);
          }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

