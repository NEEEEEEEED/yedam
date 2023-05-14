package com.yedam.moa.mem.mapper;

import java.util.List;

import com.yedam.moa.mem.ArdVO;
import com.yedam.moa.mem.CarrVO;
import com.yedam.moa.mem.EduVO;
import com.yedam.moa.mem.IntroVO;
import com.yedam.moa.mem.LicnVO;
import com.yedam.moa.mem.MemInfoVO;
import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.PrtflVO;
import com.yedam.moa.mem.ResumeVO;
import com.yedam.moa.mem.SearchVO;
import com.yedam.moa.mem.ShcrVO;
import com.yedam.moa.mem.SkillVO;

public interface MemMapper {
	
//	마이페이지 홈
	public List<MemVO> openSesame(MemVO vo);
	
	public SearchVO getCount(MemVO vo);

	public List<MemVO> getSearch(SearchVO vo);
	
	public int delAnun(SearchVO vo);
	
	
//	이력서 작성 폼
	public List<MemVO> getCode(MemVO vo);
//	이력서 개인정보 불러오기
	public MemInfoVO getMemInfo(MemVO vo);
//	스킬번호 생성하고 내용 입력
	public String getSkillNo();
	public int insertSkill(SkillVO vo);
//	자격증 번호 생성하고 내용 입력
	public String getLicnNo();
	public int insertLicence(LicnVO vo);
//	수상 입력하고 내용입력
	public String getArdNo();
	public int insertAward(ArdVO vo);
//	학력번호 생성하고 내용 입력
	public String getSchNo();
	public int insertSchool(ShcrVO vo);
//	경력번호 생성하고 내용입력
	public String getCarrNo();
	public int insertCarrer(CarrVO vo);
//	교육번호 생성하고 내용 입력
	public String getEduNo();
	public int insertEducate(EduVO vo);
//	자소서 번호 생성하고 내용 입력
	public String getIntroNo();
	public int insertIntro(IntroVO vo);
//	개인정보 입력(수정)
	public int insertMem(MemInfoVO vo);
//	이력서 번호 생성 입력
	public String getResumeNo();
	public int insertResume(ResumeVO vo);
	
//	이력서 포폴 입력
	public String insertPrtfl(PrtflVO vo);
}
