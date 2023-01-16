package com.yedam.Class6;

public class Car {
	private int speed;
	private int maxSpeed;
	private String model;

	public Car(String model, int maxSpeed) {
		this.model = model;
		this.maxSpeed = maxSpeed;
		this.speed = 0;
	}
	public String getModel() {
		return this.model;
	}
	public int getMaxSpped() {
		return this.maxSpeed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSpeed() {
		return this.speed;
	}

}
