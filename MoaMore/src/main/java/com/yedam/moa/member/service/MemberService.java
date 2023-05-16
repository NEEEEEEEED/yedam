package com.yedam.moa.member.service;

import com.yedam.moa.co.service.CoVO;
import com.yedam.moa.mem.MemVO;

public interface MemberService {

	MemberVO getMember(String id);
	MemberVO getCoMember(String id);
    boolean authenticate(String id, String pw); 

    boolean authenticateCo(String id, String pw);
    //정보수정
	int updateMember(MemVO vo);
	
	String findId(MemVO vo);
	String findpw(MemVO vo) throws Exception;
	String findCoId(CoVO vo);
	String findCoPw(CoVO vo) throws Exception; 


      
}
