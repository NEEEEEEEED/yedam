package com.yedam.spring.eqm.service;

import java.util.List;

public interface EqmService {
	//������ü��ȸ
	public List<EqmVO> selectEqmList();
	//�����ڵ��ִ밪
	public EqmVO selectMaxCd();
	
    //������
	public int insertEqm(EqmVO eqmVO);
	
	//����ܰ���ȸ
	public EqmVO selectEqm(EqmVO eqmVO);
	
	//����
	public int deleteEqm(EqmVO eqmVO);
	
	//����
	public int updateEqm(EqmVO eqmVO);
}
