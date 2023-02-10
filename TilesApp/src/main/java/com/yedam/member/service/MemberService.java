package com.yedam.member.service;

import java.util.List;

import com.yedam.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(MemberVO memeber);
	public int addMember(MemberVO member);
	public List<MemberVO> memberList();
	public MemberVO getMember(String id); //회원정보 단건조회
	public int modifyMember(MemberVO member);
	public int removeMember(String mid);
}
