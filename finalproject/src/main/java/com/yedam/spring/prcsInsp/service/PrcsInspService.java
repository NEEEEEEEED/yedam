package com.yedam.spring.prcsInsp.service;

import java.util.List;

public interface PrcsInspService {
	// ��޿� �˻� ��ü��ȸ
	public List<PrcsInspVO> selectPrcsList();
	
	//������ �˻����
	public List<PrcsInspVO> selectPrcsStd(PrcsInspVO prcsCd);

	// �ִ� ����ǰLOT��ȣ
	public PrcsInspVO selectMaxEdctsLotNo();
}
