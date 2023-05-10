package com.yedam.moa.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.admin.mapper.AdminMapper;
import com.yedam.moa.admin.service.AdminService;
import com.yedam.moa.admin.service.PostListVO;
import com.yedam.moa.mem.MemVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper adminMapper;
	@Override
	public List<MemVO> getUserInfo() {
		return adminMapper.selectUserInfo();
	}
	@Override
	public Map<String, List<PostListVO>> getUserPost(String id) {
		 Map<String, List<PostListVO>> map = new HashMap<>();
		//스터디모집
		map.put("study",adminMapper.selectStudyPost(id));
		//프로젝트모집
		map.put("prjt",adminMapper.selectPRJTPost(id));
		//면접후기
		map.put("intr",adminMapper.selectINTRVPost(id));
		//취업Q&A
		map.put("qa",adminMapper.selectQSTPost(id));
		return map;
	}
	@Override
	public MemVO getUserDetails(String email) {
		return adminMapper.selectUserDetails(email);
		
	}
	@Override
	public String modifyUser(MemVO memVo) {
		String message = null;
		int result = adminMapper.updateUser(memVo);
		if(result > 0) {
			message = "success";
		} else {
			message = "fail";
		}
		return message;
	}

}
