package com.yedam.moa.admin.service;

import java.util.List;

import com.yedam.moa.community.CommunityVO;
import com.yedam.moa.community.IntrvVO;
import com.yedam.moa.community.PrjtVO;
import com.yedam.moa.community.StudyVO;

import lombok.Data;

@Data
public class PostListVO {

	private List<CommunityVO> commVO;
	private List<IntrvVO> intrvVO;
	private List<PrjtVO> prjtVO;
	private List<StudyVO> studyVO;
	
}
