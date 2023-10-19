package com.yedam.moa.comm.service;

import java.util.List;
import java.util.Map;

import com.yedam.moa.comm.CommVO;


public interface CommService {
	
//	그룹 코드로 디테일 받아오기
	public Map<String, List<CommVO>> getCodes(String ... gpCdlist);
	
////	그룸 코드 이름으로 디테일 받아오기
//	public Map<String, List<CommVO>> getCodesWN(String ... gpCdlist);
	
}
