package com.yedam.moa.mem.service;

import java.util.HashMap;
import java.util.List;

import com.yedam.moa.community.Criteria;
import com.yedam.moa.mem.MemInfoVO;
import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.PrtflVO;
import com.yedam.moa.mem.ResumeVO;
import com.yedam.moa.mem.SearchVO;

public interface MemService {
	
//	마이페이지 홈
	public List<MemVO> openSesame (MemVO vo);
	
	public MemInfoVO getImg(MemVO vo);
	
	public SearchVO getCount(MemVO vo);
	
	public List<MemVO> getSearch (SearchVO vo);
	
	public int delAnun(SearchVO vo);
	
//	이력서 폼 
	public MemInfoVO getMemInfo(MemVO vo);
	
	public ResumeVO lastRe(MemVO vo);
	
	public String insertResume(ResumeVO vo);
	
//	디비에 포폴 입력하고 생성된 번호로 입력한 포폴 리스트 가져오기
	public PrtflVO insertPofl(PrtflVO vo);
	
	public List<PrtflVO> getPrtfl(ResumeVO vo);

	public int withdraw(String id);
	
	public int delPofol(PrtflVO vo);
	
	public ResumeVO getRe(ResumeVO vo);
	
	public void updateRe(ResumeVO vo);
	
	public int checkId(MemInfoVO vo);
	
	public int getPageCnt(String id);
	
	public List<ResumeVO>resumeList(Criteria cri);
	
	public int delResume(ResumeVO rvo);

// 회원정보 수정
	public int updateInfo(MemInfoVO vo);
	
	public int joinMoaMore(MemInfoVO vo);
	
	public int insertBiz(MemInfoVO vo);

}
