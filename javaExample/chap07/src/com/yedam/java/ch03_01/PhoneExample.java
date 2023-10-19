package com.yedam.java.ch03_01;

public class PhoneExample {

	public static void main(String[] args) {
//		Phone phone = new Phone("홍길동");

		SmartPhone smartPhone = new SmartPhone("홍길동");
		// 추상 자동타입변환
		Phone phone = new SmartPhone("길동홍");
		// 추상 강제타입변환(new 절대 불가)
//		SmartPhone smartPhone1 = (SmartPhone) new Phone("홍길동");

		smartPhone.turnOn();
		smartPhone.internetSearch();

	}

}
