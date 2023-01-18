package com.yedam.java.ch01;

public class ExceptionExample {

	public static void main(String[] args) {
//		// NullPointerException
//		String data = null;
////		System.out.println(data.toCharArray());
//
//		// ArrayIndexOutOfBoundsException
//		if (args.length > 2) {
//			String data1 = args[0];
//			String data2 = args[1];
//			System.out.println("args[0] : " + data1);
//			System.out.println("args[1] : " + data2);
//		} else {
//			System.out.println("배열 길이가 짧아요");
//		}
//
//		// NumberFormatException
//		String data3 = "100";
//		String data4 = "200";
//
//		int value3 = Integer.parseInt(data3);
//		int value4 = Integer.parseInt(data4);
//
//		int result = value3 + value4;
//		System.out.printf("%s + %s = %d\n", data3, data4, result);

		// ClassCastException
		changeDog(new Dog());
		changeDog(new Cat());
	}

	public static void changeDog(Animal animal) {
		if(animal instanceof Dog) {
			
			Dog dog = (Dog) animal;
		}

	}

}

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}