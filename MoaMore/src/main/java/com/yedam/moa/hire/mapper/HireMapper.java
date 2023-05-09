package com.yedam.moa.hire.mapper;

import java.util.List;

import com.yedam.moa.hire.HireVO;
import com.yedam.moa.self.SelfVO;

public interface HireMapper {
	public List<HireVO> serchHire(HireVO hireVO); // 구인공고 전체 조회
	public List<HireVO> scrapHire(HireVO hireVO); // 스크랩한 구인공고 조회
	public List<HireVO> searchInfo(HireVO hireVO); // 구인공고 상세 페이지
	public List<HireVO> resumeList(String id); // 구인공고 페이지 이력서 조회
	
	// 직무 리스트
		public List<SelfVO> jobList();
	// 기술스택 리스트
		public List<SelfVO> skillList();
	// 경력 리스트
		public List<SelfVO> carrList();
	// 근무지역 리스트
		public List<SelfVO> wksiteList();
}
