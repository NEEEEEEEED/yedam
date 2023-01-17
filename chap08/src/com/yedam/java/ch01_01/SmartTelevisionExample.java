package com.yedam.java.ch01_01;

public class SmartTelevisionExample {

	public static void main(String[] args) {
		SmartTelevision tv = new SmartTelevision();

		tv.turnOn();
		tv.setVolume(10);
		tv.setVolume(200);
		tv.setVolume(-10);
		tv.search("네이버");
		tv.turnOff();

		RemoteControl rc = tv;
		Searchable searchable = tv;
	}

}
