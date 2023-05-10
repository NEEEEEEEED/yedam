package com.yedam.moa.hire.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.hire.HireVO;
import com.yedam.moa.hire.mapper.HireMapper;
import com.yedam.moa.hire.service.HireService;
import com.yedam.moa.self.SelfVO;

@Service
public class HireServiceImpl implements HireService{
	
	@Autowired
	HireMapper hireMapper;
	
	// 전체조회
	@Override
	public List<HireVO> hireList(HireVO hireVO) {
		return hireMapper.serchHire(hireVO);
	}
	// 스크랩 조회
	@Override
	public List<HireVO> hireScrapList(HireVO hireVO) {
		return hireMapper.scrapHire(hireVO);
	}
	// 구인공고 상세페이지
	@Override
	public List<HireVO> hireInfo(HireVO hireVO) {
		return hireMapper.searchInfo(hireVO);
	}
	// 모달창 이력서 조회
	@Override
	public List<HireVO> resumeList(String id) {
		return hireMapper.resumeList(id);
	}
	// 보고있는 공고에 지원
	@Override
	public String resumeInsert(HireVO hireVO) {
		String message = null;
		int result = hireMapper.resumeInsert(hireVO);
		if(result > 0) {
			message = "success";
		}else {
			message = "fail";
		}
		return message;
	}
	// 현재 공고를 올린 기업 팔로우
	@Override
	public String followInsert(HireVO hrieVO) {
		String message = null;
		int result = hireMapper.followInsert(hrieVO);
		if(result > 0) {
			message = "success";
		}else {
			message="fail";
		}
		return message;
	}
	@Override
	public List<HireVO> recruitInsertSelect(HireVO hireVO) {
		return hireMapper.recruitInsertSelect(hireVO);
	}
	@Override
	public String recruitScrapInsert(HireVO hireVO) {
		String message = null;
		int result = hireMapper.recruitScrapInsert(hireVO);
		if(result > 0) {
			message = "success";
		}else {
			message="fail";
		}
		return message;
	}
	
	
	

}
