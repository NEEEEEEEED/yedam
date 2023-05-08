package com.yedam.moa.mem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.SearchVO;
import com.yedam.moa.mem.mapper.MemMapper;
import com.yedam.moa.mem.service.MemService;

@Service
public class MemServiceImpl implements MemService {

	@Autowired
	MemMapper mem;
	
	
	@Override
	public List<MemVO> openSesame(MemVO vo) {
		return mem.openSesame(vo);
	}

	@Override
	public SearchVO getCount(MemVO vo) {
		
		return mem.getCount(vo);
	}

	@Override
	public List<MemVO> getSearch(SearchVO vo) {
		List<MemVO> sv = mem.getSearch(vo);
		for(int i = 0; i<sv.size();i++) {
			if( sv.get(i).getSt().contains("1")) {
				sv.get(i).setSt("열람");
			}else if(sv.get(i).getSt().contains("0")) {
				sv.get(i).setSt("미열람");
			}
			if(sv.get(i).getExprSt() > 0) {
				sv.get(i).setExprStatus("진행중");
			}else if(sv.get(i).getExprSt() < 0) {
				sv.get(i).setExprStatus("마감");
			}
		}
		System.out.println(sv);
		return sv;
	}

	@Override
	public int delAnun(SearchVO vo) {
		return mem.delAnun(vo);
	}

	
	@Override
	public List<MemVO> getSkill(MemVO vo) {
		return mem.getCode(vo);
	}



}
