package com.yedam.moa.hire.web;

import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.moa.FileNameModel;
import com.yedam.moa.comm.service.CommService;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.hire.service.HireService;

// 권수민 개발날짜 23.04.28
// 구인광고 관리
@Controller
public class HireController {

	@Value("${site.upload}")
	String uploadPath;
	
	@Autowired
	HireService hireService;

	@Autowired
	CommService com;


	// 구인공고목록 페이지
	@GetMapping("/hirePage")
	public String hireList(Model model) {
		model.addAttribute("list", com.getCodes("Z", "X", "N", "Y"));
		return "hire/hirePage";
	}

	// 구인공고 전체조회 조건검색 스크랩정렬
	@GetMapping("/data")
	@ResponseBody
	public List<HireVO> getData(HireVO hireVO, Principal pr) {
		List<HireVO> hireList = new ArrayList<HireVO>();
		hireVO.setId(pr.getName());

		hireList = hireService.hireList(hireVO);
		return hireList;
	}

	// 구인공고 상세 페이지
	@GetMapping("/hireInfo")
	public String hireInfo(@RequestParam("recruitNo") String recruitNo, @RequestParam("skill") String skill, Model model, Principal pr) {
		HireVO hireVO = new HireVO();
		hireVO.setRecruitNo(recruitNo);
		hireVO.setSkill(skill);
		hireVO.setId(pr.getName());

		List<HireVO> hireInfo = hireService.hireInfo(hireVO);
		
		model.addAttribute("recommend", hireService.selectRecommend(hireVO));
		model.addAttribute("recImg", hireService.recImg(hireVO));
		model.addAttribute("hireInfo", hireInfo);
		
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
	public List<HireVO> selectFollow(HireVO hireVO, Principal pr) {
		List<HireVO> hireList;
		hireVO.setId(pr.getName());
		
		hireList = hireService.hireInfo(hireVO);

		return hireList;
	}
	
	// 구인공고의 기업 팔로우, 취소
	@PostMapping("/followingCo")
	@ResponseBody
	public String followInsert(HireVO hireVO, Principal pr) {
		hireVO.setId(pr.getName());
		
		return hireService.followInsert(hireVO);
	}
	
	
	// 구인공고 공고 스크랩 등록, 취소
	@PostMapping("/recScrap")
	@ResponseBody
	public String recruitScrapInsert(HireVO hireVO, Principal pr) {
		List<HireVO> hireList;
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
	public List<HireVO> selectScrap(HireVO hireVO, Principal pr) {
		List<HireVO> hireList;
		hireVO.setId(pr.getName());

		hireList = hireService.hireInfo(hireVO);

		return hireList;
	}
	
	// 구인공고 등록 페이지 
	@GetMapping("/hireInsert")
	public String recruitInsertSelect(Model model, Principal pr) {
		HireVO hireVO = new HireVO();
		hireVO.setId(pr.getName());
		
		HireVO recruitInsertSelect;
		recruitInsertSelect = hireService.recruitInsertSelect(hireVO);
		
		model.addAttribute("list", com.getCodes("Z","X","N","Y","D"));
		model.addAttribute("recruitInsert",recruitInsertSelect);
		return "hire/hireInsert";
	}
	
	// 구인공고 등록 기능
	@PostMapping("/hireDataInsert")
	@ResponseBody
	public String hireDataInsert(HireVO vo, Principal pr) {
		return hireService.hireDataInsert(vo, pr);
	}
	
	// 구인공고 이미지 등록	
	@PostMapping("/hireImgInsert")
	@ResponseBody
	public String hireImgInsert(@RequestParam("pofolImg") MultipartFile thumbnailImg,
	   		 					@RequestParam("pofolFile") MultipartFile detailImg ) {
		return null;
	}
	
	

	// 구인공고 수정 페이지
	@GetMapping("/hireMod")
	public String hireMod() {
		return "hire/hireMod";
	}


}
