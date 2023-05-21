package com.yedam.moa.admin.service;

import java.util.List;
import java.util.Map;

import com.yedam.moa.mem.MemVO;

public interface AdminService {

	public List<MemVO> getUserInfo();

	public PostListVO getBoardData();

	public MemVO getUserDetails(String email);

	public String modifyUser(MemVO[] memVo);

	public String removeUsers(String[] emails);

	public List<MemVO> getSearchUser(UserSearchVO vo);

	public Map<String,Object> getReportData(String notiwrNo);

	public String modifyRprt(List<ReportVO> vo);

	public String removeBoard(String[] nos);

	public ApprvListVO getApprvList();

	public String approveBoard(String[] nos);

}
