package com.yedam.member.mapper;

import com.yedam.member.vo.MemberVO;

// 가장 간단한(기본적인) 부분 선언하는곳 , 예를들어 연산시 => 더하기 , 뺄셈, 나누기, 곱하기
public interface MemberMapper { // 서비스부분이 아니라 데이터를 처리해주는 곳임(DB처리)

	public MemberVO login(MemberVO member); // 로그인
}