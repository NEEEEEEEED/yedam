package com.yedam.moa.mem;

import java.util.List;

import lombok.Data;

@Data
public class ResumeVO {
	
	private List<ShcrVO> sch ;
	private List<ArdVO> ard;
	private List<CarrVO> carr;
	private List<EduVO> edu;
	private List<IntroVO> intro;
	private List<LicnVO> lincn;
	private List<PrtflVO> prtfl;
	private List<SkillVO> skill; 
	private List<MemInfo> memInfo;
	
}
