package com.yedam.spring.prdtInsp.service;

import java.util.List;

public interface PrdtInspService {
	//��޿� �ֹ��� ��ü��ȸ
	public List<PrdtInspVO> selectOrderList();
	
	//�ִ� ����ǰLOT��ȣ
	public PrdtInspVO selectMaxEdctsLotNo();
}
