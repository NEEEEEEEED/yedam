package com.yedam.moa.admin.service;

import java.util.List;
import java.util.Map;

import com.yedam.moa.mem.MemVO;

public interface AdminService {

	public List<MemVO> getUserInfo();

	public Map<String, List<PostListVO>> getUserPost(String id);

	public MemVO getUserDetails(String id);

}
