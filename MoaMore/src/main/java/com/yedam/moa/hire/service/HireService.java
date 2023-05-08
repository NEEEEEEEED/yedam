package com.yedam.moa.hire.service;

import java.util.List;

import com.yedam.moa.hire.HireVO;
import com.yedam.moa.self.SelfVO;

public interface HireService {
	public List<HireVO> hireList(HireVO hireVO); // 구인공고목록 조회
	public List<HireVO> hireScrapList(HireVO hireVO); // 스크랩목록 조회
	public List<HireVO> hireInfo(HireVO hireVO); // 구인공고 상세 페이지
	
	// 직무 리스트
	public List<SelfVO> jobList();
			
	// 기술스택 리스트
	public List<SelfVO> skillList();
			
	// 근무지역 리스트
	public List<SelfVO> wksiteList();
			
	// 경력 리스트
	public List<SelfVO> carrList();
			
}
