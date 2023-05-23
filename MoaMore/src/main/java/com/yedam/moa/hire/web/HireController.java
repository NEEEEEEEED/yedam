package com.yedam.moa.hire.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
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

import com.yedam.moa.comm.service.CommService;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.hire.service.HireService;
import com.yedam.moa.hire.service.Impl.HireServiceImpl;

// 권수민 개발날짜 23.04.28
// 구인광고 관리
@Controller
public class HireController {

	@Value("${site.upload}")
	String uploadPath;
	
	@Autowired
	HireService hireService;
	
	@Autowired
	HireServiceImpl hireServiceImpl;

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
		hireVO.getAccpDt();
		hireVO.getExprDt();
//		String[] skillArray = hireList.get(0).getSkill().split(",");
//		hireVO.setSkillArray(skillArray);

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
		String[] skillArray = hireInfo.get(0).getSkill().split(",");
		hireVO.setSkillArray(skillArray);
		
		String[] array = hireInfo.get(0).getRecruitImg().split(",");
		
		model.addAttribute("recommend", hireService.selectRecommend(hireVO));
		model.addAttribute("imgArray",array);
		model.addAttribute("hireInfo", hireInfo);
		
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
		recruitInsertSelect.setRecruitNo(hireService.recruitNo());
		
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
	
	// 구인공고 상세 이미지들, 썸네일 등록 - 첨부파일 업로드 처리 // 피드백 : 받오는값을 커멘트 객체 형식으로 VO에 한꺼번에 받아도됨(대신 이름이 일치해야함)
	@PostMapping("/hireImgInsert")
	@ResponseBody
	public List<HireVO> hireImgInsert(@RequestParam("thumnailImg") MultipartFile uploadthumnailImg,
									  MultipartFile[] recrintImgDetail,
							   		  HireVO hireVO,
							   		  Principal pr) throws IllegalStateException, IOException {

	// 구인공고 썸네일 업로드
	String fileNameThumnailImg= null; // 단건
		

	
	int r = 0; // sql문 결과
	// 동일 파일명 처리 UUID 사용
	UUID uuid = UUID.randomUUID();
	
		 if(uploadthumnailImg !=null && !uploadthumnailImg.isEmpty() && uploadthumnailImg.getSize()>0) {
			// 썸네일 이미지
			fileNameThumnailImg = uploadthumnailImg.getOriginalFilename(); // 원본 이미지 파일명
			
			fileNameThumnailImg = uuid.toString() + "_" + fileNameThumnailImg; // 이미지 UUID 적용한 파일명
			uploadthumnailImg.transferTo(new File(uploadPath,fileNameThumnailImg)); // 이미지 파일
			hireVO.setCoImg(fileNameThumnailImg);
		 }
		 
		 for (int i = 0; i < recrintImgDetail.length; i++) {
		
			 if(recrintImgDetail[i] !=null && !recrintImgDetail[i].isEmpty() && recrintImgDetail[i].getSize()>0 ) { 
		    
				 // 썸네일 이미지
				 fileNameThumnailImg = recrintImgDetail[i].getOriginalFilename(); // 원본 이미지 파일명
				 
				 // 파일 UUID 적용한 파일명 
				 fileNameThumnailImg = uuid.toString() + "_" + fileNameThumnailImg; 
				 recrintImgDetail[i].transferTo(new File(uploadPath,fileNameThumnailImg)); // 이미지 파일
			 
				 hireVO.getRecruitImgList().add(fileNameThumnailImg); 
				 
				 
			 }
		 }
			 
		
		 
		//첨부파일명 VO에 지정
		hireVO.setId(pr.getName());

		r =  hireServiceImpl.hireImgInsert(hireVO);
	
	if(r > 0) {
		return hireServiceImpl.hireImgInsertList(hireVO);
	}else {			
		return null;
	}
}

	// 구인공고 수정 페이지
	@GetMapping("/hireMod")
	public String hireMod(@RequestParam("recruitNo") String recruitNo, Model model, Principal pr) {
		HireVO hireVO = new HireVO();
		hireVO.setRecruitNo(recruitNo);
		hireVO.setId(pr.getName());

		List<HireVO> hireInfo = hireService.hireInfo(hireVO);
		
		model.addAttribute("list", com.getCodes("Z","X","N","Y","D"));
		model.addAttribute("hireInfo", hireInfo);
		
		return "hire/hireMod";
	}
	
	// 구인공고 수정 기능
	@PostMapping("/hireModify")
	@ResponseBody
	public int hireModify(HireVO vo, Principal pr) {
		vo.setId(pr.getName());
		return hireService.hireModify(vo);
	}
	
	// 구인공고 이미지 수정
	@PostMapping("/hireImgModify")
	@ResponseBody
		public List<HireVO> hireImgModify(@RequestParam("thumnailImg") MultipartFile uploadthumnailImg,
				  							MultipartFile[] recrintImgDetail,
				  							HireVO hireVO,
				  							Principal pr) throws IllegalStateException, IOException {
	
		// 구인공고 썸네일 업로드
		String fileNameThumnailImg= null; // 단건
			

		
		int r = 0; // sql문 결과
		// 동일 파일명 처리 UUID 사용
		UUID uuid = UUID.randomUUID();
		
			 if(uploadthumnailImg !=null && !uploadthumnailImg.isEmpty() && uploadthumnailImg.getSize()>0) {
				// 썸네일 이미지
				fileNameThumnailImg = uploadthumnailImg.getOriginalFilename(); // 원본 이미지 파일명
				
				fileNameThumnailImg = uuid.toString() + "_" + fileNameThumnailImg; // 이미지 UUID 적용한 파일명
				uploadthumnailImg.transferTo(new File(uploadPath,fileNameThumnailImg)); // 이미지 파일
				hireVO.setCoImg(fileNameThumnailImg);
			 }
			 
			 for (int i = 0; i < recrintImgDetail.length; i++) {
			
				 if(recrintImgDetail[i] !=null && !recrintImgDetail[i].isEmpty() && recrintImgDetail[i].getSize()>0 ) { 
			    
					 // 썸네일 이미지
					 fileNameThumnailImg = recrintImgDetail[i].getOriginalFilename(); // 원본 이미지 파일명
					 
					 // 파일 UUID 적용한 파일명 
					 fileNameThumnailImg = uuid.toString() + "_" + fileNameThumnailImg; 
					 recrintImgDetail[i].transferTo(new File(uploadPath,fileNameThumnailImg)); // 이미지 파일
				 
					 hireVO.getRecruitImgList().add(fileNameThumnailImg); 
					 
					 
				 }
			 }
				 
			//첨부파일명 VO에 지정
			hireVO.setId(pr.getName());

			r =  hireServiceImpl.hireImgModify(hireVO);
		
		if(r > 0) {
			return hireServiceImpl.hireImgInsertList(hireVO);
		}else {			
			return null;
		}
	}

	@PostMapping("/hireDelete")
	@ResponseBody
	public String hireDelete(@RequestParam("recruitNo") String recruitNo) {
		hireService.hireDelete(recruitNo);
		return "hireDelSuccess";
	}
	


}
	
	
	
