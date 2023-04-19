package com.yedam.spring.prcsInsp.mapper;

import java.util.List;

import com.yedam.spring.prcsInsp.service.PrcsInspVO;

public interface PrcsInspMapper {
	//��޿� �˻� ��ü��ȸ
	public List<PrcsInspVO> selectPrcsList();
	
	//������ �˻����
	public List<PrcsInspVO> selectPrcsStd(PrcsInspVO prcsCd);
	
	//�����˻�Ϸ� �˻�����ϵ��
	public int insertDtl(PrcsInspVO prcsInspVO);
	
	//�����˻�Ϸ� �ҷ���� / �ҷ�,�˻�Ϸ� ������Ʈ
	public int inferUpdateInsert(PrcsInspVO prcsInspVO);
	//�ƽ��˻�Ϸ��ڵ�
	public PrcsInspVO selectMaxChkCd();
	
	//�˻�ϷḮ��Ʈ
	public List<PrcsInspVO> selectCompletedPrcs();
	
	//�˻�Ϸ� �ܰ���ȸ
	public List<PrcsInspVO> inspDtl(PrcsInspVO prcsInspVO);
	
	//�˻�Ϸ� ����
	public int deleteCompleted(String deleteList);
	
}
