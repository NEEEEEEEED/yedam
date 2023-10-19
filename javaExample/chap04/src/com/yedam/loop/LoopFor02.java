package com.yedam.loop;

public class LoopFor02 {

	public static void main(String[] args) {
		// 중첩 for문
		//2단 ~ 9단
		for (int i = 2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.println(i+" * " +j+" = "+(i*j)+"\t");
			}
			System.out.println();
		}

		//별찍기
		//*****
		//*****
		//*****
		//*****
		//*****
		for(int i = 0; i < 5; i++ ) {
			for(int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		for(int i=1; i<=5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		//반복문은 i값이 1 또는 0부터 시작하라는 법은 없습니다.
		for(int i=1; i<=5; i++) {
			for(int j=6; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
