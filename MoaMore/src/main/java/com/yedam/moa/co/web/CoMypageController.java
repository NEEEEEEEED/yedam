package com.yedam.moa.co.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.moa.co.service.CoService;
import com.yedam.moa.co.service.CoVO;
import com.yedam.moa.comm.service.CommService;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.mem.MemInfoVO;
import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.service.MemService;
import com.yedam.moa.member.service.MemberService;
import com.yedam.moa.products.service.ProductService;
import com.yedam.moa.self.SelfVO;

@Controller
public class CoMypageController {
	@Autowired
	CoService service;

	@Autowired
	ProductService pservice;

	@Autowired
	CommService commService;

	@Autowired
	MemService mservice;
	
	@Autowired
	MemberService memberservice;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Value("${site.upload}")
	String uploadPath;

	// 기업마이페이지
	@GetMapping("/coMypage")
	public String coMypage(Principal principal, Model model, CoVO vo) {
		vo.setId(principal.getName());
		model.addAttribute("followers", service.selectFollowers(vo)); // 나를 관심가진 수 가져오기
		model.addAttribute("id", vo); // user id 가져오기
		model.addAttribute("co", service.selectCo(vo));//기업정보 가져오기 용
		model.addAttribute("totalInter", service.selectTotalInter(vo)); // 관심게시글 수 가져오기
		model.addAttribute("commList", commService.getCodes("Z")); // 제안모달 기술스택가져오기
		return "co/coMypage";
	}
	
	// 공고의 새로운 지원목록
	@GetMapping("/selectNewApply")
	@ResponseBody
	public List<CoVO> selectNewApply(Principal principal) {
		String id = principal.getName();
		return service.selectNewApply(id);
	}
	
	// 지원 조회 이후 미열람 -> 열람 
	@PostMapping("/updateApplySt")
	@ResponseBody
	public String updateApplySt(CoVO vo) {
		service.updateApplySt(vo);
		return "stUpdateSuccess";
	}
	
	// 공고의 처리된 지원목록
	@GetMapping("/selectCompletedApply")
	@ResponseBody
	public List<CoVO> selectCompletedApply(Principal principal) {
		String id = principal.getName();
		return service.selectCompletedApply(id);
	}
	
	// 지원 합격/불합격 처리
	@PostMapping("/responseApply")
	@ResponseBody
	public String responseApply(CoVO vo) {
		service.responseApply(vo);
		return "success";
	}
	
	// 지원 삭제
	@PostMapping("/deleteApply")
	@ResponseBody
	public String deleteApply(CoVO vo) {
		service.deleteApply(vo);
		return "success";
	}

	// 기업정보등록/수정 페이지
	@GetMapping("/coInfoPage") // 기업아이디 들고 들어가서 해당 아이디에 해당하는 기업정보 있다면 model에 service담아서 미리출력
	public String coInfoPage(Model model, Principal principal, MemVO mvo, CoVO vo) {
		vo.setId(principal.getName());
		model.addAttribute("co", service.selectCo(vo)); //기업정보
		mvo.setId(principal.getName());
		model.addAttribute("member", mservice.getMemInfo(mvo)); //일반정보
		return "co/coInfo";
	}

	// 기업정보수정 비밀번호
	@PostMapping("/checkPw")
	@ResponseBody
	public boolean checkPw(Principal principal, @RequestParam String pw, MemVO mvo) {
		mvo.setId(principal.getName());
		System.out.println(pw);
		if (passwordEncoder.matches(pw, mservice.getMemInfo(mvo).getPw())) {
			return true;
		} else
			return false;
	}

	// 기업나의구인공고목록
	@GetMapping("/coRecruit")
	public String coRecruitPage(Model model, Principal principal, HireVO vo) {
		vo.setId(principal.getName());
		model.addAttribute("recList", service.selectRec(vo));
		return "co/coRecruit";
	}

	// 제안모달창 열었을 때 필요한 정보들
	@GetMapping("/getOfferModalData")
	@ResponseBody
	public List<HireVO> getOfferModalData(HireVO vo) {
		return service.selectRec(vo);// 구인공고목록
	}

	// 관심셀프구직게시글목록
	@GetMapping("/selectInterNoti")
	@ResponseBody
	public List<SelfVO> selectInterNoti(Principal principal, SelfVO vo) {
		vo.setId(principal.getName());
		return service.selectInterNoti(vo);
	}

	// 셀프구직게시글 관심해제
	@PostMapping("/deleteInter")
	@ResponseBody
	public String deleteInter(Principal principal, SelfVO vo) {
		vo.setId(principal.getName());
		service.deleteInfer(vo);
		return "success";
	}

	// 구직에 제안
	@PostMapping("/offerSelf")
	public String offerSelf(CoVO vo) {
		service.afterOffer(vo);
		return "redirect:coMypage";
	}

	// 제안조회
	@GetMapping("/selectOffer")
	@ResponseBody
	public CoVO selectOffer(CoVO vo, Principal principal, String offerCd) {
		vo.setId(principal.getName());
		return service.selectOffer(vo);
	}

	// 제안셀프구직게시글
	@GetMapping("/selectOfferNoti")
	@ResponseBody
	public List<SelfVO> selectOfferNoti(Principal principal, SelfVO vo) {
		vo.setId(principal.getName());
		return service.selectOfferNoti(vo);
	}

	// 개인정보 관리-----------------------------------------------------------
	
	// 기업정보등록/수정
	@PostMapping("/saveCoInfo")
	public String saveCoInfo(Principal principal, CoVO vo) {
		vo.setId(principal.getName());

		service.saveCoInfo(vo);
		return "redirect:coInfoPage";
	}
	
	// 프로필 이미지 등록
	@PostMapping("/uploadProfileImg")
	@ResponseBody
	public String imgUpload(@RequestParam(value="profileImage", required = false) MultipartFile uploadFile, Principal principal) throws IllegalStateException, IOException {
			
		System.out.println("uploadFile : " + uploadFile);
		//System.out.println("성공");

		//첨부파일 업로드 처리
		MultipartFile upload = uploadFile;
		String fileName = null; 		// 원본파일명
		String uploadFileName = null;	// UUID적용한 파일명
			
		if(upload !=null && !upload.isEmpty() && upload.getSize()>0) {
			fileName = upload.getOriginalFilename(); // 원본파일명
				
			// 동일 파일명 처리 UUID 사용
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + fileName;
				
			upload.transferTo(new File(uploadPath,uploadFileName)); // 파일업로드 uploadPath = c:moaImg 에 저장
			
			//member table에 img 이름(uploadFileName) 넣기
			CoVO vo = new CoVO();
			vo.setId(principal.getName());
			vo.setProfileImg(uploadFileName);
			service.uploadProfileImg(vo);
		}
			
		return "{\"file\": \"" + uploadFileName + "\"}";
	}
	
	// 개인정보 수정 (주소,)
	@PostMapping("/updateInfo") 
	@ResponseBody
	public String updateInfo(MemInfoVO vo, Principal principal) {
		vo.setId(principal.getName());
		System.out.println(vo);
		//mservice.updateInfo(vo);
		return "updateSuccess";
	}
	
	// 비밀번호 수정
	@PostMapping("/updatePw")
	@ResponseBody
	public String updatePw(@RequestBody MemVO vo) {
		String pw = passwordEncoder.encode(vo.getPw());
		vo.setPw(pw);
		if(memberservice.updateMember(vo)>0) {
			return "업데이트성공";
		}else return "업데이트실패";
		
	}

	// 기업보유상품페이지
	@GetMapping("/coProducts")
	public String coProductsPage(Model model, Principal principal, CoVO vo) {
		vo.setId(principal.getName());
		model.addAttribute("products", pservice.selectCoProducts(vo));
		return "co/coProducts";
	}

}
