package com.yedam.spring.eqm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.spring.eqm.mapper.EqmMapper;
import com.yedam.spring.eqm.service.EqmService;
import com.yedam.spring.eqm.service.EqmVO;

@Service
public class EqmServiceImpl implements EqmService{
	@Autowired
	EqmMapper mapper;
	//��ü��ȸ
	@Override
	public List<EqmVO> selectEqmList() {
		return mapper.selectEqmList();
	}
	//���
	@Override
	public int insertEqm(EqmVO eqmVO) {
		return mapper.insertEqm(eqmVO);
	}
	//�ִ��ڵ�
	@Override
	public EqmVO selectMaxCd() {
		return mapper.selectMaxCd();
	}
	//�ܰ���ȸ
	@Override
	public EqmVO selectEqm(EqmVO eqmVO) {
		return mapper.selectEqm(eqmVO);
	}
	@Override
	public int deleteEqm(EqmVO eqmVO) {
		return mapper.deleteEqm(eqmVO);
	}
	@Override
	public int updateEqm(EqmVO eqmVO) {
		return mapper.updateEqm(eqmVO);
	}

}
