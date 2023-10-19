package com.yedam.java.ch02_01;

public class Driver {
	public void driver(Vehicle vehicle) {
		if(vehicle instanceof Bus) {			
			Bus bus = (Bus)vehicle;
			bus.checkFare();
		}
		vehicle.run();
	}
}
