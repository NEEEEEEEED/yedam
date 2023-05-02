package com.yedam.moa.emp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.emp.mapper.EmpMapper;
import com.yedam.moa.emp.service.EmpService;
import com.yedam.moa.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpMapper empMapper;
	
	@Override
	public List<EmpVO> getEmpList() {
		return empMapper.getEmpList();
	}

}
