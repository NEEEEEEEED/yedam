package com.yedam.moa.hire.service;

import java.util.List;

import com.yedam.moa.hire.HireVO;

public interface HireService {
	public List<HireVO> hireList(HireVO hireVO); // 구인공고목록 조회
	public List<HireVO> hireScrapList(HireVO hireVO); // 스크랩목록 조회
}
