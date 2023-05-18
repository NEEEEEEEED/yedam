package com.yedam.moa.admin.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.moa.admin.service.AdminService;
import com.yedam.moa.admin.service.PostListVO;
import com.yedam.moa.admin.service.ReportVO;
import com.yedam.moa.admin.service.UserSearchVO;
import com.yedam.moa.comm.CommVO;
import com.yedam.moa.comm.service.Impl.CommServiceImpl;
import com.yedam.moa.community.service.CommunityService;
import com.yedam.moa.mem.MemVO;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	CommServiceImpl comm;

	@GetMapping("/getCommonCode")
	@ResponseBody
	public Map<String, List<CommVO>> getCommonCode() {
		return comm.getCodes("I");
	}

	@GetMapping("/admin")
	public String job() {
		return "admin/dashboard";
	}

	@GetMapping("/member/common")
	public String commonMember() {
		return "admin/commonMember";
	}

	@GetMapping("/getUserInfo")
	@ResponseBody
	public List<MemVO> getUserInfo() {
		return adminService.getUserInfo();
	}
	
	@PostMapping("/getUserDetail")
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
	@PostMapping("/modifyUser")
	@ResponseBody
	public String modifyUser(@RequestBody MemVO[] memVo) {
		//인코딩된 이메일을 디코딩하는 부분
		System.out.println(memVo);
		return adminService.modifyUser(memVo);
	}
	//게시글 전체 조회
	@GetMapping("/getBoardData")
	@ResponseBody
	public PostListVO getBoardData() {
		return adminService.getBoardData();
	}
	//유저 삭제
	@PostMapping("/deleteUsers")
	@ResponseBody
	public String removeUsers(@RequestBody String[] emails) {
		System.out.println(emails);
		return adminService.removeUsers(emails);
	}
	// 유저 검색
	@PostMapping("/getSearchUser")
	@ResponseBody
	public List<MemVO> getSearchUser(@RequestBody UserSearchVO vo) {
		System.out.println(vo);
		return adminService.getSearchUser(vo);
	}
	@Autowired 
	CommunityService commuService;
	// 취업 Q&A 상세페이지
	@GetMapping("/adminQnaDetail")
	public String jobQnaDetail(Model model, String qaNotiwrNo) {
		model.addAttribute("jobQnaDetail", commuService.jobQnaDetail(qaNotiwrNo));
		return "admin/qnaDetail";
	}
	// 취업 Q&A 수정페이지
	@GetMapping("/adminQnaMod")
	public String jobQnaDetailMod(Model model,String qaNotiwrNo) {
		model.addAttribute("jobQnaDetail", commuService.jobQnaDetail(qaNotiwrNo));
		return "admin/jobQnADetailMod";
	}
	// 면접 후기 상세페이지
	
	// 프로젝트 상세페이지
	@GetMapping("/adminProjectDetail")
	public String adminProjectDetail(Model model, String prjtNo) {
		model.addAttribute("projectInfo", commuService.projectDetail(prjtNo));
		return "admin/projectDetailVue";
	}
	// 스터디 상세페이지
	@GetMapping("/adminStudyDetial")
	public String adminStudyDetial(Model model, String studyNo) {
		model.addAttribute("studyDetailInfo", commuService.studyDetail(studyNo));
		return "admin/studyDetailVue";
	}
	//신고 조회
	@PostMapping("/getReportData")
	@ResponseBody
	public Map<String,Object> getReportData(@RequestBody String notiwrNo) {
		System.out.println("+++++++++++++++++++여기에요여기"+notiwrNo.replace("=", ""));
		return adminService.getReportData(notiwrNo.replace("=", ""));
	}
	
}
