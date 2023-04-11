package com.yedam.spring.prdtInsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.spring.prdtInsp.mapper.PrdtInspMapper;
import com.yedam.spring.prdtInsp.service.PrdtInspService;
import com.yedam.spring.prdtInsp.service.PrdtInspVO;

@Service
public class PrdtInspServiceImpl implements PrdtInspService{
@Autowired	
PrdtInspMapper mapper;

@Override
public List<PrdtInspVO> selectOrderList() {
	return mapper.selectOrderList();
}
//max ����ǰLOT ��ȣ
@Override
public PrdtInspVO selectMaxEdctsLotNo() {
	return mapper.selectMaxEdctsLotNo();
}
}
