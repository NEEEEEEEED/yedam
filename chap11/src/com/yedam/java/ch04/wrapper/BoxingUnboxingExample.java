package com.yedam.java.ch04.wrapper;

public class BoxingUnboxingExample {

	public static void main(String[] args) {
		// 박싱
		Integer obj1 = Integer.valueOf(100);
		Integer obj2 = Integer.valueOf("200");

		// 언박싱
		int value1 = obj1.intValue();
		int value2 = obj2.intValue();

		// 자동 박싱
		Integer newObj1 = value1;
		Integer newObj2 = value2;

		// 자동 언박싱
		int result = newObj1 + newObj2;
		System.out.println(result);

		int newValue1 = newObj1;
		int newValue2 = newObj2;

		// Wrapper 클래스 값 비교(객체 비교방식 1. 언박싱 ,2. equals():내부값비교)
		Integer data1 = 300;
		Integer data2 = 300;
		System.out.println(" == 결과 :" + (data1 == data2));
		System.out.println("언박싱 후 == 결과 : " + (data1.intValue() == data2.intValue()));
		System.out.println("equals() 결과 : " + data1.equals(data2));

		System.out.println("예외사항 -128~127");
		Integer data3 = 30;
		Integer data4 = 30;
		System.out.println(" == 결과 :" + (data3 == data4));
		System.out.println("언박싱 후 == 결과 : " + (data3.intValue() == data4.intValue()));
		System.out.println("equals() 결과 : " + data3.equals(data4));

	}

}
