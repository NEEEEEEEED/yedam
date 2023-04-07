package com.yedam.spring.mat.mapper;

import java.util.List;

import com.yedam.spring.mat.service.MatVO;

public interface MatMapper {

	//자재정보 전체조회
	public List<MatVO> matList();
	//자재정보 단건 조회
	public MatVO selectMatInfo(MatVO matVO);
	//자재정보 등록
	public int insertMatInfo(MatVO matVO);
	//자재정보 수정
	public int updateMatInfo(MatVO matVO);
	//자재정보 삭제
	public int deleteMatInfo(String rscCd);
	
	//발주 전체 조회	
	public List<MatVO> matOrderAllList();
	//자재발주 단건 조회
	public MatVO selectMatOrderInfo(MatVO matVO);
	//자재발주 등록
	public int insertMatOrderInfo(MatVO matVO);
	//자재발주 수정
	public int updateMatOrderInfo(MatVO matVO);
	//자재발주 삭제
	public int deleteMatOrderInfo(String ordrCd);
}
