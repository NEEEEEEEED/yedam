package com.yedam.moa.hire.web;

import java.io.Console;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.moa.FileNameModel;
import com.yedam.moa.comm.service.CommService;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.hire.service.HireService;

@Controller
public class HireController {

	@Autowired
	HireService hireService;

	@Autowired
	CommService com;

	Principal pr;

	// 구인공고목록 페이지
	@GetMapping("/hirePage")
	public String hireList(Model model) {
		model.addAttribute("list", com.getCodes("Z", "X", "N", "Y"));
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
	public String hireInfo(@RequestParam("recruitNo") String recruitNo, Model model, Principal principal) {
		HireVO hireVO = new HireVO();
		hireVO.setRecruitNo(recruitNo);
		pr = principal;
		hireVO.setId(pr.getName());

		List<HireVO> hireInfo = new ArrayList<HireVO>();
		hireInfo = hireService.hireInfo(hireVO);
		
		model.addAttribute("recImg", hireService.recImg(hireVO));
		model.addAttribute("hireInfo", hireInfo);
		model.addAttribute("recruitNo", recruitNo);
        System.out.println(model);
		return "hire/hireInfo";
	}

	// 구인공고 이력서 모달 조회
	@PostMapping("/resumeList")
	@ResponseBody
	public List<HireVO> resumeList(@RequestParam(required = false) String id) {
		return hireService.resumeList(id);
	}

	// 구인공고 지원
	@PostMapping("/resumeInsert")
	@ResponseBody
	public String resumeInsert(HireVO hireVO) {
		return hireService.resumeInsert(hireVO);
	}
	
	// 구인공고 관심 기업 조회
	@GetMapping("/selectFollow")
	@ResponseBody
	public List<HireVO> selectFollow(HireVO hireVO, Principal principal) {
		List<HireVO> hireList = new ArrayList<HireVO>();
		pr = principal;
		hireVO.setId(pr.getName());
		
		hireList = hireService.hireInfo(hireVO);

		return hireList;
	}
	
	// 구인공고의 기업 팔로우, 취소
	@PostMapping("/followingCo")
	@ResponseBody
	public String followInsert(HireVO hireVO, Principal principal) {
		pr = principal;
		hireVO.setId(pr.getName());
		
		return hireService.followInsert(hireVO);
	}
	
	
	// 구인공고 공고 스크랩 등록, 취소
	@PostMapping("/recScrap")
	@ResponseBody
	public String recruitScrapInsert(HireVO hireVO, Principal principal) {
		List<HireVO> hireList = new ArrayList<HireVO>();
		pr = principal;
		hireVO.setId(pr.getName());
		
		hireList = hireService.hireInfo(hireVO);
		// hireVO에서 꺼내온다
		if(hireList.get(0).getScrapYn() != null) {
			return hireService.recruitScrapDelete(hireVO);
		}else {
			return hireService.recruitScrapInsert(hireVO);
		}
		
		
	}

	// 구인공고 상세 페이지 스크랩 조회
	@GetMapping("/selectScrap")
	@ResponseBody
	public List<HireVO> selectScrap(HireVO hireVO, Principal principal) {
		List<HireVO> hireList = new ArrayList<HireVO>();
		pr = principal;
		hireVO.setId(pr.getName());

		hireList = hireService.hireInfo(hireVO);

		return hireList;
	}

	// 구인공고 등록 페이지 
	@GetMapping("/hireInsert")
	public String recruitInsertSelect(Model model, Principal principal) {
		HireVO hireVO = new HireVO();
		pr = principal;
		hireVO.setId(pr.getName());
		
		List<HireVO> recruitInsertSelect = new ArrayList<HireVO>();
		recruitInsertSelect = hireService.recruitInsertSelect(hireVO);
		
		model.addAttribute("list", com.getCodes("Z","X","N","Y","D"));
		model.addAttribute("recruitInsert",recruitInsertSelect);
		return "hire/hireInsert";
	}

	// 구인공고 수정 페이지
	@GetMapping("/hireMod")
	public String hireMod() {
		return "hire/hireMod";
	}

	// 파일변환(에디터)
	@PostMapping("/test")
	@ResponseBody
	public String test(@RequestParam("image") MultipartFile multi, HttpServletRequest request,
			HttpServletResponse response) {
		// String absolutePath = new File("").getAbsolutePath() + "\";
		String path = "c:\\moaImg";
		String url = null;
		String mv = "";

		try {
			String uploadPath = path;
			String originFilename = multi.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			long size = multi.getSize();
			FileNameModel fileNameModel = new FileNameModel();
			String saveFileName = fileNameModel.GenSaveFileName(extName);

			if (!multi.isEmpty()) {
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
