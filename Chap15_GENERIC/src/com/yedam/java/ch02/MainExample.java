package com.yedam.java.ch02;

public class MainExample {

	public static void main(String[] args) {
		Box<String> nameBox = new Box<>();
		nameBox.set("홍길동");
		String name = nameBox.get();

		Box<Integer> priceBox = new Box<>();
		priceBox.set(1000);
		int price = priceBox.get();

		Box<Apple> appleBox = new Box<Apple>();
		appleBox.set(new Apple());
		Apple apple = appleBox.get();

		Agency agency = new Agency();
		agency.rent().turnOnLight();
		agency.getCount().printRentalDate();

	}

}

class Apple {
}