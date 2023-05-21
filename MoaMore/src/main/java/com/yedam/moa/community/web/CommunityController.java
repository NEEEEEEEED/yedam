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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.moa.comm.service.CommService;
import com.yedam.moa.community.CommunityVO;
import com.yedam.moa.community.Criteria;
import com.yedam.moa.community.IntrvVO;
import com.yedam.moa.community.PagingVO;
import com.yedam.moa.community.PrjtVO;
import com.yedam.moa.community.ReplyVO;
import com.yedam.moa.community.StudyVO;
import com.yedam.moa.community.service.CommunityService;


/* 박선아 2023-05-17 커뮤니티  CommunityServiceImpl을 CommunityService로 변경 */

@Controller
@Component
public class CommunityController {

	@Value("${site.upload}")
	String uploadPath;
	
	@Autowired 
	CommunityService commuService; // 커뮤니티
	
	@Autowired
	CommService commonService;	// 공통코드
	
	
	// 취업 Q&A 게시글 목록 페이지
	@GetMapping("/jobQnA") 
	public String jobQnaList(Criteria cri, Model model) { 
		
		// 전체 글 개수
        int jobQnaListCnt = commuService.jobQnaListCnt();
        
        // 페이징 객체
        PagingVO paging = new PagingVO();
        paging.setCri(cri);
        paging.setTotalCount(jobQnaListCnt);    
        
        List<CommunityVO> list = commuService.jobQnaList(cri);
        
        model.addAttribute("jobQnaList", list);    
        model.addAttribute("paging", paging);    
		
		System.out.println(paging.toString());
		
		//model.addAttribute("jobQnaList", commuService.jobQnaList());
		model.addAttribute("bestList", commuService.jobQnaBest());
		
		return "community/jobQnA"; 
	}
	
	// 취업 Q&A 게시글 작성 페이지
	@GetMapping("/jobQnAWrite")
	public String jobQnAWrite(Model model, Principal pr) {
		// 카테고리, 직무, 경력, 평가, 난이도, 합격여부, 면접유형, 면접인원, 진행방식, 진행기간, 연락방법, 스터디 구분
		model.addAttribute("commList", commonService.getCodes("f", "N", "O", "P", "Q", "T", "R","S","j","g", "i", "k"));  
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
		
		r = commuService.jobQnaInsert(communityVO);
		
		if(r > 0) {
			return "{\"result\": \"Success\"}";
		}else {
			return "{\"result\": \"Fail\"}";
		}
		
	}
	
	// 취업 Q&A 상세페이지
	@GetMapping("/jobQnaDetail")
	public String jobQnaDetail(Model model, String qaNotiwrNo, Principal pr) {
		
		CommunityVO vo = new CommunityVO();
		vo.setQaNotiwrNo(qaNotiwrNo);
		vo.setId(pr.getName());

		String recoYn = commuService.jobQnaReco(vo) == 0 ? "N" : "Y";
		
		model.addAttribute("recoYn", recoYn);
		model.addAttribute("jobQnaDetail", commuService.jobQnaDetail(qaNotiwrNo));
		return "community/jobQnADetailVue";
	}
	
	// 취업 Q&A 게시글 추천 등록
	@PostMapping("/jobQnaRecoAdd")
	@ResponseBody
	public Map<String,Object> jobQnaRecoAdd(CommunityVO communityVO, Principal pr){
		
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;
		
		communityVO.setId(pr.getName());
		
		r = commuService.jobQnaRecoAdd(communityVO);
		
		if(r > 0) { // 등록 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
	}
	
	// 취업 Q&A 수정 페이지
	@GetMapping("/jobQnaMod")
	public String jobQnaDetailMod(Model model,String qaNotiwrNo) {
		model.addAttribute("jobQnaDetail", commuService.jobQnaDetail(qaNotiwrNo));
		return "community/jobQnADetailMod";
	}
	
	// 취업 Q&A 수정 기능
	@PostMapping("/jobQnaModFn")
	@ResponseBody
	public Map<String,Object> jobQnaModFn(CommunityVO communityVO){
		
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;
		r = commuService.jobQnaModFn(communityVO);
		
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
	public int jobQnaDeleteFn(String qaNotiwrNo){
		
		return commuService.jobQnaDelete(qaNotiwrNo);
		
	}
	
	// 취업 Q&A 부모 댓글 등록
	@PostMapping("/qnaReplyAdd")
	@ResponseBody
	public Map<String, Object> qnaReplyAdd(ReplyVO replyVO){
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;

		r = commuService.qnaReplyAdd(replyVO);
		
		if(r > 0) { // 등록 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
	}
	
	
	// 취업 Q&A 댓글 목록(모댓글) 리스트
	@PostMapping("/qnaReplyList")
	@ResponseBody
	public List<ReplyVO> qnaReplyList(@RequestBody ReplyVO replyVO){
		//System.out.println("qaNotiwrNo : " + replyVO);
		return commuService.qnaReplyList(replyVO);
	}
	
	// 현재 로그인되어있는 유저 ID
	@GetMapping("/userId")
	@ResponseBody
	public String userId(Principal pr) {
		return pr.getName();
	}
	
	// 취업Q&A 댓글 수정 기능 , 대댓글 수정 기능
	@PostMapping("/qnaReplyMod")
	@ResponseBody
	public Map<String, Object> qnaReplyMod(@RequestBody ReplyVO replyVO){
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;
		
		r = commuService.qnaReplyMod(replyVO);
		
		if(r > 0) { // 수정 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
	}
	
	// 취업 Q&A 댓글 삭제 기능
	@PostMapping("/qnaReplyDelete")
	@ResponseBody
	public Map<String, Object> qnaReplyDelete(@RequestBody ReplyVO replyVO){
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;
		
		r = commuService.qnaReplyDelete(replyVO);
		
		if(r > 0) { // 삭제 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
	}
	
	// 취업 Q&A 자식 댓글(대댓글) 등록
	@PostMapping("/chQnaReplyAdd")
	@ResponseBody
	public Map<String, Object> chQnaReplyAdd(ReplyVO replyVO){
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;

		r = commuService.chQnaReplyAdd(replyVO);
		
		if(r > 0) { // 대댓글 등록 성공시
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
		model.addAttribute("commList", commonService.getCodes("N", "O"));  
		//model.addAttribute("jobInterviewList", commuService.jobInterviewList());
		return "community/jobInterviewList";
	}
	
	// 검색조건(직무, 경력, 회사명)에 따른 면접후기 리스트
	@PostMapping("/jobInterviewList")
	@ResponseBody
	public List<IntrvVO> jobInterviewList(IntrvVO intrvVO){
		return commuService.jobInterviewList(intrvVO);
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
		
		r = commuService.jobInterviewInsert(intrvVO); // 면접후기 등록
		
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
		return commuService.projectList();
	}

	
	// 스케쥴러
	@Scheduled(cron = "0 0 9 * * *") // 매일 오전 9시에 실행
	public void myMethod(){
		// 프로젝트 모집 오늘날짜 오전 9시를 기준으로 모집 상태 update 
		commuService.proCollstScheduler(); 
		// 스터디 모집 오늘날짜 오전 9시를 기준으로 모집 상태 update 
		commuService.studyCollstScheduler();
		
    }
	
	
	// 프로젝트 모집 상세페이지
	@GetMapping("/projectDetail")
	public String projectDetail(Model model, String prjtNo) {
		model.addAttribute("projectInfo", commuService.projectDetail(prjtNo));
		return "community/projectDetailVue";
	}
	
	
	// 프로젝트 등록
	@PostMapping("/projectInsert")
	@ResponseBody
	public Map<String, Object> projectInsert(PrjtVO prjtVO){
		
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;
		r = commuService.projectInsert(prjtVO);
		
		if(r > 0) { // 등록 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
		
	}
	
	// 프로젝트 모집 수정 페이지
	@GetMapping("/projectMod")
	public String projectMod (Model model, Principal pr, String prjtNo) {
		model.addAttribute("logId",pr.getName());
		// 직무, 진행방식, 진행기간, 연락방법, 모집상태
		model.addAttribute("commList", commonService.getCodes("N","j","g","i","h"));
		model.addAttribute("projectInfo", commuService.projectDetail(prjtNo));
		return "community/projectDetailMod";
	}
	
	// 프로젝트 모집 수정 기능
	@PostMapping("/projectMod")
	@ResponseBody
	public Map<String, Object> projectModFn(PrjtVO prjtVO){
		
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;
		r = commuService.projectModFn(prjtVO);
		
		if(r > 0) { // 수정 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
		
	}
	
	// 프로젝트 모집 삭제 기능
	@PostMapping("/projectDel")
	@ResponseBody
	public Map<String, Object> projectDelFn(String prjtNo) {
		
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;
		r = commuService.projectDelFn(prjtNo);
		
		if(r > 0) { // 삭제 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
		
	}
	
	// 스터디 등록
	@PostMapping("/studyInsert")
	@ResponseBody
	public Map<String, Object> studyInsert(StudyVO studyVO){
		
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;
		r = commuService.studyInsert(studyVO);
		
		if(r > 0) { // 등록 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
	}
	
	// 스터디 모집 목록 페이지
	@GetMapping("/studyList")
	public String studyList() {
		return "community/studyListVue";
	}
	
	// 스터디 모집 리스트
	@GetMapping("/studyBoards")
	@ResponseBody
	public List<StudyVO> studyBoards(){
		return commuService.studyList();
	}
	
	
	// 스터디 모집 상세페이지
	@GetMapping("/studyDetail")
	public String studyDetail(Model model, String studyNo) {
		model.addAttribute("studyDetailInfo", commuService.studyDetail(studyNo));
		return "community/studyDetailVue";
	}
	
	
	// 스터디 모집 수정 페이지
	@GetMapping("/studyMod")
	public String studyMod (Model model, Principal pr, String studyNo) {
		model.addAttribute("logId",pr.getName());
		// 스터디 구분 , 진행방식, 진행기간, 연락방법, 모집상태
		model.addAttribute("commList", commonService.getCodes("k", "j", "g", "i", "h"));
		model.addAttribute("studyDetailInfo", commuService.studyDetail(studyNo));
		return "community/studyDetailMod";
	}
	
	// 스터디 모집 수정 기능
	@PostMapping("/studyModFn")
	@ResponseBody
	public Map<String, Object> studyModFn(StudyVO studyVO){
		
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;
		r = commuService.studyModFn(studyVO);
		
		if(r > 0) { // 수정 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
	}
	
	// 스터디 모집 삭제 기능 
	@PostMapping("/studyDelFn")
	@ResponseBody
	public Map<String, Object> studyDelFn(String studyNo) {
		
		Map<String, Object> result = new HashMap<>();
		
		int r = 0;
		r = commuService.studyDelFn(studyNo);
		
		if(r > 0) { // 삭제 성공시
			result.put("result", "Success");
			return result;
		}else {
			result.put("result", "Fail");
			return result;
		}
		
	}
	
	
	

	
}
