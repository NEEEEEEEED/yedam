package com.yedam.loop;

import java.util.Scanner;

public class LoopWhile {

	public static void main(String[] args) {
		// 1~100사이의 2의 배수
		int i = 1;
		while (i <= 100) {
			if (i % 2 == 0) {
//				System.out.println(i);
			}
			i++;
		}

		// 계산기 프로그램
		// 무한 루프 조건으로 프로그램 실행
		// event(trigger) 프로그램 종료 -> break;
		boolean run = true; // 종료시켜줄 무언가
		Scanner sc = new Scanner(System.in);

		while (run) {
			System.out.println("1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 종료");
			System.out.println("입력>");

			int num = Integer.parseInt(sc.nextLine());

			switch (num) {
			case 1:
				System.out.println("더할 두 수를 입력>");
				System.out.println("1>");
				int num1 = Integer.parseInt(sc.nextLine());
				System.out.println("2>");
				int num2 = Integer.parseInt(sc.nextLine());
				System.out.println("결과 : " + (num1 + num2));
				break;
			case 2:
				System.out.println("뺄 두 수를 입력>");
				System.out.println("1>");
				int num3 = Integer.parseInt(sc.nextLine());
				System.out.println("2>");
				int num4 = Integer.parseInt(sc.nextLine());
				System.out.println("결과 : " + (num3 - num4));
				break;
			case 3:
				System.out.println("곱할 두 수를 입력>");
				System.out.println("1>");
				int num5 = Integer.parseInt(sc.nextLine());
				System.out.println("2>");
				int num6 = Integer.parseInt(sc.nextLine());
				System.out.println("결과 : " + (num5 * num6));
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("1~4사이 수를 입력해주세요.");
				break;
			}

		}
		System.out.println("end of program");
		
		//게임 만들기
		//컴퓨터와 가위, 바위, 보
		//동전 앞, 뒤 맞추기
		//한판에 500원
		//어떤 반복문, 어떤 변수, 어떤 조건식이 필요할지 생각
		//for, while, do-while// money, menu, // logic(알고리즘)
		int money;
		System.out.println("=====insert coin=====");
		money = Integer.parseInt(sc.nextLine());
		boolean flag = true;
		while(money >= 500 && flag) {
			System.out.println((money/500)+"번의 기회가 남았습니다.");
			System.out.println("1. 가위바위보 | 2. 앞 뒤 맞추기 | 3. 종료");
			System.out.println("입력>");
			int gameNo = Integer.parseInt(sc.nextLine());
			
			switch(gameNo) {
			case 1:
				//컴퓨터와 가위, 바위, 보
				//입력값과 비교
				//가위, 바위, 보 || String.euals(내용)
				System.out.println("가위, 바위, 보 중에 하나를 입력하세요.");
				String RSP = sc.nextLine();
				int random = (int)(Math.random()*3)+1;
				if (RSP.equals("가위")) {
					//가위 == 1
					if(random == 1) {
						System.out.println("비겼다.");
					} else if(random == 2) {
						System.out.println("졌다.");
					} else if(random == 3) {
						System.out.println("이겼다.");
					}
				}else if(RSP.equals("바위")) {
					//바위 == 2
					if(random == 1) {
						System.out.println("이겼다.");
					} else if(random == 2) {
						System.out.println("비겼다.");
					} else if(random == 3) {
						System.out.println("졌다.");
					}
				}else if(RSP.equals("보")) {
					//보 == 3
					if(random == 1) {
						System.out.println("졌다.");
					} else if(random == 2) {
						System.out.println("이겼다.");
					} else if(random == 3) {
						System.out.println("비겼다.");
					}
				}
				money -= 500;
				break;
			case 2:
				//동전 앞, 뒤 맞추기
				System.out.println("앞, 뒤 중에 하나를 입력하세요.");
				String coinToss = sc.nextLine();
				int randomCoin = (int)(Math.random()*2)+1;
				if (coinToss.equals("앞")) {
					//가위 == 1
					if(randomCoin == 1) {
						System.out.println("맞췄다.");
					} else if(randomCoin == 2) {
						System.out.println("틀렸다.");
					} 
				}else if(coinToss.equals("뒤")) {
					//바위 == 2
					if(randomCoin == 1) {
						System.out.println("맞췄다.");
					} else if(randomCoin == 2) {
						System.out.println("틀렸다.");
					} 
				}
				money -= 500;
				break;
			case 3:
				//1. 투입 금액이 소진이 다 되었을때
			flag = false;
				break;
			default:
				System.out.println("없는 메뉴 입니다. 다시 입력하세요.");
				break;
			}
			if(money <500) {
				System.out.println("금액이 부족해 더이상 게임 진행 불가");
			}
		}
		System.out.println("게임 종료");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
