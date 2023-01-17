package com.yedam.java.ch02_02;

public class SmartTelevisionExample {

	public static void main(String[] args) {
		SmartTelevision tv = new SmartTelevision();
		
		RemoteControl rc = tv;
		SmartTV stv = tv;
		stv.turnOff();
		stv.turnOn();
		stv.setVolume(10);
		stv.search("네이버");
		stv.alarm("5시");

	}

}
