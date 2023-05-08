package com.yedam.moa.mem.mapper;

import java.util.List;

import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.SearchVO;

public interface MemMapper {

	public List<MemVO> openSesame(MemVO vo);
	
	public SearchVO getCount(MemVO vo);

	public List<MemVO> getSearch(SearchVO vo);
	
	public int delAnun(SearchVO vo);
}
