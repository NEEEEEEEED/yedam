package com.yedam.object;
//클래스 선언
/*
 * static 필드		:public
 * instance 필드 		:private
 * 생성자 			:public
 * getter, setter 	:public
 * 메서드				:public (일부 private 있음)
 */

public class Circle {

	static double pi = 3.14;
	private double r;	//캡슐화
	
	//r필드 초기화 시켜주는 생성자
	public Circle(){
		
	}
	public Circle(double r){
		this.r = r;
	}
	//r read/write 제어 가능
//	public void setR(double r) {
//		this.r = r;
//	}
	public double getR() {
		return r;
	}

	public double area() {
		double result = pi * r * r;
		return result;
	}
}
