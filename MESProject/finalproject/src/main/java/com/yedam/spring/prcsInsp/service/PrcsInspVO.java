package com.yedam.spring.prcsInsp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PrcsInspVO {
	//modalâ �˻縮��Ʈ 
	private String indicaCd; //�����ڵ�
	private String prcsCd; //�����ڵ�
	private String prcsNm; //������
	private String edctsCd; //��ǰ�ڵ� �����������̺� ����� ��
	private String prdtNm; //��ǰ�� �����������̺� ����� ��
	private int indicaCnt; //�˻����ü���
	private int prodCnt; //�˻緮-�ҷ��� = ���귮
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prcsInspDt; //�˻�����
	private String prcsInspMng; //�˻�����
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date edctsExpire; //�������
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
