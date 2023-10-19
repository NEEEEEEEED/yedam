package com.yedam.spring.prcsInsp.service;

import java.util.List;

public interface PrcsInspService {
	// ��޿� �˻� ��ü��ȸ
	public List<PrcsInspVO> selectPrcsList();

	// ������ �˻����
	public List<PrcsInspVO> selectPrcsStd(PrcsInspVO prcsCd);

	// �����˻�Ϸ�
	public int insertDtl(PrcsInspVO prcsInspVO);

	// �����˻�Ϸ� �ҷ���� / �ҷ�,�˻�Ϸ� ������Ʈ
	public int inferUpdateInsert(PrcsInspVO prcsInspVO);

	// �ƽ��˻�Ϸ��ڵ�
	public PrcsInspVO selectMaxChkCd();

	// �˻�ϷḮ��Ʈ
	public List<PrcsInspVO> selectCompletedPrcs();

	// �˻�Ϸ� �ܰ���ȸ
	public List<PrcsInspVO> inspDtl(PrcsInspVO prcsInspVO);

	// �˻�Ϸ� ����
	public int deleteCompleted(String deleteList);

	// ����Ϸ� ���ð�ȹ����
	public int updateIndiPlan(PrcsInspVO prcsInspVO);
}