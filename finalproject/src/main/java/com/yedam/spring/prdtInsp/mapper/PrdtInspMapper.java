package com.yedam.spring.prdtInsp.mapper;

import java.util.List;

import com.yedam.spring.prdtInsp.service.PrdtInspVO;

public interface PrdtInspMapper {
	//��޿� �ֹ��� ��ü��ȸ
	public List<PrdtInspVO> selectOrderList();
	
	//�ִ� ����ǰLOT��ȣ
	public PrdtInspVO selectMaxEdctsLotNo();
}
