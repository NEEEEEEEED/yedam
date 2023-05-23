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

import com.yedam.moa.comm.service.CommService;
import com.yedam.moa.community.Criteria;
import com.yedam.moa.community.PagingVO;
import com.yedam.moa.mem.MemInfoVO;
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
	public String createResume(Principal principal, Model model, MemVO vo) {
		
		vo.setId(principal.getName());
		model.addAttribute("list", com.getCodes("Z", "D", "E", "B", "d", "N", "A"));
		model.addAttribute("info", mem.getMemInfo(vo));
		;

		return "mem/mem_resume";
	}
	
	
//	이력서 폼 접속
	@GetMapping("mem/mkResumeTest")
	public String tesResume(Principal principal, Model model, MemVO vo, ResumeVO rvo) {
		vo.setId(principal.getName());
			rvo=mem.lastRe(vo);
		if(rvo.getResumeNo()==null) {
			rvo.setResumeNo("none");
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

				vo.getUuid().transferTo(new File(uploadPofolPath,vo.getPrtflFile())); //파일 업로드 
				vo.getUuidImg().transferTo(new File(uploadPofolPath,vo.getPrtflImg()));		//이미지 업로드
				
				rvo.setPrtflNo(mem.insertPofl(vo).getPrtflNo());

			}   
			return  mem.getPrtfl(rvo);
          }
		
//		포트폴리오 삭제 
	@PostMapping("/delPofol")
	@ResponseBody
	public List<PrtflVO> delPofol (PrtflVO vo) {
		
//		System.out.println(vo);
		ResumeVO rvo = new ResumeVO();
		
		if(mem.delPofol(vo)>0) {
		rvo.setPrtflNo(vo.getPrtflNo());
		return mem.getPrtfl(rvo);	
		}else {
			return null;
		}
	}
//	@GetMapping("mem/viewResume")
//	public String getVueRe(Principal principal, Model model, MemVO vo) {
////		vo.setId(principal.getName());
////		model.addAttribute("list", mem.openSesame(vo));
////		model.addAttribute("count", mem.getCount(vo));
//		return "mem/resume_vue";
//	}
	@GetMapping("/viewResume")
	public String getVueResume(Principal principal, Model model, ResumeVO rvo) {
		MemVO vo = new MemVO();
		vo.setId(rvo.getId());
//		rvo.setId(principal.getName());
		
		rvo=mem.getRe(rvo);
		if(rvo.getResumeNo()==null) {
		rvo.setResumeNo("none");
		};
		System.out.println(rvo);
	
	model.addAttribute("resume", rvo);
	model.addAttribute("list", com.getCodes("Z", "D", "E", "B", "d", "N", "A"));
	model.addAttribute("info", mem.getMemInfo(vo));
		return "mem/resume_view";
	}
	
	
//	이력서 수정폼
	@GetMapping("mem/modRe")
	public String getResumeMod(Principal principal, Model model, ResumeVO rvo) {
		MemVO vo = new MemVO();
		vo.setId(rvo.getId());
		rvo=mem.getRe(rvo);
		if(rvo.getResumeNo()==null) {
			rvo.setResumeNo("none");
			};
			System.out.println(rvo);
		
		model.addAttribute("resume", rvo);
		model.addAttribute("list", com.getCodes("Z", "D", "E", "B", "d", "N", "A"));
		model.addAttribute("info", mem.getMemInfo(vo));
		;

		return "mem/ModResume";
	}
	
//	이력서 수정
	@PostMapping("/ModResume")
	@ResponseBody
	public String ModRes(@RequestBody ResumeVO vo, Principal pr) {
		System.out.println(vo);
		vo.setId(pr.getName());
		mem.updateRe(vo);
		 return mem.insertResume(vo);
	}
//	마이페이지 이력서 관리 페이지(이력서 리스트 화면 출력)
	@GetMapping("/resumeList")
	public String getList(Model model,Principal pr,Criteria cri) {
		System.out.println(cri);
		
		// 전체 글 개수
        int resumePageCnt = mem.getPageCnt(pr.getName());
        System.out.println(resumePageCnt);
        // 페이징 객체
        PagingVO paging = new PagingVO();
        paging.setCri(cri);
        paging.setTotalCount(resumePageCnt);    
        cri.setId(pr.getName());
        List<ResumeVO> list = mem.resumeList(cri);
        
        model.addAttribute("resumeList", list);    
        model.addAttribute("paging", paging);    
		
		System.out.println(paging.toString());
		
		
		return "/mem/resumeList";
	}
//	이력서 삭제 메소드
	@GetMapping("/delResume")
	public String delResume(Model model,Principal pr,Criteria cri,ResumeVO rvo) {
		rvo.setId(pr.getName());
		int result = mem.delResume(rvo);
		if(result==1) {
		// 전체 글 개수
        int resumePageCnt = mem.getPageCnt(pr.getName());
        System.out.println(resumePageCnt);
        // 페이징 객체
        PagingVO paging = new PagingVO();
        paging.setCri(cri);
        paging.setTotalCount(resumePageCnt);    
        cri.setId(pr.getName());
        List<ResumeVO> list = mem.resumeList(cri);
        
        model.addAttribute("resumeList", list);    
        model.addAttribute("paging", paging);    
		
		System.out.println(paging.toString());
		
		
		return "/mem/resumeList";
		}else {
			return "redirect:/resumeList";
		}
	}
	
	
	@GetMapping("/signUp")
	public String signUpform() {
		
		return "mem/signup";
	}
	
	@PostMapping("/checkId")
	@ResponseBody
	public int checkId(@RequestBody MemInfoVO vo) {
		return mem.checkId(vo);
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

