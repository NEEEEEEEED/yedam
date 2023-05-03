package com.yedam.moa.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.admin.mapper.AdminMapper;
import com.yedam.moa.admin.service.AdminService;
import com.yedam.moa.mem.MemVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper adminMapper;
	@Override
	public List<MemVO> getUserInfo() {
		return adminMapper.selectUserInfo();
	}

}
