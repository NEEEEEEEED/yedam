package com.yedam.spring.eqm.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EqmVO {
	private String eqmCd; //�����ڵ�
	private String eqmFg; //���񱸺�
	private String eqmNm; //�����
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eqmIstDt; //�����԰�¥
	private String eqmMinTemp; //�ּҿµ�
	private String eqmMaxTemp; //�ְ�µ�
	private String chckPerd; //�����ֱ�
	private String useYn; //��뿩��
	private String eqmMng; // ���� �����
	private String eqmImg; //�����̹���
	
	//�����ڵ� �ִ밪 �ޱ�
	private String firstMax; 
	private String secondMax; 
	private String thirdMax; 
	private String fourthMax; 
	private String fifthMax; 
}
