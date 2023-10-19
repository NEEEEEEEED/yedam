package com.yedam.myclass;

import com.yedam.object.Circle;

public class CircleTest {
	public static void main(String[] args) {
		Circle cir = new Circle();
		cir.getR();
		double area = cir.area();
		System.out.println(area);
	}
}
