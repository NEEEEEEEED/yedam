package com.yedam.java.ch03_01;

public class SmartPhone extends Phone {

	// 필드

	// 생성자
	public SmartPhone(String owner) {
		super(owner);

	}

	// 메서드
	public void internetSearch() {
		System.out.println("인터넷을 검색합니다.");
	}
}
