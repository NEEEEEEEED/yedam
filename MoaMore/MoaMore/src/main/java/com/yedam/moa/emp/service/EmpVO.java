package com.yedam.moa.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO { String employeeId;
	private String 	firstName;
	private String 	lastName;
	private String  email;
	private Date  	hireDate;
	private int  	salary;
	private String 	jobId;
	private String 	departmentId;
	private String 	managerId;
}

