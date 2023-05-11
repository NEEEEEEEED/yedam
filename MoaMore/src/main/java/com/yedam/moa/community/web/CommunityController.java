package com.yedam.moa.community.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.moa.community.service.Impl.CommunityServiceImpl;

@Controller
public class CommunityController {

	@Value("${site.upload}")
	String uploadPath;
	
	@Autowired 
	CommunityServiceImpl communityServiceImpl; 
	
	// 취업 Q&A 페이지
	@GetMapping("/jobQnA") 
	public String jobQnaList() { 
		return "community/jobQnA"; 
	}
	
	// 취업 Q&A 게시글작성 페이지
	@GetMapping("/jobQnAWrite")
	public String jobQnAWrite() {
		return "community/jobQnAWriteForm";
	}
	
	// 취업Q&A Ckeditor 이미지 등록처리
	@PostMapping("/jobQnAImg")
	@ResponseBody
	public Map<String,Object> imgUpload(@RequestParam("upload") MultipartFile uploadFile) throws IllegalStateException, IOException{
		
		Map<String, Object> data = new HashMap<String, Object>();

		
		//첨부파일 업로드 처리
		MultipartFile upload = uploadFile;
		
		String fileName = null; 		// 원본파일명
		//String uploadFileName = null;	// UUID적용한 파일명
		
		if(upload !=null && !upload.isEmpty() && upload.getSize()>0) {
			
			fileName = upload.getOriginalFilename(); // 원본파일명
			
			// 동일 파일명 처리 UUID 사용
			//UUID uuid = UUID.randomUUID();
			//uploadFileName = uuid.toString() + "_" + fileName;
			
			upload.transferTo(new File("c:/moaImg/"+fileName)); // 파일업로드
			data.put("uploaded","1");
			data.put("fileName",fileName);
			data.put("url", "/moamoreImg/"+fileName);
			
		}
		
		return data;
	}
	
	
	 
}
