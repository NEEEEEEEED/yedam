package com.yedam.java.ch02_01;
//인터페이스의 자식 클래스
public class HankookTire implements Tire {

	@Override
	public void roll() {
		System.out.println("한국 타이어가 굴러갑니다.");

	}

}
