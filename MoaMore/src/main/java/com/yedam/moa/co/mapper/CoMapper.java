package com.yedam.moa.co.mapper;

import java.util.List;

import com.yedam.moa.co.service.CoVO;
import com.yedam.moa.hire.HireVO;

public interface CoMapper {
	//기업정보 조회
	public CoVO selectCo (CoVO vo);
	
	//기업정보 등록
	public int insertCo(CoVO vo);
	
	//기업정보 수정
	public int updateCo(CoVO vo);
	
	//구인공고목록
	public List<HireVO> selectRec(HireVO vo);
	
	//미완성 관심셀프구직게시글 
	//public List<셀프구직vo> selectInterNoti(셀프구직vo);
}
