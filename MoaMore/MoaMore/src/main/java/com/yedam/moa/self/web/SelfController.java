package com.yedam.moa.self.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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

import com.yedam.moa.co.service.CoService;
import com.yedam.moa.co.service.CoVO;
import com.yedam.moa.comm.service.CommService;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.self.SelfVO;
import com.yedam.moa.self.service.SelfService;

/* 박선아 2023-05-17 셀프구직 셀프구직 SelfServiceImpl을 service로 변경 */

@Controller
public class SelfController {

	@Autowired 
	SelfService selfService; // 셀프구직
	
	@Autowired
	CommService commonService; // 공통코드
	
	@Autowired
	CoService coService;	// 기업
	
	@Value("${site.upload}")
	String uploadPath;
	
	@Value("${site.pofol}")
	String uploadPofolPath; 
	
	// 셀프구직 목록 페이지
	@GetMapping("/selfJobList")
	public String selfJobList(Model model, Principal principal) {
		// 공통코드 리스트
		model.addAttribute("commList", commonService.getCodes("N","Y","X","Z")); // 직무, 경력, 지역, 기술 리스트
		
		// 기업 모달창 오픈시 필요한 구인공고 리스트
		HireVO hvo = new HireVO();
		hvo.setId(principal.getName());
		model.addAttribute("recList", coService.selectRec(hvo));
		
		return "self/selfJobList";
	}
	
	// 셀프구직 목록 리스트 호출
	@PostMapping("/selfJobList")
	@ResponseBody
	public Map<String,Object> selfJobListPrint(SelfVO selfVO) {
	
		Map<String,Object> map = new HashMap<>();
		
		int pageNum = Integer.parseInt(selfVO.getCurrentPage());
		selfVO.setPageNum(pageNum); // 현재페이지
		
		map.put("selfJobList", selfService.selfJobList(selfVO)); // 셀프구직 목록 리스트
		map.put("selfJobInterest", selfService.selfJobInterestList(selfVO.getId())); // 관심 리스트
		map.put("selfJobOffered", selfService.selfJobOfferedList(selfVO.getId())); // 제안완료 리스트
		map.put("totalListNum", selfService.totalListNum(selfVO));
		return map;
	}
	
	// 이력서 있는지 체크
	@PostMapping("/selfJobCheck")
	@ResponseBody
	public int checkResume(@RequestParam String id) {
		return selfService.checkResume(id);
	} 
	
	// 관심 등록
	@PostMapping("/selfJobInterestAdd")
	@ResponseBody
	public int selfJobInterestAdd(SelfVO interestVO) {
		return selfService.selfJobInterestAdd(interestVO);
	}
	
	// 관심등록 해제
	@PostMapping("/selfJobInterestDelete")
	@ResponseBody
	public int selfJobInterestDelete(SelfVO interestVO) {
		return selfService.selfJobInterestDelete(interestVO);
	}
	
	// 제안 영역-------------------------------------------------------------
	
	// 제안모달 안 필요정보(셀프구직상세페이지에서 사용)
	@GetMapping("/openOfferModal")
	@ResponseBody
	public Map<String,Object> openOfferModal(HireVO vo,Principal principal){
		vo.setId(principal.getName());
		String id = principal.getName();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("commList", commonService.getCodes("Z")); // 기술 목록
		map.put("recList", coService.selectRec(vo)); // 본인(기업)이 쓴 공고 목록
		map.put("coInfo", coService.selectCoInfo(id)); // 기업명, 기업주소
		return map;
	}
	
	// 제안등록
	@PostMapping("/offerSubmit")
	@ResponseBody
	public String offerSubmit(CoVO cvo, Principal principal) {
		cvo.setId(principal.getName());
		coService.afterOffer(cvo);
		return "success";
	}
	 
	
	
	// 셀프구직 등록 페이지 영역-------------------------------------------------
	
	// 셀프구직 등록 페이지
	@GetMapping("/selfJobProfile")
	public String selfJobProfile(Model model) {
		// 공통코드 리스트
		model.addAttribute("commList", commonService.getCodes("N","Y","X","Z","c")); // 직무, 경력, 지역, 기술스택, 보기권한 리스트
		model.addAttribute("selfJobKey", selfService.selfJobKey()); // 셀프구직 게시글 기본키
		return "self/selfJobProfile";
	}
	
	// 셀프구직 이력서 리스트
	@PostMapping("/resumeHeaderList")
	@ResponseBody
	public List<SelfVO> resumeHeaderList(@RequestParam String id){
		return selfService.resumeHeaderList(id);
	}
	
	// 경력사항 리스트
	@PostMapping("/careerList")
	@ResponseBody
	public List<SelfVO> careerList(@RequestParam String carrNo){
		return selfService.careerList(carrNo);
	}
	
	// 학력사항 리스트
	@PostMapping("/schoolList")
	@ResponseBody
	public List<SelfVO> schoolList(@RequestParam String shcrNo){
		return selfService.schoolList(shcrNo);
	}
	
	// 셀프구직 등록
	@PostMapping("/myProfileAdd")
	@ResponseBody
	public String myProfileAdd(@RequestBody SelfVO myProfile){
		
		int r = selfService.myProfileAdd(myProfile);
		
		if(r > 0) {
			return "{\"result\": \"Success\"}";
		}else {
			return "{\"result\": \"Fail\"}";
		}
	}
	
	// 셀프구직 이미지 등록
	@PostMapping("/myProfileImg")
	@ResponseBody
	public String imgUpload(@RequestParam(value="profileImage", required = false) MultipartFile uploadFile,@RequestParam(value="reqLoc", required = false) String st ) throws IllegalStateException, IOException {
		
		//System.out.println("uploadFile : " + uploadFile);
		//System.out.println("성공");
		
		System.out.println(st);
		//첨부파일 업로드 처리
		MultipartFile upload = uploadFile;
		String fileName = null; 		// 원본파일명
		String uploadFileName = null;	// UUID적용한 파일명
		
		if(upload !=null && !upload.isEmpty() && upload.getSize()>0) {
			fileName = upload.getOriginalFilename(); // 원본파일명
			
			// 동일 파일명 처리 UUID 사용
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + fileName;
			
			upload.transferTo(new File(uploadPath,uploadFileName)); // 파일업로드
			
			//System.out.println("파일이름: " + uploadFileName);
		}
		System.out.println(uploadFileName);
		if(st.matches("resume")) 
		{return uploadFileName;}
		else 
			
		return "{\"file\": \"" + uploadFileName + "\"}";
		
	}
	
	
	// 셀프구직 포트폴리오 등록 - 첨부파일 업로드 처리 // 피드백 : 받오는값을 커멘트 객체 형식으로 VO에 한꺼번에 받아도됨(대신 이름이 일치해야함)
	@PostMapping("/pofolAdd")
	@ResponseBody
	public List<SelfVO> pofolUpload( @RequestParam("jobSearchNo") String jobSearchNo,
							   		 @RequestParam("id") String id,
							   		 @RequestParam("title") String title,
							   		 @RequestParam("pofolImg") MultipartFile uploadPofolImg,
							   		 @RequestParam("pofolFile") MultipartFile uploadPofolFile ) throws IllegalStateException, IOException {
		
		// 포트폴리오 이미지
		String fileNamePofolImg = null; // 원본파일명
		String uploadFileNamePofolImg = null;   // UUID적용한 파일명(중복 없는 파일명)
		
		// 포트폴리오 파일
		String fileNamePofolFile = null; // 원본파일명
		String uploadFileNamePofolFile = null;   // UUID적용한 파일명(중복 없는 파일명)
		
		int r = 0; // sql문 결과
		
		if(uploadPofolImg !=null && !uploadPofolImg.isEmpty() && uploadPofolImg.getSize()>0
		&& uploadPofolFile !=null && !uploadPofolFile.isEmpty() && uploadPofolFile.getSize()>0) {
			
			// 포트폴리오 이미지
			fileNamePofolImg = uploadPofolImg.getOriginalFilename(); // 원본 이미지 파일명
			
			// 포트폴리오 파일
			fileNamePofolFile = uploadPofolFile.getOriginalFilename(); // 원본 포트폴리오 파일명
			
			// 동일 파일명 처리 UUID 사용
			UUID uuid = UUID.randomUUID();
			uploadFileNamePofolImg = uuid.toString() + "_" + fileNamePofolImg; // 이미지 UUID 적용한 파일명
			uploadFileNamePofolFile = uuid.toString() + "_" + fileNamePofolFile; // 파일 UUID 적용한 파일명
			
			uploadPofolImg.transferTo(new File(uploadPofolPath,uploadFileNamePofolImg)); // 이미지 파일
			uploadPofolFile.transferTo(new File(uploadPofolPath,uploadFileNamePofolFile)); // 이미지 파일
			
			//첨부파일명 VO에 지정
			System.out.println("파일이름: " + fileNamePofolImg);
			System.out.println("파일이름: " + fileNamePofolFile);
			
			SelfVO pofol = new SelfVO();
			pofol.setJobSearchNo(jobSearchNo);
			pofol.setId(id);
			pofol.setTitle(title);
			pofol.setPofolImg(uploadFileNamePofolImg);
			pofol.setPofolFile(fileNamePofolFile);
			pofol.setPofolUuidFile(uploadFileNamePofolFile);

			r = selfService.selfJobPofolAdd(pofol);	
		}
		if(r > 0) {
			return selfService.selfJobpofolList(jobSearchNo);
		}else {			
			return null;
		}
	}
	
	// 포트폴리오 삭제
	@PostMapping("/pofolDelete")
	@ResponseBody
	public List<SelfVO> pofolDelete(@RequestParam String fileNo, @RequestParam String jobSearchNo){
		int r = selfService.pofolDelete(fileNo);
		if(r > 0) {
			return selfService.selfJobpofolList(jobSearchNo);
		}else {
			return null;
		}
	}
	
	// 셀프구직 상세페이지
	@GetMapping("/selfJobDetail")
	public String selfJobDetail(Model model, String jobSearchNo, String resumeNo) {
		String carrNo = selfService.resumeKeys(resumeNo).getCarrNo(); // 해당 이력서의 경력번호
		String shcrNo = selfService.resumeKeys(resumeNo).getShcrNo(); // 해당 이력서의 학력번호
		
		//System.out.println("경력번호 : " + carrNo);
		//System.out.println("학력번호 : " + shcrNo);
		
		model.addAttribute("selfJobInfo", selfService.selfJobDetailInfo(jobSearchNo)); // 셀프구직 기본정보
		model.addAttribute("pofolList", selfService.selfJobDetailPofol(jobSearchNo)); // 셀프구직 포트폴리오
		model.addAttribute("skillList", selfService.selfJobDetailSkill(jobSearchNo)); // 셀프구직 스킬
		
		model.addAttribute("carrList", selfService.careerList(carrNo)); // 경력 리스트
		model.addAttribute("schoolList", selfService.schoolList(shcrNo)); // 학력 리스트
		
		return "self/selfJobDetail";
	}
	
	// 셀프구직 수정 페이지
	@GetMapping("/selfJobMod")
	public String selfJobModify(Model model, String jobSearchNo, String resumeNo) {
		String carrNo = selfService.resumeKeys(resumeNo).getCarrNo(); // 해당 이력서의 경력번호
		String shcrNo = selfService.resumeKeys(resumeNo).getShcrNo(); // 해당 이력서의 학력번호
		
	
		model.addAttribute("commList", commonService.getCodes("N","Y","X","Z","c")); // 직무, 경력, 지역, 기술스택, 보기권한 리스트
		model.addAttribute("selfJobInfo", selfService.selfJobDetailInfo(jobSearchNo)); // 셀프구직 기본정보
		//model.addAttribute("pofolList", selfService.selfJobDetailPofol(jobSearchNo)); // 셀프구직 포트폴리오
		model.addAttribute("carrList", selfService.careerList(carrNo)); // 경력 리스트
		model.addAttribute("schoolList", selfService.schoolList(shcrNo)); // 학력 리스트
		
		model.addAttribute("carrNo", selfService.resumeKeys(resumeNo).getCarrNo()); // 경력 리스트
		model.addAttribute("shcrNo", selfService.resumeKeys(resumeNo).getShcrNo()); // 학력 리스트
		
		
		return "self/selfJobDetailMod";
	}
	
	// 포트폴리오 목록 리스트
	@PostMapping("/selfJobpofolList")
	@ResponseBody
	public List<SelfVO> selfJobpofolList(String jobSearchNo){
		return selfService.selfJobpofolList(jobSearchNo);
	}
	
	// 셀프구직 수정기능
	@PostMapping("/selfJobModifyFn")
	@ResponseBody
	public String selfJobModifyFn(@RequestBody SelfVO selfVO) {
		int r = selfService.myProfileMod(selfVO);
		if(r > 0) {
			return "{\"result\": \"Success\"}";
		}else {
			return "{\"result\": \"Fail\"}";
		}
	}
	
	@PostMapping("/selfJobDelete")
	@ResponseBody
	public int selfJobDelete(String jobSearchNo) {
		return selfService.myProfileDel(jobSearchNo);
	}
	
	
}
