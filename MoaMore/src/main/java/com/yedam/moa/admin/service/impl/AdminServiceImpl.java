package com.yedam.moa.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.admin.mapper.AdminMapper;
import com.yedam.moa.admin.service.AdminService;
import com.yedam.moa.admin.service.PostListVO;
import com.yedam.moa.admin.service.ReportVO;
import com.yedam.moa.admin.service.UserSearchVO;
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
	public PostListVO getBoardData() {
		PostListVO vo = new PostListVO();
		//스터디모집
		vo.setStudyVO(adminMapper.selectStudyPost());
		//프로젝트모집
		vo.setPrjtVO(adminMapper.selectPRJTPost());
		//면접후기
		//vo.setIntrvVO(adminMapper.selectINTRVPost());
		//취업Q&A
		vo.setCommVO(adminMapper.selectQSTPost());
		return vo;
	}
	@Override
	public MemVO getUserDetails(String email) {
		return adminMapper.selectUserDetails(email);
		
	}
	@Override
	public String modifyUser(MemVO[] memVo) {
		String message = null;
		int result = 0;
		for(MemVO userInfo : memVo) {
			result += adminMapper.updateUser(userInfo);	
		}
		if(result == memVo.length) {
			message = "success";
		} else {
			message = "fail";
		}
		return message;
	}
	@Override
	public String removeUsers(String[] emails) {
		String message = null;
		int result = 0;
		for(String email : emails) {
			result += adminMapper.deleteUser(email);	
		}
		if(result == emails.length) {
			message = "success";
		} else {
			message = "fail";
		}
		return message;
	}
	@Override
	public List<MemVO> getSearchUser(UserSearchVO vo) {	
		return adminMapper.selectSearchUser(vo);
	}

	@Override
	public List<ReportVO> getReportData(String notiwrNo) {
		return adminMapper.selectReportData(notiwrNo);
	}


}
