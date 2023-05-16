package com.yedam.moa.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.moa.co.service.CoVO;
import com.yedam.moa.mem.MemVO;
import com.yedam.moa.member.service.MemberVO;

@Mapper
public interface MemberMapper {

	MemberVO getMember(String id);

	MemberVO getCoMember(String id);

	int updateMember(MemVO vo);

	String findId(MemVO vo);

	int findPw(MemVO vo);

	int changePw(MemVO vo);

	String findCoId(CoVO vo);

	MemVO findCoPw(CoVO vo);
}
