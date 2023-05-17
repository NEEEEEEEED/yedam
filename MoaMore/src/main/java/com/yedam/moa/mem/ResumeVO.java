package com.yedam.moa.mem;

import java.util.List;

import lombok.Data;

@Data
public class ResumeVO {
	
	private String resumeNo;	//이력서 헤더 번호
	private String id;			//아이디
	private String ttl;			//이력서 제목
	private String carrNo;		//경력 번호
	private String eduNo;		//교육 번호
	private String licnNo;		//자격증 번호
	private String ardNo;		//수상 번호
	private String introNo;		//자소서 번호
	private String shcrNo;		//학력 번호
	private String skillNo;		//기술 번호
	private String regDt;		//등록일자
	
	
	private List<ShcrVO> sch ;
	private List<ArdVO> ard;
	private List<CarrVO> carr;
	private List<EduVO> edu;
	private List<IntroVO> intro;
	private List<LicnVO> licn;
	private List<PrtflVO> prtfl;
	private List<SkillVO> skill; 
	private List<SkillVO> unSkill; //이력서에 기록되지 않은 스킬 받아오기
	private List<MemInfoVO> memInfo;
	
}
