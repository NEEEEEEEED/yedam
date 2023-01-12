package com.yedam.object;

public class Calculator {

	// 필드

	// 생성자

	// 메소드
	// 메소드 리턴 타입이 존재할 때
	int sum(int a, int b) {
		return a + b;
	}

	double sub(int a, int b) {
		return a - b;
	}

	String result(String value) {
		String temp = "value 테스트 : " + value;
		return temp;
	}

	// 리턴문이 없는 메소드 생성
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}

	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	//리턴 값이 존재하는 매개변수 갯수 몰?루
	int sum2(int ...values) {
		int total = 0;
		for(int a : values) {
			total += a;
		}	
		return total;
	}
}
