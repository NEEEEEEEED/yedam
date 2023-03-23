package com.yedam.spring.user.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserVO {
	private String name;
	private Integer age;
	// util.Date 기본형태은 2023/03/23
	// 그 형태를 바꿀 수 있는 DateTimeFormat
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date today;
}
