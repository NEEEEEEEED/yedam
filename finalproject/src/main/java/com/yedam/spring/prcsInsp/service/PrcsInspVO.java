package com.yedam.spring.prcsInsp.service;

import lombok.Data;

@Data
public class PrcsInspVO {
	//modalâ �˻縮��Ʈ 
	private String prcsCd; //�����ڵ�
	private String prcsNm; //������
	private String edctsCd; //��ǰ�ڵ� �����������̺� ����� ��
	private String prdtNm; //��ǰ�� �����������̺� ����� ��
	private int prodCnt; //���귮==�˻緮
	
	//�����˻���� 
	private String prcsInspCd; //�˻��ڵ�
	private String prcsInspNm; //�˻��
	private String prcsInspStd; //�˻����
	
	
	//max ����ǰlot
	private String edctsLotNo;
	
}
