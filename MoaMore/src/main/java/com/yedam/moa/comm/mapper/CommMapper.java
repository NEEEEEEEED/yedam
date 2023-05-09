package com.yedam.moa.comm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.moa.comm.CommVO;

@Mapper
public interface CommMapper {
	
	public List<CommVO> getCodeWG (CommVO vo);
	
//	public List<CommVO> getCodeWNm(CommVO vo);
}
