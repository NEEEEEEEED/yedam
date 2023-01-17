package com.yedam.java.ch02_02;

public interface RemoteControl {
	// 상수(자동 static final)
	public int Max_VALUE = 10;
	public int MIN_VALUE = 1;

	// 추상 메소드
	// default로 일반 메소드 가능
	public default void method() {
		System.out.println("일반 메소드 입니다.");
	}

	// 기본은 추상 메소드(자동 abstract)
	public void turnOn();

	public void turnOff();

	public void setVolume(int volume);
}
