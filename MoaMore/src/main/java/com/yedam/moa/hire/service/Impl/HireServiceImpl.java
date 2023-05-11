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
	
	// 스크랩 조회
	@Override
	public List<HireVO> recruitInsertSelect(HireVO hireVO) {
		return hireMapper.recruitInsertSelect(hireVO);
	}
	// 스그랩 등록
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
	@Override
	public List<HireVO> recImg(HireVO hireVO) {
		return hireMapper.recImg(hireVO);
	}

	
	
	
	

}
