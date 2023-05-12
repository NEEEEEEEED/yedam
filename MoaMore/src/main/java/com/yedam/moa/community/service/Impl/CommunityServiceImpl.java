package com.yedam.moa.community.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.community.CommunityVO;
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
	public List<CommunityVO> jobQnaList() {
		return commuMapper.jobQnaList();
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

	@Override
	public int jobQnaDelete(String qaNotiwrNo) {
		return commuMapper.jobQnaDelete(qaNotiwrNo);
	}
	
	
}
