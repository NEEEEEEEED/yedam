package com.yedam.spring.eqm.service;

import java.util.List;

public interface EqmService {
	//������ü��ȸ
	public List<EqmVO> selectEqmList();
	
    //������
	public int insertEqm(EqmVO eqmVO);
}
