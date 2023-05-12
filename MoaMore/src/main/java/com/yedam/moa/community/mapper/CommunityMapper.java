package com.yedam.moa.community.mapper;

import java.util.List;

import com.yedam.moa.community.CommunityVO;

public interface CommunityMapper {

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
	
	// 취업 Q&A 조회수 기능
	public int jobQnaView(String qaNotiwrNo);
	
}
