package com.yedam.spring.prdtInsp.service;

import lombok.Data;

@Data
public class PrdtInspVO {
	//modalâ �ֹ�����
	private String orderNo; //�ֹ���ȣ
	private String vendNm; //�ŷ�ó��
	private String edctsCd; //����ǰ�ڵ�
	private String prdtNm; //����ǰ�̸�
	private int orderCnt; //�ֹ�����
	
	//max ����ǰlot
	private String edctsLotNo;
	
}
