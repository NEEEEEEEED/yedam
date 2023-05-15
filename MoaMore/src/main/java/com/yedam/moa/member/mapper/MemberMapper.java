package com.yedam.moa.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.moa.member.service.MemberVO;

@Mapper
public interface MemberMapper {

	MemberVO getMember(String id);

	MemberVO getCoMember(String id);
}
