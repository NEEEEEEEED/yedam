package com.yedam.moa.hire.service;

import java.security.Principal;
import java.util.List;

import com.yedam.moa.community.CommunityVO;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.self.SelfVO;

public interface HireService {
	public List<HireVO> hireList(HireVO hireVO); // 구인공고목록 조회
	public List<HireVO> hireScrapList(HireVO hireVO); // 스크랩목록 조회
	public List<HireVO> hireInfo(HireVO hireVO); // 구인공고 상세 페이지
	public List<HireVO> resumeList(String id); // 구인공고페이지 이력서 조회
	public String resumeInsert(HireVO hireVO); // 구인공고 지원
	public String followInsert(HireVO hrieVO); // 관심기업 등록
	public String recruitScrapInsert(HireVO hireVO); // 공고 스크랩 등록
	public String recruitScrapDelete(HireVO hireVO); // 공고 스크랩 삭제
	public List<HireVO> recImg(HireVO hireVO); // 공고상세 페이지의 이미지 조회
	public List<HireVO> selectRecommend(HireVO hireVO); // 공고상세 추천공고 조회
	public HireVO recruitInsertSelect(HireVO hireVO); // 공고등록 페이지 기업이름 조회
	public String recruitNo(); // 공고번호
	public String hireDataInsert(HireVO vo,Principal pr); //  공고 데이터 등록
	public int hireImgInsert(HireVO vo); // 공고 이미지만 등록
	public List<HireVO> hireImgInsertList(HireVO vo); // 공고 이미지 조회
	public int hireModify(HireVO vo); // 공고 수정 기능
	public int hireImgModify(HireVO vo); // 공고 이미지 수정
	
	public List<HireVO> prdtSelect(HireVO hireVO);// 메인페이지 - 유료
	public List<HireVO> popSelect(HireVO hireVO);// 메인페이지 - 인기
	public List<HireVO> newSelect(HireVO hireVO);// 메인페이지 - 최신
	public List<CommunityVO> popSelf(SelfVO selfVO);// 메인페이지 - 셀프구직(관심순)
	public List<CommunityVO> jobQnaBest(CommunityVO communityVO);// 메인페이지 - 취업QnA 베스트3
			
}
