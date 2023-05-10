package com.yedam.moa.hire.mapper;

import java.util.List;

import com.yedam.moa.hire.HireVO;
import com.yedam.moa.self.SelfVO;

public interface HireMapper {
	public List<HireVO> serchHire(HireVO hireVO); // 구인공고 전체 조회
	public List<HireVO> scrapHire(HireVO hireVO); // 스크랩한 구인공고 조회
	public List<HireVO> searchInfo(HireVO hireVO); // 구인공고 상세 페이지
	public List<HireVO> resumeList(String id); // 구인공고 페이지 이력서 조회
	public int resumeInsert(HireVO hireVO); // 구인공고 지원
	public int followInsert(HireVO hireVO); // 공고의 기업 팔로우
	public int recruitScrapInsert(HireVO hireVO); // 공고 스크랩 등록
	public List<HireVO> recruitInsertSelect(HireVO hireVO); // 공고등록 페이지 기업이름 조회
}
