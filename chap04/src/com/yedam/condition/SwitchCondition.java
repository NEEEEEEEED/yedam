package com.yedam.condition;

import java.util.Scanner;

public class SwitchCondition {

	public static void main(String[] args) {
		int num = (int)(Math.random()*6)+1;
		
		switch(num) {
		case 1:
			System.out.println("1번이 나왔습니다.");
			break;
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;
		case 4:
			System.out.println("4번이 나왔습니다.");
			break;
		case 5:
			System.out.println("5번이 나왔습니다.");
			break;
		case 6:
			System.out.println("6번이 나왔습니다.");
			break;
		}

		//char 문자 비교
		char grade ='B';
		String grade2 = "B";
		
		switch(grade2) {
		case "A":
			System.out.println("우수 회원");
			break;
			//B b 모두 적용
		case "B":
		case "b":
			System.out.println("일반 회원");
			break;
		default:
			System.out.println("손님");
		}
		
		//입력한 성적을 등급으로 환산
		Scanner sc = new Scanner(System.in);
		//90 80 70 60
		int scores = Integer.parseInt(sc.nextLine())/10;
		
		switch(scores) {
		case 10:
		case 9:
			System.out.println("A등급");
			break;
		case 8:
			System.out.println("B등급");
			break;
		case 7:
			System.out.println("C등급");
			break;
		default:
			System.out.println("D등급");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
			
		
		
		
		
	}

}
