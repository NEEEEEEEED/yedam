package com.yedam.moa.co.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.co.mapper.CoMapper;
import com.yedam.moa.co.service.CoService;
import com.yedam.moa.co.service.CoVO;
import com.yedam.moa.hire.HireVO;

@Service
public class CoServiceImpl implements CoService{
	@Autowired
	CoMapper mapper;
	@Override
	public CoVO selectCo(CoVO vo) {
		return mapper.selectCo(vo);
	}
	@Override
	public int insertCo(CoVO vo) {
		return mapper.insertCo(vo);
	}
	@Override
	public int updateCo(CoVO vo) {
		return mapper.updateCo(vo);
	}
	@Override
	public List<HireVO> selectRec(HireVO vo) {
		return mapper.selectRec(vo);
	}
}
