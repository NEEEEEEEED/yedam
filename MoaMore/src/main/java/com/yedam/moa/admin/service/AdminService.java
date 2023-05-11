package com.yedam.moa.admin.service;

import java.util.List;
import java.util.Map;

import com.yedam.moa.mem.MemVO;

public interface AdminService {

	public List<MemVO> getUserInfo();

	public Map<String, List<PostListVO>> getUserPost(String id);

	public MemVO getUserDetails(String email);

	public String modifyUser(MemVO[] memVo);

	public String removeUsers(String[] emails);

	public List<MemVO> getSearchUser(UserSearchVO vo);

}
