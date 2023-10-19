package com.yedam.java.ch02_01;

public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver();

		driver.driver(new Taxi());// Vehicle 을 구현하는 Taxi이기 때문에 가능
		driver.driver(new Bus());// Bus는 Vehicle과 연관이 없기 때문에 불가능

	}

}
