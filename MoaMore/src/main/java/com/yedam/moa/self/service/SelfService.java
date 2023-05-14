package com.yedam.moa.self.service;

import java.util.List;

import com.yedam.moa.self.SelfVO;

public interface SelfService {
	
	// 셀프구직 목록 리스트
	public List<SelfVO> selfJobList(SelfVO selfVO);
	
	// 셀프구직 등록버튼 클릭시 이력서가 있는지 체크
	public int checkResume(String id);
	
	// 관심 등록
	public int selfJobInterestAdd(SelfVO interestVO);
	
	// 관심 목록 리스트
	public List<SelfVO> selfJobInterestList(String id);
	
	// 관심 등록 해제
	public int selfJobInterestDelete(SelfVO interestVO);
	
	// 셀프구직 상세 페이지
	public SelfVO selfJobDetailInfo(String jobSearchNo);
	
	// 셀프구직 상세 - 포트폴리오 정보
	public List<SelfVO> selfJobDetailPofol(String jobSearchNo);
	
	// 셀프구직 상세 - 스킬 정보
	public List<SelfVO> selfJobDetailSkill(String jobSearchNo);
	
	// 셀프구직 상세페이지 : 불러올 이력서 정보 학력, 경력 기본키값 가져옴
	public SelfVO resumeKeys(String resumeNo);
	
	// 셀프구직 상세페이지 수정
	public int myProfileMod(SelfVO selfVO);
	
	// 스킬 삭제
	public int skillDelete(String jobSearchNo);
	
	// 셀프구직 삭제
	public int myProfileDel(String jobSearchNo);
	
	//-------------------------------------------------
	
	// 이력서 리스트
	List<SelfVO> resumeHeaderList(String id);
	
	// 경력사항 리스트
	public List<SelfVO> careerList(String carrNo);
	
	// 학력사항 리스트
	public List<SelfVO> schoolList(String shcrNo);
	
	// 셀프구직 게시글 기본키 부여
	public String selfJobKey();

	// 스킬등록
	public int skillAdd(SelfVO skillVO);
	
	// my프로필 등록
	public int myProfileAdd(SelfVO myProfile);
	
	// 포트폴리오 등록
	public int selfJobPofolAdd(SelfVO pofol);
	
	// 포트폴리오 리스트 출력
	public List<SelfVO> selfJobpofolList(String jobSearchNo);
	
	// 포트폴리오 삭제
	public int pofolDelete(String fileNo);
	
	// 페이징 ---------------------------------------
	
	// 셀프구직 리스트 총 갯수
	public int totalListNum(SelfVO selfVO);
	
}
