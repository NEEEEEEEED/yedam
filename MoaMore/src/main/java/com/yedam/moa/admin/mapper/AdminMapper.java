package com.yedam.moa.admin.mapper;

import java.util.List;

import com.yedam.moa.admin.service.ReportVO;
import com.yedam.moa.admin.service.UserSearchVO;
import com.yedam.moa.admin.service.rprtStatusVO;
import com.yedam.moa.community.CommunityVO;
import com.yedam.moa.community.IntrvVO;
import com.yedam.moa.community.PrjtVO;
import com.yedam.moa.community.StudyVO;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.ResumeVO;
import com.yedam.moa.self.SelfVO;

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

	public List<ReportVO> selectReportData(String notiwrNo);

	public List<rprtStatusVO> selectrprtSt();

	public int updateRprt(ReportVO vo);

	public List<HireVO> selectRecruitList();

	public List<SelfVO> selectSelfList();

	public int approveREA(String recruitNo);

	public int approveJSN(String jobSearchNo);

	public int approveITV(String intrvNo);

	public int approveCancelREA(String recruitNo);

	public int approveCancelJSN(String jobSearchNo);

	public int approveCancelITV(String intrvNo);

	public int getReport(ReportVO rvo);

	public int insertReport(ReportVO rvo);



}
