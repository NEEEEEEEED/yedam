package com.yedam.spring.tx.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.spring.tx.mapper.AaaMapper;
import com.yedam.spring.tx.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService {
	
	@Autowired
	AaaMapper aaaMapper;
	
	@Override
	//2개 이상의 sql문이 하나로 움직이도록 함(1개라도 실패되면 rollback)
	@Transactional
	public void insert() {
		aaaMapper.insert("101");
		aaaMapper.insert("777");
	}

}
