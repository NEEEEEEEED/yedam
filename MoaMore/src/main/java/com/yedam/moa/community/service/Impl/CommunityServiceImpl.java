package com.yedam.moa.community.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.community.mapper.CommunityMapper;

@Service
public class CommunityServiceImpl {

	@Autowired
	CommunityMapper communityMapper;
	
}
