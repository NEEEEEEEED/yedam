package com.yedam.spring.prcsInsp.mapper;

import java.util.List;

import com.yedam.spring.prcsInsp.service.PrcsInspVO;

public interface PrcsInspMapper {
	//��޿� �˻� ��ü��ȸ
	public List<PrcsInspVO> selectPrcsList();
	
	//�ִ� ����ǰLOT��ȣ
	public PrcsInspVO selectMaxEdctsLotNo();
}
