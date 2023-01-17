package com.yedam.java.ch02_01;
//구현 클래스
public class Car {
	//인터페이스로 변수 선언
	Tire frontLeftTrie = new HankookTire();
	Tire frontRightTrie = new HankookTire();
	Tire backLeftTrie = new HankookTire();
	Tire backRightTrie = new HankookTire();

	public void run() {
		frontLeftTrie.roll();
		frontRightTrie.roll();
		backLeftTrie.roll();
		backRightTrie.roll();
	}
}
