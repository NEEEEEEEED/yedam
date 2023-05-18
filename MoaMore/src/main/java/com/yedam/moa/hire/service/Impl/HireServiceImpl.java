package com.yedam.moa.hire.service.Impl;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.hire.HireVO;
import com.yedam.moa.hire.mapper.HireMapper;
import com.yedam.moa.hire.service.HireService;

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
	// 관심기업 등록
	@Override
	public String followInsert(HireVO hrieVO) {
		String message = null;
		int result = hireMapper.selectFollow(hrieVO);
		if(result > 0) {
			hireMapper.followDelete(hrieVO);
			message = "관심기업을 취소했습니다.";
		}else {
			hireMapper.followInsert(hrieVO);
			message="관심기업으로 등록했습니다.";
		}
		return message;
	}
	
	// 공고 등록 페이지 조회
	@Override
	public HireVO recruitInsertSelect(HireVO hireVO) {
		return hireMapper.recruitInsertSelect(hireVO);
	}
	// 스크랩 등록
	@Override
	public String recruitScrapInsert(HireVO hireVO) {
		String message = null;
		int result = hireMapper.recruitScrapInsert(hireVO);
		if(result > 0) {
			message = "스크랩 되었습니다.";
		}else {
			message="fail";
		}
		return message;
	}
	// 스크랩 등록 취소
	@Override
	public String recruitScrapDelete(HireVO hireVO) {
		String message = null;
		int result = hireMapper.recruitScrapDelete(hireVO);
		if(result > 0) {
			message = "스크랩을 취소했습니다.";
		}else {
			message="fail";
		}
		return message;
	}
	
	// 구인공고 목록에 썸네일 이미지 조회
	@Override
	public List<HireVO> recImg(HireVO hireVO) {
		return hireMapper.recImg(hireVO);
	}
	
	// 구인공고 등록
	@Override
	public String hireDataInsert(HireVO vo, Principal pr ) {
		
		String message = null;
		
		int result= 0;
		
		vo.setId(pr.getName());
		
		result = hireMapper.hireDataInsert(vo);
		
		String[] skillArray = vo.getSkill().split(",");

		for(String str : skillArray) {
			String skillNo = hireMapper.skillNo();
			vo.setSkillNo(skillNo);
			vo.setSkill(str);
			result += hireMapper.skillInsert(vo);
		}
		
		
		if(result > 0) {
			message = "스크랩 되었습니다.";
		}else {
			message="fail";
		}
		
		return message;
	}
	// 공고 상세 추천공고 조회
	@Override
	public List<HireVO> selectRecommend(HireVO hireVO) {
		return hireMapper.selectRecommend(hireVO);
	}
	
	// 공고 이미지 업로드
	@Override
	public int hireImgInsert(HireVO vo) {
		
		int result= 0;
		
		for(String istr : vo.getRecruitImgList()) {
			String recuritImgNo = hireMapper.recruitImgNo();
			vo.setRecruitImgNo(recuritImgNo);
			vo.setRecruitImg(istr);
			result += hireMapper.detailImges(vo);
		}
		
		return result;
	}
	
	// 공고 이미지 조회
	@Override
	public List<HireVO> hireImgInsertList(HireVO vo) {
		System.out.println(vo);
		return hireMapper.detailImgesList(vo);
	}
	
	// 공고번호
	@Override
	public String recruitNo() {
		return hireMapper.recruitNo();
	}
	
	// 공고 수정 기능
	@Override
	public int hireModify(HireVO vo) {
		int result = hireMapper.hireSkillDelete(vo);
		result = hireMapper.hireModify(vo);
		
		
		String[] skillArray = vo.getSkill().split(",");

		for(String str : skillArray) {
			String skillNo = hireMapper.skillNo();
			vo.setSkillNo(skillNo);
			vo.setSkill(str);
			result += hireMapper.skillInsert(vo);
		}
		
		
		if(result > 0) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	// 공고 이미지 수정
	@Override
	public int hireImgModify(HireVO vo) {
		int result= 0;
		
		for(String istr : vo.getRecruitImgList()) {
			vo.setRecruitImg(istr);
			result += hireMapper.detailImges(vo);
		}
		return result;
	}
	
	
	
}

	
	
	
	


