package com.yedam.spring.eqm.mapper;

import java.util.List;

import com.yedam.spring.eqm.service.EqmVO;

public interface EqmMapper {
	//������ü��ȸ
	public List<EqmVO> selectEqmList();
	
	//������
	public int insertEqm(EqmVO eqmVO);
}
