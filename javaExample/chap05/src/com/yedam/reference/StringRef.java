package com.yedam.reference;

public class StringRef {

	public static void main(String[] args) {
		String strVal1 = "yedam";
		String strVal2 = "yedam";
		//문자열 주소값 비교
		if(strVal1 == strVal2) {
			System.out.println("strVal1과 strVal2는 메모리 주소가" + "같다");
		}else {
			System.out.println("strVal 1과 strVal2는 메모리 주소가" + "다르다");
		}
		//문자열간의 데이터 비교
		if(strVal1.equals(strVal2)) {
			System.out.println("strVa1과 strVal2는 데이터 동일");
		} else {
			System.out.println("strVa1과 strVal2는 데이터 다름");
		}
		//new 연산자를 활용한 String 새롭게 객체 생성
		String strVal3 = new String("yedam");
		String strVal4 = new String("yedam");

		if(strVal3 == strVal4) {
			System.out.println("strVal3과 strVal4는 메모리 주소가" + "같다");
		}else {
			System.out.println("strVal3과 strVal4는 메모리 주소가" + "다르다");
		}
		
		if(strVal3.equals(strVal4)) {
			System.out.println("strVa3과 strVal4는 데이터 동일");
		} else {
			System.out.println("strVa3과 strVal4는 데이터 다름");
		}
	}

}
