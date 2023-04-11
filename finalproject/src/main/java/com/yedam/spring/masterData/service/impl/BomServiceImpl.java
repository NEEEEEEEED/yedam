package com.yedam.spring.masterData.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.spring.masterData.mapper.BomMapper;
import com.yedam.spring.masterData.service.BomService;
import com.yedam.spring.mat.service.MatVO;
import com.yedam.spring.production.service.BomVO;
import com.yedam.spring.production.service.ProPrcsVO;

@Service
public class BomServiceImpl implements BomService {
	
	@Autowired
	BomMapper bomMapper;

	@Override
	public List<BomVO> getBomList(String edctsCd) {
		return bomMapper.selectBomList(edctsCd);
	}

	@Override
	public List<ProPrcsVO> getPrcsList() {
		return bomMapper.selectPrcsList();
	}

	@Override
	public int deleteBom(BomVO vo) {
		return bomMapper.deleteBom(vo);
	}

	@Override
	public int saveBom(BomVO vo) {
		return bomMapper.saveBom(vo);
	}

	@Override
	public List<MatVO> getMatList(MatVO vo) {
		return bomMapper.selectMatList(vo);
	}

}
