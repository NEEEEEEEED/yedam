package com.yedam.moa.mem.mapper;

import java.util.List;

import com.yedam.moa.mem.ArdVO;
import com.yedam.moa.mem.CarrVO;
import com.yedam.moa.mem.EduVO;
import com.yedam.moa.mem.IntroVO;
import com.yedam.moa.mem.LicnVO;
import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.PrtflVO;
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
	public MemVO getMemInfo(MemVO vo);
	public PrtflVO getPrtflNo();
	public ShcrVO getShcrlNo();
	public SkillVO getSkillNo();
	public ArdVO getArdNo();
	public CarrVO getCarrNo();
	public EduVO getEduNo();
	public IntroVO getIntroNo();
//	이력서 포폴 입력
	public String insertPrtfl(PrtflVO vo);
}
