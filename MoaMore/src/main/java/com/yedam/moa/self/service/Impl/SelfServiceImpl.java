package com.yedam.moa.self.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.self.SelfVO;
import com.yedam.moa.self.mapper.SelfMapper;
import com.yedam.moa.self.service.SelfService;

@Service
public class SelfServiceImpl implements SelfService{

	@Autowired
	SelfMapper selfMapper;

	// 지역 리스트
	@Override
	public List<SelfVO> cityList() {
		return selfMapper.cityList();
	}
	
	// 직무 리스트
	@Override
	public List<SelfVO> jobList() {
		return selfMapper.jobList();
	}
	
	// 기술스택 리스트
	@Override
	public List<SelfVO> techList() {
		return selfMapper.techList();
	}
	
	// 보기권한 리스트
	@Override
	public List<SelfVO> authList() {
		return selfMapper.authList();
	}
	
	// 이력서 리스트
	@Override
	public List<SelfVO> resumeHeaderList(String id) {
		return selfMapper.resumeHeader(id);
	}

	// 경력사항 리스트
	@Override
	public List<SelfVO> careerList(String carrNo) {
		return selfMapper.careerList(carrNo);
	}

	// 학력사항 리스트
	@Override
	public List<SelfVO> schoolList(String shcrNo) {
		return selfMapper.schoolList(shcrNo);
	}

	// my프로필 등록
	@Override
	public int myProfileAdd(SelfVO myProfile) {
		return selfMapper.myProfileAdd(myProfile);
	}
	
	// 셀프구직 게시글 기본키 부여
	@Override
	public String selfJobKey() {
		return selfMapper.selfJobKey();
	}
	
	// 포트폴리오 기본키 부여
	@Override
	public String selfJobPofolKey() {
		return selfMapper.selfJobPofolKey();
	}
	
	// 포트폴리오 등록
	@Override
	public int selfJobPofolAdd(SelfVO pofol) {
		pofol.setFileNo(selfMapper.selfJobPofolKey()); // 포트폴리오 기본키 부여
		return selfMapper.selfJobPofolAdd(pofol);
	}

	// 포트폴리오 리스트 출력
	@Override
	public List<SelfVO> selfJobpofolList(String jobSearchNo) {
		return selfMapper.selfJobpofolList(jobSearchNo);
	}

	// 포트폴리오 삭제
	@Override
	public int pofolDelete(String fileNo) {
		return selfMapper.pofolDelete(fileNo);
	}

	// ----------------------------------------------------
	
	// my프로필 등록버튼 클릭시 이력가 있는지 체크
	@Override
	public int checkResume(String id) {
		return selfMapper.checkResume(id);
	}

	// 셀프구직 목록 리스트
	@Override
	public List<SelfVO> selfJobList(String auth) {
		return selfMapper.selfJobList(auth);
	}
	
	
	
	
}
