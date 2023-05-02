package com.yedam.moa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yedam.moa.emp.mapper.EmpMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
class MapperTest {
	@Autowired
	EmpMapper mapper;

	@Test
	void list() {
		System.out.println(mapper.getEmpList());
		
	}
}