package com.yedam.spring.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.spring.emp.service.EmpVO;

public interface EmpMapper {
	//전체 조회
	public List<EmpVO> selectEmpAllList();
	//단건 조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	//등록
	public int insertEmpInfo(EmpVO empVO);
	//수정 - 급여를 정해진 비율로 인상
	//@Param : mybatis에서 지원
	public int updateEmpSal(
			@Param("empId") int employeeId, 
			@Param("raise") int raise);
	//수정 - 사원 정보 수정
	public int updateEmpInfo(EmpVO empVO);
	//삭제
	public int deleteEmpInfo(int employeeId);
}
