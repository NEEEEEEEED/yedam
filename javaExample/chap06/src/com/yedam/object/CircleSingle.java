package com.yedam.object;

public class CircleSingle {

	static CircleSingle instance = new CircleSingle();
	//싱글톤 메소드
	static CircleSingle getInstance() {
		return instance;
	}
	
	
	final double pi;
	double r;
	
	//r필드 초기화 시켜주는 생성자
	private CircleSingle() {
		this.pi = 3.14;
	}
	//메소드
	double area() {
		double result = pi * r * r;
		return result;
	}
}
