package com.yedam.moa.self.service;

import java.util.List;

import com.yedam.moa.self.SelfVO;

public interface SelfService {
	
	// 셀프구직 목록 리스트
	public List<SelfVO> selfJobList(String auth);
	
	// my프로필 등록버튼 클릭시 이력서가 있는지 체크
	public int checkResume(String id);
	
	//-------------------------------------------------
	
	// 지역 리스트
	public List<SelfVO> cityList();
	
	// 직무 리스트
	public List<SelfVO> jobList();
	
	// 기술스택 리스트
	public List<SelfVO> techList();
	
	// 보기권한 리스트
	public List<SelfVO> authList();
	
	// 이력서 리스트
	List<SelfVO> resumeHeaderList(String id);
	
	// 경력사항 리스트
	public List<SelfVO> careerList(String carrNo);
	
	// 학력사항 리스트
	public List<SelfVO> schoolList(String shcrNo);
	
	// 셀프구직 게시글 기본키 부여
	public String selfJobKey();
	
	// my프로필 등록
	public int myProfileAdd(SelfVO myProfile);
	
	// 포트폴리오 기본키부여
	public String selfJobPofolKey();
	
	// 포트폴리오 등록
	public int selfJobPofolAdd(SelfVO pofol);
	
	// 포트폴리오 리스트 출력
	public List<SelfVO> selfJobpofolList(String jobSearchNo);
	
	// 포트폴리오 삭제
	public int pofolDelete(String fileNo);
	
}
