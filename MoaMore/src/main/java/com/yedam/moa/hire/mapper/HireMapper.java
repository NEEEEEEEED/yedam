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
	public int followInsert(HireVO hireVO); // 관심기업 등록
	public int followDelete(HireVO hireVO); // 관심기업 취소
	public int recruitScrapInsert(HireVO hireVO); // 공고 스크랩 등록
	public int recruitScrapDelete(HireVO hireVO); // 공고 스크랩 삭제
	public int selectFollow(HireVO hrieVO); // 관심기업 테이블에서 데이터가 있는지 확인
	public List<HireVO> recImg(HireVO hireVO); // 공고상세 페이지 이미지 조회
	public List<HireVO> selectRecommend(HireVO hireVO); // 공고상세 추천공고 조회
	public HireVO recruitInsertSelect(HireVO hireVO); // 공고등록 페이지 기업이름 조회
	public String skillNo(); // 스킬번호
	public String recruitNo(); // 공고번호
	public String recruitImgNo(); // 공고 상세 이미지 번호
	public int hireDataInsert(HireVO vo); // 공고 데이터 등록 
	public int skillInsert(HireVO vo); // 공고 스킬 등록
	public int detailImges(HireVO hireVO); // 공고 상세 이미지들 등록
	public List<HireVO> detailImgesList(HireVO hireVO); // 공고 상세 이미지 조회
	public int hireModify (HireVO vo); // 공고 수정 기능
	public int hireSkillDelete(HireVO vo); // 공고 스킬 삭제
	public int hireImgDelete(HireVO vo); // 공고 이미지 삭제
}
