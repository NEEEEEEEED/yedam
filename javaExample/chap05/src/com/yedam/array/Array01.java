package com.yedam.array;

public class Array01 {

	public static void main(String[] args) {
		//1. 값 목록을 활용해서 배열 만들기
		//배열 공간(인덱스)와 값을 입력
		int[] intAry = {1,2,3,4,5,6};
		
		//2. 배열 공간을 먼저 확보(데이터 값 x)
		int[] intAry2 = new int[6];
		//빈 공간에 데이터 값 넣는 법
//		intAry2[0] = 1;
		
		//String 데이터 10개 배열 공간 생성
		String[] strAry = new String[10];
		
		System.out.println("intAry의 첫번째 값 : " + intAry[0]);
		System.out.println("intAry의 마지막 값 : " + intAry[5]);

		//for (int i=0; i<=10; i++)
		// i = 0~10 => 배열의 인덱스
		//배열의 데이터 총 합계
		int sum =0;
		int[] score = {84,54,67};
		for(int i =0; i<3; i++) {
			System.out.println(score[i]);
			sum += score[i];
		}
		System.out.println("총 합계 : " + sum);
		
		//new 연산자 활용한 배여 생성
		int[] point;
		point = new int[] {74,63,83};
		
		sum = 0;
		for(int i =0; i<3; i++) {
			System.out.println(point[i]);
			sum += point[i];
		}
		System.out.println("총 합계 : " + sum);
		
		//new 연산자 활용해서 배열, 비어있는 배열
		int[] arr1 = new int[3];
		for(int i=0; i<3;i++) {
			//int 기본값으로 0, double은 0.0, String은 null
			System.out.println("arr1["+i+"] : "+arr1[i]);
		}
		
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		
		for(int i=0; i<3;i++) {
			System.out.println("arr1["+i+"] : "+arr1[i]);
		}
		
		//참조 타입 배열
		String[] arr3 = new String[3];
		for(int i=0; i<3;i++) {
			System.out.println("arr3["+i+"] : "+arr3[i]);
		}
		
		arr3[0] = "3월";
		arr3[1] = "11월";
		arr3[2] = "12월";
		for(int i=0; i<3;i++) {
			System.out.println("arr3["+i+"] : "+arr3[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
