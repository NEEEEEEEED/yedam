package com.yedam.moa.mem.service;

import java.util.List;

import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.SearchVO;

public interface MemService {
	
	public List<MemVO> openSesame (MemVO vo);
	
	public List<MemVO> getSearch (SearchVO vo);
}
