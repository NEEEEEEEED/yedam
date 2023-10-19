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
	///////�������˳���////////
	//�������̵��� ��ü��ȸ
	@Override
	public List<EqmVO> selectCheckList() {
		return mapper.selectCheckList();
	}
	//���˰˻���ȸ
	@Override
	public List<EqmVO> searchEqmCheck(EqmVO eqmVO) {
		return mapper.searchEqmCheck(eqmVO);
	}
	//���˴ܰ���ȸ
	@Override
	public EqmVO selectCheck(EqmVO eqmVO) {
		return mapper.selectCheck(eqmVO);
	}
	//���˵��
	@Override
	public int insertCheck(EqmVO eqmVO) {
		return mapper.insertCheck(eqmVO);
	}
	@Override
	public int deleteCheck(String checkCd) {
		return mapper.deleteCheck(checkCd);
	}
	@Override
	public int updateCheck(EqmVO eqmVO) {
		return mapper.updateCheck(eqmVO);
	}
	@Override
	public List<EqmVO> selectOprList() {
		return mapper.selectOprList();
	}
	@Override
	public List<EqmVO> selectYList() {
		return mapper.selectYList();
	}
	@Override
	public EqmVO selectMaxNoprCd() {
		return mapper.selectMaxNoprCd();
	}
	@Override
	public int insertOprUpdateY(EqmVO eqmVO) {
		return mapper.insertOprUpdateY(eqmVO);
	}
	@Override
	public int deleteOpr(String noprCd) {
		// TODO Auto-generated method stub
		return mapper.deleteOpr(noprCd);
	}
	@Override
	public int updateOpr(EqmVO eqmVO) {
		return mapper.updateOpr(eqmVO);
	}
	@Override
	public List<EqmVO> selectEmpList() {
		return mapper.selectEmpList();
	}

}