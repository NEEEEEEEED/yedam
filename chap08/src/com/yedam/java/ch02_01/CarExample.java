package com.yedam.java.ch02_01;

public class CarExample {

	public static void main(String[] args) {
		Car mycar = new Car();
		
		mycar.run();
		System.out.println();
		mycar.backLeftTrie = new KumhoTire();
		mycar.frontLeftTrie = new KumhoTire();
		
		mycar.run();

	}

}
