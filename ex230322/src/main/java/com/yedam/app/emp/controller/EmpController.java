package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	@RequestMapping("/getEmpInfo")
	@ResponseBody //page를 return하지 않고 return 하는 대상을 body에 출력
	public EmpVO getEmpInfo(EmpVO empVO) {
		return empService.getEmpInfo(empVO);
	}
}
