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
	// 직무 리스트
	@Override
	public List<SelfVO> jobList() {
		return hireMapper.jobList();
	}
	// 기술스택 리스트
	@Override
	public List<SelfVO> skillList() {
		return hireMapper.skillList();
	}
	// 근무지역 리스트
	@Override
	public List<SelfVO> wksiteList() {
		return hireMapper.wksiteList();
	}
	// 경력 리스트
	@Override
	public List<SelfVO> carrList() {
		return hireMapper.carrList();
	}
	@Override
	public List<HireVO> resumeList(String id) {
		return hireMapper.resumeList(id);
	}
	
	

}
