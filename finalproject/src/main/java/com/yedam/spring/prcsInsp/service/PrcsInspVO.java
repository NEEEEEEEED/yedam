package com.yedam.spring.prcsInsp.service;

import java.util.Date;

import lombok.Data;

@Data
public class PrcsInspVO {
	//modalâ �˻縮��Ʈ 
	private String indicaCd; //�����ڵ�
	private String prcsCd; //�����ڵ�
	private String prcsNm; //������
	private String edctsCd; //��ǰ�ڵ� �����������̺� ����� ��
	private String prdtNm; //��ǰ�� �����������̺� ����� ��
	private int prodCnt; //���귮==�˻緮
	private Date prcsInspDt; //�˻�����
	private String prcsInspMng; //�˻�����
	//�����˻���� 
	private String prcsInspCd; //�˻��ڵ�
	private String prcsInspNm; //�˻��
	private String prcsInspStd; //�˻����
	private String prcsInspRst; //�˻���
	private String prcsInspJdg; //����
	
	//�����˻�Ϸ� �� dtl�� �ֱ�
	private String prcsChkCd;//�˻�Ϸ��ڵ�
	//�˻�Ϸ� �� �ҷ��� �ֱ�
	private int inferCnt; //�ҷ���
	

	
}
