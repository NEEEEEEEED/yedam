package com.yedam.moa.hire.mapper;

import java.util.List;

import com.yedam.moa.hire.HireVO;

public interface HireMapper {
	public List<HireVO> serchHire(HireVO hireVO); // 구인공고 전체 조회
	public List<HireVO> scrapHire(HireVO hireVO); // 스크랩한 구인공고 조회
}
