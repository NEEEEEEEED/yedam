package com.yedam.moa.hire.service;

import java.util.List;

import com.yedam.moa.hire.HireVO;
import com.yedam.moa.self.SelfVO;

public interface HireService {
	public List<HireVO> hireList(HireVO hireVO); // 구인공고목록 조회
	public List<HireVO> hireScrapList(HireVO hireVO); // 스크랩목록 조회
	public List<HireVO> hireInfo(HireVO hireVO); // 구인공고 상세 페이지
	public List<HireVO> resumeList(String id); // 구인공고페이지 이력서 조회
	public String resumeInsert(HireVO hireVO); // 구인공고 지원
			
}
