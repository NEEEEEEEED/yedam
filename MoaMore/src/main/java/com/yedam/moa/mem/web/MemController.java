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
		if(rvo.getResumeNo() == null) {
//			rvo.setResumeNo("none");
		};
		
			model.addAttribute("resume", rvo);
		
		model.addAttribute("list", com.getCodes("Z", "D", "E", "B", "d", "N", "A"));
		model.addAttribute("info", mem.getMemInfo(vo));
		;

		return "mem/mem_resume";
	}

//	이력서 데이터 입력
	@PostMapping("/insertResume")
	@ResponseBody
	public String insertRes(@RequestBody ResumeVO vo, Principal pr) {
		System.out.println(vo);
		vo.setId(pr.getName());
		 return mem.insertResume(vo);
	}

//	포폴 업로드
	@PostMapping("/resumePofol")
	@ResponseBody
	public List<PrtflVO> pofolUpload(
//			@RequestParam("prtflNo") String prtflNo, 
//									 @RequestParam("id") String id,
									 @RequestParam("ttl") String ttl,
									 @RequestParam("pofolImg") MultipartFile uploadPofolImg,
									 @RequestParam("prtflFile") MultipartFile uploadPofolFile) throws IllegalStateException, IOException {
//		System.out.println(prtflNo);
//		System.out.println(id);
		System.out.println(ttl);
		System.out.println(uploadPofolImg);
		System.out.println(uploadPofolFile);
//		
//		// 포트폴리오 이미지
//		String fileNamePofolImg = null; // 원본파일명
//		String uploadFileNamePofolImg = null;   // UUID적용한 파일명(중복 없는 파일명)
//		
//		// 포트폴리오 파일
//		String fileNamePofolFile = null; // 원본파일명
//		String uploadFileNamePofolFile = null;   // UUID적용한 파일명(중복 없는 파일명)
//		
//		int r = 0; // sql문 결과
//		
//		if(vo.getUploadPofolImg() !=null && !vo.getUploadPofolImg().isEmpty() && vo.getUploadPofolImg().getSize()>0
//		&& vo.getUploadPofolFile() !=null && !vo.getUploadPofolFile().isEmpty() && vo.getUploadPofolFile().getSize()>0) {
//			
//			// 포트폴리오 이미지
//			fileNamePofolImg = vo.getUploadPofolImg().getOriginalFilename(); // 원본 이미지 파일명
//			
//			// 포트폴리오 파일
//			fileNamePofolFile = vo.getUploadPofolFile().getOriginalFilename(); // 원본 포트폴리오 파일명
//			
//			// 동일 파일명 처리 UUID 사용
//			UUID uuid = UUID.randomUUID();
//			uploadFileNamePofolImg = uuid.toString() + "_" + fileNamePofolImg; // 이미지 UUID 적용한 파일명
//			uploadFileNamePofolFile = uuid.toString() + "_" + fileNamePofolFile; // 파일 UUID 적용한 파일명
//			
//			vo.getUploadPofolImg().transferTo(new File(uploadPath+'/'+uploadFileNamePofolImg)); // 이미지 파일
//			vo.getUploadPofolFile().transferTo(new File(uploadPath+'/'+uploadFileNamePofolFile)); // 이미지 파일
//			
//			//첨부파일명 VO에 지정
//			System.out.println("파일이름: " + fileNamePofolImg);
//			System.out.println("파일이름: " + fileNamePofolFile);
//			
////			PrtflVO pofol = new PrtflVO();
////			pofol.setPrtflNo(vo.getPrtflNo());
////			pofol.setId(id);
////			pofol.setttl(ttl);
////			pofol.setPofolImg(uploadFileNamePofolImg);
////			pofol.setPofolFile(fileNamePofolFile);
////			pofol.setPofolUuidFile(uploadFileNamePofolFile);
////			r = selfServiceImpl.selfJobPofolAdd(vo);	
//			
//			vo.setPrtfImg(uploadFileNamePofolFile);
//			vo.setPrtflFile(uploadFileNamePofolFile);
//		
//		}
//		mem.insGetPofl(vo);
		return null;
	}

}
