package com.yedam.moa.admin.service;

import java.util.List;

import com.yedam.moa.community.IntrvVO;
import com.yedam.moa.hire.HireVO;
import com.yedam.moa.self.SelfVO;

import lombok.Data;

@Data
public class ApprvListVO {
	private List<IntrvVO> intrvVO;
	private List<HireVO> hireVO;
	private List<SelfVO> selfVO;
}
