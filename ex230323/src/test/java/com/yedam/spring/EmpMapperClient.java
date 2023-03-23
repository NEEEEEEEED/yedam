package com.yedam.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.spring.emp.mapper.EmpMapper;
import com.yedam.spring.emp.service.EmpVO;

import oracle.security.o3logon.a;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class EmpMapperClient {
	@Autowired
	EmpMapper empMapper;
	//전체조회 테스트
	@Test
	public void selectAllEmp() {
		List<EmpVO> emplist = empMapper.selectEmpAllList();
		assertNotNull(emplist);
	}
	//단건조회 테스트
	@Test
	public void selectEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(),"King");
	}
	//등록 테스트
	@Test
	public void insertEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Kang");
		empVO.setFirstName("San-Ha");
		empVO.setEmail("shKang@google.com");
		empVO.setJobId("IT_PROG");
		empVO.setSalary(5000);
		
		empMapper.insertEmpInfo(empVO);
		assertNotEquals(empVO.getEmployeeId(), 0);
	}
	//급여 수정 테스트
	@Test
	public void updateEmpSal() {
		int result = empMapper.updateEmpSal(1001,10);
		assertEquals(result, 1);
	}
	//정보 수정 테스트
	@Test
	public void updateEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(1002);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		System.out.println(findVO);
		
		empVO.setEmail("sujung@google.com");
		
		int result = empMapper.updateEmpInfo(empVO);
		assertEquals(result, 1);
		
	}
	//삭제 테스트
	@Test
	public void deleteEmpInfo() {
		int result = empMapper.deleteEmpInfo(1002);
		assertEquals(result, 1);
	}
}
