package com.yedam.java.ch03.string;

public class CaseException {
	public static final String DATA = "HELLO WORLD!";

	public static void main(String[] args) {
		String inputData = "Hello World!";
		// 소문자 변환
		String newInputData = inputData.toLowerCase();
		String newDATA = DATA.toLowerCase();
		System.out.println(newInputData);
		System.out.println(newDATA);
		// 대문자 변환
		String newInputData1 = inputData.toUpperCase();
		String newDATA1 = DATA.toUpperCase();
		System.out.println(newInputData1);
		System.out.println(newDATA1);

		// 두 객체 비교
		if (newInputData.equals(newDATA)) {
			System.out.println("있");
		} else {
			System.out.println("없");
		}
		// 대소문자 구분 없이 의미만 비교하는 메소드
		if (inputData.equalsIgnoreCase(DATA)) {
			System.out.println("있");
		} else {
			System.out.println("없");
		}

	}
}
