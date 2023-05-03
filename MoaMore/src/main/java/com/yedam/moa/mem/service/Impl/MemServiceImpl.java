package com.yedam.moa.mem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.mapper.MemMapper;
import com.yedam.moa.mem.service.MemService;

@Service
public class MemServiceImpl implements MemService {

	@Autowired
	MemMapper mem;
	
	
	@Override
	public List<MemVO> openSesame(MemVO vo) {
		return mem.openSesame(vo);
	}

}
