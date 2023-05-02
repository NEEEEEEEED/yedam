package com.yedam.moa.self.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.self.mapper.SelfMapper;

@Service
public class SelfServiceImpl {

	@Autowired
	SelfMapper selfMapper;
	
}
