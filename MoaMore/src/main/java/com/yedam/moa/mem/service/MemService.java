package com.yedam.moa.mem.service;

import java.util.List;

import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.SearchVO;

public interface MemService {
	
//	마이페이지 홈
	public List<MemVO> openSesame (MemVO vo);
	
	public SearchVO getCount(MemVO vo);
	
	public List<MemVO> getSearch (SearchVO vo);
	
	public int delAnun(SearchVO vo);
	
//	이력서 폼 
	public MemVO getMemInfo(MemVO vo);
}
