package com.yedam.spring.prcsInsp.mapper;

import java.util.List;

import com.yedam.spring.prcsInsp.service.PrcsInspVO;

public interface PrcsInspMapper {
	//��޿� �˻� ��ü��ȸ
	public List<PrcsInspVO> selectPrcsList();
	
	//������ �˻����
	public List<PrcsInspVO> selectPrcsStd(PrcsInspVO prcsCd);
	
	//�ִ� ����ǰLOT��ȣ
	public PrcsInspVO selectMaxEdctsLotNo();
}
