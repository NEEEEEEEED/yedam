package com.yedam.moa.comm.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.comm.CommVO;
import com.yedam.moa.comm.mapper.CommMapper;
import com.yedam.moa.comm.service.CommService;

@Service
public class CommServiceImpl implements CommService {

	@Autowired
	CommMapper mapper;
	
	@Override
	public Map<String, List<CommVO>> getCodes(String ... gpCdlist) {
		
		Map<String,List<CommVO>> map = new HashMap<String,List<CommVO>>();
		for(String gpCd : gpCdlist) {
			map.put(gpCd, mapper.getCodeWG(new CommVO(gpCd)));
		}
		return map;
	}

//	@Override
//	public Map<String, List<CommVO>> getCodesWN( String ... gpCdlist) {
//		Map<String,List<CommVO>> map = new HashMap<String,List<CommVO>>();
////		CommVO vo = new CommVO(null,"기술");
//		for(String gpCd : gpCdlist) {
//			map.put(gpCd, mapper.getCodeWNm(new CommVO(null, gpCd)));
//		}
//		return map;
//	}

}
