package com.yedam.moa.admin.mapper;

import java.util.List;

import com.yedam.moa.admin.service.UserSearchVO;
import com.yedam.moa.community.CommunityVO;
import com.yedam.moa.community.IntrvVO;
import com.yedam.moa.community.PrjtVO;
import com.yedam.moa.community.StudyVO;
import com.yedam.moa.mem.MemVO;

public interface AdminMapper {

	public List<MemVO> selectUserInfo();

	public List<StudyVO> selectStudyPost();

	public List<PrjtVO> selectPRJTPost();

	public List<IntrvVO> selectINTRVPost();

	public List<CommunityVO> selectQSTPost();

	public MemVO selectUserDetails(String email);

	public int updateUser(MemVO memVo);

	public int deleteUser(String email);

	public List<MemVO> selectSearchUser(UserSearchVO vo);

}
