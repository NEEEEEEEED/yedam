package com.yedam.java.ch02;

public class Box<T> {	//타입(클래스)를 값으로 받는 일종의 변수
	//필드
	private T t;
	//생성자
	public void set(T t) {
		this.t = t;
	}
	//메서드
	public T get() {
		return t;
	}
}
