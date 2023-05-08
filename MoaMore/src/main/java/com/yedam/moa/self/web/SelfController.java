package com.yedam.moa.self.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.yedam.moa.self.SelfVO;
import com.yedam.moa.self.service.Impl.SelfServiceImpl;

@Controller
public class SelfController {

	@Autowired 
	SelfServiceImpl selfServiceImpl; 
	
	@Value("${site.upload}")
	String uploadPath;
	
	@Value("${site.pofol}")
	String uploadPofolPath; 
	
	// 셀프구직 목록 페이지
	@GetMapping("/selfJobList")
	public String selfJobList(Model model) {
		model.addAttribute("jobList", selfServiceImpl.jobList()); // 직무리스트
		model.addAttribute("carrList", selfServiceImpl.carrList()); // 경력리스트
		model.addAttribute("cityList", selfServiceImpl.cityList()); // 지역리스트
		return "self/selfJobList";
	}
	
	// 셀프구직 목록 리스트 호출
	@PostMapping("/selfJobList")
	@ResponseBody
	public Map<String,Object> selfJobListPrint(SelfVO selfVO) {
	
		Map<String,Object> map = new HashMap<>();
		map.put("selfJobList", selfServiceImpl.selfJobList(selfVO));
		map.put("selfJobInterest", selfServiceImpl.selfJobInterestList(selfVO.getId()));
		return map;
	}
	
	// 이력서 있는지 체크
	@PostMapping("/selfJobCheck")
	@ResponseBody
	public int checkResume(@RequestParam String id) {
		return selfServiceImpl.checkResume(id);
	} 
	
	// 관심 등록
	@PostMapping("/selfJobInterestAdd")
	@ResponseBody
	public int selfJobInterestAdd(SelfVO interestVO) {
		return selfServiceImpl.selfJobInterestAdd(interestVO);
	}
	
	// 관심등록 해제
	@PostMapping("/selfJobInterestDelete")
	@ResponseBody
	public int selfJobInterestDelete(SelfVO interestVO) {
		return selfServiceImpl.selfJobInterestDelete(interestVO);
	}
	
	// 셀프구직 my프로필 등록 페이지 영역-------------------------------------------------
	
	// 셀프구직 my프로필 등록 페이지
	@GetMapping("/selfJobProfile")
	public String selfJobProfile(Model model) {
		model.addAttribute("cityList", selfServiceImpl.cityList()); // 지역리스트
		model.addAttribute("carrList", selfServiceImpl.carrList()); // 경력리스트
		model.addAttribute("jobList", selfServiceImpl.jobList()); // 직무리스트
		model.addAttribute("techList", selfServiceImpl.techList()); // 기술스택리스트
		model.addAttribute("authList", selfServiceImpl.authList()); // 보기권한리스트
		model.addAttribute("selfJobKey", selfServiceImpl.selfJobKey()); // 셀프구직 게시글 기본키
		return "self/selfJobProfile";
	}
	
	// my프로필 이력서 리스트
	@PostMapping("/resumeHeaderList")
	@ResponseBody
	public List<SelfVO> resumeHeaderList(@RequestParam String id){
		return selfServiceImpl.resumeHeaderList(id);
	}
	
	// 경력사항 리스트
	@PostMapping("/careerList")
	@ResponseBody
	public List<SelfVO> careerList(@RequestParam String carrNo){
		return selfServiceImpl.careerList(carrNo);
	}
	
	// 학력사항 리스트
	@PostMapping("/schoolList")
	@ResponseBody
	public List<SelfVO> schoolList(@RequestParam String shcrNo){
		return selfServiceImpl.schoolList(shcrNo);
	}
	
	// my프로필 등록
	@PostMapping("/myProfileAdd")
	@ResponseBody
	public String myProfileAdd(@RequestBody SelfVO myProfile){
		
		int r = selfServiceImpl.myProfileAdd(myProfile);
		
		if(r > 0) {
			return "{\"result\": \"Success\"}";
		}else {
			return "{\"result\": \"Fail\"}";
		}
	}
	
	// my프로필 이미지
	@PostMapping("/myProfileImg")
	@ResponseBody
	public String imgUpload(@RequestParam(value="profileImage", required = false) MultipartFile uploadFile) throws IllegalStateException, IOException {
		
		//System.out.println("uploadFile : " + uploadFile);
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
			
			upload.transferTo(new File("c:/moaImg/"+uploadFileName)); // 파일업로드
			
			//System.out.println("파일이름: " + uploadFileName);
		}
		
		return "{\"file\": \"" + uploadFileName + "\"}";
	}
	
	
	// my프로필 포트폴리오 등록
	@PostMapping("/pofolAdd")
	@ResponseBody
	public List<SelfVO> pofolUpload( @RequestParam("jobSearchNo") String jobSearchNo,
							   @RequestParam("id") String id,
							   @RequestParam("title") String title,
							   @RequestParam("pofolImg") MultipartFile pofolImg,
							   @RequestParam("pofolFile") MultipartFile pofolFile ) throws IllegalStateException, IOException {
		
		System.out.println("jobSearchNo : " + jobSearchNo);
		System.out.println("id : " + id);
		System.out.println("title : " + title);
		System.out.println("pofolImg : " + pofolImg);
		System.out.println("pofolFile : " + pofolFile);
		System.out.println("성공");

		
		//첨부파일 업로드 처리
		MultipartFile uploadPofolImg = pofolImg;
		MultipartFile uploadPofolFile = pofolFile;
		
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
			
			uploadPofolImg.transferTo(new File("c:/moapofol/"+uploadFileNamePofolImg)); // 이미지 파일
			uploadPofolFile.transferTo(new File("c:/moapofol/"+uploadFileNamePofolFile)); // 이미지 파일
			
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

			r = selfServiceImpl.selfJobPofolAdd(pofol);	
		}
		if(r > 0) {
			return selfServiceImpl.selfJobpofolList(jobSearchNo);
		}else {			
			return null;
		}
	}
	
	// 포트폴리오 삭제
	@PostMapping("/pofolDelete")
	@ResponseBody
	public List<SelfVO> pofolDelete(@RequestParam String fileNo, @RequestParam String jobSearchNo){
		int r = selfServiceImpl.pofolDelete(fileNo);
		if(r > 0) {
			return selfServiceImpl.selfJobpofolList(jobSearchNo);
		}else {
			return null;
		}
	}
	
	
}
