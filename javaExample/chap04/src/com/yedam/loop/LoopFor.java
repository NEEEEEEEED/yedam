package com.yedam.loop;

import java.util.Scanner;

public class LoopFor {

	public static void main(String[] args) {
		//for문
		
		for(int i=0; i<=100; i++) {
//			System.out.println(i);
		}
		
		//1부터 100까지의 합 구하기
		int result = 0;
		for(int i=1; i<=100; i++) {
			result += i;	//result = result + 1
		}
//		System.out.println("1~100까지의 합 : " + result);
		
		//1~100사이의 짝수 구하기
		for(int i=1; i<=100; i++) {
			if(i%2 == 0) {
//				System.out.println(i+"는 짝수");
			} else if (i%2==1) {
//				System.out.println(i+"는 홀수");
			}
		}
		
		//입력한 숫자에 대한 구구단 출력
		//스캐너를 활용해서 값을 하나 입력
		//입력 받은 값에 대한 구구단 출력
		//2를 입력 -> 2*1 =2...2*9 = 18
		Scanner sc = new Scanner(System.in);
		System.out.println("입력>");
		
//		int gugu = Integer.parseInt(sc.nextLine());
//		for(int i =1; i<=9; i++) {
//			System.out.println(gugu+" * " + i + "=" + (gugu*i));
//		}
		
		//입력한 값에 대한 총합, 평균, 최대값, 최소값, 데이터 받을 갯수
		//스캐너 입력
		//데이터 받을 갯수 ->5
		//데이터 입력횟수가 5 : 1, 20 ,40, 30, 10
		//총합 : 값을 입력 받을 때마다 변수에 저장
		//평균 : 총합 / 갯수
		//최대값, 최소값 초기 값을 무엇으로 해야 비교할 수 있는지 고민
		//최대값 : 입력할때마다 비교, 최대값인지
		//최소값 : 입력할때마다 비교, 최소값인지
		int number = Integer.parseInt(sc.nextLine());
		int sum = 0;
		int min = 0;
		int max = 0;
		for (int i = 0; i < number; i++) {
			int num = Integer.parseInt(sc.nextLine());
			sum += num;
			if(i==0) {
				max = num;
				min = num;
			}
			if (max < num) {
				max = num;
			}
			if (min > num) {
				min = num; 
			}
		}
		System.out.println(number);
		System.out.println(sum);
		System.out.println(sum/number);
		System.out.println(min);
		System.out.println(max);

		//2번 문제) up and down
		//임의의 랜덤 값(1~100) 추출하여 5번의 기회안에
		//해당 랜덤 값을 맞추는 프로그램을 구현하다.
//		예시)랜엄 값 : 50
//			입력값 : 30
//			=> 더 큰수를 입력하세요.
//			입력값 : 40 
//			=> 더 큰수를 입력하세요.
//			입력값 : 70
//			=> 더 작은 값을 입력하세요
//			정답일 경우
//			정답입니다.
//			5번 기회동안 못 맞출 경우
//			=> 실패 하였습니다.
		int random = (int) (Math.random()*100)+1;
		for (int i =0; i < 5; i++) {
			int check = Integer.parseInt(sc.nextLine());
			if (random > check) {
				System.out.println("더 큰 값을 입력하세요.");
			} else if (random < check) {
				System.out.println("더 작은 값을 입력하세요.");
			} else {
				System.out.println("정답 입니다.");
			}
		}
		System.out.println("실패 하였습니다.");


	}

}
