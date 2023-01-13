package com.yedam.object;

public class StringUtil {

	// Hello 출력 메소드
	static void greet() {
		System.out.println("Hello");
	}

	static void greet(String str) {
		System.out.println(str);
	}

	static long greetLength(String str) {
		long result;
		result = str.length();
		return result;
	}

}
