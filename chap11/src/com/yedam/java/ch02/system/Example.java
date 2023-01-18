package com.yedam.java.ch02.system;

public class Example {

	public static void main(String[] args) {
		long start = System.nanoTime();

		int sum = 0;
		for (int i = 1; i <= 100000; i++) {
			sum += 1;
		}
		
		long end = System.nanoTime();
		
		System.out.println("1~100000 까지의 합 : " + sum);
		System.out.println("계산에 " + (end - start) + "나노초가 소요되었습니다.");
		System.out.println("저는 신입니다.");
	}

}
