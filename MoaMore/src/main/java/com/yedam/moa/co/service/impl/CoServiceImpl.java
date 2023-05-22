package com.yedam.moa.co.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.co.mapper.CoMapper;
import com.yedam.moa.co.service.CoService;
import com.yedam.moa.co.service.CoVO;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.self.SelfVO;

@Service
public class CoServiceImpl implements CoService{
	@Autowired
	CoMapper mapper;
	@Override
	public CoVO selectCo(CoVO vo) {
		return mapper.selectCo(vo);
	}
	
	@Override
	public List<HireVO> selectRec(HireVO vo) {
		return mapper.selectRec(vo);
	}
	//관심셀프구직게시글
	@Override
	public List<SelfVO> selectInterNoti(SelfVO vo) {
		return mapper.selectInterNoti(vo);
	}
	@Override
	public List<SelfVO> selectOfferNoti(SelfVO vo) {
		return mapper.selectOfferNoti(vo);
	}
	@Override
	public int saveCoInfo(CoVO vo) {
		return mapper.saveCoInfo(vo);
	}

	@Override
	public String selectFollowers(CoVO vo) {
		return mapper.selectFollowers(vo);
	}

	@Override
	public int deleteInfer(SelfVO vo) {
		return mapper.deleteInfer(vo);
	}

	@Override
	public SelfVO selectTotalInter(CoVO vo) {
		return mapper.selectTotalInter(vo);
	}

	@Override
	public int afterOffer(CoVO vo) {
		return mapper.afterOffer(vo);
	}

	@Override
	public CoVO selectOffer(CoVO vo) {
		return mapper.selectOffer(vo);
	}

	@Override
	public int uploadProfileImg(CoVO vo) {
		return mapper.uploadProfileImg(vo);
	}

	@Override
	public List<CoVO> selectNewApply(String id) {
		return mapper.selectNewApply(id);
	}
	
	
	
	 
}
