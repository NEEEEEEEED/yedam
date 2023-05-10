package com.yedam.moa.admin.mapper;

import java.util.List;

import com.yedam.moa.admin.service.PostListVO;
import com.yedam.moa.mem.MemVO;

public interface AdminMapper {

	public List<MemVO> selectUserInfo();

	public List<PostListVO> selectStudyPost(String id);

	public List<PostListVO> selectPRJTPost(String id);

	public List<PostListVO> selectINTRVPost(String id);

	public List<PostListVO> selectQSTPost(String id);

	public MemVO selectUserDetails(String email);

	public int updateUser(MemVO memVo);

}
