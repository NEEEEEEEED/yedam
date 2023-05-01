package com.yedam.moa.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.moa.emp.service.EmpVO;

@Mapper
public interface EmpMapper { 
	public EmpVO getEmp(EmpVO empVO); 
	public List<EmpVO> getEmpList(); 
	public void empInsert(EmpVO empVO);
}