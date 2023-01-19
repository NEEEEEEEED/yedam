package com.yedam.java.ch05.Math;

public class Example {

	public static void main(String[] args) {
		// abs() : 절대값
		System.out.println("-2.14 의 절대값 : " + Math.abs(-2.14));
		System.out.println("2.14 의 절대값 : " + Math.abs(2.14));

		// max() : 최대값, min() : 최소값
		System.out.println(Math.max(3.8, 6.7));
		System.out.println(Math.min(3.8, 6.7));

		// ceil() : 올림값
		System.out.println(Math.ceil(5.3));
		System.out.println(Math.ceil(-5.3));

		// floor() : 버림값
		System.out.println(Math.floor(5.3));
		System.out.println(Math.floor(-5.3));

		// round() : 반올림값 (정수)
		System.out.println(Math.round(5.3));
		System.out.println(Math.round(-5.3));

		// rint(): 가까운 정수의 실수값 (기준 6)
		System.out.println(Math.rint(5.3));
		System.out.println(Math.rint(-5.3));
		System.out.println(Math.rint(5.5));
		System.out.println(Math.rint(-5.5));
		System.out.println(Math.rint(4.5));
		System.out.println(Math.rint(-4.5));
		System.out.println(Math.rint(4.6));
		System.out.println(Math.rint(-4.6));
		
		//random() : 0.0 =< random() <1.0
		System.out.println((int)(Math.random()*6)+8);
		
	}

}
