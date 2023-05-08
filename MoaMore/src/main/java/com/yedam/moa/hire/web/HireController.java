package com.yedam.moa.hire.web;

import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.moa.FileNameModel;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.hire.service.HireService;

@Controller
public class HireController {

	@Autowired
	HireService hireService;
	
	Principal pr;
	
	// 구인공고목록 페이지
	@GetMapping("/hirePage")
	public String hireList(Model model) {
		model.addAttribute("wksiteList",hireService.wksiteList() ); // 근무지역 리스트
		model.addAttribute("jobList", hireService.jobList() ); // 직무 리스트
		model.addAttribute("skillList",hireService.skillList() ); // 기술스택 리스트
		model.addAttribute("carrList",hireService.carrList() ); // 경력 리스트
		return "hire/hirePage";
	}
	
	// 구인공고 전체조회 조건검색 스크랩정렬
	@GetMapping("/data")
	@ResponseBody
    public List<HireVO> getData(HireVO hireVO, Principal principal) {
		List<HireVO> hireList = new ArrayList<HireVO>();
		pr = principal;
		hireVO.setId(pr.getName());
		
		 hireList = hireService.hireList(hireVO);
         return hireList;
    }
	
	
	// 구인공고 상세 페이지
	@GetMapping("/hireInfo")
	public String hireInfo(@RequestParam HireVO hireVO, Principal principal) {
		List<HireVO> hireInfo = new ArrayList<HireVO>();
		
		pr = principal;
		hireVO.setId(pr.getName());
		hireInfo = hireService.hireInfo(hireVO);
		
		return "hire/hireInfo";
	}
	
	// 구인공고 등록 페이지
	@GetMapping("/hireInsert")
	public String hireInsert() {
		return "hire/hireInsert";
	}
	
	// 구인공고 수정 페이지
		@GetMapping("/hireMod")
		public String hireMod() {
			return "hire/hireMod";
	}

	//파일변환(에디터)
    @PostMapping("/test")
    @ResponseBody
    public String test(@RequestParam("image") MultipartFile multi,  HttpServletRequest request, HttpServletResponse response) {
        //String absolutePath = new File("").getAbsolutePath() + "\";
        String path =  "c:\\moaImg";
        String url = null;
        String mv = "";

        try {
            String uploadPath = path;
            String originFilename = multi.getOriginalFilename();
            String extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
            long size = multi.getSize();
            FileNameModel fileNameModel = new FileNameModel();
            String saveFileName = fileNameModel.GenSaveFileName(extName);

            if(!multi.isEmpty()) {
                File file = new File(uploadPath, saveFileName);
                multi.transferTo(file);

                mv = "{\"filename\":\"" + saveFileName + "\"}"; 

            } else {
                mv = "fail";
            }
        } catch (Exception e) {
            System.out.println("[Error] " + e.getMessage());
        }
        return mv;
    }
}
