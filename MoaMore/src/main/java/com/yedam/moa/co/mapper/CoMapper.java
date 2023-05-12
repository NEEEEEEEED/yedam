package com.yedam.moa.co.mapper;

import java.util.List;

import com.yedam.moa.co.service.CoVO;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.self.SelfVO;

public interface CoMapper {
	//기업정보 조회
	public CoVO selectCo (CoVO vo);
	
	//받은 관심 수
	public String selectFollowers(CoVO vo);
	
	//기업정보 등록/수정
	public int saveCoInfo(CoVO vo);
	
	//구인공고목록
	public List<HireVO> selectRec(HireVO vo);
	
	//관심셀프구직게시글 
	public List<SelfVO> selectInterNoti(SelfVO vo);
	
	//제안셀프구직게시글 
	public List<SelfVO> selectOfferNoti(SelfVO vo);

	public int deleteInfer(SelfVO vo);

	public SelfVO selectTotalInter(CoVO vo);

	public int afterOffer(CoVO vo);
	
	//제안조회
	public CoVO selectOffer(CoVO vo);
}
