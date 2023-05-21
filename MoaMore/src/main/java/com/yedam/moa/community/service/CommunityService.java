package com.yedam.moa.community.service;

import java.util.List;

import com.yedam.moa.community.CommunityVO;
import com.yedam.moa.community.Criteria;
import com.yedam.moa.community.IntrvVO;
import com.yedam.moa.community.PrjtVO;
import com.yedam.moa.community.ReplyVO;
import com.yedam.moa.community.StudyVO;

public interface CommunityService {

	// 취업 Q&A 게시글 등록
	public int jobQnaInsert(CommunityVO commuVO);
	
	// 취업 Q&A 게시글 기본키부여
	public String jobQnaKey();
	
	// 취업 Q&A 리스트
	public List<CommunityVO> jobQnaList(Criteria cri);
	
	// 취업 Q&A 게시글 총갯수
	public int jobQnaListCnt();
	
	// 취업 Q&A Best리스트
	public List<CommunityVO> jobQnaBest();
	
	// 취업 Q&A 상세 페이지
	public CommunityVO jobQnaDetail(String qaNotiwrNo);
	
	// 취업 Q&A 상세 페이지 - 추천 등록
	public int jobQnaRecoAdd(CommunityVO communityVO);
	
	// 취업 Q&A 상세페이지 - 추천여부
	public int jobQnaReco(CommunityVO communityVO);
	
	// 취업 Q&A 수정기능
	public int jobQnaModFn(CommunityVO communityVO);
	
	// 취업 Q&A 삭제기능
	public int jobQnaDelete(String qaNotiwrNo);
	
	// 취업 Q&A 댓글 등록
	public int qnaReplyAdd(ReplyVO replyVO);
	
	// 취업 Q&A 댓글 목록(모댓글) 리스트
	public List<ReplyVO> qnaReplyList(ReplyVO replyVO);
	
	// 취업 Q&A 댓글 수정 기능
	public int qnaReplyMod(ReplyVO replyVO);
	
	// 취업 Q&A 댓글 삭제 기능
	public int qnaReplyDelete(ReplyVO replyVO);
	
	// 취업 Q&A 대댓글(자식) 등록
	public int chQnaReplyAdd(ReplyVO replyVO);
	
	// 면접후기 리스트 출력
	List<IntrvVO> jobInterviewList(IntrvVO intrvVO);
	
	// 면접후기 등록 기능
	public int jobInterviewInsert(IntrvVO intrvVO);
	
	// 프로젝트 리스트 출력
	public List<PrjtVO> projectList();
	
	// 스케쥴러 - 프로젝트 모집 오늘날짜 오전9시를 기준으로 모집 상태 update  
	public void proCollstScheduler();
	
	// 스케쥴러 - 스터디 모집 오늘날짜 오전9시를 기준으로 모집 상태 update  
	public void studyCollstScheduler();
	
	// 프로젝트 등록 기능
	public int projectInsert(PrjtVO prjtVO);
	
	// 프로젝트 모집 상세
	public PrjtVO projectDetail(String prjtNo);
	
	// 프로젝트 모집 수정
	public int projectModFn(PrjtVO prjtVO);
	
	// 프로젝트 모집 삭제
	public int projectDelFn(String prjtNo);
	
	// 스터디 모집 등록
	public int studyInsert(StudyVO studyVO);
	
	// 스터디 모집 리스트
	public List<StudyVO> studyList();
	
	// 스터디 모집 상세
	public StudyVO studyDetail(String studyNo);
	
	// 스터디 모집 수정
	public int studyModFn(StudyVO studyVO);
	
	// 스터디 모집 삭제
	public int studyDelFn(String studyNo);
	
	// 면접후기 단건: 관리자
	public IntrvVO jobInterviewDetail(String intrvNo);
	
	
}
