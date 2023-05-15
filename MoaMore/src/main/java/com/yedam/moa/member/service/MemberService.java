package com.yedam.moa.member.service;

public interface MemberService {

	MemberVO getMember(String id);
	MemberVO getCoMember(String id);
    boolean authenticate(String id, String pw); 
    boolean authenticateCo(String id, String pw); 
}
