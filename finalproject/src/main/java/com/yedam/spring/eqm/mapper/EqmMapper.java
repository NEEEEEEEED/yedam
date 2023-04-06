package com.yedam.spring.eqm.mapper;

import java.util.List;

import com.yedam.spring.eqm.service.EqmVO;

public interface EqmMapper {
	//������ü��ȸ
	public List<EqmVO> selectEqmList();
	//�����ڵ� �ִ밪
	public EqmVO selectMaxCd();
	
	//������
	public int insertEqm(EqmVO eqmVO);
	
	//����ܰ���ȸ
	public EqmVO selectEqm(EqmVO eqmVO);
	
	//����
	public int deleteEqm(EqmVO eqmVO);
	
	//����
	public int updateEqm(EqmVO eqmVO);
	
	//////////�������˳���////////////////
	
	//�������˳��� ��ü��ȸ
	public List<EqmVO> selectCheckList();
}
