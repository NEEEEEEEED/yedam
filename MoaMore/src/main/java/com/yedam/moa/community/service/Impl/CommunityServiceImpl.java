package com.yedam.moa.community.service.Impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.community.CommunityVO;
import com.yedam.moa.community.Criteria;
import com.yedam.moa.community.IntrvVO;
import com.yedam.moa.community.PrjtVO;
import com.yedam.moa.community.ReplyVO;
import com.yedam.moa.community.StudyVO;
import com.yedam.moa.community.mapper.CommunityMapper;
import com.yedam.moa.community.service.CommunityService;

@Service
public class CommunityServiceImpl implements CommunityService{

	@Autowired
	CommunityMapper commuMapper;

	// 취업 Q&A 게시글 등록
	@Override
	public int jobQnaInsert(CommunityVO commuVO) {
		commuVO.setQaNotiwrNo(commuMapper.jobQnaKey());
		return commuMapper.jobQnaInsert(commuVO);
	}

	// 취업 Q&A 게시글 기본키부여
	@Override
	public String jobQnaKey() {
		return commuMapper.jobQnaKey();
	}

	// 취업 Q&A 리스트
	@Override
	public List<CommunityVO> jobQnaList(Criteria cri) {
		return commuMapper.jobQnaList(cri);
	}

	// 취업 Q&A 상세 페이지
	@Override
	public CommunityVO jobQnaDetail(String qaNotiwrNo) {
		commuMapper.jobQnaView(qaNotiwrNo); // 조회수 증가
		return commuMapper.jobQnaDetail(qaNotiwrNo);
	}
	

	// 취업 Q&A 수정기능
	@Override
	public int jobQnaModFn(CommunityVO communityVO) {
		return commuMapper.jobQnaModFn(communityVO);
	}
	
	// 취업 Q&A 삭제기능
	@Override
	public int jobQnaDelete(String qaNotiwrNo) {
		return commuMapper.jobQnaDelete(qaNotiwrNo);
	}

	// 면접후기 등록
	@Override
	public int jobInterviewInsert(IntrvVO intrvVO) {
		return commuMapper.jobInterviewInsert(intrvVO);
	}

	// 면접후기 리스트 출력
	@Override
	public List<IntrvVO> jobInterviewList(IntrvVO intrvVO) {
		return commuMapper.jobInterviewList(intrvVO);
	}

	// 프로젝트 등록 기능
	@Override
	public int projectInsert(PrjtVO prjtVO) {
		return commuMapper.projectInsert(prjtVO);
	}

	// 프로젝트 리스트 출력
	@Override
	public List<PrjtVO> projectList() {
		return commuMapper.projectList();
	}

	// 프로젝트 상세 출력
	@Override
	public PrjtVO projectDetail(String prjtNo) {
		commuMapper.projectView(prjtNo); // 조회수 증가
		return commuMapper.projectDetail(prjtNo);
	}

	// 프로젝트 모집 수정
	@Override
	public int projectModFn(PrjtVO prjtVO) {
		return commuMapper.projectModFn(prjtVO);
	}

	// 프로젝트 모집 삭제
	@Override
	public int projectDelFn(String prjtNo) {
		return commuMapper.projectDelFn(prjtNo);
	}

	// 스터디 모집 등록
	@Override
	public int studyInsert(StudyVO studyVO) {
		return commuMapper.studyInsert(studyVO);
	}

	// 스터디 목록
	@Override
	public List<StudyVO> studyList() {
		return commuMapper.studyList();
	}

	// 스터디 모집 상세
	@Override
	public StudyVO studyDetail(String studyNo) {
		commuMapper.studyView(studyNo); // 조회수 증가
		return commuMapper.studyDetail(studyNo);
	}

	// 스터디 모집 수정
	@Override
	public int studyModFn(StudyVO studyVO) {
		return commuMapper.studyModFn(studyVO);
	}

	// 스터디 모집 삭제
	@Override
	public int studyDelFn(String studyNo) {
		return commuMapper.studyDelFn(studyNo);
	}

	// 취업 Q&A 댓글 등록
	@Override
	public int qnaReplyAdd(ReplyVO replyVO) {
		commuMapper.jobQnaReplyCount(replyVO.getQaNotiwrNo()); // 댓글수 증가
		return commuMapper.qnaReplyAdd(replyVO);
	}

	// 취업 Q&A 댓글 목록(모댓글) 리스트
	@Override
	public List<ReplyVO> qnaReplyList(ReplyVO replyVO) {
		
		replyVO.setRplyDepth(0); // 깊이 0 = 부모 댓글
		
		List<ReplyVO> parentReplyList = commuMapper.qnaReplyList(replyVO); // 부모댓글리스트
		
		for(int i = 0; i < parentReplyList.size(); i++) {
			ReplyVO childInfo = new ReplyVO(); 
			childInfo.setRplyDepth(1); // 깊이 1 = 자식 댓글
			childInfo.setRplyGroup(parentReplyList.get(i).getRplyNo()); // 자식댓글 그룹 ID
			
			List<ReplyVO> childReplyList = commuMapper.childReplyList(childInfo); // 자식 댓글 리스트
			
			parentReplyList.get(i).setChreplyList(childReplyList); // 부모댓글에 대한 자식 댓글들
			parentReplyList.get(i).setChildCount(childReplyList.size()); // 부모 댓글에 대한 자식 댓글 총갯수
			
		}
		
		return parentReplyList;
		
	}
	
	// 취업 Q&A 댓글 수정 기능
	@Override
	public int qnaReplyMod(ReplyVO replyVO) {
		return commuMapper.qnaReplyMod(replyVO);
	}

	// 취업 Q&A 댓글 삭제 기능
	@Override
	public int qnaReplyDelete(ReplyVO replyVO) {
		return commuMapper.qnaReplyDelete(replyVO);
	}

	// 취업 Q&A 대댓글(자식) 등록
	@Override
	public int chQnaReplyAdd(ReplyVO replyVO) {
		replyVO.setRplyDepth(1); // 댓글 깊이 1 = 자식 댓글(대댓글)
		return commuMapper.chQnaReplyAdd(replyVO);
	}
	
	// 면접후기 단건: 관리자
	@Override
	public IntrvVO jobInterviewDetail(String intrvNo) {
		return commuMapper.selectITVDetail(intrvNo);
	}

	// 취업 Q&A 상세페이지 - 추천여부
	@Override
	public int jobQnaReco(CommunityVO communityVO) {
		return commuMapper.jobQnaReco(communityVO);
	}

	
	// 취업 Q&A 상세 페이지 - 추천 등록
	@Override
	public int jobQnaRecoAdd(CommunityVO communityVO) {
		commuMapper.jobQnaRecoCount(communityVO.getQaNotiwrNo()); // 추천수 증가
		return commuMapper.jobQnaRecoAdd(communityVO);
	}

	// 취업 Q&A Best리스트
	@Override
	public List<CommunityVO> jobQnaBest() {
		return commuMapper.jobQnaBest();
	}

	
	// 스케쥴러 - 프로젝트 모집 오늘날짜 오전 9시를 기준으로 모집 상태 update 
	@Override
	public void proCollstScheduler() {
		
		List<PrjtVO> list = commuMapper.projectList(); // 프로젝트 모집 게시글 리스트
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 날짜 포맷
		
		LocalDate today = LocalDate.now();
		
		//System.out.println("오늘날짜 : " + today);
		
		for(PrjtVO project : list) {
			
			LocalDate clsDt = LocalDate.parse(project.getClsDt(), formatter);
			
			//System.out.println("마감일 : " + clsDt);

			// 마감날짜가 오늘날짜 이후이고(마감날짜보다 오늘날짜가 미래일때 true) 모집중 상태라면
			if(today.isAfter(clsDt) && project.getCollSt().equals("모집중")) {
				//System.out.println(project.getPrjtNo()+" - 업데이트 :" + (today.isAfter(clsDt) && project.getCollSt().equals("모집중")));
				
				// 모집중 => 모집 마감 상태로 업데이트
				commuMapper.projectCollstUpdate(project.getPrjtNo());
			}
		}
	}
	
	// 스케쥴러 - 스터디 모집 오늘날짜 오전 9시를 기준으로 모집 상태 update 
	@Override
	public void studyCollstScheduler() {
		
		List<StudyVO> list = commuMapper.studyList(); // 스터디 모집 게시글 리스트
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 날짜 포맷
		
		LocalDate today = LocalDate.now();
		
		//System.out.println("오늘날짜 : " + today);
		
		for(StudyVO study : list) {
			
			LocalDate clsDt = LocalDate.parse(study.getClsDt(), formatter);
			
			//System.out.println("마감일 : " + clsDt);

			// 마감날짜가 오늘날짜 이후이고(마감날짜보다 오늘날짜가 미래일때 true) 모집중 상태라면
			if(today.isAfter(clsDt) && study.getCollSt().equals("모집중")) {
				
				// 모집중 => 모집 마감 상태로 업데이트
				commuMapper.studyCollstUpdate(study.getStudyNo());
				
			}
		}
	}

	// 취업 Q&A 게시글 총갯수
	@Override
	public int jobQnaListCnt() {
		return commuMapper.jobQnaListCnt();
	}

	
}
