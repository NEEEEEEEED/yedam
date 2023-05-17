package com.yedam.moa.admin.service;

import java.util.List;

import lombok.Data;

@Data
public class UserSearchVO {
	private String id;
	private String name;
	private String startDate;
	private String lastDate;
	private String userName;
	private String server;
	
	private String[] commds;



}
