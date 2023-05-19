package com.yedam.moa.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.admin.mapper.AdminMapper;
import com.yedam.moa.admin.service.AdminService;
import com.yedam.moa.admin.service.PostListVO;
import com.yedam.moa.admin.service.ReportVO;
import com.yedam.moa.admin.service.UserSearchVO;
import com.yedam.moa.community.mapper.CommunityMapper;
import com.yedam.moa.mem.MemVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper adminMapper;
	@Autowired
	CommunityMapper commuMapper;
	
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
	public Map<String,Object> getReportData(String notiwrNo) {
		Map<String,Object> map = new HashMap<>();
		map.put("list",adminMapper.selectReportData(notiwrNo));
		map.put("rprt",adminMapper.selectrprtSt());
		return map;
	}
	@Override
	public String modifyRprt(List<ReportVO> vo) {
		String message = ""	;
		for(ReportVO rvo : vo) {
			if(adminMapper.updateRprt(rvo)>0) {
				message = message + rvo.getRprtNo() +",";
			} else {
				message = message + rvo.getRprtNo() +",";
			}
		}
		return message;
	}

	
	@Override
	public String removeBoard(String[] nos) {
		String message = "";
		for(String str : nos) {
			String substr = str.substring(0,3);
			System.out.println(substr);
			if(substr.equals("STD")) {
				commuMapper.studyDelFn(str);
				message = message + str +",";
			} else if(substr.equals("PRJ")) {
				commuMapper.projectDelFn(str);
				message = message + str +",";
			} else {
				commuMapper.jobQnaDelete(str);
				message = message + str +",";
			}
		}
		return message;
		
	}


}
