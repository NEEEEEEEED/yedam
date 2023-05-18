package com.yedam.moa.community.service;

import java.util.List;

import com.yedam.moa.community.CommunityVO;
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
	public List<CommunityVO> jobQnaList();
	
	// 취업 Q&A 상세 페이지
	public CommunityVO jobQnaDetail(String qaNotiwrNo);
	
	// 취업 Q&A 수정기능
	public int jobQnaModFn(CommunityVO communityVO);
	
	// 취업 Q&A 삭제기능
	public int jobQnaDelete(String qaNotiwrNo);
	
	// 취업 Q&A 댓글 등록
	public int qnaReplyAdd(ReplyVO replyVO);
	
	// 취업 Q&A 댓글 목록(모댓글) 리스트
	public List<ReplyVO> qnaReplyList(ReplyVO replyVO);
	
	// 면접후기 리스트 출력
	List<IntrvVO> jobInterviewList();
	
	// 면접후기 등록 기능
	public int jobInterviewInsert(IntrvVO intrvVO);
	
	// 프로젝트 리스트 출력
	public List<PrjtVO> projectList();
	
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
	
	
}
