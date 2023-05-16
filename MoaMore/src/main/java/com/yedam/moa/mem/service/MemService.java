package com.yedam.moa.mem.service;

import java.util.List;

import com.yedam.moa.mem.MemInfoVO;
import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.PrtflVO;
import com.yedam.moa.mem.ResumeVO;
import com.yedam.moa.mem.SearchVO;

public interface MemService {
	
//	마이페이지 홈
	public List<MemVO> openSesame (MemVO vo);
	
	public SearchVO getCount(MemVO vo);
	
	public List<MemVO> getSearch (SearchVO vo);
	
	public int delAnun(SearchVO vo);
	
//	이력서 폼 
	public MemInfoVO getMemInfo(MemVO vo);
	
	public ResumeVO lastRe(MemVO vo);
	
	public String insertResume(ResumeVO vo);
	
//	디비에 포폴 입력하고 생성된 번호로 입력한 포폴 리스트 가져오기
	public List<PrtflVO> insGetPofl(PrtflVO vo);
	
}
