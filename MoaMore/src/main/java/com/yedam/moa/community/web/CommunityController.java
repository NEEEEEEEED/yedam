package com.yedam.moa.community.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.moa.community.CommunityVO;
import com.yedam.moa.community.service.Impl.CommunityServiceImpl;

@Controller
public class CommunityController {

	@Value("${site.upload}")
	String uploadPath;
	
	@Autowired 
	CommunityServiceImpl commuServiceImpl; 
	
	Principal pr; // 현재 로그인된 유저정보
	
	// 취업 Q&A 페이지
	@GetMapping("/jobQnA") 
	public String jobQnaList(Model model) { 
		model.addAttribute("jobQnaList", commuServiceImpl.jobQnaList());
		return "community/jobQnA"; 
	}
	
	// 취업 Q&A 게시글작성 페이지
	@GetMapping("/jobQnAWrite")
	public String jobQnAWrite(Model model, Principal principal) {
		pr = principal;
		model.addAttribute("logId",pr.getName());
		return "community/jobQnAWriteForm";
	}
	
	// 취업Q&A Ckeditor 이미지를 올렸을때 처리
	@PostMapping("/jobQnAImg")
	@ResponseBody
	public Map<String,Object> imgUpload(@RequestParam("upload") MultipartFile uploadFile) throws IllegalStateException, IOException{
		
		Map<String, Object> data = new HashMap<String, Object>();

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
			data.put("uploaded",true);
			data.put("fileName",fileName);
			data.put("UUIDFileName",uploadFileName);
			data.put("url", "/moamoreImg/"+uploadFileName);
			
		}
		return data;
	}
	
	// 취업 Q&A
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
	
	
	 
}
