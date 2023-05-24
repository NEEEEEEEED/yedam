package com.yedam.moa.admin.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.moa.admin.service.AdminService;
import com.yedam.moa.admin.service.ApprvListVO;
import com.yedam.moa.admin.service.PostListVO;
import com.yedam.moa.admin.service.ReportVO;
import com.yedam.moa.admin.service.ReserveVO;
import com.yedam.moa.admin.service.UserSearchVO;
import com.yedam.moa.comm.CommVO;
import com.yedam.moa.comm.service.CommService;
import com.yedam.moa.comm.service.Impl.CommServiceImpl;
import com.yedam.moa.community.CommunityVO;
import com.yedam.moa.community.service.CommunityService;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.hire.service.HireService;
import com.yedam.moa.mem.MemVO;
import com.yedam.moa.products.service.ProductVO;
import com.yedam.moa.self.service.SelfService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {


	@Autowired
	AdminService adminService;

	@Autowired
	CommServiceImpl comm;

	@Autowired
	CommService commonService;
	
	@GetMapping("/api/getCommonCode")
	@ResponseBody
	public Map<String, List<CommVO>> getCommonCode() {
		return comm.getCodes("I");
	}

	@GetMapping("/admin")
	public String job() {
		return "admin";
	}

	@GetMapping("/api/getUserInfo")
	@ResponseBody
	public List<MemVO> getUserInfo() {
		return adminService.getUserInfo();
	}
	
	@PostMapping("/api/getUserDetail")
	@ResponseBody
	public MemVO getUserDetails(@RequestBody String email) {
		//인코딩된 이메일을 디코딩하는 부분
		String decoded = null;
		try {
			decoded = URLDecoder.decode(email, "UTF-8");
			decoded = decoded.substring(0, URLDecoder.decode(email, "UTF-8").length()-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return adminService.getUserDetails(decoded);
	}
	//유저 수정
	@PostMapping("/api/modifyUser")
	@ResponseBody
	public String modifyUser(@RequestBody MemVO[] memVo) {
		//인코딩된 이메일을 디코딩하는 부분
		System.out.println(memVo);
		return adminService.modifyUser(memVo);
	}
	//게시글 전체 조회
	@GetMapping("/api/getBoardData")
	@ResponseBody
	public PostListVO getBoardData() {
		return adminService.getBoardData();
	}
	//유저 삭제
	@PostMapping("/api/deleteUsers")
	@ResponseBody
	public String removeUsers(@RequestBody String[] emails) {
		return adminService.removeUsers(emails);
	}
	// 유저 검색
	@PostMapping("/api/getSearchUser")
	@ResponseBody
	public List<MemVO> getSearchUser(@RequestBody UserSearchVO vo) {
		System.out.println(vo);
		return adminService.getSearchUser(vo);
	}
	@PostMapping("/api/modifyRprt")
	@ResponseBody
	public String modifyRprt(@RequestBody List<ReportVO> vo) {
		return adminService.modifyRprt(vo);
	}
	@PostMapping("/api/removeBoard")
	@ResponseBody
	public String removeBoard(@RequestBody String[] nos) {
		return adminService.removeBoard(nos);
	}
	@GetMapping("/api/getApprvList")
	@ResponseBody
	public ApprvListVO getApprvList() {
		return adminService.getApprvList();
	}
	@PostMapping("/api/approveBoard")
	@ResponseBody
	public String approveBoard(@RequestBody String[] nos) {
		return adminService.approveBoard(nos);
	}
	@PostMapping("/api/approveCancelBoard")
	@ResponseBody
	public String approveCancelBoard(@RequestBody String[] nos) {
		return adminService.approveCancelBoard(nos);
	}
	@GetMapping("/api/reportForm")
	public String reportForm(Model model,@RequestParam String no,@RequestParam String title) {
		model.addAttribute("Codes",comm.getCodes("l"));
		model.addAttribute("no",no);
		model.addAttribute("title",title);
		return "reportForm";
	}
	@PostMapping("/api/addReport")
	@ResponseBody
	public String addReport(ReportVO rvo, Principal pr) {
		rvo.setRprter(pr.getName());
		return adminService.addReport(rvo);
	}
	//결제 전체 조회
	@GetMapping("/api/getPayList")
	@ResponseBody
	public List<ProductVO> getPayList() {
		return adminService.getPayList();
	}
	//예약 전체 조회
	@GetMapping("/api/getReservList")
	@ResponseBody
	public List<ReserveVO> getReservList() {
		return adminService.getReservList();
	}
	
	@Autowired 
	CommunityService commuService;
	// 취업 Q&A 상세페이지
	@GetMapping("/api/adminQnaDetail")
	public String jobQnaDetail(Model model, String qaNotiwrNo, Principal pr) {
		CommunityVO vo = new CommunityVO();
		vo.setQaNotiwrNo(qaNotiwrNo);
		vo.setId(pr.getName());

		String recoYn = commuService.jobQnaReco(vo) == 0 ? "N" : "Y";
		
		model.addAttribute("recoYn", recoYn);
		model.addAttribute("jobQnaDetail", commuService.jobQnaDetail(qaNotiwrNo));
		return "admin/qnaDetail";
	}
	// 취업 Q&A 수정페이지
	@GetMapping("/api/adminQnaMod")
	public String jobQnaDetailMod(Model model,String qaNotiwrNo) {
		model.addAttribute("jobQnaDetail", commuService.jobQnaDetail(qaNotiwrNo));
		return "admin/jobQnADetailMod";
	}	
	// 프로젝트 상세페이지
	@GetMapping("/api/adminProjectDetail")
	public String adminProjectDetail(Model model, String prjtNo) {
		model.addAttribute("projectInfo", commuService.projectDetail(prjtNo));
		return "admin/projectDetailVue";
	}
	// 프로젝트 수정페이지
	@GetMapping("/api/adminProjectMod")
	public String adminProjectMod (Model model, Principal pr, String prjtNo) {
		model.addAttribute("logId",pr.getName());
		// 직무, 진행방식, 진행기간, 연락방법, 모집상태
		model.addAttribute("commList", commonService.getCodes("N","j","g","i","h"));
		model.addAttribute("projectInfo", commuService.projectDetail(prjtNo));
		return "admin/projectDetailMod";
	}
	
	// 스터디 상세페이지
	@GetMapping("/api/adminStudyDetial")
	public String adminStudyDetial(Model model, String studyNo) {
		model.addAttribute("studyDetailInfo", commuService.studyDetail(studyNo));
		return "admin/studyDetailVue";
	}
	// 스터디 수정페이지
	@GetMapping("/api/adminStudyMod")
	public String adminStudyMod (Model model, Principal pr, String studyNo) {
		model.addAttribute("logId",pr.getName());
		// 스터디 구분 , 진행방식, 진행기간, 연락방법, 모집상태
		model.addAttribute("commList", commonService.getCodes("k", "j", "g", "i", "h"));
		model.addAttribute("studyDetailInfo", commuService.studyDetail(studyNo));
		return "admin/studyDetailMod";
	}
	//신고 조회
	@PostMapping("/api/getReportData")
	@ResponseBody
	public Map<String,Object> getReportData(@RequestBody String notiwrNo) {
		return adminService.getReportData(notiwrNo.replace("=", ""));
	}
	@Autowired
	HireService hireService;
	// 구인공고 상세페이지
	@GetMapping("/api/adminReaDetail")
	public String adminReaDetail(String recruitNo, Model model, Principal pr) {
		HireVO hireVO = new HireVO();
		hireVO.setRecruitNo(recruitNo);
		//hireVO.setSkill(skill);
		hireVO.setId(pr.getName());

		List<HireVO> hireInfo = hireService.hireInfo(hireVO);
		
		String[] array = hireInfo.get(0).getRecruitImg().split(","); 
		
		//model.addAttribute("recommend", hireService.selectRecommend(hireVO));
		model.addAttribute("imgArray",array);
		model.addAttribute("hireInfo", hireInfo);
		
		return "admin/hireDetail";
	}
	@Autowired 
	SelfService selfService; // 셀프구직
	// 구직공고 상세페이지
	@GetMapping("/api/adminJSNDetail")
	public String adminJSNDetail(Model model, String jobSearchNo, String resumeNo) {
		String carrNo = selfService.resumeKeys(resumeNo).getCarrNo(); // 해당 이력서의 경력번호
		String shcrNo = selfService.resumeKeys(resumeNo).getShcrNo(); // 해당 이력서의 학력번호
		
		//System.out.println("경력번호 : " + carrNo);
		//System.out.println("학력번호 : " + shcrNo);
		
		model.addAttribute("selfJobInfo", selfService.selfJobDetailInfo(jobSearchNo)); // 셀프구직 기본정보
		model.addAttribute("pofolList", selfService.selfJobDetailPofol(jobSearchNo)); // 셀프구직 포트폴리오
		model.addAttribute("skillList", selfService.selfJobDetailSkill(jobSearchNo)); // 셀프구직 스킬
		
		model.addAttribute("carrList", selfService.careerList(carrNo)); // 경력 리스트
		model.addAttribute("schoolList", selfService.schoolList(shcrNo)); // 학력 리스트
		
		return "admin/selfDetail";
	}
	// 면접 후기 상세페이지
	@GetMapping("/api/adminITVDetail")
	public String adminITVDetail(String intrvNo,Model model) {
		model.addAttribute("jobInterviewList", commuService.jobInterviewDetail(intrvNo));
		return "admin/jobITVDetail";
	}

}
