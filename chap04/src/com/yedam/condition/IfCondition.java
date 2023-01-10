package com.yedam.condition;

import java.util.Scanner;

public class IfCondition {

	public static void main(String[] args) {
		int score = 93;
		
		if(score >= 90) {
			System.out.println("점수가 90 이상이고, 등급 A");
		}
		//실행문이 한 줄 일때만 사용 - 쓰지마 무조건 중괄호 써
		if (score >= 90)
			System.out.println("점수가 90이상이고, 등급 A");
		
		//if-else
		if(score>=90) {
			System.out.println("점수가 90이상입니다.");
			System.out.println("등급은 A입니다.");
		}	else {
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		}
		
		//else-if
		//if문(조건식을 여러게 사용 할 때)
		score = 70;
		if(score>=90) {
			System.out.println("등급은 A입니다.");
		}	else if(score >=80) {
			System.out.println("등급은 B입니다.");
		} 	else if(score >=70) {
			System.out.println("등급은 C입니다.");
		}	else {
			System.out.println("등급은 D입니다.");
		}
		
		//random 값 추출
		//random() / Math.random()  --2가지방법
		//다이스
//		System.out.println((int)(Math.random()*6)+1);
		// 0 * 10 <= Math.random() * 10 < 1*10
		
		//0<= Math.random() * 10 < 10
		
		int num = (int)(Math.random()*6)+1;
		if(num==1) {
			System.out.println("1번이 나왔습니다.");
		}	else if ( num==2) {
			System.out.println("2번이 나왔습니다.");
		}	else if ( num==3) {
			System.out.println("3번이 나왔습니다.");
		}	else if ( num==4) {
			System.out.println("4번이 나왔습니다.");
		}	else if ( num==5) {
			System.out.println("5번이 나왔습니다.");
		}	else if ( num==6) {
			System.out.println("6번이 나왔습니다.");
		}
		
		//중첩 if 문
//		if(조건식) {
//			if(조건식) {
//				if(조건식) {
//				}
//			}
//		}
//		int no = 10;
//		if(no % 2 == 0) {
//			if (no % 5 == 0) {
//				if ( no % 10 == 0) {
//					System.out.println("no는 10의 배수 입니다.");
//				}
//			}
//		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수입력>");
		
		score = Integer.parseInt(sc.nextLine());
		String grade = "";
		
		if (score >= 90) {
			if(score >=95) {
				grade = "A+";
			}else {
				grade = "A";
			}
		}
		System.out.println("획득한 학점 : " + grade);	

	}

}
