package com.yedam.spring.eqm.mapper;

import java.util.List;

import com.yedam.spring.eqm.service.EqmVO;

public interface EqmMapper {
	//������ü��ȸ
	public List<EqmVO> selectEqmList();
	//�����ڵ� �ִ밪
	public EqmVO selectMaxCd();
	
	//������
	public int insertEqm(EqmVO eqmVO);
	
	//����ܰ���ȸ
	public EqmVO selectEqm(EqmVO eqmVO);
	
	//����
	public int deleteEqm(EqmVO eqmVO);
	
	//����
	public int updateEqm(EqmVO eqmVO);
	
	//////////�������˳���////////////////
	
	//���˳��� ��ü��ȸ
	public List<EqmVO> selectCheckList();
	
	//���˰˻���ȸ
	public List<EqmVO> searchEqmCheck();
	
	//���˴ܰ���ȸ
	public EqmVO selectCheck(EqmVO eqmVO);
	
	//���˵��
	public int insertCheck(EqmVO eqmVO);
	
	//���˻���
	public int deleteCheck(String checkCd);
	
	//���˼���
	public int updateCheck(EqmVO eqmVO);
	
	///////////����񰡵�//////////
	//��� ������ ��뿩��Y�� ���񸮽�Ʈ
	public List<EqmVO> selectYList();
	
	//�񰡵������ȸ
	public List<EqmVO> selectOprList();
	
	//�ִ�񰡵��ڵ�
	public EqmVO selectMaxNoprCd();
	
	//�񰡵����,Y������Ʈ
	public int insertOprUpdateY(EqmVO eqmVO);
	
	//�񰡵� ���� 
	public int deleteOpr(String noprCd);
	
	//�񰡵� ����
	public int updateOpr(EqmVO eqmVO);
	
}
