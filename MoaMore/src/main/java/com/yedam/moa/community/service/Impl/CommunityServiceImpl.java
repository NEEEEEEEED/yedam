package com.yedam.moa.community.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.community.CommunityVO;
import com.yedam.moa.community.IntrvVO;
import com.yedam.moa.community.PrjtVO;
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
	public List<IntrvVO> jobInterviewList() {

		return commuMapper.jobInterviewList();
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
		return commuMapper.projectDetail(prjtNo);
	}
	
	
}
