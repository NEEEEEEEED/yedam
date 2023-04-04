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
	private int eqmMinTemp; //�ּҿµ�
	private int eqmMaxTemp; //�ְ�µ�
	private int chckPerd; //�����ֱ�
	private String useYn; //��뿩��
	private String eqmMng; // ���� �����
	private String eqmImg; //�����̹���
}
