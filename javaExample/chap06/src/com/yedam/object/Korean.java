package com.yedam.object;

public class Korean {
	// 필드
	String nation = "Korea";
	String name;
	String ssn;

	// 생성자
	// 생성자에서 필드 초기화
	// +데이터가 들어간 상태로 객체 생성하기
	// +생성자를 활용한 필드 초기화
	Korean(String name, String ssn) {
		// this 는 테이블의 주인을 지칭
		this.name = name;
		this.ssn = ssn;
	}

	// 메소드

}
