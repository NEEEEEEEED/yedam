package co.yedam.member.service;

import java.util.List;

import co.yedam.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(MemberVO memeber);
	public int addMember(MemberVO member);
	public List<MemberVO> memberList();
}
