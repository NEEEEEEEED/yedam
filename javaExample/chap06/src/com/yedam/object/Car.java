package com.yedam.object;

public class Car {
	// 필드
	String company = "hyundai";
	String model;
	String color;
	int maxSpeed;

	// 생성자
	Car() {

	}

	Car(String model) {
//		this.model = model;
		this(model, "은색", 250);
	}

	Car(String model, String color) {
//		this.model = model;
//		this.color = color;
		this(model, color, 250);
		
	}

	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	// 메소드
}
