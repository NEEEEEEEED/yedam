package com.yedam.moa.community.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.moa.comm.service.Impl.CommServiceImpl;
import com.yedam.moa.community.CommunityVO;
import com.yedam.moa.community.IntrvVO;
import com.yedam.moa.community.PrjtVO;
import com.yedam.moa.community.service.Impl.CommunityServiceImpl;

@Controller
public class CommunityController {

	@Value("${site.upload}")
	String uploadPath;
	
	@Autowired 
	CommunityServiceImpl commuServiceImpl; // 커뮤니티
	
	@Autowired
	CommServiceImpl commServiceImpl;	// 공통코드
	
	
	// 취업 Q&A 게시글 목록 페이지
	@GetMapping("/jobQnA") 
	public String jobQnaList(Model model) { 
		model.addAttribute("jobQnaList", commuServiceImpl.jobQnaList());
		return "community/jobQnA"; 
	}
	
	// 취업 Q&A 게시글 작성 페이지
	@GetMapping("/jobQnAWrite")
	public String jobQnAWrite(Model model, Principal pr) {
		// 카테고리, 직무, 경력, 평가, 난이도, 합격여부, 면접유형, 면접인원, 진행방식, 진행기간, 연락방법
		model.addAttribute("commList", commServiceImpl.getCodes("f", "N", "O", "P", "Q", "T", "R","S","j","g", "i"));  
		model.addAttribute("logId",pr.getName());
		return "community/communityWrite";
	}
	
	// 취업Q&A Ckeditor 이미지를 올렸을때 처리
	@PostMapping("/jobQnAImg")
	@ResponseBody
	public Map<String,Object> imgUpload(MultipartFile upload) throws IllegalStateException, IOException{
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		String fileName = null; 		// 원본파일명
		String uploadFileName = null;	// UUID적용한 파일명
		
		if(upload !=null && !upload.isEmpty() && upload.getSize()>0) {
			
			fileName = upload.getOriginalFilename(); // 원본파일명
			
			// 동일 파일명 처리 UUID 사용
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + fileName;
			
			upload.transferTo(new File(uploadPath,uploadFileName)); // 파일업로드
			data.put("uploaded",true);
			data.put("fileName",fileName);
			data.put("UUIDFileName",uploadFileName);
			data.put("url", "/moamoreImg/"+uploadFileName);
			
		}
		return data;
	}
	
	// 취업 Q&A 등록 기능
	@PostMapping("/jobQnaAdd")
	@ResponseBody
	public String jobQnaInsert(CommunityVO communityVO) {
		int r = 0;
		
		r = commuServiceImpl.jobQnaInsert(communityVO);
		
		if(r > 0) {
			return "{\"result\": \"Success\"}";
		}else {
			return "{\"result\": \"Fail\"}";
		}
		
	}
	
	// 취업 Q&A 상세페이지
	@GetMapping("/jobQnaDetail")
	public String jobQnaDetail(Model model, String qaNotiwrNo) {
		model.addAttribute("jobQnaDetail", commuServiceImpl.jobQnaDetail(qaNotiwrNo));
		return "community/jobQnADetail";
	}
	
	// 취업 Q&A 수정 페이지
	@GetMapping("/jobQnaMod")
	public String jobQnaDetailMod(Model model,String qaNotiwrNo) {
		model.addAttribute("jobQnaDetail", commuServiceImpl.jobQnaDetail(qaNotiwrNo));
		return "community/jobQnADetailMod";
	}
	
	// 취업 Q&A 수정 기능
	@PostMapping("/jobQnaModFn")
	@ResponseBody
	public Map<String,Object> jobQnaModFn(CommunityVO communityVO){
		
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;
		r = commuServiceImpl.jobQnaModFn(communityVO);
		
		if(r > 0) { // 수정 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
	}
	
	// 취업 Q&A 삭제 기능
	@PostMapping("/jobQnaDelete")
	@ResponseBody
	public Map<String, Object> jobQnaDeleteFn(String qaNotiwrNo){
		
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;
		r = commuServiceImpl.jobQnaDelete(qaNotiwrNo);
		
		if(r > 0) { // 삭제 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
	}
	
	// 면접후기 리스트
	@GetMapping("/jobInterview")
	public String jobInterview(Model model) {
		model.addAttribute("jobInterviewList", commuServiceImpl.jobInterviewList());
		return "community/jobInterviewList";
	}
	
	// 면접후기 등록
	@PostMapping("/jobInterviewAdd")
	@ResponseBody
	public Map<String, Object> jobInterviewAdd(IntrvVO intrvVO) throws IllegalStateException, IOException {
		
		Map<String, Object> result = new HashMap<>();
		
		String fileName = null; 		// 원본파일명
		String uploadFileName = null;	// UUID적용한 파일명
		
		if(intrvVO.getUpload() !=null && !intrvVO.getUpload().isEmpty() && intrvVO.getUpload().getSize()>0) {
			fileName = intrvVO.getUpload().getOriginalFilename(); // 원본파일명
			
			// 동일 파일명 처리 UUID 사용
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + fileName;
			
			intrvVO.getUpload().transferTo(new File(uploadPath,uploadFileName)); // 파일업로드

		}
		
		intrvVO.setIntrvImg(uploadFileName); // 이미지 파일명
		
		int r = 0;
		
		r = commuServiceImpl.jobInterviewInsert(intrvVO); // 면접후기 등록
		
		if(r > 0) { // 등록 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
	}
	
	// 프로젝트 모집 리스트
	@GetMapping("/projectList")
	public String projectListPage() {
		return "community/projectListVue";
	}
	
	// 프로젝트 모집 리스트 axios 호출
	@GetMapping("/projectBoards")
	@ResponseBody
	public List<PrjtVO> projectBoards(){
		return commuServiceImpl.projectList();
	}
	
	// 프로젝트 모집 상세페이지
	@GetMapping("/projectDetail")
	public String projectDetail(Model model, String prjtNo) {
		model.addAttribute("projectInfo", commuServiceImpl.projectDetail(prjtNo));
		return "community/projectDetailVue";
	}
	
	
	// 프로젝트 등록
	@PostMapping("/projectInsert")
	@ResponseBody
	public Map<String, Object> projectInsert(PrjtVO prjtVO){
		
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;
		r = commuServiceImpl.projectInsert(prjtVO);
		
		if(r > 0) { // 등록 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
		
	}
	
	
	// 스터디 모집 리스트
	@GetMapping("/studyList")
	public String studyList() {
		return "community/studyList";
	}
	
	
	// 스터디 모집 상세페이지
	@GetMapping("/studyDetail")
	public String studyDetail() {
		return "community/studyDetail";
	}
	

	
}
