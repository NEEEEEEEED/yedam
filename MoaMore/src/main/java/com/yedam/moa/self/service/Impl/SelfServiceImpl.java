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

	// 스킬등록
	@Override
	public int skillAdd(SelfVO skillVO) {
		return selfMapper.skillAdd(skillVO);
	}

	// 셀프구직 등록
	@Override
	public int myProfileAdd(SelfVO myProfile) {
		
		SelfVO skillVO = new SelfVO();
		String[] skill = myProfile.getPosit().split(","); // 기술스택을 ,를 기준으로 자름
		
		
		skillVO.setJobSearchNo(myProfile.getJobSearchNo());
		skillVO.setId(myProfile.getId());
		
		for(int i = 0; i < skill.length ; i++) {
			System.out.println("skill-" + i + " : " + skill[i]);
			skillVO.setSkillNo(selfMapper.skillKey()); // 스킬 기본키
			skillVO.setSkill(skill[i]);		// 등록할 스킬1개
			selfMapper.skillAdd(skillVO); // 스킬등록
		}
		
		return selfMapper.myProfileAdd(myProfile); // 이력서 등록
	}
	
	// 셀프구직 게시글 기본키 부여
	@Override
	public String selfJobKey() {
		return selfMapper.selfJobKey();
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
	
	// 셀프구직 등록버튼 클릭시 이력서가 있는지 체크
	@Override
	public int checkResume(String id) {
		return selfMapper.checkResume(id);
	}

	// 셀프구직 목록 리스트
	@Override
	public List<SelfVO> selfJobList(SelfVO selfVO) {
		return selfMapper.selfJobList(selfVO);
	}

	// 관심 등록
	@Override
	public int selfJobInterestAdd(SelfVO interestVO) {
		return selfMapper.selfJobInterestAdd(interestVO);
	}

	// 관심등록 리스트
	@Override
	public List<SelfVO> selfJobInterestList(String id) {
		return selfMapper.selfJobInterestList(id);
	}

	// 관심 등록 해제
	@Override
	public int selfJobInterestDelete(SelfVO interestVO) {
		return selfMapper.selfJobInterestDelete(interestVO);
	}

	// 셀프구직 상세 페이지
	@Override
	public SelfVO selfJobDetailInfo(String jobSearchNo) {
		return selfMapper.selfJobDetailInfo(jobSearchNo);
	}

	// 셀프구직 상세 - 포트폴리오 정보
	@Override
	public List<SelfVO> selfJobDetailPofol(String jobSearchNo) {
		return selfMapper.selfJobDetailPofol(jobSearchNo);
	}

	// 셀프구직 상세 - 스킬 정보
	@Override
	public List<SelfVO> selfJobDetailSkill(String jobSearchNo) {
		return selfMapper.selfJobDetailSkill(jobSearchNo);
	}

	//--------------------------------------------------
	
	// 셀프구직 상세페이지 : 불러올 이력서 정보 학력,경력 기본키값 가져옴
	@Override
	public SelfVO resumeKeys(String resumeNo) {
		return selfMapper.resumeKeys(resumeNo);
	}
	
	// 셀프구직 수정
	@Override
	public int myProfileMod(SelfVO selfVO) {
		
		SelfVO skillVO = new SelfVO();
		String[] skill = selfVO.getPosit().split(","); // 기술스택을 ,를 기준으로 자름
		
		skillVO.setJobSearchNo(selfVO.getJobSearchNo()); // 셀프구직 게시글 기본키
		skillVO.setId(selfVO.getId()); // 아이디
		
		selfMapper.skillDelete(selfVO.getJobSearchNo()); // 셀프구직 게시글의 스킬목록 삭제
		
		for(int i = 0; i < skill.length ; i++) {
			skillVO.setSkillNo(selfMapper.skillKey()); // 스킬 기본키 부텨
			skillVO.setSkill(skill[i]);		// 등록할 스킬1개
			selfMapper.skillAdd(skillVO); // 스킬등록
		}
		
		return selfMapper.myProfileMod(selfVO); // 이력서 등록
	}
	
	// 스킬 삭제
	@Override
	public int skillDelete(String jobSearchNo) {
		return selfMapper.skillDelete(jobSearchNo);
	}

	// 셀프구직 삭제
	@Override
	public int myProfileDel(String jobSearchNo) {
		return selfMapper.myProfileDel(jobSearchNo);
	}

	// 페이징 ---------------------------------------
	
	// 셀프구직 리스트 총 갯수
	@Override
	public int totalListNum(SelfVO selfVO) {
		return selfMapper.totalListNum(selfVO);
	}
	
	
}
